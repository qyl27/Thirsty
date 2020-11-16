package cx.rain.mc.forgemod.thirsty.api.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface IThirstyCapability extends INBTSerializable<CompoundNBT> {
    int getThirsty();
    void setThirsty(int thirstyIn);
}
