package me.rtx4090.no7ter.asm.transformers;

import me.rtx4090.no7ter.asm.loader.InjectionStatus;
import me.rtx4090.no7ter.asm.loader.MWETransformer;
import me.rtx4090.no7ter.asm.mappings.ClassMapping;
import me.rtx4090.no7ter.asm.mappings.FieldMapping;
import org.objectweb.asm.tree.ClassNode;

public class GuiNewChatTransformer implements MWETransformer {

    @Override
    public String[] getTargetClassName() {
        return new String[]{"net.minecraft.client.gui.GuiNewChat"};
    }

    @Override
    public void transform(ClassNode classNode, InjectionStatus status) {
        status.setInjectionPoints(0);
        addInterface(classNode, "GuiNewChatAccessor");
        addGetterMethod(
                classNode,
                "getChatLines",
                FieldMapping.GUINEWCHAT$CHATLINES,
                "()Ljava/util/List<L" + ClassMapping.CHATLINE + ";>;"
        );
        addGetterMethod(
                classNode,
                "getDrawnChatLines",
                FieldMapping.GUINEWCHAT$DRAWNCHATLINES,
                "()Ljava/util/List<L" + ClassMapping.CHATLINE + ";>;"
        );
    }

}
