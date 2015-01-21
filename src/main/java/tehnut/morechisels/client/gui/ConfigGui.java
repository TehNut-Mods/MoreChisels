package tehnut.morechisels.client.gui;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraftforge.common.config.ConfigElement;
import tehnut.morechisels.ModInformation;
import tehnut.morechisels.util.TextHelper;
import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;
import java.util.List;

import static tehnut.morechisels.ConfigHandler.*;

public class ConfigGui extends GuiConfig {

	public ConfigGui(GuiScreen parentScreen) {
		super(parentScreen, getConfigElements(parentScreen), ModInformation.ID, false, false, TextHelper.localize("gui." + ModInformation.ID + ".config.title"));
	}

	@SuppressWarnings("rawtypes")
	private static List<IConfigElement> getConfigElements(GuiScreen parent) {
		List<IConfigElement> list = new ArrayList<IConfigElement>();

		// adds sections declared in ConfigHandler. toLowerCase() is used because the configuration class automatically does this, so must we.
		list.add(new ConfigElement(config.getCategory(chisels.toLowerCase())));
		list.add(new ConfigElement(config.getCategory(durability.toLowerCase())));
		list.add(new ConfigElement(config.getCategory(misc.toLowerCase())));

		return list;
	}
}