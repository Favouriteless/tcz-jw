package com.tacz.guns.client.renderer.item;

import com.tacz.guns.GunMod;
import com.tacz.guns.item.CustomItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class CustomItemRenderer extends GeoItemRenderer<CustomItem> {
    public CustomItemRenderer() {
        super(new GeoModel<>() {
            @Override
            public ResourceLocation getModelResource(CustomItem customItem) {
                return new ResourceLocation(GunMod.MOD_ID, "geo/item/"+ customItem.getCustomItemName() +".geo.json");
            }

            @Override
            public ResourceLocation getTextureResource(CustomItem customItem) {
                return new ResourceLocation(GunMod.MOD_ID, "textures/item/"+ customItem.getCustomItemName() +".png");
            }

            @Override
            public ResourceLocation getAnimationResource(CustomItem customItem) {
                return null;
            }
        });
    }
}
