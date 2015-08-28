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

import static tehnut.morechisels.ConfigHandler.chiselCheeseEnabled;
import static tehnut.morechisels.ConfigHandler.chiselDeshEnabled;

public class CompatibilityGalacticraft {

    public static Item chiselCheese;
    public static Item chiselDesh;

    static {
        LogHelper.info("Galacticraft compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselCheese = new ItemChiselBase(ChiselType.CHEESE);
        ItemRegistry.registerCompatItem(chiselCheese, "ItemChiselCheese", chiselCheeseEnabled);

        chiselDesh = new ItemChiselBase(ChiselType.DESH);
        ItemRegistry.registerCompatItem(chiselDesh, "ItemChiselDesh", chiselDeshEnabled);
    }

    private static void registerRecipes() {
        Item cheese = GameRegistry.findItem("GalacticraftCore", "item.cheeseCurd");
        Item gcStick = GameRegistry.findItem("GalacticraftMars", "item.null");
        int gcStickMeta = 1;

        RecipeRegistry.addConfiguredChiselRecipe(chiselCheese, cheese, chiselCheeseEnabled);
        GameRegistry.addRecipe(new ShapedOreRecipe(chiselDesh, " I", "S ", 'I', "ingotDesh", 'S', new ItemStack(gcStick, 1, gcStickMeta)));
    }
}
