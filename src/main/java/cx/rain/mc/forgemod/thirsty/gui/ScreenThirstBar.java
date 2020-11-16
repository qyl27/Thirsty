package cx.rain.mc.forgemod.thirsty.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import cx.rain.mc.forgemod.thirsty.Thirsty;
import cx.rain.mc.forgemod.thirsty.api.capability.IThirstyCapability;
import cx.rain.mc.forgemod.thirsty.capability.Capabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.util.LazyOptional;

import java.util.concurrent.atomic.AtomicInteger;

public class ScreenThirstBar extends Screen {
    public static final ResourceLocation THIRST_BAR =
            new ResourceLocation(Thirsty.MODID, "textures/gui/hud_sprite.png");

    public ScreenThirstBar() {
        super(new StringTextComponent("thirst_bar"));
    }

    public void render(RenderGameOverlayEvent event, Minecraft mc, PlayerEntity player) {
        LazyOptional<IThirstyCapability> thirstyOriginal = player.getCapability(Capabilities.THIRSTY);
        AtomicInteger thirstyAtom = new AtomicInteger();
        thirstyOriginal.ifPresent(thitsry -> {
            thirstyAtom.set(MathHelper.ceil(thitsry.getThirsty()));
        });

        mc.getProfiler().startSection("thirsty");

        int thirsty = thirstyAtom.get();
        int startX = event.getWindow().getScaledWidth() / 2 - 91;
        int startY = event.getWindow().getScaledHeight() - 39;
        int actualY = startY - 10;

        RenderSystem.enableBlend();
        RenderSystem.color4f(1, 1, 1, 1);
        mc.textureManager.bindTexture(THIRST_BAR);

        for(int i = 0; i < 10; ++i) {
            int actualX = startX + i * 8;
            if (i * 2 + 1 < thirsty) {
                renderThirstBarCell(actualX, actualY, false, true);
            }

            if (i * 2 + 1 == thirsty) {
                renderThirstBarCell(actualX, actualY, true, false);
            }

            if (i * 2 + 1 > thirsty) {
                renderThirstBarCell(actualX, actualY, false, false);
            }
        }

        mc.getProfiler().endSection();
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
