package com.tacz.guns.util;

import java.lang.reflect.Method;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.InstrumentItem;

public class ReflectionUtil {

    public static Object invokeGetInstrument(ItemStack stack) {
        try {
            Method method = InstrumentItem.class.getDeclaredMethod("getInstrument", ItemStack.class);
            method.setAccessible(true);
            return method.invoke(null, stack); // null para métodos estáticos
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
