package org.redthsgayclub.no7ter.asm.hooks;

import org.redthsgayclub.no7ter.asm.accessors.ChatComponentTextAccessor;
import net.minecraft.util.IChatComponent;

@SuppressWarnings("unused")
public class ChatComponentStyleHook_ChatHeads {

    public static void transferHeadToComponent(IChatComponent thisComponent, IChatComponent otherComponent) {
        if (thisComponent instanceof ChatComponentTextAccessor && otherComponent instanceof ChatComponentTextAccessor) {
            if (((ChatComponentTextAccessor) otherComponent).getSkinChatHead() != null) {
                ((ChatComponentTextAccessor) thisComponent).setSkinChatHead(((ChatComponentTextAccessor) otherComponent).getSkinChatHead());
                ((ChatComponentTextAccessor) otherComponent).setSkinChatHead(null);
            }
        }
    }

}
