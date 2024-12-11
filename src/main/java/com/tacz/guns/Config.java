package com.tacz.guns;

import com.tacz.guns.GunMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = GunMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{


    //static final ForgeConfigSpec SPEC = BUILDER.build();



    public static int materialPerBlock;

    public static int thatchResistance = 20;

    public static int woodenResistance = 50;
    public static int stoneResistance = 600;
    public static int metalResistance = 900;
    public static int armoredResistance = 1200;

    public static int pillarThatchResistance = 25;

    public static int pillarWoodResistance = 50;

    public static int pillarStoneResistance = 650;

    public static int pillarMetalResistance = 950;

    public static int pillarArmoredResistance = 1250;

    public static int thatchFlammability;
    public static int thatchFireSpread;

    public static int woodenFlammability;
    public static int woodenFireSpread;

    public static int destructionMode = 1;


    public static List<? extends String> destructionWhiteList;


//    public static boolean logDirtBlock;
//    public static int magicNumber;
//    public static String magicNumberIntroduction;
//    public static Set<Item> items;
//
//    private static boolean validateItemName(final Object obj)
//    {
//        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
//    }

}