package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import tehnut.morechisels.items.ItemRecipeRegistry;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.items.chisel.ItemChiselBedrockium;
import tehnut.morechisels.util.EnviroChecks;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselBedrockiumEnabled;
import static tehnut.morechisels.ConfigHandler.chiselSteamEnabled;
import static tehnut.morechisels.ConfigHandler.chiselUnstableEnabled;

public class ExtraUtilitiesCompat {

    public static Item chiselBedrockium;
    public static Item chiselUnstable;

    public static void load() {
        LogHelper.info("ExtraUtilities compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselBedrockium = new ItemChiselBedrockium();
        ItemRegistry.registerCompatItem(chiselBedrockium, "ItemChiselBedrockium", chiselBedrockiumEnabled, EnviroChecks.isExtraUtilitiesLoaded());

        chiselUnstable = new ItemChiselBase(ChiselType.UNSTABLE);
        ItemRegistry.registerCompatItem(chiselUnstable, "ItemChiselUnstable", chiselUnstableEnabled, EnviroChecks.isExtraUtilitiesLoaded());
    }

    private static void registerRecipes() {
        Item bedrockiumIngot = GameRegistry.findItem("ExtraUtilities", "bedrockiumIngot");

        ItemRecipeRegistry.addThemedChiselRecipe(chiselBedrockium, bedrockiumIngot, "ingotUnstable", chiselBedrockiumEnabled);
        if (chiselUnstableEnabled && bedrockiumIngot != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(chiselUnstable, "I", "O", 'I', "ingotUnstable", 'O', Blocks.obsidian));
    }
}
