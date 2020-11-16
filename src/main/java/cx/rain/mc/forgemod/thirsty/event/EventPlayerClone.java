package cx.rain.mc.forgemod.thirsty.event;

import cx.rain.mc.forgemod.thirsty.Thirsty;
import cx.rain.mc.forgemod.thirsty.api.capability.IThirstyCapability;
import cx.rain.mc.forgemod.thirsty.capability.Capabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Thirsty.MODID)
public class EventPlayerClone {
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) {
            LazyOptional<IThirstyCapability> oldThirsty = event.getOriginal().getCapability(Capabilities.THIRSTY);
            LazyOptional<IThirstyCapability> newThirsty = event.getPlayer().getCapability(Capabilities.THIRSTY);
            if (oldThirsty.isPresent() && newThirsty.isPresent()) {
                newThirsty.ifPresent(newCapa -> {
                    oldThirsty.ifPresent(oldCapa -> {
                        newCapa.deserializeNBT(oldCapa.serializeNBT());
                    });
                });
            }
        }
    }
}
