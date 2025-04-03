package com.echoes.eoa.common.item;

import com.echoes.eoa.EchoesOfAdventure;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EchoesOfAdventure.MOD_ID);

    public static void register(IEventBus event) {
        ITEMS.register(event);
        EchoesOfAdventure.print("Registering items...");
    }
}
