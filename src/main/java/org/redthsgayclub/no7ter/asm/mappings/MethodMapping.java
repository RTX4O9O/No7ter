package org.redthsgayclub.no7ter.asm.mappings;

import org.redthsgayclub.no7ter.asm.loader.ASMLoadingPlugin;

import static org.objectweb.asm.Opcodes.*;

public enum MethodMapping {

    C08PACKETPLAYERBLOCKPLACEMENT$INIT3("<init>", "(L" + ClassMapping.BLOCKPOS + ";IL" + ClassMapping.ITEMSTACK + ";FFF)V"),
    CHATCOMPONENTSTYLE$APPENDSIBLING("a", "appendSibling", "(L" + ClassMapping.ICHATCOMPONENT + ";)L" + ClassMapping.ICHATCOMPONENT + ";"),
    CHATCOMPONENTTEXT$INIT(INVOKESPECIAL, ClassMapping.CHATCOMPONENTTEXT, "<init>", "(Ljava/lang/String;)V"),
    CLICKEVENT$GETVALUE(INVOKEVIRTUAL, ClassMapping.CLICKEVENT, "b", "getValue", "()Ljava/lang/String;"),
    COLLECTION$REMOVE(INVOKEINTERFACE, ClassMapping.COLLECTION, "remove", "(Ljava/lang/Object;)Z"),
    COMMANDHANDLER$GETTABCOMPLETIONOPTION("a", "getTabCompletionOptions", "(L" + ClassMapping.ICOMMANDSENDER + ";Ljava/lang/String;L" + ClassMapping.BLOCKPOS + ";)Ljava/util/List;"),
    EFFECTRENDERER$ADDBLOCKDESTROYEFFECTS(INVOKEVIRTUAL, ClassMapping.EFFECTRENDERER, "a", "addBlockDestroyEffects", "(L" + ClassMapping.BLOCKPOS + ";L" + ClassMapping.IBLOCKSTATE + ";)V"),
    ENTITY$SETCURRENTITEMORARMOR(INVOKEVIRTUAL, ClassMapping.ENTITY, "c", "setCurrentItemOrArmor", "(IL" + ClassMapping.ITEMSTACK + ";)V"),
    ENTITY$SETPOSITIONANDROTATION2("a", "setPositionAndRotation2", "(DDDFFIZ)V"),
    ENTITY$SETROTATIONYAWHEAD("f", "setRotationYawHead", "(F)V"),
    ENTITYFX$RENDERPARTICLE("a", "renderParticle", "(L" + ClassMapping.WORLDRENDERER + ";L" + ClassMapping.ENTITY + ";FFFFFF)V"),
    ENTITYLIVINGBASE$ISPOTIONACTIVE("a", "isPotionActive", "(L" + ClassMapping.POTION + ";)Z"),
    ENTITYPLAYER$GETDISPLAYNAME("f_", "getDisplayName", "()L" + ClassMapping.ICHATCOMPONENT + ";"),
    ENTITYPLAYER$ONUPDATE("t_", "onUpdate", "()V"),
    ENTITYPLAYERSP$DROPONEITEM(INVOKEVIRTUAL, ClassMapping.ENTITYPLAYERSP, "a", "dropOneItem", "(Z)L" + ClassMapping.ENTITYITEM + ";"),
    ENTITYPLAYERSP$SENDCHATMESSAGE("e", "sendChatMessage", "(Ljava/lang/String;)V"),
    ENTITYPLAYERSP$SETPLAYERSPHEALTH("n", "setPlayerSPHealth", "(F)V"),
    ENTITYRENDERER$UPDATECAMERAANDRENDER("a", "updateCameraAndRender", "(FJ)V"),
    ENTITYRENDERER$UPDATEFOGCOLOR("i", "updateFogColor", "(F)V"),
    ENTITYRENDERER$UPDATELIGHTMAP("g", "updateLightmap", "(F)V"),
    ENUMCHATFORMATTING$GETTEXTWITHOUTFORMATTINGCODES(INVOKESTATIC, ClassMapping.ENUMCHATFORMATTING, "a", "getTextWithoutFormattingCodes", "(Ljava/lang/String;)Ljava/lang/String;"),
    FLOATBUFFER$PUT(INVOKEVIRTUAL, ClassMapping.FLOATBUFFER, "put", "(F)L" + ClassMapping.FLOATBUFFER + ";"),
    FONTRENDERER$DRAWSTRINGWITHSHADOW(INVOKEVIRTUAL, ClassMapping.FONTRENDERER, "a", "drawStringWithShadow", "(Ljava/lang/String;FFI)I"),
    FONTRENDERER$GETSTRINGWIDTH(INVOKEVIRTUAL, ClassMapping.FONTRENDERER, "a", "getStringWidth", "(Ljava/lang/String;)I"),
    FONTRENDERER$LISTFORMATTEDSTRINGTOWIDTH(INVOKEVIRTUAL, ClassMapping.FONTRENDERER, "c", "listFormattedStringToWidth", "(Ljava/lang/String;I)Ljava/util/List;"),
    GLSTATEMANAGER$ALPHAFUNC(INVOKESTATIC, ClassMapping.GLSTATEMANAGER, "a", "alphaFunc", "(IF)V"),
    GLSTATEMANAGER$ENABLEBLEND(INVOKESTATIC, ClassMapping.GLSTATEMANAGER, "l", "enableBlend", "()V"),
    GUICHAT$ONAUTOCOMPLETERESPONSE("a", "onAutocompleteResponse", "([Ljava/lang/String;)V"),
    GUICHAT$SENDAUTOCOMPLETEREQUEST("a", "sendAutocompleteRequest", "(Ljava/lang/String;Ljava/lang/String;)V"),
    GUICONTAINER$CHECKHOTBARKEYS("b", "checkHotbarKeys", "(I)Z"),
    GUICONTAINER$HANDLEMOUSECLICK(INVOKEVIRTUAL, ClassMapping.GUICONTAINER, "a", "handleMouseClick", "(L" + ClassMapping.SLOT + ";III)V"),
    GUIINGAME$DISPLAYTITLE("a", "displayTitle", "(Ljava/lang/String;Ljava/lang/String;III)V"),
    GUIINGAME$GETFONTRENDERER(INVOKEVIRTUAL, ClassMapping.GUIINGAME, "f", "getFontRenderer", "()L" + ClassMapping.FONTRENDERER + ";"),
    GUIINGAME$RENDERGAMEOVERLAY(INVOKEVIRTUAL, ClassMapping.GUIINGAME, "a", "renderGameOverlay", "(F)V"),
    GUIINGAME$RENDERSCOREBOARD("a", "renderScoreboard", "(L" + ClassMapping.SCOREOBJECTIVE + ";L" + ClassMapping.SCALEDRESOLUTION + ";)V"),
    GUIINGAMEFORGE$RENDERRECORDOVERLAY(INVOKEVIRTUAL, ClassMapping.GUIINGAMEFORGE, "renderRecordOverlay", "(IIF)V"),
    GUINEWCHAT$DRAWCHAT("a", "drawChat", "(I)V"),
    GUINEWCHAT$GETCHATCOMPONENT("a", "getChatComponent", "(II)L" + ClassMapping.ICHATCOMPONENT + ";"),
    GUINEWCHAT$PRINTCHATMESSAGE(INVOKEVIRTUAL, ClassMapping.GUINEWCHAT, "a", "printChatMessage", "(L" + ClassMapping.ICHATCOMPONENT + ";)V"),
    GUINEWCHAT$PRINTCHATMESSAGEWITHOPTIONALDELETION("a", "printChatMessageWithOptionalDeletion", "(L" + ClassMapping.ICHATCOMPONENT + ";I)V"),
    GUIPLAYERTABOVERLAY$DRAWPING(INVOKEVIRTUAL, ClassMapping.GUIPLAYERTABOVERLAY, "a", "drawPing", "(IIIL" + ClassMapping.NETWORKPLAYERINFO + ";)V"),
    GUIPLAYERTABOVERLAY$DRAWSCOREBOARDVALUES(INVOKESPECIAL, ClassMapping.GUIPLAYERTABOVERLAY, "a", "drawScoreboardValues", "(L" + ClassMapping.SCOREOBJECTIVE + ";ILjava/lang/String;IIL" + ClassMapping.NETWORKPLAYERINFO + ";)V"),
    GUIPLAYERTABOVERLAY$RENDERPLAYERLIST("a", "renderPlayerlist", "(IL" + ClassMapping.SCOREBOARD + ";L" + ClassMapping.SCOREOBJECTIVE + ";)V"),
    GUISCREEN$HANDLECOMPONENTCLICK("a", "handleComponentClick", "(L" + ClassMapping.ICHATCOMPONENT + ";)Z"),
    GUISCREEN$SENDCHATMESSAGE(INVOKEVIRTUAL, ClassMapping.GUISCREEN, "b", "sendChatMessage", "(Ljava/lang/String;Z)V"),
    GUISCREENBOOK$DRAWSCREEN("a", "drawScreen", "(IIF)V"),
    GUISCREENBOOK$DRAWTEXTUREDMODALRECT(INVOKEVIRTUAL, ClassMapping.GUISCREENBOOK, "b", "drawTexturedModalRect", "(IIIIII)V"),
    GUISCREENBOOK$INIT("<init>", "(L" + ClassMapping.ENTITYPLAYER + ";L" + ClassMapping.ITEMSTACK + ";Z)V"),
    GUISCREENBOOK$KEYTYPED("a", "keyTyped", "(CI)V"),
    GUIUTILRENDERCOMPONENTS$SPLITTEXT("a", "splitText", "(L" + ClassMapping.ICHATCOMPONENT + ";IL" + ClassMapping.FONTRENDERER + ";ZZ)Ljava/util/List;"),
    ICHATCOMPONENT$GETUNFORMATTEDTEXT(INVOKEINTERFACE, ClassMapping.ICHATCOMPONENT, "c", "getUnformattedText", "()Ljava/lang/String;"),
    INVENTORYPLAYER$CHANGECURRENTITEM(INVOKEVIRTUAL, ClassMapping.INVENTORYPLAYER, "d", "changeCurrentItem", "(I)V"),
    INVENTORYPLAYER$GETCURRENTITEM(INVOKEVIRTUAL, ClassMapping.INVENTORYPLAYER, "h", "getCurrentItem", "()L" + ClassMapping.ITEMSTACK + ";"),
    LAYERARMORBASE$SHOULDCOMBINETEXTURES("b", "shouldCombineTextures", "()Z"),
    LAYERARROW$DORENDERLAYER("a", "doRenderLayer", "(L" + ClassMapping.ENTITYLIVINGBASE + ";FFFFFFF)V"),
    LIST$ADD(INVOKEINTERFACE, "java/util/List", "add", "(Ljava/lang/Object;)Z"),
    MAP$PUT(INVOKEINTERFACE, ClassMapping.MAP, "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"),
    MAP$REMOVE(INVOKEINTERFACE, ClassMapping.MAP, "remove", "(Ljava/lang/Object;)Ljava/lang/Object;"),
    MATH$MAX(INVOKESTATIC, ClassMapping.MATH, "max", "(II)I"),
    MINECRAFT$RIGHTCLICKMOUSE("ax", "rightClickMouse", "()V"),
    MINECRAFT$RUNTICK("s", "runTick", "()V"),
    NETHANDLERPLAYCLIENT$HANDLEBLOCKBREAKANIM("a", "handleBlockBreakAnim", "(L" + ClassMapping.S25PACKETBLOCKBREAKANIM + ";)V"),
    NETHANDLERPLAYCLIENT$HANDLEBLOCKCHANGE("a", "handleBlockChange", "(L" + ClassMapping.S23PACKETBLOCKCHANGE + ";)V"),
    NETHANDLERPLAYCLIENT$HANDLEENTITYEQUIPMENT("a", "handleEntityEquipment", "(L" + ClassMapping.S04PACKETENTITYEQUIPMENT + ";)V"),
    NETHANDLERPLAYCLIENT$HANDLEENTITYTELEPORT("a", "handleEntityTeleport", "(L" + ClassMapping.S18PACKETENTITYTELEPORT + ";)V"),
    NETHANDLERPLAYCLIENT$HANDLEMULTIBLOCKCHANGE("a", "handleMultiBlockChange", "(L" + ClassMapping.S22PACKETMULTIBLOCKCHANGE + ";)V"),
    NETHANDLERPLAYCLIENT$HANDLEPLAYERLISTITEM("a", "handlePlayerListItem", "(L" + ClassMapping.S38PACKETPLAYERLISTITEM + ";)V"),
    NETHANDLERPLAYCLIENT$HANDLETEAMS("a", "handleTeams", "(L" + ClassMapping.S3EPACKETTEAMS + ";)V"),
    NETHANDLERPLAYCLIENT$INIT("<init>", "(L" + ClassMapping.MINECRAFT + ";L" + ClassMapping.GUISCREEN + ";L" + ClassMapping.NETWORKMANAGER + ";L" + ClassMapping.GAMEPROFILE + ";)V"),
    NETWORKMANAGER$CHANNELREAD0("a", "channelRead0", "(Lio/netty/channel/ChannelHandlerContext;L" + ClassMapping.PACKET + ";)V"),
    NETWORKMANAGER$SENDPACKET("a", "sendPacket", "(L" + ClassMapping.PACKET + ";)V"),
    NETWORKPLAYERINFO$1$SKINAVAILABLE("a", "skinAvailable", null),
    NETWORKPLAYERINFO$ACCESS002(INVOKESTATIC, ClassMapping.NETWORKPLAYERINFO, "a", "access$002", "(L" + ClassMapping.NETWORKPLAYERINFO + ";L" + ClassMapping.RESOURCELOCATION + ";)L" + ClassMapping.RESOURCELOCATION + ";"),
    NETWORKPLAYERINFO$GETDISPLAYNAME("k", "getDisplayName", "()L" + ClassMapping.ICHATCOMPONENT + ";"),
    NETWORKPLAYERINFO$GETGAMETYPE(INVOKEVIRTUAL, ClassMapping.NETWORKPLAYERINFO, "b", "getGameType", "()L" + ClassMapping.WORLDSETTINGS$GAMETYPE + ";"),
    NETWORKPLAYERINFO$INIT("<init>", "(L" + ClassMapping.S38PACKETPLAYERLISTITEM$ADDPLAYERDATA + ";)V"),
    PACKETTHREADUTIL$CHECKTHREADANDENQUEUE(INVOKESTATIC, ClassMapping.PACKETTHREADUTIL, "a", "checkThreadAndEnqueue", "(L" + ClassMapping.PACKET + ";L" + ClassMapping.INETHANDLER + ";L" + ClassMapping.ITHREADLISTENER + ";)V"),
    PROFILER$ENDSECTION(INVOKEVIRTUAL, ClassMapping.PROFILER, "b", "endSection", "()V"),
    RENDERERLIVINGENTITY$RENDERNAME("b", "renderName", "(L" + ClassMapping.ENTITYLIVINGBASE + ";DDD)V"),
    RENDERERLIVINGENTITY$ROTATECORPSE("a", "rotateCorpse", "(L" + ClassMapping.ENTITYLIVINGBASE + ";FFF)V"),
    RENDERERLIVINGENTITY$SETBRIGHTNESS("a", "setBrightness", "(L" + ClassMapping.ENTITYLIVINGBASE + ";FZ)Z"),
    RENDERGLOBAL$LOADRENDERER(INVOKEVIRTUAL, ClassMapping.RENDERGLOBAL, "a", "loadRenderers", "()V"),
    RENDERGLOBAL$PLAYAUXSFX("a", "playAuxSFX", "(L" + ClassMapping.ENTITYPLAYER + ";IL" + ClassMapping.BLOCKPOS + ";I)V"),
    RENDERGLOBAL$RENDERENTITIES("a", "renderEntities", "(L" + ClassMapping.ENTITY + ";L" + ClassMapping.ICAMERA + ";F)V"),
    RENDERMANAGER$INIT("<init>", "(L" + ClassMapping.TEXTUREMANAGER + ";L" + ClassMapping.RENDERITEM + ";)V"),
    RENDERMANAGER$ISDEBUGBOUNDINGBOX(INVOKEVIRTUAL, ClassMapping.RENDERMANAGER, "b", "isDebugBoundingBox", "()Z"),
    RENDERMANAGER$RENDERDEBUGBOUNDINGBOX("b", "renderDebugBoundingBox", "(L" + ClassMapping.ENTITY + ";DDDFF)V"),
    RENDERMANAGER$RENDERENTITYSIMPLE(INVOKEVIRTUAL, ClassMapping.RENDERMANAGER, "a", "renderEntitySimple", "(L" + ClassMapping.ENTITY + ";F)Z"),
    RENDERMANAGER$SETDEBUGBOUNDINGBOX(INVOKEVIRTUAL, ClassMapping.RENDERMANAGER, "b", "setDebugBoundingBox", "(Z)V"),
    RENDERPLAYER$RENDEROFFSETLIVINGLABEL("a", "renderOffsetLivingLabel", "(L" + ClassMapping.ABSTRACTCLIENTPLAYER + ";DDDLjava/lang/String;FD)V"),
    SCORE$GETSCOREPOINTS(INVOKEVIRTUAL, ClassMapping.SCORE, "c", "getScorePoints", "()I"),
    SCOREBOARD$ADDPLAYERTOTEAM("a", "addPlayerToTeam", "(Ljava/lang/String;Ljava/lang/String;)Z"),
    SCOREBOARD$REMOVEPLAYERFROMTEAM("a", "removePlayerFromTeam", "(Ljava/lang/String;L" + ClassMapping.SCOREPLAYERTEAM + ";)V"),
    SCOREBOARD$REMOVETEAM("d", "removeTeam", "(L" + ClassMapping.SCOREPLAYERTEAM + ";)V"),
    SCOREOBJECTIVE$GETDISPLAYNAME(INVOKEVIRTUAL, ClassMapping.SCOREOBJECTIVE, "d", "getDisplayName", "()Ljava/lang/String;"),
    SCOREPLAYERTEAM$FORMATPLAYERNAME(INVOKESTATIC, ClassMapping.SCOREPLAYERTEAM, "a", "formatPlayerName", "(L" + ClassMapping.TEAM + ";Ljava/lang/String;)Ljava/lang/String;"),
    SCOREPLAYERTEAM$SETNAMESUFFIX(INVOKEVIRTUAL, ClassMapping.SCOREPLAYERTEAM, "c", "setNameSuffix", "(Ljava/lang/String;)V"),
    STRINGBUILDER$APPEND_I(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;"),
    STRINGBUILDER$APPEND_STRING(INVOKEVIRTUAL, ClassMapping.STRINGBUILDER, "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;"),
    STRINGBUILDER$TOSTRING(INVOKEVIRTUAL, ClassMapping.STRINGBUILDER, "toString", "()Ljava/lang/String;"),
    TESSELLATOR$DRAW(INVOKEVIRTUAL, ClassMapping.TESSELLATOR, "b", "draw", "()V"),
    TESSELLATOR$GETINSTANCE(INVOKESTATIC, ClassMapping.TESSELLATOR, "a", "getInstance", "()L" + ClassMapping.TESSELLATOR + ";"),
    WORLD$UPDATEENTITYWITHOPTIONALFORCE("a", "updateEntityWithOptionalForce", "(L" + ClassMapping.ENTITY + ";Z)V");

    public final int opcode;
    public final String owner;
    public final String name;
    public final String desc;

    MethodMapping(String mcpName, String desc) {
        this.opcode = -1;
        this.owner = null;
        this.name = mcpName;
        this.desc = desc;
    }

    MethodMapping(String obfName, String mcpName, String desc) {
        this.opcode = -1;
        this.owner = null;
        this.name = ASMLoadingPlugin.isObf() ? obfName : mcpName;
        this.desc = desc;
    }

    MethodMapping(int opcode, ClassMapping owner, String mcpName, String desc) {
        this.opcode = opcode;
        this.owner = owner.toString();
        this.name = mcpName;
        this.desc = desc;
    }

    MethodMapping(int opcode, ClassMapping owner, String obfName, String mcpName, String desc) {
        this.opcode = opcode;
        this.owner = owner.toString();
        this.name = ASMLoadingPlugin.isObf() ? obfName : mcpName;
        this.desc = desc;
    }

    MethodMapping(int opcode, String owner, String mcpName, String desc) {
        this.opcode = opcode;
        this.owner = owner;
        this.name = mcpName;
        this.desc = desc;
    }

}
