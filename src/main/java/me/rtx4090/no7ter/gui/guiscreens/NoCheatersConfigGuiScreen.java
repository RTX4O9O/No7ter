package me.rtx4090.no7ter.gui.guiscreens;

import fr.alexdoru.megawallsenhancementsmod.config.ConfigHandler;
import fr.alexdoru.megawallsenhancementsmod.gui.elements.FancyGuiButton;
import fr.alexdoru.megawallsenhancementsmod.gui.elements.SimpleGuiButton;
import fr.alexdoru.megawallsenhancementsmod.gui.elements.TextElement;
import fr.alexdoru.megawallsenhancementsmod.utils.NameUtil;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiSlider;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.util.EnumChatFormatting.*;

public class NoCheatersConfigGuiScreen extends MyGuiScreen implements GuiSlider.ISlider {

    public NoCheatersConfigGuiScreen(GuiScreen parent) {
        this.parent = parent;
    }

    @Override
    public void initGui() {
        final String msg = WHITE + "fun things";
        this.maxWidth = fontRendererObj.getStringWidth(msg);
        this.maxHeight = (buttonsHeight + 4) * 10 + buttonsHeight;
        super.initGui();
        final int xPos = getxCenter() - BUTTON_WIDTH / 2;
        this.elementList.add(new TextElement(DARK_PURPLE + "Extras :D", getxCenter(), getButtonYPos(-1)).setSize(2).makeCentered());
        final List<String> iconsTooltip = new ArrayList<>();
        iconsTooltip.add(WHITE + "Warning Icon on names");
        iconsTooltip.add("");
        iconsTooltip.add(DARK_GRAY + "\u25AA " + GREEN + "Enabled" + GRAY + " : displays a warning icon in front of names on nametags and in the tablist");
        iconsTooltip.add("");
        iconsTooltip.add(DARK_GRAY + "\u25AA " + GREEN + "Tab Only" + GRAY + " : displays a warning icon in front of names in the tablist only");
        this.buttonList.add(new FancyGuiButton(
                xPos, getButtonYPos(2),
                () -> "Warning Icon on names : " + (ConfigHandler.warningIconsTabOnly ? GREEN + "Tab Only" : getSuffix(ConfigHandler.warningIconsOnNames)),
                () -> {
                    if (ConfigHandler.warningIconsOnNames && !ConfigHandler.warningIconsTabOnly) {
                        ConfigHandler.warningIconsOnNames = false;
                        ConfigHandler.warningIconsTabOnly = true;
                    } else if (ConfigHandler.warningIconsTabOnly) {
                        ConfigHandler.warningIconsTabOnly = false;
                    } else {
                        ConfigHandler.warningIconsOnNames = true;
                    }
                    NameUtil.refreshAllNamesInWorld();
                },
                iconsTooltip));
        this.buttonList.add(new SimpleGuiButton(getxCenter() - 150 / 2, getButtonYPos(11), 150, buttonsHeight, "Back", () -> mc.displayGuiScreen(this.parent)));
        this.buttonList.add(new SimpleGuiButton(getxCenter() - 200 / 2, getButtonYPos(3), 200, buttonsHeight, WHITE + "Snake Game", () -> mc.displayGuiScreen(new SnakeGameScreen(this))));

    }

    @Override
    public void onChangeSliderValue(GuiSlider slider) {
        if (slider.id == 7) {
            ConfigHandler.timeDeleteReport = slider.getValueInt();
        }
    }

}
