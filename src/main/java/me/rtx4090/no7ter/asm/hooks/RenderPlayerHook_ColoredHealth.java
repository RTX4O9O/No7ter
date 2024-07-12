package me.rtx4090.no7ter.asm.hooks;

import me.rtx4090.no7ter.config.ConfigHandler;
import me.rtx4090.no7ter.scoreboard.ScoreboardTracker;
import me.rtx4090.no7ter.utils.ColorUtil;
import net.minecraft.client.entity.AbstractClientPlayer;

@SuppressWarnings("unused")
public class RenderPlayerHook_ColoredHealth {

    public static StringBuilder getColoredScore(StringBuilder str, int score, AbstractClientPlayer entity) {
        if (ConfigHandler.coloredScoreAboveHead) {
            if (ScoreboardTracker.isInMwGame) {
                return str.append(ColorUtil.getHPColor(44, score)).append(score);
            } else {
                return str.append(ColorUtil.getHPColor(entity.getMaxHealth(), score)).append(score);
            }
        }
        return str.append(score);
    }

}
