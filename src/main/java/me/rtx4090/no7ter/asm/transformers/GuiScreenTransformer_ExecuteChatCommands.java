package me.rtx4090.no7ter.asm.transformers;

import me.rtx4090.no7ter.asm.loader.InjectionStatus;
import me.rtx4090.no7ter.asm.loader.MWETransformer;
import me.rtx4090.no7ter.asm.mappings.MethodMapping;
import org.objectweb.asm.tree.*;

public class GuiScreenTransformer_ExecuteChatCommands implements MWETransformer {

    @Override
    public String[] getTargetClassName() {
        return new String[]{"net.minecraft.client.gui.GuiScreen"};
    }

    @Override
    public void transform(ClassNode classNode, InjectionStatus status) {
        status.setInjectionPoints(1);
        for (final MethodNode methodNode : classNode.methods) {
            if (checkMethodNode(methodNode, MethodMapping.GUISCREEN$HANDLECOMPONENTCLICK)) {
                for (final AbstractInsnNode insnNode : methodNode.instructions.toArray()) {
                    if (checkVarInsnNode(insnNode, ALOAD, 0)) {
                        final AbstractInsnNode secondNode = insnNode.getNext();
                        if (checkVarInsnNode(secondNode, ALOAD, 2)) {
                            final AbstractInsnNode thirdNode = secondNode.getNext();
                            if (checkMethodInsnNode(thirdNode, MethodMapping.CLICKEVENT$GETVALUE)) {
                                final AbstractInsnNode fourthNode = thirdNode.getNext();
                                if (checkInsnNode(fourthNode, ICONST_0)) {
                                    final AbstractInsnNode fifthNode = fourthNode.getNext();
                                    if (checkMethodInsnNode(fifthNode, MethodMapping.GUISCREEN$SENDCHATMESSAGE)) {
                                        methodNode.instructions.insert(insnNode, getInsnList());
                                        status.addInjection();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private InsnList getInsnList() {
        final InsnList list = new InsnList();
        final LabelNode notCancelled = new LabelNode();
        list.add(new VarInsnNode(ALOAD, 2));
        list.add(getNewMethodInsnNode(MethodMapping.CLICKEVENT$GETVALUE));
        list.add(new MethodInsnNode(INVOKESTATIC, getHookClass("GuiScreenHook"), "executeMWEClickEvent", "(Ljava/lang/String;)Z", false));
        list.add(new JumpInsnNode(IFEQ, notCancelled));
        list.add(new InsnNode(ICONST_1));
        list.add(new InsnNode(IRETURN));
        list.add(notCancelled);
        return list;
    }

}
