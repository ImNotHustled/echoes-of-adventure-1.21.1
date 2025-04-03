package com.echoes.eoa.datagen;

import com.echoes.eoa.EchoesOfAdventure;
import com.echoes.eoa.common.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends BlockTagsProvider {
    public BlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EchoesOfAdventure.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(BlockTags.STAIRS)
                .add(ModBlocks.CRACKED_BRICK_STAIRS.get())
                .add(ModBlocks.CRACKED_STONE_BRICK_STAIRS.get());
        tag(BlockTags.SLABS)
                .add(ModBlocks.CRACKED_BRICK_SLAB.get())
                .add(ModBlocks.CRACKED_STONE_BRICK_SLAB.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.CRACKED_BRICK_WALL.get())
                .add(ModBlocks.CRACKED_STONE_BRICK_WALL.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CRACKED_BRICKS.get())
                .add(ModBlocks.CRACKED_BRICK_STAIRS.get())
                .add(ModBlocks.CRACKED_STONE_BRICK_STAIRS.get())
                .add(ModBlocks.CRACKED_BRICK_SLAB.get())
                .add(ModBlocks.CRACKED_STONE_BRICK_SLAB.get())
                .add(ModBlocks.CRACKED_BRICK_WALL.get())
                .add(ModBlocks.CRACKED_STONE_BRICK_WALL.get());
    }
}
