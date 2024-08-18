package com.tacz.guns.events;

import com.tacz.guns.GunMod;
import com.tacz.guns.init.PacketHandler;
import com.tacz.guns.GunMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = GunMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event){
        event.enqueueWork(()-> {
            PacketHandler.register();
        });
    }
}
