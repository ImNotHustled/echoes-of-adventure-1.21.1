package com.echoes.eoa;

import com.echoes.eoa.common.block.ModBlocks;
import com.echoes.eoa.common.item.ModItems;
import com.echoes.eoa.common.item.ModItemGroups;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.User;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(EchoesOfAdventure.MOD_ID)
public class EchoesOfAdventure {
    public static final String MOD_ID = "eoa";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EchoesOfAdventure(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModItemGroups.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static void print(String s) {
        if (Config.DEBUG_LOGGING) {
            LOGGER.info(s);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        print("Hello, `debug-logging` option is on. You'll get a lot-lot of EOA debug logs.");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        print(String.format("Server starting with name %s", event.getServer().name()));
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            User user = Minecraft.getInstance().getUser();
            print(String.format("Username: %s | UUID: %s", user.getName(), user.getProfileId()));
        }
    }

    public static ResourceLocation getId(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }
    public static ResourceLocation getId(String id, String suffix) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, suffix+ "/" +id);
    }
}
