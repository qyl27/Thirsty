package cx.rain.mc.forgemod.thirsty.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import cx.rain.mc.forgemod.thirsty.Thirsty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Thirsty.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ScreenThirstBar extends Screen {
    public static final ResourceLocation THIRST_BAR =
            new ResourceLocation(Thirsty.MODID, "textures/gui/hud_sprite.png");

    public ScreenThirstBar() {
        super(new StringTextComponent("thirst_bar"));
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {
        Minecraft mc = Minecraft.getInstance();
        PlayerEntity player = mc.player;

        if (event.getType() == RenderGameOverlayEvent.ElementType.FOOD) {
            mc.getProfiler().startSection("thirst_bar_section");
            //renderThirstBar(event, mc, player);
            mc.getProfiler().endSection();
        }
    }

    private void renderThirstBar(RenderGameOverlayEvent event, Minecraft mc, PlayerEntity player) {
        RenderSystem.enableBlend();
        RenderSystem.color4f(1, 1, 1, 1);
        mc.textureManager.bindTexture(THIRST_BAR);
        for (int i = 0;i < 10;i++) {
        }
    }

    private void renderThirstBarCell(int x, int y, boolean isHalf, boolean isEmpty) {
        if (isHalf) {
            blit(x, y, 16, 16, 16, 16);
        } else if (isEmpty) {
            blit(x, y, 16, 32, 16, 16);
        } else {
            blit(x, y, 16, 0, 16, 16);
        }
    }
}
