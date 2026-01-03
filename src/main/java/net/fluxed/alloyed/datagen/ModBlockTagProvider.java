package net.fluxed.alloyed.datagen;

import net.fluxed.alloyed.Alloyed;
import net.fluxed.alloyed.block.ModBlocks;
import net.fluxed.alloyed.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Alloyed.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ROSE_GOLD_BLOCK.get())
                .add(ModBlocks.FLUXED_BLOCK.get());
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ROSE_GOLD_BLOCK.get())
                .add(ModBlocks.FLUXED_BLOCK.get());

        tag(ModTags.Blocks.INCORRECT_FOR_ROSE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_ROSE_TOOL);
        tag(ModTags.Blocks.NEEDS_ROSE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
        tag(ModTags.Blocks.NEEDS_FLUXED_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_FLUXED_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_FLUXED_TOOL);
    }
}
