package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.item.ItemRecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselSouliumEnabled;

public class CompatibilitySoulShards {

    public static Item chiselSoulium;

    static {
        LogHelper.info("Soul Shards: The Old Ways compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselSoulium = new ItemChiselBase(ChiselType.SOULIUM);
        ItemRegistry.registerCompatItem(chiselSoulium, "ItemChiselSoulium", chiselSouliumEnabled);
    }

    private static void registerRecipes() {
        ItemRecipeRegistry.addThemedChiselRecipe(chiselSoulium, "ingotSoulium", "ingotIron", chiselSouliumEnabled);
    }
}
