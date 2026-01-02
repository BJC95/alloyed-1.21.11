package net.fluxed.alloyed.item;

import net.fluxed.alloyed.Alloyed;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

        public class ModItems {
            public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Alloyed.MOD_ID);

            public static final DeferredItem<Item> ROSE_GOLD = ITEMS.registerItem("rose_gold",
            Item::new, new Item.Properties());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
