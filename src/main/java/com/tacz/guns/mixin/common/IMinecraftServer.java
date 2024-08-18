package com.tacz.guns.mixin.common;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import virtuoel.pehkui.api.ScaleData;

@Mixin(MinecraftServer.class)
public interface IMinecraftServer {
    @Accessor
    LevelStorageSource.LevelStorageAccess getStorageSource();
}
