package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import tehnut.morechisels.items.ItemRecipeRegistry;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.util.EnviroChecks;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

public class TwilightForestCompat {

    public static Item chiselIronwood;
    public static Item chiselSteeleaf;
    public static Item chiselKnightmetal;
    public static Item chiselFiery;

    public static void load() {
        LogHelper.info("TwilightForest compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselIronwood = new ItemChiselBase(ChiselType.IRONWOOD);
        ItemRegistry.registerCompatItem(chiselIronwood, "ItemChiselIronwood", chiselIronwoodEnabled, EnviroChecks.isTwilightForestLoaded());

        chiselSteeleaf = new ItemChiselBase(ChiselType.STEELEAF);
        ItemRegistry.registerCompatItem(chiselSteeleaf, "ItemChiselSteeleaf", chiselSteeleafEnabled, EnviroChecks.isTwilightForestLoaded());

        chiselKnightmetal = new ItemChiselBase(ChiselType.KNIGHTMETAL);
        ItemRegistry.registerCompatItem(chiselKnightmetal, "ItemChiselKnightmetal", chiselKnightmetalEnabled, EnviroChecks.isTwilightForestLoaded());

        chiselFiery = new ItemChiselBase(ChiselType.FIERY);
        ItemRegistry.registerCompatItem(chiselFiery, "ItemChiselFiery", chiselFieryEnabled, EnviroChecks.isTwilightForestLoaded());
    }

    private static void registerRecipes() {
        Item knightmetalIngot = GameRegistry.findItem("TwilightForest", "item.knightMetal");
        Item fieryIngot = GameRegistry.findItem("TwilightForest", "item.fieryIngot");

        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselIronwood, "ironwood", chiselIronwoodEnabled);
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselSteeleaf, "steeleaf", chiselSteeleafEnabled);
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselKnightmetal, knightmetalIngot, chiselKnightmetalEnabled);
        GameRegistry.addRecipe(new ShapedOreRecipe(chiselFiery, " I", "R ", 'I', fieryIngot, 'R', Items.blaze_rod));
    }
}
