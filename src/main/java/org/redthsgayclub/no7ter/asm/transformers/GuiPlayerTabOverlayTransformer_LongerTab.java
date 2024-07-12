package org.redthsgayclub.no7ter.asm.transformers;

import org.redthsgayclub.no7ter.asm.loader.ASMLoadingPlugin;
import org.redthsgayclub.no7ter.asm.loader.InjectionStatus;
import org.redthsgayclub.no7ter.asm.loader.MWETransformer;
import org.redthsgayclub.no7ter.asm.mappings.MethodMapping;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class GuiPlayerTabOverlayTransformer_LongerTab implements MWETransformer {

    @Override
    public String[] getTargetClassName() {
        return new String[]{"net.minecraft.client.gui.GuiPlayerTabOverlay"};
    }

    @Override
    public void transform(ClassNode classNode, InjectionStatus status) {
        final boolean isPatcherLoaded = ASMLoadingPlugin.isPatcherLoaded();
        status.setInjectionPoints(isPatcherLoaded ? 1 : 2);
        for (final MethodNode methodNode : classNode.methods) {
            if (checkMethodNode(methodNode, MethodMapping.GUIPLAYERTABOVERLAY$RENDERPLAYERLIST)) {
                for (final AbstractInsnNode insnNode : methodNode.instructions.toArray()) {
                    if (checkIntInsnNode(insnNode, BIPUSH, 20)) {
                        methodNode.instructions.insertBefore(insnNode, new MethodInsnNode(INVOKESTATIC, getHookClass("GuiPlayerTabOverlayHook"), "getTablistHeight", "()I", false));
                        methodNode.instructions.remove(insnNode);
                        status.addInjection();
                    }
                    if (!isPatcherLoaded && checkIntInsnNode(insnNode, BIPUSH, 80)) {
                        methodNode.instructions.insertBefore(insnNode, new MethodInsnNode(INVOKESTATIC, getHookClass("GuiPlayerTabOverlayHook"), "getTotalPlayerAmount", "()I", false));
                        methodNode.instructions.remove(insnNode);
                        status.addInjection();
                    }
                }
            }
        }
    }

}
