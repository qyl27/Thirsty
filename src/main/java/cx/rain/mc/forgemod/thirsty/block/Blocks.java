package cx.rain.mc.forgemod.thirsty.block;

import cx.rain.mc.forgemod.thirsty.Thirsty;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Blocks {
    public static final DeferredRegister<Block> REGISTRY =
            new DeferredRegister<>(ForgeRegistries.BLOCKS, Thirsty.MODID);

    public Blocks(IEventBus bus) {
        REGISTRY.register(bus);
    }
}
