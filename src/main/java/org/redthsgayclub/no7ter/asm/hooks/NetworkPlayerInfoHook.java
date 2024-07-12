package org.redthsgayclub.no7ter.asm.hooks;

import com.mojang.authlib.GameProfile;
import org.redthsgayclub.no7ter.features.FinalKillCounter;
import org.redthsgayclub.no7ter.utils.NameUtil;
import net.minecraft.util.IChatComponent;

@SuppressWarnings("unused")
public class NetworkPlayerInfoHook {

    public static IChatComponent getDisplayName(GameProfile gameProfileIn) {
        return NameUtil.fetchMWPlayerData(gameProfileIn, false).displayName;
    }

    public static int getPlayersFinals(String playername) {
        return FinalKillCounter.getPlayersFinals(playername);
    }

}
