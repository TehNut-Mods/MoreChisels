package tehnut.morechisels.compat;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.item.chisel.ItemChiselReinforcedMetal;
import tehnut.morechisels.item.chisel.ItemChiselGalgadorianMetal;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class CompatibilityStevesCarts {

    public static Item chiselReinforcedMetal;
    public static Item chiselGalgadorianMetal;

    static {
        LogHelper.info("Steve's Carts compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselReinforcedMetal =  new ItemChiselReinforcedMetal();
        ItemRegistry.registerCompatItem(chiselReinforcedMetal, "ItemChiselReinforcedMetal", chiselReinforcedMetalEnabled);

        chiselGalgadorianMetal =  new ItemChiselGalgadorianMetal();
        ItemRegistry.registerCompatItem(chiselGalgadorianMetal, "ItemChiselGalgadorianMetal", chiselGalgadorianMetalEnabled);
    }

    private static void registerRecipes() {
        Item reinforcedMetal = GameRegistry.findItem("StevesCarts", "ModuleComponents");
        Item galgadorianMetal = GameRegistry.findItem("StevesCarts", "ModuleComponents");
        int reinforcedMeta = 22;
        int galgadorianMeta = 49;

//        RecipeRegistry.addConfiguredChiselRecipe(chiselReinforcedMetal, new ItemStack(reinforcedMetal, 1, reinforcedMeta), chiselReinforcedMetalEnabled);
//        RecipeRegistry.addConfiguredChiselRecipe(chiselGalgadorianMetal, new ItemStack(galgadorianMetal, 1, galgadorianMeta), chiselGalgadorianMetalEnabled);

        GameRegistry.addRecipe(new ShapedOreRecipe(chiselReinforcedMetal, " I", "S ", 'I', new ItemStack(reinforcedMetal, 1, reinforcedMeta), 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(chiselGalgadorianMetal, " I", "S ", 'I', new ItemStack(galgadorianMetal, 1, galgadorianMeta), 'S', "stickWood"));
    }
}
