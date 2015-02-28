package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import tehnut.morechisels.items.ItemRecipeRegistry;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.items.chisel.ItemChiselVoidmetal;
import tehnut.morechisels.util.EnviroChecks;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

public class ThaumcraftCompat {

    public static Item chiselThaumium;
    public static Item chiselVoidmetal;

    public static void load() {
        LogHelper.info("Thaumcraft compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselThaumium = new ItemChiselBase(ChiselType.THAUMIUM);
        ItemRegistry.registerCompatItem(chiselThaumium, "ItemChiselThaumium", chiselThaumiumEnabled, EnviroChecks.isThaumcraftLoaded());

        chiselVoidmetal = new ItemChiselVoidmetal();
        ItemRegistry.registerCompatItem(chiselVoidmetal, "ItemChiselVoidmetal", chiselVoidmetalEnabled, EnviroChecks.isThaumcraftLoaded());
    }

    private static void registerRecipes() {
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselThaumium, "ingotThaumium", chiselThaumiumEnabled);
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselVoidmetal, "ingotVoid", chiselVoidmetalEnabled);
    }
}
