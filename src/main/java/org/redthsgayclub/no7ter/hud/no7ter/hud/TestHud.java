package org.redthsgayclub.no7ter.hud.no7ter.hud;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import org.redthsgayclub.no7ter.hud.no7ter.config.TestConfig;

/**
 * An example OneConfig HUD that is started in the config and displays text.
 *
 * @see TestConfig#hud
 */
public class TestHud extends SingleTextHud {
    public TestHud() {
        super("Test", true);
    }

    @Override
    public String getText(boolean example) {
        return "I'm an example HUD";
    }
}
