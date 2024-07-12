package me.rtx4090.no7ter.asm.transformers;

import me.rtx4090.no7ter.asm.loader.InjectionStatus;
import me.rtx4090.no7ter.asm.loader.MWETransformer;
import me.rtx4090.no7ter.asm.mappings.ClassMapping;
import me.rtx4090.no7ter.asm.mappings.MethodMapping;
import org.objectweb.asm.tree.*;

public class NetworkManagerTransformer_ClientPacketListener implements MWETransformer {

    @Override
    public String[] getTargetClassName() {
        return new String[]{"net.minecraft.network.NetworkManager"};
    }

    @Override
    public void transform(ClassNode classNode, InjectionStatus status) {
        status.setInjectionPoints(1);
        for (final MethodNode methodNode : classNode.methods) {
            if (checkMethodNode(methodNode, MethodMapping.NETWORKMANAGER$SENDPACKET)) {
                final InsnList list = new InsnList();
                list.add(new VarInsnNode(ALOAD, 1));
                list.add(new MethodInsnNode(
                        INVOKESTATIC,
                        getHookClass("NetworkManagerHook_PacketListener"),
                        "listenSentPacket",
                        "(L" + ClassMapping.PACKET + ";)V",
                        false));
                methodNode.instructions.insert(list);
                status.addInjection();
            }
        }
    }

}
