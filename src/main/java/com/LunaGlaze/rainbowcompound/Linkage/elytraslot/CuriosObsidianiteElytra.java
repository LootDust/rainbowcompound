package com.LunaGlaze.rainbowcompound.Linkage.elytraslot;

import com.LunaGlaze.rainbowcompound.Core.Tab.RainbowcompoundTab;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.simibubi.create.AllItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.UUID;

public class CuriosObsidianiteElytra extends CuriosModElytraItem implements ICurio {

    private static final UUID uuid = UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D");
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public CuriosObsidianiteElytra() {
        super(new Item.Properties().fireResistant().durability(864).rarity(Rarity.UNCOMMON));
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        int defense = this.getDefense();
        builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier", defense, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    private int getDefense(){
        return 3;
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(AllItems.POWDERED_OBSIDIAN.get());
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, net.minecraft.world.entity.LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                if ((flightTicks) % 25 == 0) {
                    stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.CHEST));
                }
                entity.gameEvent(GameEvent.ELYTRA_GLIDE);
            }
        }
        return true;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.CHEST ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }
}
