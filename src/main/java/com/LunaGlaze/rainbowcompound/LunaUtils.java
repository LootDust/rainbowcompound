package com.LunaGlaze.rainbowcompound;

import net.minecraft.resources.ResourceLocation;

public class LunaUtils {
    public static final String MOD_ID = "rainbowcompound";
    public static final String NAME = "Rainbow Compound";

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

}
