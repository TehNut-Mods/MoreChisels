package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.item.chisel.ItemChiselInfinity;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselInfinityEnabled;

public class CompatibilityAvaritia {

    public static Item chiselInfinity;

    static {
        LogHelper.info("Avaritia compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselInfinity = new ItemChiselInfinity();
        ItemRegistry.registerCompatItem(chiselInfinity, "ItemChiselInfinity", chiselInfinityEnabled);
    }

    private static void registerRecipes() {
    	if (chiselInfinityEnabled){
    		ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(new ItemStack(chiselInfinity),
	        	"    Y  ",
	        	"   YYY ",
	        	"   YYYY",
	        	"  YYYY ",
	        	" XXY   ",
	        	"XXX    ",
	        	" X     ",
	        	'X', "ingotCosmicNeutronium", 'Y', "ingotInfinity");
    	}
    }
}
