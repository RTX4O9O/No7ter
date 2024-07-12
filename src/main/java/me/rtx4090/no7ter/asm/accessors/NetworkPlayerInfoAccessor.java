package me.rtx4090.no7ter.asm.accessors;

import net.minecraft.util.IChatComponent;

public interface NetworkPlayerInfoAccessor {
    void setPlayerFinalkills(int playerFinalkills);
    int getPlayerFinalkills();
    void setCustomDisplayname(IChatComponent customDisplaynameIn);
}