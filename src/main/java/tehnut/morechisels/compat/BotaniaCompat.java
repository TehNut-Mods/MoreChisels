package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.items.ItemRecipeRegistry;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.items.chisel.ItemChiselElementium;
import tehnut.morechisels.items.chisel.ItemChiselManasteel;
import tehnut.morechisels.util.EnviroChecks;

public class BotaniaCompat {

    public static Item chiselManasteel;
    public static Item chiselElementium;

    public static void load() {
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {

        chiselManasteel = new ItemChiselManasteel();
        ItemRegistry.registerCompatItem(chiselManasteel, "ItemChiselManasteel", ConfigHandler.chiselManasteelEnabled, EnviroChecks.isBotaniaLoaded());

        chiselElementium = new ItemChiselElementium();
        ItemRegistry.registerCompatItem(chiselElementium, "ItemChiselElementium", ConfigHandler.chiselElementiumEnabled, EnviroChecks.isBotaniaLoaded());
    }

    private static void registerRecipes() {

        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselManasteel, "ingotManasteel");
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselElementium, "ingotElvenElementium");
    }
}
