package me.rtx4090.no7ter;

import me.rtx4090.no7ter.asm.hooks.RenderPlayerHook_RenegadeArrowCount;
import me.rtx4090.no7ter.chat.ChatListener;
import me.rtx4090.no7ter.command.*;
import me.rtx4090.no7ter.config.ConfigHandler;
import me.rtx4090.no7ter.config.PolyConfig;
import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import me.rtx4090.no7ter.features.FinalKillCounter;
import me.rtx4090.no7ter.features.LowHPIndicator;
import me.rtx4090.no7ter.features.MegaWallsEndGameStats;
import me.rtx4090.no7ter.features.SquadHandler;
import me.rtx4090.no7ter.gui.guiapi.GuiManager;
import me.rtx4090.no7ter.nocheaters.PlayerJoinListener;
import me.rtx4090.no7ter.nocheaters.ReportQueue;
import me.rtx4090.no7ter.nocheaters.WdrData;
import me.rtx4090.no7ter.scoreboard.ScoreboardTracker;
import me.rtx4090.no7ter.hackerdetector.HackerDetector;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * The entrypoint of the Example Mod that initializes it.
 *
 * @see Mod
 * @see InitializationEvent
 */
@Mod(modid = No7ter.MODID, name = No7ter.NAME, version = No7ter.VERSION)
public class No7ter {

    // Sets the variables from `gradle.properties`. See the `blossom` config in `build.gradle.kts`.
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Mod.Instance(MODID)
    public static No7ter INSTANCE; // Adds the instance of the mod, so we can access other variables.
    public static PolyConfig config;
    public static File jarFile;
    public static final Logger logger = LogManager.getLogger(NAME);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.preInit(event.getSuggestedConfigurationFile());
        jarFile = event.getSourceFile();
    }

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new PolyConfig();
        CommandManager.INSTANCE.registerCommand(new ExampleCommand());
        MinecraftForge.EVENT_BUS.register(new WdrData());
        MinecraftForge.EVENT_BUS.register(new GuiManager());
        MinecraftForge.EVENT_BUS.register(new ReportQueue());
        MinecraftForge.EVENT_BUS.register(new ChatListener());
        MinecraftForge.EVENT_BUS.register(new SquadHandler());
        MinecraftForge.EVENT_BUS.register(new HackerDetector());
        MinecraftForge.EVENT_BUS.register(new LowHPIndicator());
        MinecraftForge.EVENT_BUS.register(new FinalKillCounter());
        MinecraftForge.EVENT_BUS.register(new ScoreboardTracker());
        MinecraftForge.EVENT_BUS.register(new PlayerJoinListener());
        MinecraftForge.EVENT_BUS.register(new MegaWallsEndGameStats());
        MinecraftForge.EVENT_BUS.register(new RenderPlayerHook_RenegadeArrowCount());

        ClientCommandHandler.instance.registerCommand(new CommandWDR());
        ClientCommandHandler.instance.registerCommand(new CommandName());
        ClientCommandHandler.instance.registerCommand(new CommandUnWDR());
        ClientCommandHandler.instance.registerCommand(new CommandSquad());
        ClientCommandHandler.instance.registerCommand(new CommandStalk());
        ClientCommandHandler.instance.registerCommand(new CommandReport());
        ClientCommandHandler.instance.registerCommand(new CommandPlancke());
        ClientCommandHandler.instance.registerCommand(new CommandAddAlias());
        ClientCommandHandler.instance.registerCommand(new CommandScanGame());
        ClientCommandHandler.instance.registerCommand(new CommandFKCounter());
        ClientCommandHandler.instance.registerCommand(new CommandNocheaters());
        ClientCommandHandler.instance.registerCommand(new CommandHypixelShout());
        ClientCommandHandler.instance.registerCommand(new CommandMWEnhancements());
    }
}
