package net.fluxed.alloyed.item;

import net.fluxed.alloyed.Alloyed;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

        public class ModItems {
            public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Alloyed.MOD_ID);

            public static final DeferredItem<Item> GOLD_DUST = ITEMS.registerItem("gold_powder",
                    Item::new, new Item.Properties());
            public static final DeferredItem<Item> IRON_DUST = ITEMS.registerItem("iron_powder",
                    Item::new, new Item.Properties());
            public static final DeferredItem<Item> COPPER_DUST = ITEMS.registerItem("copper_powder",
                    Item::new, new Item.Properties());

            public static final DeferredItem<Item> ROSE_GOLD = ITEMS.registerItem("rose_gold_ingot",
            Item::new, new Item.Properties());
            public static final DeferredItem<Item> ROSE_GOLD_NUGGET = ITEMS.registerItem("rose_gold_nugget",
            Item::new, new Item.Properties());
            public static final DeferredItem<Item> ROSE_GOLD_BLEND = ITEMS.registerItem("rose_gold_blend",
            Item::new, new Item.Properties());

            public static final DeferredItem<Item> ROSE_SWORD = ITEMS.registerItem("rose_gold_sword",
                    (properties) -> new Item(properties.sword(ModToolTiers.ROSE_GOLD, 3, -2.4f)));
            public static final DeferredItem<Item> ROSE_PICKAXE = ITEMS.registerItem("rose_gold_pickaxe",
                    (properties) -> new Item(properties.pickaxe(ModToolTiers.ROSE_GOLD, 1, -2.8f)));
            public static final DeferredItem<Item> ROSE_AXE = ITEMS.registerItem("rose_gold_axe",
                    (properties) -> new Item(properties.axe(ModToolTiers.ROSE_GOLD, 5, -3f)));
            public static final DeferredItem<Item> ROSE_SHOVEL = ITEMS.registerItem("rose_gold_shovel",
                    (properties) -> new Item(properties.shovel(ModToolTiers.ROSE_GOLD, 1.5f, -3f)));
            public static final DeferredItem<Item> ROSE_HOE = ITEMS.registerItem("rose_gold_hoe",
                    (properties) -> new Item(properties.hoe(ModToolTiers.ROSE_GOLD, -1, 0)));
            public static final DeferredItem<Item> ROSE_SPEAR = ITEMS.registerItem("rose_gold_spear",
                    (properties) -> new Item(properties.spear(ModToolTiers.ROSE_GOLD, 0.85f, 0.82f,
                            0.62f, 4.0f, 9.0f, 8.25f, 5.1f,
                            13.75f, 4.6f)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
