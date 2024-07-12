package org.redthsgayclub.no7ter.asm.hooks;

import org.redthsgayclub.no7ter.config.ConfigHandler;

@SuppressWarnings("unused")
public class GuiIngameForgeHook {
    public static int adjustActionBarHeight(int y, int leftHeigth) {
        return ConfigHandler.fixActionbarTextOverlap && 68 < leftHeigth ? y + 68 - leftHeigth : y;
    }
}
