package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import tehnut.morechisels.items.ItemRecipeRegistry;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.util.EnviroChecks;

import static tehnut.morechisels.ConfigHandler.chiselBedrockiumEnabled;

public class ExtraUtilitiesCompat {

    public static Item chiselBedrockium;

    public static void load() {
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselBedrockium = new ItemChiselBase(ChiselType.BEDROCKIUM);
        ItemRegistry.registerCompatItem(chiselBedrockium, "ItemChiselBedrockium", chiselBedrockiumEnabled, EnviroChecks.isExtraUtilitiesLoaded());
    }

    private static void registerRecipes() {
        Item bedrockiumIngot = GameRegistry.findItem("ExtraUtilities", "bedrockiumIngot");

        ItemRecipeRegistry.addConfiguredChiselRecipe(chiselBedrockium, bedrockiumIngot);
    }
}
