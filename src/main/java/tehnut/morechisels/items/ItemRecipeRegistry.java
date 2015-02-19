package tehnut.morechisels.items;

import com.cricketcraft.chisel.config.Configurations;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.util.LogHelper;

public class ItemRecipeRegistry {

    public static void registerRecipes() {
        for (int i = 0; i < ItemRegistry.chiselGem.length; i++) {
            String[] gemType = ConfigHandler.gemChiselWhitelist[i].split(":");

            addConfiguredChiselRecipe(ItemRegistry.chiselGem[i], "gem" + gemType[0]);
            LogHelper.info("Added recipe for gem" + gemType[0]);
        }
    }

    /**
     * Pre-configured chisel recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - OreDict entry to use in recipe
     */
    public static void addConfiguredChiselRecipe(Item chisel, String type) {
        if (!Configurations.chiselRecipe)
            addStandardChiselRecipe(chisel, type);
        else
            addModifiedChiselRecipe(chisel, type);
    }

    /**
     * Pre-configured chisel recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - Item to use in recipe
     */
    public static void addConfiguredChiselRecipe(Item chisel, Item type) {
        if (!Configurations.chiselRecipe)
            addStandardChiselRecipe(chisel, type);
        else
            addModifiedChiselRecipe(chisel, type);
    }

    /**
     * Pre-configured chisel recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - Item to use in recipe
     */
    public static void addConfiguredChiselRecipe(Item chisel, Block type) {
        if (!Configurations.chiselRecipe)
            addStandardChiselRecipe(chisel, type);
        else
            addModifiedChiselRecipe(chisel, type);
    }

    /**
     * Chisel standard recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - OreDict entry to use in recipe
     */
    public static void addStandardChiselRecipe(Item chisel, String type) {
        if (!OreDictionary.getOres(type).isEmpty())
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " O", "S ", 'O', type, 'S', "stickWood"));
    }

    /**
     * Chisel standard recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - Item to use in recipe
     */
    public static void addStandardChiselRecipe(Item chisel, Item type) {
        if (type != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " O", "S ", 'O', type, 'S', "stickWood"));
    }

    /**
     * Chisel standard recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - Block to use in recipe
     */
    public static void addStandardChiselRecipe(Item chisel, Block type) {
        if (type != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " O", "S ", 'O', type, 'S', "stickWood"));
    }

    /**
     * Chisel modified recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - OreDict entry to use in recipe
     */
    public static void addModifiedChiselRecipe(Item chisel, String type) {
        if (!OreDictionary.getOres(type).isEmpty())
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " OO", " OO", "S  ", 'O', type, 'S', "stickWood"));
    }

    /**
     * Chisel modified recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - Item to use in recipe
     */
    public static void addModifiedChiselRecipe(Item chisel, Item type) {
        if (type != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " OO", " OO", "S  ", 'O', type, 'S', "stickWood"));
    }

    /**
     * Chisel modified recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - Block to use in recipe
     */
    public static void addModifiedChiselRecipe(Item chisel, Block type) {
        if (type != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " OO", " OO", "S  ", 'O', type, 'S', "stickWood"));
    }
}
