package me.rtx4090.no7ter.asm.transformers;

import me.rtx4090.no7ter.asm.loader.InjectionStatus;
import me.rtx4090.no7ter.asm.loader.MWETransformer;
import me.rtx4090.no7ter.asm.mappings.ClassMapping;
import me.rtx4090.no7ter.asm.mappings.MethodMapping;
import org.objectweb.asm.tree.*;

public class LayerArrowTransformer implements MWETransformer {

    @Override
    public String[] getTargetClassName() {
        return new String[]{"net.minecraft.client.renderer.entity.layers.LayerArrow"};
    }

    @Override
    public void transform(ClassNode classNode, InjectionStatus status) {
        status.setInjectionPoints(1);
        for (final MethodNode methodNode : classNode.methods) {
            if (checkMethodNode(methodNode, MethodMapping.LAYERARROW$DORENDERLAYER)) {
                for (final AbstractInsnNode insnNode : methodNode.instructions.toArray()) {
                    if (checkVarInsnNode(insnNode, ASTORE, 10)) {
                        /*
                         * Injects after line 32 :
                         * entity.pinnedToPlayer = true;
                         */
                        final InsnList list = new InsnList();
                        list.add(new InsnNode(DUP));
                        list.add(new InsnNode(ICONST_1));
                        list.add(new FieldInsnNode(PUTFIELD, ClassMapping.ENTITYARROW.toString(), "pinnedToPlayer", "Z"));
                        methodNode.instructions.insertBefore(insnNode, list);
                        status.addInjection();
                    }
                }
            }
        }
    }

}
