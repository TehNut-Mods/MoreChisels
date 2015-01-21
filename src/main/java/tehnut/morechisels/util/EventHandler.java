package tehnut.morechisels.util;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import tehnut.morechisels.MoreChisels;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.ModInformation;

public class EventHandler {

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.modID.equals(ModInformation.ID)) {
			ConfigHandler.syncConfig();
			MoreChisels.logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.config.refresh"));
		}
	}
}
