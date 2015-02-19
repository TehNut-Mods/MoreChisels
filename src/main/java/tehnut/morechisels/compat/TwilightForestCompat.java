package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import tehnut.morechisels.items.ItemRecipeRegistry;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.util.EnviroChecks;

import static tehnut.morechisels.ConfigHandler.chiselIronwoodEnabled;
import static tehnut.morechisels.ConfigHandler.chiselSteeleafEnabled;

public class TwilightForestCompat {

    public static Item chiselIronwood;
    public static Item chiselSteeleaf;

    public static void load() {
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselIronwood = new ItemChiselBase(ChiselType.IRONWOOD);
        ItemRegistry.registerCompatItem(chiselIronwood, "ItemChiselIronwood", chiselIronwoodEnabled, EnviroChecks.isTwilightForestLoaded());

        chiselSteeleaf = new ItemChiselBase(ChiselType.STEELEAF);
        ItemRegistry.registerCompatItem(chiselSteeleaf, "ItemChiselSteeleaf", chiselSteeleafEnabled, EnviroChecks.isTwilightForestLoaded());
    }

    private static void registerRecipes() {
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselIronwood, "ironwood");
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselSteeleaf, "steeleaf");
    }
}
