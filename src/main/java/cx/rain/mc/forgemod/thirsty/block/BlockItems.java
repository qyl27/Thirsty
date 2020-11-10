package cx.rain.mc.forgemod.thirsty.block;

import cx.rain.mc.forgemod.thirsty.Thirsty;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockItems {
    public static final DeferredRegister<Item> REGISTRY =
            new DeferredRegister<>(ForgeRegistries.ITEMS, Thirsty.MODID);

    public BlockItems(IEventBus bus) {
        REGISTRY.register(bus);
    }
}
