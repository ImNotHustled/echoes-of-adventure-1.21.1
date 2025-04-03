package com.echoes.eoa.datagen;

import com.echoes.eoa.EchoesOfAdventure;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = EchoesOfAdventure.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerationCore {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        boolean includeServer = event.includeServer();

        if (!includeServer) {return;}

        DataGenerator generator = event.getGenerator();
        PackOutput pack = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();

        generator.addProvider(true, new LootTableProvider(pack, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(BlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookup));
        generator.addProvider(true, new BlockStateProvider(pack, fileHelper));
        generator.addProvider(true, new TranslationProvider(pack, "en_us"));
        generator.addProvider(true, new ItemModelProvider(pack, fileHelper));
        generator.addProvider(true, new BlockTagProvider(pack, lookup, fileHelper));
        generator.addProvider(true, new RecipeProvider(pack, lookup));
        generator.addProvider(true, new DatapackProvider(pack, lookup));
    }
}
