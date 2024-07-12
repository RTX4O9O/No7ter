package org.redthsgayclub.no7ter.asm.transformers;

import org.redthsgayclub.no7ter.asm.loader.ASMLoadingPlugin;
import org.redthsgayclub.no7ter.asm.loader.InjectionStatus;
import org.redthsgayclub.no7ter.asm.loader.MWETransformer;
import org.redthsgayclub.no7ter.asm.mappings.ClassMapping;
import org.objectweb.asm.tree.ClassNode;

public class ChatComponentTextTransformer_ChatHeads implements MWETransformer {

    @Override
    public String[] getTargetClassName() {
        return new String[]{"net.minecraft.util.ChatComponentText"};
    }

    @Override
    public void transform(ClassNode classNode, InjectionStatus status) {
        if (ASMLoadingPlugin.isFeatherLoaded()) {
            status.skipTransformation();
            return;
        }
        status.setInjectionPoints(0);
        addInterface(classNode, "ChatComponentTextAccessor");
        final String SKIN_FIELD_NAME = "mwe$skin";
        final String SKIN_DESC = "L" + ClassMapping.SKINCHATHEAD + ";";
        classNode.visitField(ACC_PRIVATE, SKIN_FIELD_NAME, SKIN_DESC, null, null);
        addGetterAndSetterMethod(classNode, "SkinChatHead", ClassMapping.CHATCOMPONENTTEXT, SKIN_FIELD_NAME, SKIN_DESC, null);
    }

}
