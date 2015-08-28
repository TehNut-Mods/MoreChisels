package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.chisel.ItemChiselMana;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
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

        chiselManasteel = new ItemChiselMana(ChiselType.MANASTEEL);
        ItemRegistry.registerCompatItem(chiselManasteel, "ItemChiselManasteel", chiselManasteelEnabled);

        chiselElementium = new ItemChiselMana(ChiselType.ELEMENTIUM);
        ItemRegistry.registerCompatItem(chiselElementium, "ItemChiselElementium", chiselElementiumEnabled);
    }

    private static void registerRecipes() {

        RecipeRegistry.addConfiguredChiselRecipe(chiselManasteel, "ingotManasteel", chiselManasteelEnabled);
        RecipeRegistry.addConfiguredChiselRecipe(chiselElementium, "ingotElvenElementium", chiselElementiumEnabled);
    }
}
