package org.redthsgayclub.no7ter.asm.mappings;

import org.redthsgayclub.no7ter.asm.loader.ASMLoadingPlugin;

public enum FieldMapping {

    CLIENTCOMMANDHANDLER$INSTANCE(ClassMapping.CLIENTCOMMANDHANDLER, "instance", ClassMapping.CLIENTCOMMANDHANDLER),
    ENTITY$ONGROUND(ClassMapping.ENTITY, "C", "onGround", "Z"),
    ENTITYARROW$ISINGROUND(ClassMapping.ENTITYARROW, "i", "inGround", "Z"),
    ENTITYARROW$PINNEDTOPLAYER(ClassMapping.ENTITYARROW, "pinnedToPlayer", "Z"),
    ENTITYPLAYER$ITEMINUSE(ClassMapping.ENTITYPLAYER, "g", "itemInUse", ClassMapping.ITEMSTACK),
    ENTITYPLAYER$MWCLASS(ClassMapping.ENTITYPLAYER, "mwe$mwClass", ClassMapping.MWCLASS),
    ENTITYPLAYER$PLAYERDATASAMPLES(ClassMapping.ENTITYPLAYER, "mwe$PlayerDataSamples", ClassMapping.PLAYERDATASAMPLES),
    ENTITYPLAYERSP$HURTTIME(ClassMapping.ENTITYPLAYERSP, "au", "hurtTime", "I"),
    ENUMCHATFORMATTING$YELLOW(ClassMapping.ENUMCHATFORMATTING, "o", "YELLOW", ClassMapping.ENUMCHATFORMATTING),
    GAMESETTINGS$ADVANCEDITEMTOOLTIPS(ClassMapping.GAMESETTINGS, "y", "advancedItemTooltips", "Z"),
    GAMESETTINGS$PAUSEONLOSTFOCUS(ClassMapping.GAMESETTINGS, "z", "pauseOnLostFocus", "Z"),
    GUICHAT$SENTHISTORYCURSOR(ClassMapping.GUICHAT, "h", "sentHistoryCursor", "I"),
    GUICHAT$WAITINGONAUTOCOMPLETE(ClassMapping.GUICHAT, "r", "waitingOnAutocomplete", "Z"),
    GUICONTAINER$THESLOT(ClassMapping.GUICONTAINER, "u", "theSlot", ClassMapping.SLOT),
    GUIINGAME$DISPLAYEDSUBTITLE(ClassMapping.GUIINGAME, "y", "displayedSubTitle", "Ljava/lang/String;"),
    GUINEWCHAT$CHATLINES(ClassMapping.GUINEWCHAT, "h", "chatLines", "Ljava/util/List;"),
    GUINEWCHAT$DRAWNCHATLINES(ClassMapping.GUINEWCHAT, "i", "drawnChatLines", "Ljava/util/List;"),
    GUIPLAYERTABOVERLAY$FOOTER(ClassMapping.GUIPLAYERTABOVERLAY, "h", "footer", ClassMapping.ICHATCOMPONENT),
    GUIPLAYERTABOVERLAY$HEADER(ClassMapping.GUIPLAYERTABOVERLAY, "i", "header", ClassMapping.ICHATCOMPONENT),
    GUISCREENBOOK$BOOKIMAGEHEIGHT(ClassMapping.GUISCREENBOOK, "v", "bookImageHeight", "I"),
    GUISCREENBOOK$WIDTH(ClassMapping.GUISCREENBOOK, "l", "width", "I"),
    INVENTORYPLAYER$CURRENTITEM(ClassMapping.INVENTORYPLAYER, "c", "currentItem", "I"),
    MINECRAFT$GAMESETTINGS(ClassMapping.MINECRAFT, "t", "gameSettings", ClassMapping.GAMESETTINGS),
    MINECRAFT$RENDERMANAGER(ClassMapping.MINECRAFT, "aa", "renderManager", ClassMapping.RENDERMANAGER),
    NETHANDLERPLAYCLIENT$PLAYERINFOMAP(ClassMapping.NETHANDLERPLAYCLIENT, "i", "playerInfoMap", "Ljava/util/Map;"),
    NETWORKPLAYERINFO$1$INSTANCE(ClassMapping.NETWORKPLAYERINFO$1, "a", "this$0", ClassMapping.NETWORKPLAYERINFO),
    NETWORKPLAYERINFO$DISPLAYNAME(ClassMapping.NETWORKPLAYERINFO, "h", "displayName", ClassMapping.ICHATCOMPONENT),
    NETWORKPLAYERINFO$GAMEPROFILE(ClassMapping.NETWORKPLAYERINFO, "a", "gameProfile", ClassMapping.GAMEPROFILE),
    NETWORKPLAYERINFO$LOCATIONSKIN(ClassMapping.NETWORKPLAYERINFO, "e", "locationSkin", ClassMapping.RESOURCELOCATION),
    POTION$NIGHTVISION(ClassMapping.POTION, "r", "nightVision", ClassMapping.POTION),
    RENDERERLIVINGENTITY$BRIGHTNESSBUFFER(ClassMapping.RENDERERLIVINGENTITY, "g", "brightnessBuffer", ClassMapping.FLOATBUFFER),
    RENDERGLOBAL$COUNTENTITIESRENDERED(ClassMapping.RENDERGLOBAL, "S", "countEntitiesRendered", "I"),
    RENDERMANAGER$DEBUGBOUNDINGBOX(ClassMapping.RENDERMANAGER, "t", "debugBoundingBox", "Z"),
    RENDERMANAGER$LIVINGENTITY(ClassMapping.RENDERMANAGER, "c", "livingPlayer", ClassMapping.ENTITY),
    S19PACKETENTITYSTATUS$ENTITYID(ClassMapping.S19PACKETENTITYSTATUS, "a", "entityId", "I");

    public final String owner;
    public final String name;
    public final String desc;

    FieldMapping(ClassMapping owner, String mcpName, String desc) {
        this.owner = owner.toString();
        this.name = mcpName;
        this.desc = desc;
    }

    FieldMapping(ClassMapping owner, String mcpName, ClassMapping classMapping) {
        this.owner = owner.toString();
        this.name = mcpName;
        this.desc = "L" + classMapping + ";";
    }

    FieldMapping(ClassMapping owner, String obfName, String mcpName, String desc) {
        this.owner = owner.toString();
        this.name = ASMLoadingPlugin.isObf() ? obfName : mcpName;
        this.desc = desc;
    }

    FieldMapping(ClassMapping owner, String obfName, String mcpName, ClassMapping classMapping) {
        this.owner = owner.toString();
        this.name = ASMLoadingPlugin.isObf() ? obfName : mcpName;
        this.desc = "L" + classMapping + ";";
    }

}
