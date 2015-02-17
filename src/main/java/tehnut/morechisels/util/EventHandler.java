package tehnut.morechisels.util;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.ModInformation;
import tehnut.morechisels.MoreChisels;

import java.util.List;

public class EventHandler {

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if (eventArgs.modID.equals(ModInformation.ID)) {
            ConfigHandler.syncConfig();
            MoreChisels.logger.info(TextHelper.localize("info.morechisels.console.config.refresh"));
        }
    }

    @SuppressWarnings("unchecked")
    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.itemStack;
        Item item = event.itemStack.getItem();
        List list = event.toolTip;

        if (stack.getDisplayName().equals(TextHelper.localize("item.morechisels.chisel.bedrockium.name")))
            list.add(TextHelper.localize("tip.morechisels.bedrockium"));
    }
}
