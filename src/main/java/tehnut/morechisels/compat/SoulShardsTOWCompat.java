package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import tehnut.morechisels.items.ItemRecipeRegistry;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.util.EnviroChecks;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselSouliumEnabled;

public class SoulShardsTOWCompat {

    public static Item chiselSoulium;

    public static void load() {
        LogHelper.info("Soul Shards: The Old Ways compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselSoulium = new ItemChiselBase(ChiselType.SOULIUM);
        ItemRegistry.registerCompatItem(chiselSoulium, "ItemChiselSoulium", chiselSouliumEnabled, EnviroChecks.isSoulShardsTOWLoaded());
    }

    private static void registerRecipes() {
        ItemRecipeRegistry.addThemedChiselRecipe(chiselSoulium, "ingotSoulium", "ingotIron", chiselSouliumEnabled);
    }
}
