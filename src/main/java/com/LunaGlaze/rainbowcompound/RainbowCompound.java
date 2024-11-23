package com.LunaGlaze.rainbowcompound;

import com.LunaGlaze.rainbowcompound.Core.Curios.Curios;
import com.LunaGlaze.rainbowcompound.Core.Date.KeyBoard.ElytraFlyKey;
import com.LunaGlaze.rainbowcompound.Core.Date.LunaConfig;
import com.LunaGlaze.rainbowcompound.Core.Tab.RainbowcompoundTab;
import com.LunaGlaze.rainbowcompound.Linkage.createaddition.CCAItemRegistry;
import com.LunaGlaze.rainbowcompound.Linkage.elytraslot.CuriosElytra;
import com.LunaGlaze.rainbowcompound.Linkage.farmersdelight.farmersdelightItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Effect.EffectRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.ArmorsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.CuriosElytraItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Armors.ElytraItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Basic.ItemsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Foods.FoodsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.Props.PropsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Items.SequencedAssembly.IncompleteItems;
import com.LunaGlaze.rainbowcompound.Projects.Items.Tools.ToolsItemRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Blocks.BlocksBlockRegistry;
import com.LunaGlaze.rainbowcompound.Projects.Blocks.BlocksItemRegistry;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.client.KeyMapping;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LunaUtils.MOD_ID)
public class RainbowCompound {

    public static boolean isFarmersDelightLoaded = false;
    public static boolean isCuriousElytraLoaded = false;
    public static boolean isCreateCraftAddLoaded = false;

    public RainbowCompound(){
        IEventBus registerEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        isFarmersDelightLoaded = ModList.get().isLoaded("farmersdelight");
        isCuriousElytraLoaded = ModList.get().isLoaded("elytraslot");
        isCreateCraftAddLoaded = ModList.get().isLoaded("createaddition");

        onCreate();
        registerEventBus.addListener(this::addCreative);

        FoodsItemRegistry.ITEMS.register(registerEventBus);
        ItemsItemRegistry.ITEMS.register(registerEventBus);
        ToolsItemRegistry.ITEMS.register(registerEventBus);
        ArmorsItemRegistry.ITEMS.register(registerEventBus);
        if(isCuriousElytraLoaded) {
            CuriosElytra.init(registerEventBus, forgeEventBus);
            CuriosElytraItemRegistry.ITEMS.register(registerEventBus);
        } else {
            ElytraItemRegistry.ITEMS.register(registerEventBus);
        }
        PropsItemRegistry.ITEMS.register(registerEventBus);
        BlocksBlockRegistry.BLOCKS.register(registerEventBus);
        BlocksItemRegistry.ITEMS.register(registerEventBus);
        EffectRegistry.EFFECTS.register(registerEventBus);

        if(isFarmersDelightLoaded) {
            farmersdelightItemRegistry.ITEMS.register(registerEventBus);
        }
        if(isCreateCraftAddLoaded) {
            CCAItemRegistry.ITEMS.register(registerEventBus);
        }

        RainbowcompoundTab.REGISTRY.register(registerEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, LunaConfig.COMMON_CONFIG);

        Curios.init(registerEventBus, forgeEventBus);
    }
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(LunaUtils.MOD_ID);
    public static void onCreate() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get()
                .getModEventBus();

        REGISTRATE.registerEventListeners(modEventBus);

        IncompleteItems.register();
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == AllCreativeModeTabs.BASE_CREATIVE_TAB.getKey()) {
            event.accept(new ItemStack(AllItems.CHROMATIC_COMPOUND.get()));
            event.accept(new ItemStack(AllItems.SHADOW_STEEL.get()));
            event.accept(new ItemStack(AllItems.REFINED_RADIANCE.get()));
            event.accept(new ItemStack(AllBlocks.SHADOW_STEEL_CASING.get()));
            event.accept(new ItemStack(AllBlocks.REFINED_RADIANCE_CASING.get()));
        }
    }

    @Mod.EventBusSubscriber(modid = LunaUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            for (ElytraFlyKey key : ElytraFlyKey.values()) {
                key.keybind = new KeyMapping(key.description, key.key, LunaUtils.NAME);
                if (!key.modifiable)
                    continue;

                event.register(key.keybind);
            }
        }
    }
}