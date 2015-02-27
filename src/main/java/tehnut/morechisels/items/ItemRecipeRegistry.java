package tehnut.morechisels.items;

import com.cricketcraft.chisel.config.Configurations;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.ConfigHandler;

public class ItemRecipeRegistry {

    public static void registerRecipes() {
        for (int i = 0; i < ItemRegistry.chiselGem.length; i++) {
            String[] gemType = ConfigHandler.gemChiselWhitelist[i].split(":");

            addConfiguredChiselRecipe(ItemRegistry.chiselGem[i], "gem" + gemType[0], true);
        }
    }

    /**
     * Pre-configured chisel recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - OreDict entry to use in recipe
     * @param chiselEnabled - Is the chisel enabled in the config
     */
    public static void addConfiguredChiselRecipe(Item chisel, String type, boolean chiselEnabled) {
        if (!Configurations.chiselRecipe)
            addStandardChiselRecipe(chisel, type, chiselEnabled);
        else
            addModifiedChiselRecipe(chisel, type, chiselEnabled);
    }

    /**
     * Pre-configured chisel recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - Item to use in recipe
     * @param chiselEnabled - Is the chisel enabled in the config
     */
    public static void addConfiguredChiselRecipe(Item chisel, Item type, boolean chiselEnabled) {
        if (!Configurations.chiselRecipe)
            addStandardChiselRecipe(chisel, type, chiselEnabled);
        else
            addModifiedChiselRecipe(chisel, type, chiselEnabled);
    }

    /**
     * Pre-configured chisel recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - Item to use in recipe
     * @param chiselEnabled - Is the chisel enabled in the config
     */
    public static void addConfiguredChiselRecipe(Item chisel, Block type, boolean chiselEnabled) {
        if (!Configurations.chiselRecipe)
            addStandardChiselRecipe(chisel, type, chiselEnabled);
        else
            addModifiedChiselRecipe(chisel, type, chiselEnabled);
    }

    /**
     * Chisel standard recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - OreDict entry to use in recipe
     * @param chiselEnabled - Is the chisel enabled in the config
     */
    public static void addStandardChiselRecipe(Item chisel, String type, boolean chiselEnabled) {
        if (!OreDictionary.getOres(type).isEmpty() && chiselEnabled)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1), " O", "S ", 'O', type, 'S', "stickWood"));
    }

    /**
     * Chisel standard recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - Item to use in recipe
     * @param chiselEnabled - Is the chisel enabled in the config
     */
    public static void addStandardChiselRecipe(Item chisel, Item type, boolean chiselEnabled) {
        if (type != null && chiselEnabled)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1), " O", "S ", 'O', type, 'S', "stickWood"));
    }

    /**
     * Chisel standard recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - Block to use in recipe
     * @param chiselEnabled - Is the chisel enabled in the config
     */
    public static void addStandardChiselRecipe(Item chisel, Block type, boolean chiselEnabled) {
        if (type != null && chiselEnabled)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1), " O", "S ", 'O', type, 'S', "stickWood"));
    }

    /**
     * Chisel modified recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - OreDict entry to use in recipe
     * @param chiselEnabled - Is the chisel enabled in the config
     */
    public static void addModifiedChiselRecipe(Item chisel, String type, boolean chiselEnabled) {
        if (!OreDictionary.getOres(type).isEmpty() && chiselEnabled)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1), " OO", " OO", "S  ", 'O', type, 'S', "stickWood"));
    }

    /**
     * Chisel modified recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - Item to use in recipe
     * @param chiselEnabled - Is the chisel enabled in the config
     */
    public static void addModifiedChiselRecipe(Item chisel, Item type, boolean chiselEnabled) {
        if (type != null && chiselEnabled)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1), " OO", " OO", "S  ", 'O', type, 'S', "stickWood"));
    }

    /**
     * Chisel modified recipe creation
     *
     * @param chisel - Chisel to add recipe for
     * @param type - Block to use in recipe
     * @param chiselEnabled - Is the chisel enabled in the config
     */
    public static void addModifiedChiselRecipe(Item chisel, Block type, boolean chiselEnabled) {
        if (type != null && chiselEnabled)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1), " OO", " OO", "S  ", 'O', type, 'S', "stickWood"));
    }
}
