package cx.rain.mc.forgemod.thirsty;

import cx.rain.mc.forgemod.thirsty.block.BlockItems;
import cx.rain.mc.forgemod.thirsty.block.Blocks;
import cx.rain.mc.forgemod.thirsty.item.Items;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Thirsty.MODID)
public class Thirsty {
    public static final String MODID = "thirsty";

    private Logger log = LogManager.getLogger("Thirsty Mods");

    private static Thirsty INSTANCE;

    public Thirsty() {
        INSTANCE = this;

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::serverSetup);

        new Items(bus);
        new Blocks(bus);
        new BlockItems(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        log.info("Hello, Minecraft!");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }

    private void serverSetup(final FMLDedicatedServerSetupEvent event) {
    }

    public static Thirsty getInstance() {
        return INSTANCE;
    }
}
