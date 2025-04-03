package com.echoes.eoa.datagen;

import com.echoes.eoa.EchoesOfAdventure;
import com.echoes.eoa.common.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EchoesOfAdventure.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleBlockItem(ModBlocks.CHORUS_GRASS.get());
        
        simpleBlockItem(ModBlocks.CRACKED_BRICKS.get());
        registerWall(ModBlocks.CRACKED_BRICK_WALL, ModBlocks.CRACKED_BRICKS);
        registerStairs(ModBlocks.CRACKED_BRICK_STAIRS, ModBlocks.CRACKED_BRICKS);
        registerSlab(ModBlocks.CRACKED_BRICK_SLAB, ModBlocks.CRACKED_BRICKS);

        ResourceLocation stone_bricks = ResourceLocation.withDefaultNamespace("block/stone_bricks");
        stairs(ModBlocks.CRACKED_STONE_BRICK_STAIRS.getRegisteredName(), stone_bricks, stone_bricks, stone_bricks);
        slab(ModBlocks.CRACKED_STONE_BRICK_SLAB.getRegisteredName(), stone_bricks, stone_bricks, stone_bricks);
        registerWall(ModBlocks.CRACKED_STONE_BRICK_WALL, "minecraft", "stone_bricks");
    }

    protected void registerStairs(DeferredBlock<StairBlock> block, DeferredBlock<Block> from) {
        String id = block.getRegisteredName();
        ResourceLocation texture = from.getId().withPrefix("block/");

        this.stairs(id, texture, texture, texture);
    }

    protected void registerSlab(DeferredBlock<SlabBlock> block, DeferredBlock<Block> from) {
        String id = block.getRegisteredName();
        ResourceLocation texture = from.getId().withPrefix("block/");

        this.slab(id, texture, texture, texture);
    }

    protected void registerWall(DeferredBlock<WallBlock> block, DeferredBlock<Block> from) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(EchoesOfAdventure.MOD_ID,
                        "block/" + from.getId().getPath()));
    }
    protected void registerWall(DeferredBlock<WallBlock> block, String namespace, String path) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(namespace,
                        "block/" + path));
    }
}
