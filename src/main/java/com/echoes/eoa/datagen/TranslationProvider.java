package com.echoes.eoa.datagen;

import com.echoes.eoa.EchoesOfAdventure;
import com.echoes.eoa.common.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class TranslationProvider extends LanguageProvider {
    public TranslationProvider(PackOutput output, String locale) {
        super(output, EchoesOfAdventure.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        // Blocks
        add(ModBlocks.CRACKED_BRICKS.get(), "Cracked Bricks");
        add(ModBlocks.CRACKED_BRICK_STAIRS.get(), "Cracked Brick Stairs");
        add(ModBlocks.CRACKED_BRICK_SLAB.get(), "Cracked Brick Slab");
        add(ModBlocks.CRACKED_BRICK_WALL.get(), "Cracked Brick Wall");

        add(ModBlocks.CRACKED_STONE_BRICK_STAIRS.get(), "Cracked Stone Brick Stairs");
        add(ModBlocks.CRACKED_STONE_BRICK_SLAB.get(), "Cracked Stone Slab");
        add(ModBlocks.CRACKED_STONE_BRICK_WALL.get(), "Cracked Stone Wall");

        // Others
        add("itemGroup.echoesofadventure", "Echoes of Adventure");
    }
}
