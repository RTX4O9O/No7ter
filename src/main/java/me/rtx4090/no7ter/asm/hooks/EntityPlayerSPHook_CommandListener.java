package me.rtx4090.no7ter.asm.hooks;

import me.rtx4090.no7ter.config.ConfigHandler;
import me.rtx4090.no7ter.gui.huds.KillCooldownHUD;
import me.rtx4090.no7ter.scoreboard.ScoreboardTracker;
import me.rtx4090.no7ter.utils.StringUtil;

@SuppressWarnings("unused")
public class EntityPlayerSPHook_CommandListener {

    public static void onMessageSent(String message) {
        if (StringUtil.isNullOrEmpty(message)) {
            return;
        }
        if (ConfigHandler.showKillCooldownHUD && ScoreboardTracker.isInMwGame) {
            message = message.toLowerCase();
            if (message.equals("/kill") || message.startsWith("/kill ")) {
                KillCooldownHUD.instance.drawCooldownHUD();
            }
        }
    }

}
