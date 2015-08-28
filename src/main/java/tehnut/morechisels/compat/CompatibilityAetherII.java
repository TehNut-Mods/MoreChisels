package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

public class CompatibilityAetherII {

    public static Item chiselSkyroot;
    public static Item chiselHolystone;
    public static Item chiselZanite;
    public static Item chiselGravitite;

    static {
        LogHelper.info("Aether II compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselSkyroot = new ItemChiselBase(ChiselType.SKYROOT);
        ItemRegistry.registerCompatItem(chiselSkyroot, "ItemChiselSkyroot", chiselSkyrootEnabled);

        chiselHolystone = new ItemChiselBase(ChiselType.HOLYSTONE);
        ItemRegistry.registerCompatItem(chiselHolystone, "ItemChiselHolystone", chiselHolystoneEnabled);

        chiselZanite = new ItemChiselBase(ChiselType.ZANITE);
        ItemRegistry.registerCompatItem(chiselZanite, "ItemChiselZanite", chiselZaniteEnabled);

        chiselGravitite = new ItemChiselBase(ChiselType.GRAVITITE);
        ItemRegistry.registerCompatItem(chiselGravitite, "ItemChiselGravitite", chiselGravititeEnabled);

    }

    private static void registerRecipes() {
        Block skyroot = GameRegistry.findBlock("aether", "skyrootPlank");
        Block holystone = GameRegistry.findBlock("aether", "holystone");
        Item zanite = GameRegistry.findItem("aether", "zaniteGemstone");
        Block gravitite = GameRegistry.findBlock("aether", "enchantedGravitite");

        RecipeRegistry.addConfiguredChiselRecipe(chiselSkyroot, skyroot, chiselSkyrootEnabled);
        RecipeRegistry.addConfiguredChiselRecipe(chiselHolystone, holystone, chiselHolystoneEnabled);
        RecipeRegistry.addConfiguredChiselRecipe(chiselZanite, zanite, chiselZaniteEnabled);
        RecipeRegistry.addConfiguredChiselRecipe(chiselGravitite, gravitite, chiselGravititeEnabled);
    }
}
