package com.tacz.guns.init;


import com.tacz.guns.GunMod;
//import com.tacz.guns.blockEntity.BlockEntityLootCrate;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntity {
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GunMod.MOD_ID);

    // public static RegistryObject<BlockEntityType<BlockEntityLootCrate>> LOOT_CRATE =
    // BLOCK_ENTITIES.register("loot_crate", ()-> BlockEntityType.Builder.of(
                //    BlockEntityLootCrate::new, ModBlocks.LOOT_CRATE.get()
                    //  ).build(null));
}
