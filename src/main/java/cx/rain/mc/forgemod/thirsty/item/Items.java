package cx.rain.mc.forgemod.thirsty.item;

import cx.rain.mc.forgemod.thirsty.Thirsty;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {
    public static final DeferredRegister<Item> REGISTRY =
            new DeferredRegister<>(ForgeRegistries.ITEMS, Thirsty.MODID);

    public Items(IEventBus bus) {
        REGISTRY.register(bus);
    }
}
