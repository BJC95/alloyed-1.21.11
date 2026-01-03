package net.fluxed.alloyed.item;

import net.fluxed.alloyed.Alloyed;
import net.fluxed.alloyed.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Alloyed.MOD_ID);

    public static final Supplier<CreativeModeTab> ALLOYED_MATERIALS_TAB = CREATIVE_MODE_TAB.register("materials_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ROSE_GOLD.get()))
                    .title(Component.translatable("creativetab.flx_alloys.materials_tab"))
                    .displayItems((itemDisplayPerameters, output) -> {
                        output.accept(ModItems.IRON_DUST);
                        output.accept(ModItems.COPPER_DUST);
                        output.accept(ModItems.GOLD_DUST);

                        output.accept(ModItems.ROSE_GOLD);
                        output.accept(ModItems.ROSE_GOLD_NUGGET);
                        output.accept(ModItems.ROSE_GOLD_BLEND);
                        output.accept(ModBlocks.ROSE_GOLD_BLOCK);
                    }).build());
    public static final Supplier<CreativeModeTab> ALLOYED_TOOLS_TAB = CREATIVE_MODE_TAB.register("tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ROSE_GOLD.get()))
                    .title(Component.translatable("creativetab.flx_alloys.tools_tab"))
                    .displayItems((itemDisplayPerameters, output) -> {
                        output.accept(ModItems.ROSE_SWORD);
                        output.accept(ModItems.ROSE_PICKAXE);
                        output.accept(ModItems.ROSE_AXE);
                        output.accept(ModItems.ROSE_SHOVEL);
                        output.accept(ModItems.ROSE_HOE);
                        output.accept(ModItems.ROSE_SPEAR);
                    }).build());

                        public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
