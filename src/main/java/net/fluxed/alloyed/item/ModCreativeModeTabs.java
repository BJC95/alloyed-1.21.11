package net.fluxed.alloyed.item;

import net.fluxed.alloyed.Alloyed;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Alloyed.MOD_ID);

    public static final Supplier<CreativeModeTab> ALLOYED_MATERIALS_TAB = CREATIVE_MODE_TAB.register("materials_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ROSE_GOLD.get()))
                    .title(Component.translatable("creativetab.flx_alloyed.materials_tab"))
                    .displayItems((itemDisplayPerameters, output) -> {

                    }).build());

                        public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
