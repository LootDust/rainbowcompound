package com.LunaGlaze.rainbowcompound.Projects.Items.Basic;

import com.LunaGlaze.rainbowcompound.Core.Tab.RainbowcompoundTab;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SimpleFoiledItem;

public class NetherstarIngot extends SimpleFoiledItem {
    public NetherstarIngot() {
        super(new Properties().tab(RainbowcompoundTab.group).fireResistant().rarity(Rarity.UNCOMMON));
    }

}