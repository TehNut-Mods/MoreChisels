package tehnut.morechisels.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemRecipeRegistry {

    public static void registerRecipes() {
        // TODO - Add gem chisel recipes
    }

    public static void addStandardChiselRecipe(Item chisel, String type) {
        if (!OreDictionary.getOres(type).isEmpty())
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " O", "S ", 'O', type, 'S', "stickWood"));
    }

    public static void addStandardChiselRecipe(Item chisel, Item type) {
        if (type != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " O", "S ", 'O', type, 'S', "stickWood"));
    }

    public static void addModifiedChiselRecipe(Item chisel, String type) {
        if (!OreDictionary.getOres(type).isEmpty())
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " OO", " OO", "S  ", 'O', type, 'S', "stickWood"));
    }

    public static void addModifiedChiselRecipe(Item chisel, Item type) {
        if (type != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " OO", " OO", "S  ", 'O', type, 'S', "stickWood"));
    }
}
