package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.item.ItemRecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

public class CompatibilityTwilightForest {

    public static Item chiselIronwood;
    public static Item chiselSteeleaf;
    public static Item chiselKnightmetal;
    public static Item chiselFiery;

    static {
        LogHelper.info("TwilightForest compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselIronwood = new ItemChiselBase(ChiselType.IRONWOOD);
        ItemRegistry.registerCompatItem(chiselIronwood, "ItemChiselIronwood", chiselIronwoodEnabled);

        chiselSteeleaf = new ItemChiselBase(ChiselType.STEELEAF);
        ItemRegistry.registerCompatItem(chiselSteeleaf, "ItemChiselSteeleaf", chiselSteeleafEnabled);

        chiselKnightmetal = new ItemChiselBase(ChiselType.KNIGHTMETAL);
        ItemRegistry.registerCompatItem(chiselKnightmetal, "ItemChiselKnightmetal", chiselKnightmetalEnabled);

        chiselFiery = new ItemChiselBase(ChiselType.FIERY);
        ItemRegistry.registerCompatItem(chiselFiery, "ItemChiselFiery", chiselFieryEnabled);
    }

    private static void registerRecipes() {
        Item knightmetalIngot = GameRegistry.findItem("TwilightForest", "item.knightMetal");
        Item fieryIngot = GameRegistry.findItem("TwilightForest", "item.fieryIngot");

        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselIronwood, "ironwood", chiselIronwoodEnabled);
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselSteeleaf, "steeleaf", chiselSteeleafEnabled);
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselKnightmetal, knightmetalIngot, chiselKnightmetalEnabled);
        ItemRecipeRegistry.addThemedChiselRecipe(chiselFiery, fieryIngot, Items.blaze_rod, chiselFieryEnabled);
    }
}
