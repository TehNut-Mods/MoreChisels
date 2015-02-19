package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import tehnut.morechisels.items.ItemRecipeRegistry;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.util.EnviroChecks;

import static tehnut.morechisels.ConfigHandler.*;

public class AetherIICompat {

    public static Item chiselSkyroot;
    public static Item chiselHolystone;
    public static Item chiselZanite;
    public static Item chiselGravitite;

    public static void load() {
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselSkyroot = new ItemChiselBase(ChiselType.SKYROOT);
        ItemRegistry.registerCompatItem(chiselSkyroot, "ItemChiselSkyroot", chiselSkyrootEnabled, EnviroChecks.isAetherIILoaded());

        chiselHolystone = new ItemChiselBase(ChiselType.HOLYSTONE);
        ItemRegistry.registerCompatItem(chiselHolystone, "ItemChiselHolystone", chiselHolystoneEnabled, EnviroChecks.isAetherIILoaded());

        chiselZanite = new ItemChiselBase(ChiselType.ZANITE);
        ItemRegistry.registerCompatItem(chiselZanite, "ItemChiselZanite", chiselZaniteEnabled, EnviroChecks.isAetherIILoaded());

        chiselGravitite = new ItemChiselBase(ChiselType.GRAVITITE);
        ItemRegistry.registerCompatItem(chiselGravitite, "ItemChiselGravitite", chiselGravititeEnabled, EnviroChecks.isAetherIILoaded());

    }

    private static void registerRecipes() {
        Block skyroot = GameRegistry.findBlock("aether", "skyrootPlank");
        Block holystone = GameRegistry.findBlock("aether", "holystone");
        Item zanite = GameRegistry.findItem("aether", "zaniteGemstone");
        Block gravitite = GameRegistry.findBlock("aether", "enchantedGravitite");

        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselSkyroot, skyroot);
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselHolystone, holystone);
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselZanite, zanite);
        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselGravitite, gravitite);
    }
}
