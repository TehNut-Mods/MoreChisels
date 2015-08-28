package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.item.chisel.ItemChiselBedrockium;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselBedrockiumEnabled;
import static tehnut.morechisels.ConfigHandler.chiselUnstableEnabled;

public class CompatibilityExtraUtilities {

    public static Item chiselBedrockium;
    public static Item chiselUnstable;

    static {
        LogHelper.info("ExtraUtilities compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselBedrockium = new ItemChiselBedrockium();
        ItemRegistry.registerCompatItem(chiselBedrockium, "ItemChiselBedrockium", chiselBedrockiumEnabled);

        chiselUnstable = new ItemChiselBase(ChiselType.UNSTABLE);
        ItemRegistry.registerCompatItem(chiselUnstable, "ItemChiselUnstable", chiselUnstableEnabled);
    }

    private static void registerRecipes() {
        Item bedrockiumIngot = GameRegistry.findItem("ExtraUtilities", "bedrockiumIngot");

        RecipeRegistry.addThemedChiselRecipe(chiselBedrockium, bedrockiumIngot, "ingotUnstable", chiselBedrockiumEnabled);
        if (chiselUnstableEnabled && bedrockiumIngot != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(chiselUnstable, "I", "O", 'I', "ingotUnstable", 'O', Blocks.obsidian));
    }
}
