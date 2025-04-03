package com.echoes.eoa.datagen;

import com.echoes.eoa.EchoesOfAdventure;
import com.echoes.eoa.common.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BlockStateProvider extends net.neoforged.neoforge.client.model.generators.BlockStateProvider {
    public BlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EchoesOfAdventure.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(ModBlocks.CHORUS_GRASS.get(), models().cross(ModBlocks.CHORUS_GRASS.getRegisteredName(), blockTexture(ModBlocks.CHORUS_GRASS.get())).renderType("cutout"));
        simpleBlock(ModBlocks.CRACKED_BRICKS.get());
        registerStairs(ModBlocks.CRACKED_BRICK_STAIRS, ModBlocks.CRACKED_BRICKS);
        registerSlab(ModBlocks.CRACKED_BRICK_SLAB, ModBlocks.CRACKED_BRICKS);
        registerWall(ModBlocks.CRACKED_BRICK_WALL, ModBlocks.CRACKED_BRICKS);

        registerStairs(ModBlocks.CRACKED_STONE_BRICK_STAIRS, Blocks.CRACKED_STONE_BRICKS);
        registerSlab(ModBlocks.CRACKED_STONE_BRICK_SLAB, Blocks.CRACKED_STONE_BRICKS);
        registerWall(ModBlocks.CRACKED_STONE_BRICK_WALL, Blocks.CRACKED_STONE_BRICKS);
    }

    private void registerStairs(DeferredBlock<StairBlock> block, DeferredBlock<Block> from) {
        ResourceLocation texture = blockTexture(from.get());

        stairsBlock(block.get(), texture);
    }
    private void registerStairs(DeferredBlock<StairBlock> block, Block from) {
        ResourceLocation texture = blockTexture(from);

        stairsBlock(block.get(), texture);
    }

    private void registerSlab(DeferredBlock<SlabBlock> block, DeferredBlock<Block> from) {
        ResourceLocation texture = blockTexture(from.get());

        slabBlock(block.get(), texture, texture);
    }
    private void registerSlab(DeferredBlock<SlabBlock> block, Block from) {
        ResourceLocation texture = blockTexture(from);

        slabBlock(block.get(), texture, texture);
    }

    private void registerWall(DeferredBlock<WallBlock> block, DeferredBlock<Block> from) {

        wallBlock(block.get(), blockTexture(from.get()));
    }
    private void registerWall(DeferredBlock<WallBlock> block, Block from) {

        wallBlock(block.get(), blockTexture(from));
    }
}
