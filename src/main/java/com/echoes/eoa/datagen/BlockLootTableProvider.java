package com.echoes.eoa.datagen;

import com.echoes.eoa.common.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BlockLootTableProvider extends BlockLootSubProvider {
    protected BlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropWhenSilkTouch(ModBlocks.CHORUS_GRASS.get());
        createShearsOnlyDrop(ModBlocks.CHORUS_GRASS.get());

        dropSelf(ModBlocks.CRACKED_BRICKS.get());
        dropSelf(ModBlocks.CRACKED_BRICK_STAIRS.get());
        dropSelf(ModBlocks.CRACKED_BRICK_SLAB.get());
        dropSelf(ModBlocks.CRACKED_BRICK_WALL.get());

        dropSelf(ModBlocks.CRACKED_STONE_BRICK_STAIRS.get());
        dropSelf(ModBlocks.CRACKED_STONE_BRICK_SLAB.get());
        dropSelf(ModBlocks.CRACKED_STONE_BRICK_WALL.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
