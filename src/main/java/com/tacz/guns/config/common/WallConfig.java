package com.tacz.guns.config.common;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class WallConfig {
    public static ForgeConfigSpec.IntValue MATERIAL_PER_BLOCK;
    public static ForgeConfigSpec.IntValue DESTRUCTION_MODE;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> WHITELIST;

    public static  ForgeConfigSpec.DoubleValue THATCH_RESISTANCE;
    public static  ForgeConfigSpec.DoubleValue WOODEN_RESISTANCE;
    public static  ForgeConfigSpec.DoubleValue STONE_RESISTANCE;
    public static  ForgeConfigSpec.DoubleValue METAL_RESISTANCE;
    public static  ForgeConfigSpec.DoubleValue ARMORED_RESISTANCE;

    public static  ForgeConfigSpec.IntValue MATERIAL_REPAIR;
    public static  ForgeConfigSpec.DoubleValue REPAIR_PERCENTAGE;
    public static  ForgeConfigSpec.IntValue REPAIR_AMOUNT;

    public static void init(ForgeConfigSpec.Builder builder) {
        builder.push("walls");

        builder.comment("Amount of material to build or upgrade a tile per block; total material = number of block x this value (default 2)");
        MATERIAL_PER_BLOCK = builder.defineInRange("materialPerBlock", 2, 1, 7);


        builder.comment("Amount of material required to repair a structure");
        MATERIAL_REPAIR = builder.defineInRange("materialRepair", 1, 0, 255);


        builder.comment("Structure Block destruction integration with TACZ mod. 0 - no destruction, 1 - all structure blocks from justwalls, 2 - whitelist, 3 - all blocks");
        DESTRUCTION_MODE = builder.defineInRange("mode", 1, 0, 3);

        builder.comment("whitelist for blocks that can be destroyed by TACZ");
        WHITELIST = builder.defineList("whitelist", Arrays.asList("minecraft:stone"), entry -> true);


        builder.comment("Percentage of Max HP that would be restored to structure when repairing (default 0.2)");
        REPAIR_PERCENTAGE = builder.defineInRange("repairPercentage", 0.2, 0, 1);

        builder.comment("Amount of HP that would be restored to a structure when repairing. This is added after repairPercentage (default 0)");
        REPAIR_AMOUNT = builder.defineInRange("repairAmount", 0, 0, Integer.MAX_VALUE);

        builder.comment("Amount of HP multiplier structures with this tier have x100 (default 3 = 300hp)");
        THATCH_RESISTANCE = builder.defineInRange("thatchResistance",  3, 1, 1000d);

        builder.comment("Amount of HP multiplier structures with this tier have x100 (default 5 = 500hp)");
        WOODEN_RESISTANCE  = builder.defineInRange("woodenResistance",  5, 1, 1000d);

        builder.comment("Amount of HP multiplier structures with this tier have x100 (default 7.5 = 750hp)");
        STONE_RESISTANCE  = builder.defineInRange("stoneResistance",  7.5, 1, 1000d);

        builder.comment("Amount of HP multiplier structures with this tier have x100 (default 7.5 = 750hp)");
        METAL_RESISTANCE  = builder.defineInRange("metalResistance",  10, 1, 1000d);

        builder.comment("Amount of HP multiplier structures with this tier have x100 (default 7.5 = 750hp)");
        ARMORED_RESISTANCE  = builder.defineInRange("armoredResistance",  12.5, 1, 1000d);



        builder.pop();
    }

}
