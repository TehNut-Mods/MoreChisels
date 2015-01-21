package tehnut.morechisels.items;

import com.cricketcraft.chisel.config.Configurations;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static tehnut.morechisels.ConfigHandler.*;

public class ItemRecipeRegistry {

	public static void registerRecipes() {
		if (!Configurations.chiselRecipe) {
			if (chiselRubyEnabled && !OreDictionary.getOres("gemRuby").isEmpty())
				addChiselRecipe(ItemRegistry.chiselRuby, "gemRuby");
			if (chiselSapphireEnabled && !OreDictionary.getOres("gemSapphire").isEmpty())
				addChiselRecipe(ItemRegistry.chiselSapphire, "gemSapphire");
			if (chiselEmeraldEnabled && !OreDictionary.getOres("gemEmerald").isEmpty())
				addChiselRecipe(ItemRegistry.chiselEmerald, "gemEmerald");
			if (chiselWoodEnabled && !OreDictionary.getOres("plankWood").isEmpty())
				addChiselRecipe(ItemRegistry.chiselWood, "plankWood");
			if (chiselStoneEnabled && !OreDictionary.getOres("cobblestone").isEmpty())
				addChiselRecipe(ItemRegistry.chiselStone, "cobblestone");
			if (chiselGoldEnabled && !OreDictionary.getOres("ingotGold").isEmpty())
				addChiselRecipe(ItemRegistry.chiselGold, "ingotGold");
		} else {
			if (chiselRubyEnabled && !OreDictionary.getOres("gemRuby").isEmpty())
				addModifiedChiselRecipe(ItemRegistry.chiselRuby, "gemRuby");
			if (chiselSapphireEnabled && !OreDictionary.getOres("gemSapphire").isEmpty())
				addModifiedChiselRecipe(ItemRegistry.chiselSapphire, "gemSapphire");
			if (chiselEmeraldEnabled && !OreDictionary.getOres("gemEmerald").isEmpty())
				addModifiedChiselRecipe(ItemRegistry.chiselEmerald, "gemEmerald");
			if (chiselWoodEnabled && !OreDictionary.getOres("plankWood").isEmpty())
				addModifiedChiselRecipe(ItemRegistry.chiselWood, "plankWood");
			if (chiselStoneEnabled && !OreDictionary.getOres("cobblestone").isEmpty())
				addModifiedChiselRecipe(ItemRegistry.chiselStone, "cobblestone");
			if (chiselGoldEnabled && !OreDictionary.getOres("ingotGold").isEmpty())
				addModifiedChiselRecipe(ItemRegistry.chiselGold, "ingotGold");
		}
	}

	private static void addChiselRecipe(Item chisel, String type) {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " O", "S ", 'O', type, 'S', Items.stick));
	}

	private static void addModifiedChiselRecipe(Item chisel, String type) {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " OO", " OO", "S  ", 'O', type, 'S', Items.stick));
	}
}
