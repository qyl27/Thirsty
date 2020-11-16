package cx.rain.mc.forgemod.thirsty;

import cx.rain.mc.forgemod.thirsty.api.capability.IThirstyCapability;
import cx.rain.mc.forgemod.thirsty.block.BlockItems;
import cx.rain.mc.forgemod.thirsty.block.Blocks;
import cx.rain.mc.forgemod.thirsty.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
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
        CapabilityManager.INSTANCE.register(IThirstyCapability.class,
                new Capability.IStorage<IThirstyCapability>() {
                    @Override
                    public INBT writeNBT(Capability<IThirstyCapability> capability, IThirstyCapability instance, Direction side) {
                        CompoundNBT nbt = new CompoundNBT();
                        nbt.putInt("thirsty", 20);
                        return nbt;
                    }

                    @Override
                    public void readNBT(Capability<IThirstyCapability> capability, IThirstyCapability instance, Direction side, INBT nbt) {
                        CompoundNBT compound = (CompoundNBT) nbt;
                        int thirsty = compound.getInt("thirsty");
                        instance.setThirsty(thirsty);
                    }
                },
                () -> {
                    return null;
                });

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
