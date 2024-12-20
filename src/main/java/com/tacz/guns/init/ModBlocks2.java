/*package com.tacz.guns.init;

import com.tacz.guns.GunMod;
import com.tacz.guns.blocks.*;
import com.tacz.guns.util.Tiers;
import com.tacz.guns.block.GunSmithTableBlock;
import com.tacz.guns.block.StatueBlock;
import com.tacz.guns.block.TargetBlock;
import com.tacz.guns.block.entity.GunSmithTableBlockEntity;
import com.tacz.guns.block.entity.StatueBlockEntity;
import com.tacz.guns.block.entity.TargetBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GunMod.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GunMod.MOD_ID);

    public static RegistryObject<Block> GUN_SMITH_TABLE = BLOCKS.register("gun_smith_table", GunSmithTableBlock::new);
    public static RegistryObject<Block> TARGET = BLOCKS.register("target", TargetBlock::new);
    public static RegistryObject<Block> STATUE = BLOCKS.register("statue", StatueBlock::new);

    public static RegistryObject<BlockEntityType<GunSmithTableBlockEntity>> GUN_SMITH_TABLE_BE = TILE_ENTITIES.register("gun_smith_table", () -> GunSmithTableBlockEntity.TYPE);
    public static RegistryObject<BlockEntityType<TargetBlockEntity>> TARGET_BE = TILE_ENTITIES.register("target", () -> TargetBlockEntity.TYPE);
    public static RegistryObject<BlockEntityType<StatueBlockEntity>> STATUE_BE = TILE_ENTITIES.register("statue", () -> StatueBlockEntity.TYPE);

    public static final RegistryObject<Block> THATCH_WALL = BLOCKS.register("thatch_wall", () -> new Wall(Tiers.TIER.THATCH));
    public static final RegistryObject<Block> WOODEN_WALL = BLOCKS.register("wooden_wall", () -> new Wall(Tiers.TIER.WOOD));
    public static final RegistryObject<Block> STONE_WALL = BLOCKS.register("stone_wall", () -> new Wall(Tiers.TIER.STONE));
    public static final RegistryObject<Block> METAL_WALL = BLOCKS.register("metal_wall", () -> new Wall(Tiers.TIER.METAL));
    public static final RegistryObject<Block> ARMORED_WALL = BLOCKS.register("armored_wall", () -> new Wall(Tiers.TIER.ARMOR));

    public static final RegistryObject<Block> THATCH_WALL_FLOOR = BLOCKS.register("thatch_wall_floor", () -> new WallFloor(Tiers.TIER.THATCH));
    public static final RegistryObject<Block> WOODEN_WALL_FLOOR = BLOCKS.register("wooden_wall_floor", () -> new WallFloor(Tiers.TIER.WOOD));
    public static final RegistryObject<Block> STONE_WALL_FLOOR = BLOCKS.register("stone_wall_floor", () -> new WallFloor(Tiers.TIER.STONE));
    public static final RegistryObject<Block> METAL_WALL_FLOOR = BLOCKS.register("metal_wall_floor", () -> new WallFloor(Tiers.TIER.METAL));
    public static final RegistryObject<Block> ARMORED_WALL_FLOOR = BLOCKS.register("armored_wall_floor", () -> new WallFloor(Tiers.TIER.ARMOR));



    public static final RegistryObject<Block> THATCH_WALL_DOOR = BLOCKS.register("thatch_wall_door", () -> new WallDoor(Tiers.TIER.THATCH));
    public static final RegistryObject<Block> WOODEN_WALL_DOOR = BLOCKS.register("wooden_wall_door", () -> new WallDoor(Tiers.TIER.WOOD));
    public static final RegistryObject<Block> STONE_WALL_DOOR = BLOCKS.register("stone_wall_door", () -> new WallDoor(Tiers.TIER.STONE));
    public static final RegistryObject<Block> METAL_WALL_DOOR = BLOCKS.register("metal_wall_door", () -> new WallDoor(Tiers.TIER.METAL));
    public static final RegistryObject<Block> ARMORED_WALL_DOOR = BLOCKS.register("armored_wall_door", () -> new WallDoor(Tiers.TIER.ARMOR));




    public static final RegistryObject<Block> THATCH_WALL_WINDOW = BLOCKS.register("thatch_wall_window", () -> new WallWindow(Tiers.TIER.THATCH));
    public static final RegistryObject<Block> WOODEN_WALL_WINDOW = BLOCKS.register("wooden_wall_window", () -> new WallWindow(Tiers.TIER.WOOD));
    public static final RegistryObject<Block> STONE_WALL_WINDOW = BLOCKS.register("stone_wall_window", () -> new WallWindow(Tiers.TIER.STONE));
    public static final RegistryObject<Block> METAL_WALL_WINDOW = BLOCKS.register("metal_wall_window", () -> new WallWindow(Tiers.TIER.METAL));
    public static final RegistryObject<Block> ARMORED_WALL_WINDOW = BLOCKS.register("armored_wall_window", () -> new WallWindow(Tiers.TIER.ARMOR));



    public static final RegistryObject<Block> THATCH_WALL_WINDOW_FRAME = BLOCKS.register("thatch_wall_window_frame", () -> new WallWindowFrame(Tiers.TIER.THATCH));
    public static final RegistryObject<Block> WOODEN_WALL_WINDOW_FRAME = BLOCKS.register("wooden_wall_window_frame", () -> new WallWindowFrame(Tiers.TIER.WOOD));
    public static final RegistryObject<Block> STONE_WALL_WINDOW_FRAME = BLOCKS.register("stone_wall_window_frame", () -> new WallWindowFrame(Tiers.TIER.STONE));
    public static final RegistryObject<Block> METAL_WALL_WINDOW_FRAME = BLOCKS.register("metal_wall_window_frame", () -> new WallWindowFrame(Tiers.TIER.METAL));
    public static final RegistryObject<Block> ARMORED_WALL_WINDOW_FRAME = BLOCKS.register("armored_wall_window_frame", () -> new WallWindowFrame(Tiers.TIER.ARMOR));


    public static final RegistryObject<Block> THATCH_WALL_DOOR_FRAME = BLOCKS.register("thatch_wall_door_frame", () -> new WallDoorFrame(Tiers.TIER.THATCH));
    public static final RegistryObject<Block> WOODEN_WALL_DOOR_FRAME = BLOCKS.register("wooden_wall_door_frame", () -> new WallDoorFrame(Tiers.TIER.WOOD));
    public static final RegistryObject<Block> STONE_WALL_DOOR_FRAME = BLOCKS.register("stone_wall_door_frame", () -> new WallDoorFrame(Tiers.TIER.STONE));
    public static final RegistryObject<Block> METAL_WALL_DOOR_FRAME = BLOCKS.register("metal_wall_door_frame", () -> new WallDoorFrame(Tiers.TIER.METAL));
    public static final RegistryObject<Block> ARMORED_WALL_DOOR_FRAME = BLOCKS.register("armored_wall_door_frame", () -> new WallDoorFrame(Tiers.TIER.ARMOR));



    public static final RegistryObject<Block> THATCH_WALL_PILLAR = BLOCKS.register("thatch_wall_pillar", () -> new WallPillar(Tiers.TIER.THATCH));
    public static final RegistryObject<Block> WOODEN_WALL_PILLAR = BLOCKS.register("wooden_wall_pillar", () -> new WallPillar(Tiers.TIER.WOOD));
    public static final RegistryObject<Block> STONE_WALL_PILLAR = BLOCKS.register("stone_wall_pillar", () -> new WallPillar(Tiers.TIER.STONE));
    public static final RegistryObject<Block> METAL_WALL_PILLAR = BLOCKS.register("metal_wall_pillar", () -> new WallPillar(Tiers.TIER.METAL));
    public static final RegistryObject<Block> ARMORED_WALL_PILLAR = BLOCKS.register("armored_wall_pillar", () -> new WallPillar(Tiers.TIER.ARMOR));




    public static final RegistryObject<Block> THATCH_WALL_HATCH = BLOCKS.register("thatch_wall_hatch", () -> new WallHatch(Tiers.TIER.THATCH));
    public static final RegistryObject<Block> WOODEN_WALL_HATCH = BLOCKS.register("wooden_wall_hatch", () -> new WallHatch(Tiers.TIER.WOOD));
    public static final RegistryObject<Block> STONE_WALL_HATCH = BLOCKS.register("stone_wall_hatch", () -> new WallHatch(Tiers.TIER.STONE));
    public static final RegistryObject<Block> METAL_WALL_HATCH = BLOCKS.register("metal_wall_hatch", () -> new WallHatch(Tiers.TIER.METAL));
    public static final RegistryObject<Block> ARMORED_WALL_HATCH = BLOCKS.register("armored_wall_hatch", () -> new WallHatch(Tiers.TIER.ARMOR));

   // public static final RegistryObject<Block> LOOT_CRATE = BLOCKS.register("loot_crate", () -> new LootCrate(
     //       BlockBehaviour.Properties.copy(Blocks.CHEST).noOcclusion()));
}
*/