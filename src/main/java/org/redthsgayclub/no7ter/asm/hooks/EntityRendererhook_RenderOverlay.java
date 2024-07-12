package org.redthsgayclub.no7ter.asm.hooks;

import org.redthsgayclub.no7ter.gui.guiapi.GuiManager;

@SuppressWarnings("unused")
public class EntityRendererhook_RenderOverlay {
    public static void onPostRenderGameOverlay(float partialTicks) {
        GuiManager.onPostRenderGameOverlay(partialTicks);
    }
}
