package me.rtx4090.no7ter;

import me.rtx4090.no7ter.command.ExampleCommand;
import me.rtx4090.no7ter.config.TestConfig;
import cc.polyfrost.oneconfig.events.event.InitializationEvent;
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
    public static TestConfig config;

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new TestConfig();
        CommandManager.INSTANCE.registerCommand(new ExampleCommand());
    }
}
