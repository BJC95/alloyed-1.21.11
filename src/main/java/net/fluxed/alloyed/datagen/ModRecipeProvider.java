package net.fluxed.alloyed.datagen;

import net.fluxed.alloyed.Alloyed;
import net.fluxed.alloyed.block.ModBlocks;
import net.fluxed.alloyed.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "My Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        shapeless(RecipeCategory.TOOLS, ModItems.ROSE_GOLD_BLEND.get(), 4)
                .requires(ModItems.COPPER_DUST)
                .requires(ModItems.GOLD_DUST)
                .requires(ModItems.GOLD_DUST)
                .requires(ModItems.GOLD_DUST)
                .unlockedBy("has_gold", has(Tags.Items.INGOTS_COPPER)).save(output);

        shaped(RecipeCategory.TOOLS, ModBlocks.ROSE_GOLD_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.ROSE_GOLD.get())
                .unlockedBy("has_rose_gold", has(ModItems.ROSE_GOLD.get())).save(output);
        shapeless(RecipeCategory.TOOLS, ModItems.ROSE_GOLD.get(),9)
                .requires(ModBlocks.ROSE_GOLD_BLOCK)
                .unlockedBy("has_rose_gold", has(ModItems.ROSE_GOLD.get()))
                .save(output, "flx_alloys:rose_gold_ingot_from_block");
        shaped(RecipeCategory.TOOLS, ModItems.ROSE_GOLD.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.ROSE_GOLD_NUGGET.get())
                .unlockedBy("has_rose_gold", has(ModItems.ROSE_GOLD.get()))
                .save(output, "flx_alloys:rose_gold_ingot_from_nuggets");
        shapeless(RecipeCategory.TOOLS, ModItems.ROSE_GOLD_NUGGET.get(), 9)
                .requires(ModItems.ROSE_GOLD)
                .unlockedBy("has_rose_gold", has(ModItems.ROSE_GOLD.get())).save(output);
        oreSmelting(output, List.of(ModItems.ROSE_GOLD_BLEND.get()),
                RecipeCategory.TOOLS, ModItems.ROSE_GOLD.get(),
                0.25f, 200,"rose_gold_smelt");
        oreBlasting(output, List.of(ModItems.ROSE_GOLD_BLEND.get()),
                RecipeCategory.TOOLS, ModItems.ROSE_GOLD.get(),
                0.25f, 100,"rose_gold_smelt");

        stonecutting(
                RecipeCategory.TOOLS,
                ModItems.IRON_DUST, Items.IRON_INGOT, 1, output);
        stonecutting(
                RecipeCategory.TOOLS,
                ModItems.COPPER_DUST, Items.COPPER_INGOT, 1, output);
        stonecutting(
                RecipeCategory.TOOLS,
                ModItems.GOLD_DUST, Items.GOLD_INGOT, 1, output);
        stonecutting(
                RecipeCategory.TOOLS,
                ModItems.ROSE_GOLD_BLEND, ModItems.ROSE_GOLD, 1, output);

        shaped(RecipeCategory.TOOLS, ModItems.ROSE_SWORD.get())
                .pattern("R")
                .pattern("R")
                .pattern("/")
                .define('R', ModItems.ROSE_GOLD.get())
                .define('/', Items.STICK)
                .unlockedBy("has_rose_gold", has(ModItems.ROSE_GOLD.get())).save(output);
        shaped(RecipeCategory.TOOLS, ModItems.ROSE_PICKAXE.get())
                .pattern("RRR")
                .pattern(" / ")
                .pattern(" / ")
                .define('R', ModItems.ROSE_GOLD.get())
                .define('/', Items.STICK)
                .unlockedBy("has_rose_gold", has(ModItems.ROSE_GOLD.get())).save(output);
        shaped(RecipeCategory.TOOLS, ModItems.ROSE_AXE.get())
                .pattern("RR")
                .pattern("R/")
                .pattern(" /")
                .define('R', ModItems.ROSE_GOLD.get())
                .define('/', Items.STICK)
                .unlockedBy("has_rose_gold", has(ModItems.ROSE_GOLD.get())).save(output);
        shaped(RecipeCategory.TOOLS, ModItems.ROSE_SHOVEL.get())
                .pattern("R")
                .pattern("/")
                .pattern("/")
                .define('R', ModItems.ROSE_GOLD.get())
                .define('/', Items.STICK)
                .unlockedBy("has_rose_gold", has(ModItems.ROSE_GOLD.get())).save(output);
        shaped(RecipeCategory.TOOLS, ModItems.ROSE_HOE.get())
                .pattern("RR")
                .pattern(" /")
                .pattern(" /")
                .define('R', ModItems.ROSE_GOLD.get())
                .define('/', Items.STICK)
                .unlockedBy("has_rose_gold", has(ModItems.ROSE_GOLD.get())).save(output);
        shaped(RecipeCategory.TOOLS, ModItems.ROSE_SPEAR.get())
                .pattern("  R")
                .pattern(" / ")
                .pattern("/  ")
                .define('R', ModItems.ROSE_GOLD.get())
                .define('/', Items.STICK)
                .unlockedBy("has_rose_gold", has(ModItems.ROSE_GOLD.get())).save(output);

    }

    protected void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                               float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                               float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected void oreSmoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                              float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    protected <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Alloyed.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
    protected void stonecutting(RecipeCategory category, ItemLike result, ItemLike material, int resultCount, RecipeOutput output) {
        SingleItemRecipeBuilder recipeBuilder = SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), category, result, resultCount).unlockedBy(getHasName(material), this.has(material));
        recipeBuilder.save(output, Alloyed.MOD_ID + ":" + getItemName(result) + "_from_" + getItemName(material) + "_stonecutting");
    }
}