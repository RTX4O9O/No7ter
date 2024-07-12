package me.rtx4090.no7ter.api.requests;

import com.google.gson.JsonObject;
import me.rtx4090.no7ter.api.HttpClient;
import me.rtx4090.no7ter.api.exceptions.ApiException;
import me.rtx4090.no7ter.utils.JsonUtil;
import net.minecraft.util.EnumChatFormatting;

public class HypixelGuild {

    private String guildName;
    private String formattedGuildTag;

    public HypixelGuild(String uuid) throws ApiException {
        final HttpClient httpClient = new HttpClient("https://api.hypixel.net/guild?player=" + uuid);
        final JsonObject obj = httpClient.getJsonResponse();
        final JsonObject guildData = JsonUtil.getJsonObject(obj, "guild");
        if (guildData == null) {
            return;
        }
        this.guildName = JsonUtil.getString(guildData, "name");
        final String tag = JsonUtil.getString(guildData, "tag");
        final EnumChatFormatting tagColor = EnumChatFormatting.getValueByName(JsonUtil.getString(guildData, "tagColor"));
        this.formattedGuildTag = " " + (tag == null ? "" : (tagColor == null ? "[" + tag + "]" : tagColor + "[" + tag + "]"));
    }

    public String getGuildName() {
        return guildName;
    }

    public String getFormattedGuildTag() {
        return formattedGuildTag;
    }

}
