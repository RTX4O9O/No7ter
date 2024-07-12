package me.rtx4090.no7ter.features;

import me.rtx4090.no7ter.config.ConfigHandler;
import me.rtx4090.no7ter.utils.SoundUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class LowHPIndicator {

    private static final Minecraft mc = Minecraft.getMinecraft();
    private boolean playedSound = false;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (!ConfigHandler.playSoundLowHP || event.phase == TickEvent.Phase.START || mc.theWorld == null || mc.thePlayer == null) {
            return;
        }
        if (!playedSound && mc.thePlayer.getHealth() < mc.thePlayer.getMaxHealth() * ConfigHandler.healthThreshold) {
            SoundUtil.playLowHPSound();
            playedSound = true;
            return;
        }
        if (playedSound && mc.thePlayer.getHealth() >= mc.thePlayer.getMaxHealth() * ConfigHandler.healthThreshold) {
            playedSound = false;
        }
    }

}
