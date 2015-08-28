package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.item.chisel.ItemChiselElementium;
import tehnut.morechisels.item.chisel.ItemChiselManasteel;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

public class CompatibilityBotania {

    public static Item chiselManasteel;
    public static Item chiselElementium;

    static {
        LogHelper.info("Botania compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {

        chiselManasteel = new ItemChiselManasteel();
        ItemRegistry.registerCompatItem(chiselManasteel, "ItemChiselManasteel", chiselManasteelEnabled);

        chiselElementium = new ItemChiselElementium();
        ItemRegistry.registerCompatItem(chiselElementium, "ItemChiselElementium", chiselElementiumEnabled);
    }

    private static void registerRecipes() {

        RecipeRegistry.addConfiguredChiselRecipe(chiselManasteel, "ingotManasteel", chiselManasteelEnabled);
        RecipeRegistry.addConfiguredChiselRecipe(chiselElementium, "ingotElvenElementium", chiselElementiumEnabled);
    }
}
