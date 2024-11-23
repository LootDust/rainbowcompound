package com.LunaGlaze.rainbowcompound.Projects.Items.Tools;

import com.LunaGlaze.rainbowcompound.Core.Tab.RainbowcompoundTab;
import com.LunaGlaze.rainbowcompound.Core.Tiers.ToolTiers;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;

public class RainbowShovel extends ShovelItem {
    public RainbowShovel() {
        super(ToolTiers.RAINBOW, 1.5f, -3f, new Properties().tab(RainbowcompoundTab.group).fireResistant().rarity(Rarity.UNCOMMON));
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(2, pAttacker, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        pTarget.addEffect(new MobEffectInstance(MobEffects.GLOWING,7*20,0));
        return true;
    }
}
