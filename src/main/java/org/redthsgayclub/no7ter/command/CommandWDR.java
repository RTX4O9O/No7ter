package org.redthsgayclub.no7ter.command;

import org.redthsgayclub.no7ter.api.apikey.HypixelApiKeyUtil;
import org.redthsgayclub.no7ter.api.cache.CachedHypixelPlayerData;
import org.redthsgayclub.no7ter.api.exceptions.ApiException;
import org.redthsgayclub.no7ter.api.hypixelplayerdataparser.LoginData;
import org.redthsgayclub.no7ter.api.requests.MojangPlayernameToUUID;
import org.redthsgayclub.no7ter.chat.ChatUtil;
import org.redthsgayclub.no7ter.features.FinalKillCounter;
import org.redthsgayclub.no7ter.features.PartyDetection;
import org.redthsgayclub.no7ter.nocheaters.ReportQueue;
import org.redthsgayclub.no7ter.nocheaters.WDR;
import org.redthsgayclub.no7ter.nocheaters.WdrData;
import org.redthsgayclub.no7ter.scoreboard.ScoreboardTracker;
import org.redthsgayclub.no7ter.utils.MultithreadingUtil;
import org.redthsgayclub.no7ter.utils.NameUtil;
import org.redthsgayclub.no7ter.utils.TabCompletionUtil;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.command.ICommandSender;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;

import java.util.*;

public class CommandWDR extends MyAbstractCommand {

    @Override
    public String getCommandName() {
        return "watchdogreport";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            sendChatMessage("/wdr");
            return;
        }
        final String playername = args[0];
        final ArrayList<String> cheats = new ArrayList<>();
        final StringBuilder message = new StringBuilder("/wdr " + playername);

        if (args.length == 1) {
            cheats.add("cheating");
        } else {
            for (int i = 1; i < args.length; i++) {
                if (args[i].equalsIgnoreCase("autoblock") || args[i].equalsIgnoreCase("multiaura")) {
                    message.append(" killaura");
                } else {
                    if (!args[i].equalsIgnoreCase("noslowdown")
                            && !args[i].equalsIgnoreCase("keepsprint")
                            && !args[i].equalsIgnoreCase("fastbreak")
                            && !args[i].equalsIgnoreCase("scaffold")) {
                        message.append(" ").append(args[i]);
                    }
                }
                cheats.add(args[i]);
            }
        }

        sendChatMessage(message.toString());
        ReportQueue.INSTANCE.addPlayerReportedThisGame(playername);
        PartyDetection.printBoostingReportAdvice(playername);

        if (ScoreboardTracker.isPreGameLobby) {
            ChatUtil.printReportingAdvice();
        }
        addPlayerToReportList(playername, cheats);
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("wdr");
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        if (args.length == 1) {
            if (ScoreboardTracker.isInMwGame) {
                if (ScoreboardTracker.isPrepPhase) {
                    return getListOfStringsMatchingLastWord(args, TabCompletionUtil.getOnlinePlayersByName());
                } else {
                    final List<String> playersInThisGame = FinalKillCounter.getPlayersInThisGame();
                    playersInThisGame.removeAll(TabCompletionUtil.getOnlinePlayersByName());
                    return getListOfStringsMatchingLastWord(args, playersInThisGame);
                }
            }
            return null;
        }
        return args.length > 1 ? getListOfStringsMatchingLastWord(args, CommandReport.cheatsArray) : null;
    }

    private static void addPlayerToReportList(String playername, ArrayList<String> cheats) {
        for (final NetworkPlayerInfo netInfo : mc.getNetHandler().getPlayerInfoMap()) {
            if (netInfo.getGameProfile().getName().equalsIgnoreCase(playername)) {
                final UUID uuid = netInfo.getGameProfile().getId();
                if (uuid.version() == 1 || uuid.version() == 4) {
                    addPlayerToReportList(
                            uuid,
                            netInfo.getGameProfile().getName(),
                            ScorePlayerTeam.formatPlayerName(netInfo.getPlayerTeam(), netInfo.getGameProfile().getName()),
                            cheats);
                    return;
                }
            }
        }
        MultithreadingUtil.addTaskToQueue(() -> {
            try {
                final MojangPlayernameToUUID mojangReq = new MojangPlayernameToUUID(playername);
                if (HypixelApiKeyUtil.apiKeyIsNotSetup()) {
                    mc.addScheduledTask(() -> addPlayerToReportList(mojangReq.getUUID(), mojangReq.getName(), null, cheats));
                    return null;
                }
                final LoginData loginData = new LoginData(CachedHypixelPlayerData.getPlayerData(mojangReq.getUuid()));
                if (!loginData.hasNeverJoinedHypixel() && mojangReq.getName().equals(loginData.getdisplayname())) {
                    // real player
                    mc.addScheduledTask(() -> addPlayerToReportList(mojangReq.getUUID(), mojangReq.getName(), loginData.getFormattedName(), cheats));
                    return null;
                }
            } catch (ApiException ignored) {}
            return null;
        });
    }

    private static void addPlayerToReportList(UUID uuid, String playername, String formattedName, ArrayList<String> cheats) {
        final WDR wdr = WdrData.getWdr(uuid, playername);
        final long time = new Date().getTime();

        final boolean isNicked = uuid.version() != 4;
        if (wdr == null) {
            WdrData.put(uuid, playername, new WDR(time, cheats));
        } else {
            wdr.time = time;
            cheats.removeAll(wdr.hacks);
            wdr.hacks.addAll(cheats);
            wdr.hacks.trimToSize();
        }
        WdrData.saveReportedPlayers();

        NameUtil.updateMWPlayerDataAndEntityData(playername, false);
        if (wdr == null) {
            ChatUtil.addChatMessage(ChatUtil.getTagNoCheaters() +
                    EnumChatFormatting.GREEN + "You reported " + (isNicked ? EnumChatFormatting.GREEN + "the" + EnumChatFormatting.DARK_PURPLE + " nicked player " : "")
                    + EnumChatFormatting.RED + (formattedName == null ? playername : EnumChatFormatting.RESET + formattedName) + EnumChatFormatting.GREEN + " and will receive warnings about this player in-game"
                    + EnumChatFormatting.GREEN + (isNicked ? " for the next 24 hours." : "."));
        }
    }

}