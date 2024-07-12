package me.rtx4090.no7ter.chat;

import net.minecraft.util.ChatComponentText;

public class WarningChatComponent extends ChatComponentText {

    private final String playername;

    public WarningChatComponent(String playername, String msg) {
        super(msg);
        this.playername = playername;
    }

    public String getPlayername() {
        return playername;
    }

}
