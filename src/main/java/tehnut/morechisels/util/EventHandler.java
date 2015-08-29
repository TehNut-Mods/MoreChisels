package tehnut.morechisels.util;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderPlayerEvent;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.ModInformation;

public class EventHandler {

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if (eventArgs.modID.equals(ModInformation.ID)) {
            ConfigHandler.syncConfig();
            LogHelper.info(StatCollector.translateToLocal("info.morechisels.console.config.refresh"));
        }
    }

    public static class ClientEventHandler {

        String specialPeople[] = {
            /*TehNut*/ "eb21559e-bb22-46f2-897b-71eee2d5c09b",
            /*TehNut Dev*/ "2ec627b4-782c-33b9-8668-a9992029ca84",
            /*BBoldt*/ "c30338e2-e28a-4c90-b940-bfe9197f9e82",
            /*ChatFawkes*/ "b7399e3a-e08d-4e2f-b78a-0135bba240bb",
            /*insanau*/ "f31da867-d0d2-4bb5-8b02-be673ebec214"
        };

        String chiselDevs[] = {
            /*CptSpaceToaster*/ "6dee4d8f-56a2-4cad-8a25-2505856bb4c9",
            /*Drullkus*/ "5399b615-3440-4c66-939d-ab1375952ac3",
            /*tterrag*/ "671516b1-4fb3-4c03-aa7c-9c88cfab3ae8",
            /*Cricket*/ "a7529984-8cb2-4fb9-b799-97980f770101"
        };

        ItemStack ironChisel = new ItemStack(GameRegistry.findItem("chisel", "chisel"));
        ItemStack diamondChisel = new ItemStack(GameRegistry.findItem("chisel", "diamondChisel"));

        @SubscribeEvent
        @SideOnly(Side.CLIENT)
        public void onPlayerRender(RenderPlayerEvent.Specials.Pre event) {
            if (ConfigHandler.addCoolStuffForCoolPeople) {
                if (ironChisel != null)
                    RenderUtils.renderItemOnPlayersBack(diamondChisel, specialPeople, event.entityPlayer);
                if (diamondChisel != null)
                    RenderUtils.renderItemOnPlayersBack(ironChisel, chiselDevs, event.entityPlayer);
            }
        }
    }
}
