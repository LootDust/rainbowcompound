package com.LunaGlaze.rainbowcompound.Projects.Items.Basic;

import com.LunaGlaze.rainbowcompound.Core.Tab.RainbowcompoundTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class RainbowCompound extends Item {
    public RainbowCompound() {
        super(new Properties().tab(RainbowcompoundTab.group).fireResistant().rarity(Rarity.UNCOMMON));
    }
}