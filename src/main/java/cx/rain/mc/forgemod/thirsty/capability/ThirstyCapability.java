package cx.rain.mc.forgemod.thirsty.capability;

import cx.rain.mc.forgemod.thirsty.api.capability.IThirstyCapability;
import net.minecraft.nbt.CompoundNBT;

public class ThirstyCapability implements IThirstyCapability {
    private int thirsty;

    public ThirstyCapability(int thirstyIn) {
        thirsty = thirstyIn;
    }

    @Override
    public double getThirsty() {
        return thirsty;
    }

    @Override
    public void setThirsty(int thirstyIn) {
        thirsty = thirstyIn;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("thirsty", thirsty);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        thirsty = nbt.getInt("thirsty");
    }
}
