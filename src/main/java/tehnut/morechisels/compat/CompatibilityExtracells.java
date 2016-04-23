package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class CompatibilityExtraCells {

    public static Item chiselWalrus;

    static {
        LogHelper.info("Extra Cells compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselWalrus = new ItemChiselBase(ChiselType.WALRUS);
        ItemRegistry.registerCompatItem(chiselWalrus, "ItemChiselWalrus", chiselWalrusEnabled);
    }

    private static void registerRecipes() {
        Item walrus = GameRegistry.findItem("extracells", "walrus");

        RecipeRegistry.addConfiguredChiselRecipe(chiselWalrus, walrus, chiselWalrusEnabled);
    }
}
