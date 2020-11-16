package cx.rain.mc.forgemod.thirsty.capability.provider;

import cx.rain.mc.forgemod.thirsty.api.capability.IThirstyCapability;
import cx.rain.mc.forgemod.thirsty.capability.Capabilities;
import cx.rain.mc.forgemod.thirsty.capability.ThirstyCapability;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ThirstyCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {
    private IThirstyCapability capability;

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == Capabilities.THIRSTY
                ? LazyOptional.of(() -> this.getOrCreateCapability()).cast()
                : LazyOptional.empty();
    }

    @Nonnull
    IThirstyCapability getOrCreateCapability() {
        if (capability == null) {
            capability = new ThirstyCapability(20);
        }
        return capability;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return getOrCreateCapability().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        getOrCreateCapability().deserializeNBT(nbt);
    }
}
