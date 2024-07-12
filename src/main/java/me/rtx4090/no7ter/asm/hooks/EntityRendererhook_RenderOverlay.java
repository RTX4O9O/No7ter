package me.rtx4090.no7ter.asm.hooks;

import fr.alexdoru.megawallsenhancementsmod.gui.guiapi.GuiManager;

@SuppressWarnings("unused")
public class EntityRendererhook_RenderOverlay {
    public static void onPostRenderGameOverlay(float partialTicks) {
        GuiManager.onPostRenderGameOverlay(partialTicks);
    }
}
