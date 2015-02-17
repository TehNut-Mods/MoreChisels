package tehnut.morechisels.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.items.chisel.ItemChiselGem;

import java.util.ArrayList;

import static tehnut.morechisels.ConfigHandler.*;

public class ItemRegistry {

    // Items
    public static Item chiselGem[];

    public static int gemChiselCount = 0;

    public static void registerItems() {
        // Gems
        for (String ore : OreDictionary.getOreNames()) {
            if (ore.startsWith("gem")) {
                String gem = ore.substring(3);

                chiselGem = new Item[ConfigHandler.gemChiselWhitelist.length];
                for (String whitelist : ConfigHandler.gemChiselWhitelist) {
                    String[] splitWhitelist = whitelist.split(":");

                    if (gem.equals(splitWhitelist[0])) {
                        chiselGem[gemChiselCount] = new ItemChiselGem(splitWhitelist[0], Integer.parseInt(splitWhitelist[1]), true);
                        registerOreItem(chiselGem[gemChiselCount], "ItemChisel" + splitWhitelist[0], "gem" + splitWhitelist[0]);
                        gemChiselCount++;
                    }
                }
            }
        }
    }

    public static void registerOreItem(Item item, String name, String ore) {
        if (!OreDictionary.getOres(ore).isEmpty())
            GameRegistry.registerItem(item, name);
    }

    public static void registerCompatItem(Item item, String name, boolean config, boolean modLoaded) {
        if (config && modLoaded)
            GameRegistry.registerItem(item, name);
    }
}
