package tehnut.morechisels.items;

import com.cricketcraft.chisel.config.Configurations;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemRecipeRegistry {

	public static void registerRecipes() {

		if (!Configurations.chiselRecipe) {
			addChiselRecipe(ItemRegistry.chiselRuby, "gemRuby");
			addChiselRecipe(ItemRegistry.chiselSapphire, "gemSapphire");
			addChiselRecipe(ItemRegistry.chiselEmerald, "gemEmerald");
		} else {
			addModifiedChiselRecipe(ItemRegistry.chiselRuby, "gemRuby");
			addModifiedChiselRecipe(ItemRegistry.chiselSapphire, "gemSapphire");
			addModifiedChiselRecipe(ItemRegistry.chiselEmerald, "gemEmerald");
		}
	}

	private static void addChiselRecipe(Item chisel, String type) {
		if (!OreDictionary.getOres(type).isEmpty())
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " O", "S ", 'O', type, 'S', "stickWood"));
	}

	private static void addModifiedChiselRecipe(Item chisel, String type) {
		if (!OreDictionary.getOres(type).isEmpty())
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " OO", " OO", "S  ", 'O', type, 'S', "stickWood"));
	}
}
