package net.fluxed.alloyed.util;

import net.fluxed.alloyed.Alloyed;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ROSE_TOOL = createTag("needs_rose_tool");
        public static final TagKey<Block> INCORRECT_FOR_ROSE_TOOL = createTag("incorrect_for_rose_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(Alloyed.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ROSE_REPAIRABLE = createTag("rose_gold_repairable");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(Alloyed.MOD_ID, name));
        }
    }

}
