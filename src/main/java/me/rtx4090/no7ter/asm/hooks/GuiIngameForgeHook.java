package me.rtx4090.no7ter.asm.hooks;

import me.rtx4090.no7ter.config.ConfigHandler;

@SuppressWarnings("unused")
public class GuiIngameForgeHook {
    public static int adjustActionBarHeight(int y, int leftHeigth) {
        return ConfigHandler.fixActionbarTextOverlap && 68 < leftHeigth ? y + 68 - leftHeigth : y;
    }
}
