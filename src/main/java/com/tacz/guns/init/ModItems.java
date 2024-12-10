package com.tacz.guns.init;

import com.tacz.guns.GunMod;
import com.tacz.guns.item.*;
import com.tacz.guns.api.item.gun.GunItemManager;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GunMod.MOD_ID);

    public static RegistryObject<ModernKineticGunItem> MODERN_KINETIC_GUN = ITEMS.register("modern_kinetic_gun", ModernKineticGunItem::new);

    public static RegistryObject<Item> AMMO = ITEMS.register("ammo", AmmoItem::new);
    public static RegistryObject<AttachmentItem> ATTACHMENT = ITEMS.register("attachment", AttachmentItem::new);
    public static RegistryObject<Item> GUN_SMITH_TABLE = ITEMS.register("gun_smith_table", GunSmithTableItem::new);
    public static RegistryObject<Item> TARGET = ITEMS.register("target", () -> new BlockItem(ModBlocks.TARGET.get(), new Item.Properties()));
    public static RegistryObject<Item> STATUE = ITEMS.register("statue", () -> new BlockItem(ModBlocks.STATUE.get(), new Item.Properties()));
    public static RegistryObject<Item> AMMO_BOX = ITEMS.register("ammo_box", AmmoBoxItem::new);
    public static RegistryObject<Item> TARGET_MINECART = ITEMS.register("target_minecart", TargetMinecartItem::new);

   // public static RegistryObject<Item> HP_CHECKER = ITEMS.register("hp_checker", HPCheckerItem::new);


    public static final RegistryObject<Item> THATCH_WALL_DOOR_ITEM = ITEMS.register("thatch_wall_door", () -> new WallDoorItem(ModBlocks.THATCH_WALL_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> WOODEN_WALL_DOOR_ITEM = ITEMS.register("wooden_wall_door", () -> new WallDoorItem(ModBlocks.WOODEN_WALL_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> STONE_WALL_DOOR_ITEM = ITEMS.register("stone_wall_door", () -> new WallDoorItem(ModBlocks.STONE_WALL_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> ARMORED_WALL_DOOR_ITEM = ITEMS.register("armored_wall_door", () -> new WallDoorItem(ModBlocks.ARMORED_WALL_DOOR.get(), new Item.Properties()));

    public static RegistryObject<Item> BLUEPRINT_AK = ITEMS.register("blueprint_ak", BlueprintAKItem::new);

    public static final RegistryObject<Item> THATCH_WALL_ITEM = ITEMS.register("thatch_wall", () -> new WallItem(ModBlocks.THATCH_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> WOODEN_WALL_ITEM = ITEMS.register("wooden_wall", () -> new WallItem(ModBlocks.WOODEN_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> STONE_WALL_ITEM = ITEMS.register("stone_wall", () -> new WallItem(ModBlocks.STONE_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> METAL_WALL_ITEM = ITEMS.register("metal_wall", () -> new WallItem(ModBlocks.METAL_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> ARMORED_WALL_ITEM = ITEMS.register("armored_wall", () -> new WallItem(ModBlocks.ARMORED_WALL.get(), new Item.Properties()));

    public static final RegistryObject<Item> THATCH_WALL_FLOOR_ITEM = ITEMS.register("thatch_wall_floor", () -> new WallFloorItem(ModBlocks.THATCH_WALL_FLOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> WOODEN_WALL_FLOOR_ITEM = ITEMS.register("wooden_wall_floor", () -> new WallFloorItem(ModBlocks.WOODEN_WALL_FLOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> STONE_WALL_FLOOR_ITEM = ITEMS.register("stone_wall_floor", () -> new WallFloorItem(ModBlocks.STONE_WALL_FLOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> METAL_WALL_FLOOR_ITEM = ITEMS.register("metal_wall_floor", () -> new WallFloorItem(ModBlocks.METAL_WALL_FLOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> ARMORED_WALL_FLOOR_ITEM = ITEMS.register("armored_wall_floor", () -> new WallFloorItem(ModBlocks.ARMORED_WALL_FLOOR.get(), new Item.Properties()));

    public static final RegistryObject<Item> THATCH_WALL_WINDOW_ITEM = ITEMS.register("thatch_wall_window", () -> new WallWindowItem(ModBlocks.THATCH_WALL_WINDOW.get(), new Item.Properties()));
    public static final RegistryObject<Item> WOODEN_WALL_WINDOW_ITEM = ITEMS.register("wooden_wall_window", () -> new WallWindowItem(ModBlocks.WOODEN_WALL_WINDOW.get(), new Item.Properties()));
    public static final RegistryObject<Item> STONE_WALL_WINDOW_ITEM = ITEMS.register("stone_wall_window", () -> new WallWindowItem(ModBlocks.STONE_WALL_WINDOW.get(), new Item.Properties()));

    public static final RegistryObject<Item> ARMORED_WALL_WINDOW_ITEM = ITEMS.register("armored_wall_window", () -> new WallWindowItem(ModBlocks.ARMORED_WALL_WINDOW.get(), new Item.Properties()));
    public static final RegistryObject<Item> METAL_WALL_WINDOW_ITEM = ITEMS.register("metal_wall_window", () -> new WallWindowItem(ModBlocks.METAL_WALL_WINDOW.get(), new Item.Properties()));
    public static final RegistryObject<Item> METAL_WALL_DOOR_ITEM = ITEMS.register("metal_wall_door", () -> new WallDoorItem(ModBlocks.METAL_WALL_DOOR.get(), new Item.Properties()));

    public static final RegistryObject<Item> THATCH_WALL_WINDOW_FRAME_ITEM = ITEMS.register("thatch_wall_window_frame", () -> new WallWindowFrameItem(ModBlocks.THATCH_WALL_WINDOW_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> WOODEN_WALL_WINDOW_FRAME_ITEM = ITEMS.register("wooden_wall_window_frame", () -> new WallWindowFrameItem(ModBlocks.WOODEN_WALL_WINDOW_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> STONE_WALL_WINDOW_FRAME_ITEM = ITEMS.register("stone_wall_window_frame", () -> new WallWindowFrameItem(ModBlocks.STONE_WALL_WINDOW_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> METAL_WALL_WINDOW_FRAME_ITEM = ITEMS.register("metal_wall_window_frame", () -> new WallWindowFrameItem(ModBlocks.METAL_WALL_WINDOW_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> ARMORED_WALL_WINDOW_FRAME_ITEM = ITEMS.register("armored_wall_window_frame", () -> new WallWindowFrameItem(ModBlocks.ARMORED_WALL_WINDOW_FRAME.get(), new Item.Properties()));

    public static final RegistryObject<Item> THATCH_WALL_DOOR_FRAME_ITEM = ITEMS.register("thatch_wall_door_frame", () -> new WallDoorFrameItem(ModBlocks.THATCH_WALL_DOOR_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> WOODEN_WALL_DOOR_FRAME_ITEM = ITEMS.register("wooden_wall_door_frame", () -> new WallDoorFrameItem(ModBlocks.WOODEN_WALL_DOOR_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> STONE_WALL_DOOR_FRAME_ITEM = ITEMS.register("stone_wall_door_frame", () -> new WallDoorFrameItem(ModBlocks.STONE_WALL_DOOR_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> METAL_WALL_DOOR_FRAME_ITEM = ITEMS.register("metal_wall_door_frame", () -> new WallDoorFrameItem(ModBlocks.METAL_WALL_DOOR_FRAME.get(), new Item.Properties()));
    public static final RegistryObject<Item> ARMORED_WALL_DOOR_FRAME_ITEM = ITEMS.register("armored_wall_door_frame", () -> new WallDoorFrameItem(ModBlocks.ARMORED_WALL_DOOR_FRAME.get(), new Item.Properties()));

    public static final RegistryObject<Item> THATCH_WALL_HATCH_ITEM = ITEMS.register("thatch_wall_hatch", () -> new WallHatchItem(ModBlocks.THATCH_WALL_HATCH.get(), new Item.Properties()));
    public static final RegistryObject<Item> WOODEN_WALL_HATCH_ITEM = ITEMS.register("wooden_wall_hatch", () -> new WallHatchItem(ModBlocks.WOODEN_WALL_HATCH.get(), new Item.Properties()));
    public static final RegistryObject<Item> STONE_WALL_HATCH_ITEM = ITEMS.register("stone_wall_hatch", () -> new WallHatchItem(ModBlocks.STONE_WALL_HATCH.get(), new Item.Properties()));
    public static final RegistryObject<Item> METAL_WALL_HATCH_ITEM = ITEMS.register("metal_wall_hatch", () -> new WallHatchItem(ModBlocks.METAL_WALL_HATCH.get(), new Item.Properties()));
    public static final RegistryObject<Item> ARMORED_WALL_HATCH_ITEM = ITEMS.register("armored_wall_hatch", () -> new WallHatchItem(ModBlocks.ARMORED_WALL_HATCH.get(), new Item.Properties()));

    public static final RegistryObject<Item> THATCH_WALL_PILLAR_ITEM_2 = ITEMS.register("thatch_wall_pillar_2", () -> new WallPillarItem(ModBlocks.THATCH_WALL_PILLAR.get(), new Item.Properties(), 2));
    public static final RegistryObject<Item> THATCH_WALL_PILLAR_ITEM_3 = ITEMS.register("thatch_wall_pillar_3", () -> new WallPillarItem(ModBlocks.THATCH_WALL_PILLAR.get(), new Item.Properties(), 3));
    public static final RegistryObject<Item> THATCH_WALL_PILLAR_ITEM_4 = ITEMS.register("thatch_wall_pillar_4", () -> new WallPillarItem(ModBlocks.THATCH_WALL_PILLAR.get(), new Item.Properties(), 4));
    public static final RegistryObject<Item> THATCH_WALL_PILLAR_ITEM_5 = ITEMS.register("thatch_wall_pillar_5", () -> new WallPillarItem(ModBlocks.THATCH_WALL_PILLAR.get(), new Item.Properties(), 5));

    //public static final RegistryObject<Item> LOOT_CRATE_ITEM = ITEMS.register("loot_crate", () -> new LootCrateItem(ModBlocks.LOOT_CRATE.get(), new Item.Properties()));

    public static final RegistryObject<Item> DEBUGGER = ITEMS.register("debugger", ()-> new Debugger(new Item.Properties()));
    public static final RegistryObject<Item> SUPER_HAMMER = ITEMS.register("super_hammer", ()-> new SuperHammer(new Item.Properties()));

    //public static final RegistryObject<Item> SKIN_TOOL = ITEMS.register("skin_tool", ()-> new SkinTool(new Item.Properties()));

    public static final RegistryObject<Item> STRAW_SCRAP = ITEMS.register("straw_scrap", () -> new ConstructionMaterial(new Item.Properties()));
    public static final RegistryObject<Item> WOOD_SCRAP = ITEMS.register("wood_scrap", () -> new ConstructionMaterial(new Item.Properties()));
    public static final RegistryObject<Item> STONE_SCRAP = ITEMS.register("stone_scrap", () -> new ConstructionMaterial(new Item.Properties()));
    public static final RegistryObject<Item> METAL_SCRAP = ITEMS.register("metal_scrap", () -> new ConstructionMaterial(new Item.Properties()));
    public static final RegistryObject<Item> ARMORED_SCRAP = ITEMS.register("armored_scrap", () -> new ConstructionMaterial(new Item.Properties()));

    public static final RegistryObject<Item> MAGAZINE = ITEMS.register("magazine", () -> new CustomItem(new Item.Properties(), "magazine"));
    public static final RegistryObject<Item> AWP_MAGAZINE = ITEMS.register("awp_magazine", () -> new CustomItem(new Item.Properties(), "awp_magazine"));

    public static final RegistryObject<Item> AK_STOCK = ITEMS.register("ak_stock", () -> new CustomItem(new Item.Properties(), "ak_stock"));

    public static final RegistryObject<Item> M4A1_MAGAZINE = ITEMS.register("m4a1_magazine", () -> new CustomItem(new Item.Properties(), "m4a1_magazine"));

    public static final RegistryObject<Item> M4A1_STOCK = ITEMS.register("m4a1_stock", () -> new CustomItem(new Item.Properties(), "m4a1_stock"));

    public static final RegistryObject<Item> M4A1_BODY = ITEMS.register("m4a1_body", () -> new CustomItem(new Item.Properties(), "m4a1_body"));

    public static final RegistryObject<Item> M4A1_BARREL = ITEMS.register("m4a1_barrel", () -> new CustomItem(new Item.Properties(), "m4a1_barrel"));

    public static final RegistryObject<Item> AN94_STOCK = ITEMS.register("an94_stock", () -> new CustomItem(new Item.Properties(), "an94_stock"));



    @SubscribeEvent
    public static void onItemRegister(RegisterEvent event) {
        if (event.getRegistryKey().equals(ForgeRegistries.ITEMS.getRegistryKey())) {
            GunItemManager.registerGunItem(ModernKineticGunItem.TYPE_NAME, MODERN_KINETIC_GUN);
        }
    }
}