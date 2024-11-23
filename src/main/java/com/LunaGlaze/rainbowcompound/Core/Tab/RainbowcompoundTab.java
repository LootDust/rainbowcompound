package com.LunaGlaze.rainbowcompound.Core.Tab;

import com.LunaGlaze.rainbowcompound.Linkage.createaddition.CCAItemRegistry;
import com.LunaGlaze.rainbowcompound.Linkage.farmersdelight.farmersdelightItemRegistry;
import com.LunaGlaze.rainbowcompound.LunaUtils;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.ArmorsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Basic.ItemsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Basic.RainbowCompound;
import com.LunaGlaze.rainbowcompound.Projects.Items.Foods.FoodsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Props.PropsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Tools.ToolsItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class RainbowcompoundTab {
    public static boolean isFarmersDelightLoaded = false;

    public static boolean isCuriousElytraLoaded = false;

    public static boolean isCreateCraftAddLoaded = false;

    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LunaUtils.MOD_ID);
    public static RegistryObject<CreativeModeTab> MOD_TAB = REGISTRY.register("rainbowcompound_group", () -> CreativeModeTab.builder()
            .icon(() -> (new ItemStack((ItemLike) ItemsItemRegistry.rainbowcompound.get())))
            .title(Component.translatable("tab.un_combat"))
            .displayItems((parameters, output) -> {
                // Basics
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.rainbowcompound.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.blazeiteingot.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.chorusiteingot.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.enderiteingot.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.frostiteingot.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.glowstoneiteingot.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.netherwartiteingot.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.warpediteingot.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.slimeiteingot.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.strangecoloredingot.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.obsidianiteingot.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.obsidianitestick.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.lapissheet.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.integratedcircuit.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.shadowsteelsheet.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.refinedradiancesheet.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.shadowmechanism.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.radiancemechanism.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.shadowresonantassembly.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.radianceresonantassembly.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.hauntedmembrane.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.enderquartz.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.polishedenderquartz.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.netherstaringot.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.obsidianiteupgradekit.get()));
                output.accept(new ItemStack((ItemLike)ItemsItemRegistry.rainbowupgradekit.get()));
                // Foods
                output.accept(new ItemStack((ItemLike)FoodsItemRegistry.rainbowapple.get()));
                output.accept(new ItemStack((ItemLike)FoodsItemRegistry.honeyedporkchop.get()));
                // Props
                output.accept(new ItemStack((ItemLike)PropsItemRegistry.homemagicmirror.get()));
                output.accept(new ItemStack((ItemLike)PropsItemRegistry.shadowring.get()));
                output.accept(new ItemStack((ItemLike)PropsItemRegistry.radiancering.get()));
                // Tools
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.obsidianitesword.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.obsidianiteaxe.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.obsidianitepickaxe.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.obsidianiteshovel.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.obsidianitehoe.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.obsidianitebow.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.rainbowsword.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.rainbowaxe.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.rainbowpickaxe.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.rainbowshovel.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.rainbowhoe.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.shadowsteelsword.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.shadowsteelaxe.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.shadowsteelpickaxe.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.shadowsteelshovel.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.shadowsteelmattock.get()));
                output.accept(new ItemStack((ItemLike)ToolsItemRegistry.refinedradiancescythes.get()));
                // Armors
                output.accept(new ItemStack((ItemLike)ArmorsItemRegistry.obsidianitehelmet.get()));
                output.accept(new ItemStack((ItemLike)ArmorsItemRegistry.obsidianitechestplate.get()));
                output.accept(new ItemStack((ItemLike)ArmorsItemRegistry.obsidianiteleggings.get()));
                output.accept(new ItemStack((ItemLike)ArmorsItemRegistry.obsidianiteboots.get()));
                output.accept(new ItemStack((ItemLike)ArmorsItemRegistry.rainbowhelmet.get()));
                output.accept(new ItemStack((ItemLike)ArmorsItemRegistry.rainbowchestplate.get()));
                output.accept(new ItemStack((ItemLike)ArmorsItemRegistry.rainbowleggings.get()));
                output.accept(new ItemStack((ItemLike)ArmorsItemRegistry.rainbowboots.get()));
                // Farmers' Delight Linkage
                if (isFarmersDelightLoaded) {
                    output.accept(new ItemStack((ItemLike)farmersdelightItemRegistry.obsidianiteknife.get()));
                }
                // Curios Linkage
                if (isCuriousElytraLoaded) {

                } else {

                }
                // Create Additions Linkage
                if (isCreateCraftAddLoaded) {
                    output.accept(new ItemStack((ItemLike)CCAItemRegistry.overchargedalloy.get()));
                }
            })
            .build()
    );
}
