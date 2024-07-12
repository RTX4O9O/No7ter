package me.rtx4090.no7ter.api.requests;

import com.google.gson.JsonObject;
import me.rtx4090.no7ter.api.HttpClient;
import me.rtx4090.no7ter.api.exceptions.ApiException;
import me.rtx4090.no7ter.utils.JsonUtil;

import java.util.UUID;

public class HypixelPlayerData {

    private final JsonObject playerData;
    private final String uuid;

    public HypixelPlayerData(UUID uuid) throws ApiException {
        this(uuid.toString());
    }

    public HypixelPlayerData(String uuid) throws ApiException {
        final HttpClient httpClient = new HttpClient("https://api.hypixel.net/player?uuid=" + uuid);
        final JsonObject obj = httpClient.getJsonResponse();
        final JsonObject playerdata = JsonUtil.getJsonObject(obj, "player");
        if (playerdata == null) {
            throw new ApiException("This player never joined Hypixel, it might be a nick.");
        }
        this.playerData = playerdata;
        this.uuid = uuid;
    }

    public JsonObject getPlayerData() {
        return this.playerData;
    }

    public String getUuid() {
        return this.uuid;
    }
}
