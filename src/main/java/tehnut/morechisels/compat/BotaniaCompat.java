package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.items.ItemRecipeRegistry;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.items.chisel.ItemChiselElementium;
import tehnut.morechisels.items.chisel.ItemChiselManasteel;
import tehnut.morechisels.util.EnviroChecks;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

public class BotaniaCompat {

    public static Item chiselManasteel;
    public static Item chiselElementium;

    public static void load() {
        LogHelper.info("Botania compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {

        chiselManasteel = new ItemChiselManasteel();
        ItemRegistry.registerCompatItem(chiselManasteel, "ItemChiselManasteel", chiselManasteelEnabled, EnviroChecks.isBotaniaLoaded());

        chiselElementium = new ItemChiselElementium();
        ItemRegistry.registerCompatItem(chiselElementium, "ItemChiselElementium", chiselElementiumEnabled, EnviroChecks.isBotaniaLoaded());
    }

    private static void registerRecipes() {

        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselManasteel, "ingotManasteel", chiselManasteelEnabled);
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselElementium, "ingotElvenElementium", chiselElementiumEnabled);
    }
}
