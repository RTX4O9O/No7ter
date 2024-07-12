package me.rtx4090.no7ter.api.cache;

import com.google.gson.JsonObject;
import me.rtx4090.no7ter.api.exceptions.ApiException;
import me.rtx4090.no7ter.api.requests.HypixelPlayerData;
import me.rtx4090.no7ter.utils.TimerUtil;

public class CachedHypixelPlayerData {

    private static final TimerUtil timer = new TimerUtil(60000L);
    private static JsonObject playerData;
    private static String uuid;

    public static synchronized JsonObject getPlayerData(String uuidIn) throws ApiException {
        if (!timer.update() && uuidIn.equals(uuid)) {
            return playerData;
        }
        playerData = new HypixelPlayerData(uuidIn).getPlayerData();
        uuid = uuidIn;
        return playerData;
    }

}
