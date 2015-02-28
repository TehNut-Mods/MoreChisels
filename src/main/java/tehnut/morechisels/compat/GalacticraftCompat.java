package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import tehnut.morechisels.items.ItemRecipeRegistry;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.util.EnviroChecks;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselCheeseEnabled;
import static tehnut.morechisels.ConfigHandler.chiselDeshEnabled;

public class GalacticraftCompat {

    public static Item chiselCheese;
    public static Item chiselDesh;

    public static void load() {
        LogHelper.info("Galacticraft compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselCheese = new ItemChiselBase(ChiselType.CHEESE);
        ItemRegistry.registerCompatItem(chiselCheese, "ItemChiselCheese", chiselCheeseEnabled, EnviroChecks.isGalacticraftLoaded());

        chiselDesh = new ItemChiselBase(ChiselType.DESH);
        ItemRegistry.registerCompatItem(chiselDesh, "ItemChiselDesh", chiselDeshEnabled, EnviroChecks.isGalacticraftLoaded());
    }

    private static void registerRecipes() {
        Item cheese = GameRegistry.findItem("GalacticraftCore", "item.cheeseCurd");
        Item gcStick = GameRegistry.findItem("GalacticraftMars", "item.null");
        int gcStickMeta = 1;

        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselCheese, cheese, chiselCheeseEnabled);
        GameRegistry.addRecipe(new ShapedOreRecipe(chiselDesh, " I", "S ", 'I', "ingotDesh", 'S', new ItemStack(gcStick, 1, gcStickMeta)));
    }
}
