package org.redthsgayclub.no7ter.asm.transformers;

import org.redthsgayclub.no7ter.asm.loader.InjectionStatus;
import org.redthsgayclub.no7ter.asm.loader.MWETransformer;
import org.redthsgayclub.no7ter.asm.mappings.ClassMapping;
import org.redthsgayclub.no7ter.asm.mappings.MethodMapping;
import org.objectweb.asm.tree.*;

public class NetHandlerPlayClientTransformer_BlockChangeListener implements MWETransformer {

    @Override
    public String[] getTargetClassName() {
        return new String[]{"net.minecraft.client.network.NetHandlerPlayClient"};
    }

    @Override
    public void transform(ClassNode classNode, InjectionStatus status) {
        status.setInjectionPoints(2);
        for (final MethodNode methodNode : classNode.methods) {
            final boolean isBlockChange = checkMethodNode(methodNode, MethodMapping.NETHANDLERPLAYCLIENT$HANDLEBLOCKCHANGE);
            final boolean isMultiBlockChange = checkMethodNode(methodNode, MethodMapping.NETHANDLERPLAYCLIENT$HANDLEMULTIBLOCKCHANGE);
            if (isBlockChange || isMultiBlockChange) {
                for (final AbstractInsnNode insnNode : methodNode.instructions.toArray()) {
                    if (checkMethodInsnNode(insnNode, MethodMapping.PACKETTHREADUTIL$CHECKTHREADANDENQUEUE)) {
                        final InsnList list = new InsnList();
                        list.add(new VarInsnNode(ALOAD, 1));
                        list.add(new MethodInsnNode(
                                INVOKESTATIC,
                                getHookClass("NetHandlerPlayClientHook_BlockChangeListener"),
                                isBlockChange ? "onBlockChange" : "onMultiBlockChange",
                                "(L" + (isBlockChange ? ClassMapping.S23PACKETBLOCKCHANGE : ClassMapping.S22PACKETMULTIBLOCKCHANGE) + ";)V",
                                false));
                        methodNode.instructions.insert(insnNode, list);
                        status.addInjection();
                        break;
                    }
                }
            }
        }
    }

}
