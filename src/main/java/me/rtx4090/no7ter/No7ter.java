package me.rtx4090.no7ter;

import me.rtx4090.no7ter.command.ExampleCommand;
import me.rtx4090.no7ter.config.PolyConfig;
import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

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

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new PolyConfig();
        CommandManager.INSTANCE.registerCommand(new ExampleCommand());
        MinecraftForge.EVENT_BUS.register(new WdrData());
        MinecraftForge.EVENT_BUS.register(new GuiManager());
        MinecraftForge.EVENT_BUS.register(new ModUpdater());
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
