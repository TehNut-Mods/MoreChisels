package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.item.chisel.ItemChiselNeptunium;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselCardboardEnabled;

public class CompatibilityBetterStorage {

    public static Item chiselCardboard;

    static {
        LogHelper.info("Better Storage compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselCardboard =  new ItemChiselBase(ChiselType.CARDBOARD);
        ItemRegistry.registerCompatItem(chiselCardboard, "ItemChiselCardboard", chiselCardboardEnabled);
    }

    private static void registerRecipes() {
        RecipeRegistry.addConfiguredChiselRecipe(chiselCardboard, "sheetCardboard", chiselCardboardEnabled);
    }
}
