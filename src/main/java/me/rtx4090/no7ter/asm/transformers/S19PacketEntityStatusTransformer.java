package me.rtx4090.no7ter.asm.transformers;

import me.rtx4090.no7ter.asm.loader.InjectionStatus;
import me.rtx4090.no7ter.asm.loader.MWETransformer;
import me.rtx4090.no7ter.asm.mappings.FieldMapping;
import org.objectweb.asm.tree.ClassNode;

public class S19PacketEntityStatusTransformer implements MWETransformer {

    @Override
    public String[] getTargetClassName() {
        return new String[]{"net.minecraft.network.play.server.S19PacketEntityStatus"};
    }

    @Override
    public void transform(ClassNode classNode, InjectionStatus status) {
        status.setInjectionPoints(0);
        addInterface(classNode, "S19PacketEntityStatusAccessor");
        addGetterMethod(classNode, "getEntityId", FieldMapping.S19PACKETENTITYSTATUS$ENTITYID, "()I");
    }

}
