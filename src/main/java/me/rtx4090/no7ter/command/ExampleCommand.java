package me.rtx4090.no7ter.command;

import me.rtx4090.no7ter.No7ter;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;

/**
 * An example command implementing the Command api of OneConfig.
 * Registered in ExampleMod.java with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see Main
 * @see No7ter
 */
@Command(value = No7ter.MODID, description = "Access the " + No7ter.NAME + " GUI.")
public class ExampleCommand {
    @Main
    private void handle() {
        No7ter.INSTANCE.config.openGui();
    }
}