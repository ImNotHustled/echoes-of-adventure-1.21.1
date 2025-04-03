package com.echoes.eoa.datagen;

import com.echoes.eoa.common.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {
    public RecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        super.buildRecipes(recipeOutput);
        simpleCookingRecipe(recipeOutput, "smelting", RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, 200, Blocks.BRICKS, ModBlocks.CRACKED_BRICKS, 0.1F);

        stairBuilder(ModBlocks.CRACKED_BRICK_STAIRS, Ingredient.of(ModBlocks.CRACKED_BRICKS))
                .unlockedBy("has_cracked_bricks", has(ModBlocks.CRACKED_BRICKS))
                .save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICK_SLAB, Ingredient.of(ModBlocks.CRACKED_BRICKS))
                .unlockedBy("has_cracked_bricks", has(ModBlocks.CRACKED_BRICKS))
                .save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICK_WALL, Ingredient.of(ModBlocks.CRACKED_BRICKS))
                .unlockedBy("has_cracked_bricks", has(ModBlocks.CRACKED_BRICKS))
                .save(recipeOutput);

        stairBuilder(ModBlocks.CRACKED_STONE_BRICK_STAIRS, Ingredient.of(Blocks.CRACKED_STONE_BRICKS))
                .unlockedBy("has_cracked_stone_bricks", has(Blocks.CRACKED_STONE_BRICKS))
                .save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_STONE_BRICK_SLAB, Ingredient.of(Blocks.CRACKED_STONE_BRICKS))
                .unlockedBy("has_cracked_stone_bricks", has(Blocks.CRACKED_STONE_BRICKS))
                .save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_STONE_BRICK_WALL, Ingredient.of(Blocks.CRACKED_STONE_BRICKS))
                .unlockedBy("has_cracked_stone_bricks", has(Blocks.CRACKED_STONE_BRICKS))
                .save(recipeOutput);
    }
}
