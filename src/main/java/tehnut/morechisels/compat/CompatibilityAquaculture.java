package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselNeptuniumEnabled;

public class CompatibilityAquaculture {

    public static Item chiselNeptunium;

    static {
        LogHelper.info("Aquaculture compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselNeptunium = new ItemChiselBase(ChiselType.NEPTUNIUM);
        ItemRegistry.registerCompatItem(chiselNeptunium, "ItemChiselNeptunium", chiselNeptuniumEnabled);
    }

    private static void registerRecipes() {
        Item neptunium =GameRegistry.findItem("Aquaculture", "item.loot");
        int neptuniumMeta = 12;

//        RecipeRegistry.addConfiguredChiselRecipe(chiselNeptunium, new ItemStack(neptunium, 1, neptuniumMeta), chiselNeptuniumEnabled);	//meh, it doesn't support ItemStack
        GameRegistry.addRecipe(new ShapedOreRecipe(chiselNeptunium, " I", "S ", 'I', new ItemStack(neptunium, 1, neptuniumMeta), 'S', "stickWood"));
    }
}
