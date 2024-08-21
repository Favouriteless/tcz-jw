package com.tacz.guns;

import com.tacz.guns.api.resource.ResourceManager;
import com.tacz.guns.config.ClientConfig;
import com.tacz.guns.config.CommonConfig;
import com.tacz.guns.config.ServerConfig;
import com.tacz.guns.config.loader.ConfigLoader;
import com.tacz.guns.display.Hud;
import com.tacz.guns.init.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.tacz.guns.util.RayTrace;
import com.tacz.guns.config.Config;
import com.tacz.guns.config.loader.IConfig;

import java.util.Random;

@Mod(GunMod.MOD_ID)
public class GunMod {
    public static final String MOD_ID = "tacz";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static Config CONFIG = new Config();
    public static Hud HUD = new Hud();
    public static RayTrace RAYTRACE = new RayTrace();
    public static boolean IS_HOLDING_WEAPON = false;
    public static Random RAND = new Random();

    public static void init() {
        ClientEventHandler.init();
    }

    private static ConfigLoader<Config> CONFIG_LOADER = new ConfigLoader<>(new Config(),
            GunMod.MOD_ID + ".json", config -> GunMod.CONFIG = config);
    /**
     * 默认模型包文件夹
     */
    public static final String DEFAULT_GUN_PACK_NAME = "tacz_default_gun";

    public GunMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.init());
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfig.init());
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.init());

        MinecraftForge.EVENT_BUS.register(this);
        ToroHealthClient.init();


        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(bus);
        ModBlocks.TILE_ENTITIES.register(bus);
        ModCreativeTabs.TABS.register(bus);
        ModItems.ITEMS.register(bus);
        ModEntities.ENTITY_TYPES.register(bus);
        ModRecipe.RECIPE_SERIALIZERS.register(bus);
        ModContainer.CONTAINER_TYPE.register(bus);
        ModSounds.SOUNDS.register(bus);
        ModParticles.PARTICLE_TYPES.register(bus);

        registerDefaultExtraGunPack();
    }

    private static void registerDefaultExtraGunPack() {
        String jarDefaultPackPath = String.format("/assets/%s/custom/%s", GunMod.MOD_ID, DEFAULT_GUN_PACK_NAME);
        ResourceManager.registerExtraGunPack(GunMod.class, jarDefaultPackPath);
    }
}