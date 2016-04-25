package tehnut.morechisels.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.item.chisel.ItemChiselGem;

public class ItemRegistry {
    public static void registerItems() {
        // Gems and Ingots
        for (String ore : OreDictionary.getOreNames()) {
            if (ore.startsWith("gem")) {
                String gem = ore.substring(3);

                for (String whitelist : ConfigHandler.gemChiselWhitelist) {
                    String[] splitWhitelist = whitelist.split(":");

                    if (gem.equals(splitWhitelist[0]))
                        new ItemChiselGem(splitWhitelist[0], Integer.parseInt(splitWhitelist[1]), splitWhitelist[2], true);
                }
            }
        }
    }

    /**
     *
     * @param item - Item to register
     * @param name - Name of Item to register
     * @param ore - OreDict item required in order to register
     */
    public static void registerOreItem(Item item, String name, String ore) {
        if (!OreDictionary.getOres(ore).isEmpty())
            GameRegistry.registerItem(item, name);
    }

    /**
     *
     * @param item - Item to register
     * @param name - Name of Item to register
     * @param config - Does the config allow the item
     */
    public static void registerCompatItem(Item item, String name, boolean config) {
        if (config)
            GameRegistry.registerItem(item, name);
    }
}
