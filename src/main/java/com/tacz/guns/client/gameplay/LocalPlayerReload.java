package com.tacz.guns.client.gameplay;

import com.tacz.guns.api.DefaultAssets;
import com.tacz.guns.api.TimelessAPI;
import com.tacz.guns.api.entity.IGunOperator;
import com.tacz.guns.api.event.common.GunReloadEvent;
import com.tacz.guns.api.item.IAmmo;
import com.tacz.guns.api.item.IAmmoBox;
import com.tacz.guns.api.item.IGun;
import com.tacz.guns.api.item.attachment.AttachmentType;
import com.tacz.guns.client.animation.statemachine.GunAnimationStateMachine;
import com.tacz.guns.client.resource.index.ClientGunIndex;
import com.tacz.guns.client.sound.SoundPlayManager;
import com.tacz.guns.network.NetworkHandler;
import com.tacz.guns.network.message.ClientMessagePlayerReloadGun;
import com.tacz.guns.resource.pojo.data.gun.Bolt;
import com.tacz.guns.util.AttachmentDataUtils;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.LogicalSide;

public class LocalPlayerReload {
    private final LocalPlayerDataHolder data;
    private final LocalPlayer player;

    public LocalPlayerReload(LocalPlayerDataHolder data, LocalPlayer player) {
        this.data = data;
        this.player = player;
    }

    public void reload() {
        ItemStack mainhandItem = player.getMainHandItem();
        if (!(mainhandItem.getItem() instanceof IGun iGun)) {
            return;
        }
        ResourceLocation gunId = iGun.getGunId(mainhandItem);
        TimelessAPI.getClientGunIndex(gunId).ifPresent(gunIndex -> {
            if (data.clientStateLock) {
                return;
            }
            if (IGunOperator.fromLivingEntity(player).needCheckAmmo() && !inventoryHasAmmo(iGun, gunIndex, mainhandItem)) {
                return;
            }
            data.lockState(operator -> operator.getSynReloadState().getStateType().isReloading());
            if (MinecraftForge.EVENT_BUS.post(new GunReloadEvent(player, player.getMainHandItem(), LogicalSide.CLIENT))) {
                return;
            }
            NetworkHandler.CHANNEL.sendToServer(new ClientMessagePlayerReloadGun());
            this.doReload(iGun, gunIndex, mainhandItem);
        });
    }

    private void doReload(IGun iGun, ClientGunIndex gunIndex, ItemStack mainhandItem) {
        GunAnimationStateMachine animationStateMachine = gunIndex.getAnimationStateMachine();
        if (animationStateMachine != null) {
            Bolt boltType = gunIndex.getGunData().getBolt();
            boolean noAmmo;
            if (boltType == Bolt.OPEN_BOLT) {
                noAmmo = iGun.getCurrentAmmoCount(mainhandItem) <= 0;
            } else {
                noAmmo = !iGun.hasBulletInBarrel(mainhandItem);
            }
            SoundPlayManager.stopPlayGunSound();
            SoundPlayManager.playReloadSound(player, gunIndex, noAmmo);
            animationStateMachine.setNoAmmo(noAmmo).onGunReload();
        }
    }

    private void playMagExtendedAnimation(ItemStack mainhandItem, IGun iGun, GunAnimationStateMachine animationStateMachine) {
        ResourceLocation extendedMagId = iGun.getAttachmentId(mainhandItem, AttachmentType.EXTENDED_MAG);
        if (!DefaultAssets.isEmptyAttachmentId(extendedMagId)) {
            TimelessAPI.getCommonAttachmentIndex(extendedMagId).ifPresent(index -> {
                animationStateMachine.setMagExtended(index.getData().getExtendedMagLevel() > 0);
            });
        }
    }

    private boolean inventoryHasAmmo(IGun iGun, ClientGunIndex gunIndex, ItemStack mainhandItem) {
        int maxAmmoCount = AttachmentDataUtils.getAmmoCountWithAttachment(mainhandItem, gunIndex.getGunData());
        if (iGun.getCurrentAmmoCount(mainhandItem) >= maxAmmoCount) {
            return false;
        }
        if (iGun.useDummyAmmo(mainhandItem)) {
            return iGun.getDummyAmmoAmount(mainhandItem) > 0;
        }

        Inventory inventory = player.getInventory();
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack checkAmmo = inventory.getItem(i);
            if (checkAmmo.getItem() instanceof IAmmo iAmmo) {
                if (iAmmo.isAmmoOfGun(mainhandItem, checkAmmo)) {
                    return true;
                }
            } else if (checkAmmo.getItem() instanceof IAmmoBox iAmmoBox) {
                if (iAmmoBox.isAmmoBoxOfGun(mainhandItem, checkAmmo)) {
                    return true;
                }
            }
        }

        return false;
    }
}


