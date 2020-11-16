package cx.rain.mc.forgemod.thirsty.capability;

import cx.rain.mc.forgemod.thirsty.api.capability.IThirstyCapability;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class Capabilities {
    @CapabilityInject(IThirstyCapability.class)
    public static Capability<IThirstyCapability> THIRSTY;
}
