package cx.rain.mc.forgemod.thirsty.event;

import cx.rain.mc.forgemod.thirsty.Thirsty;
import cx.rain.mc.forgemod.thirsty.capability.provider.ThirstyCapabilityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Thirsty.MODID)
public class EventAttachCapability {
    @SubscribeEvent
    public static void onAttachCapability(AttachCapabilitiesEvent<Entity> event) {
        Entity entity = event.getObject();
        if (entity instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation(Thirsty.MODID, "thirsty"),
                    new ThirstyCapabilityProvider());
        }
    }


}
