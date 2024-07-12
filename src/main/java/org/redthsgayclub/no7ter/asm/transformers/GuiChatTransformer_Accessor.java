package org.redthsgayclub.no7ter.asm.transformers;

import org.redthsgayclub.no7ter.asm.loader.InjectionStatus;
import org.redthsgayclub.no7ter.asm.loader.MWETransformer;
import org.redthsgayclub.no7ter.asm.mappings.FieldMapping;
import org.objectweb.asm.tree.ClassNode;

public class GuiChatTransformer_Accessor implements MWETransformer {

    @Override
    public String[] getTargetClassName() {
        return new String[]{"net.minecraft.client.gui.GuiChat"};
    }

    @Override
    public void transform(ClassNode classNode, InjectionStatus status) {
        status.setInjectionPoints(0);
        addInterface(classNode, "GuiChatAccessor");
        addGetterAndSetterMethod(classNode, "SentHistoryCursor", FieldMapping.GUICHAT$SENTHISTORYCURSOR, null);
    }

}
