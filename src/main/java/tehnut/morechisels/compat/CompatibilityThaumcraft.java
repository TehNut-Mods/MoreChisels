package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.item.chisel.ItemChiselThaumium;
import tehnut.morechisels.item.chisel.ItemChiselVoidmetal;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

public class CompatibilityThaumcraft {

    public static Item chiselThaumium;
    public static Item chiselVoidmetal;

    static {
        LogHelper.info("Thaumcraft compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselThaumium = new ItemChiselThaumium();
        ItemRegistry.registerCompatItem(chiselThaumium, "ItemChiselThaumium", chiselThaumiumEnabled);

        chiselVoidmetal = new ItemChiselVoidmetal();
        ItemRegistry.registerCompatItem(chiselVoidmetal, "ItemChiselVoidmetal", chiselVoidmetalEnabled);
    }

    private static void registerRecipes() {
        RecipeRegistry.addConfiguredChiselRecipe(chiselThaumium, "ingotThaumium", chiselThaumiumEnabled);
        RecipeRegistry.addConfiguredChiselRecipe(chiselVoidmetal, "ingotVoid", chiselVoidmetalEnabled);
    }
}
