package tehnut.morechisels.items;

import WayofTime.alchemicalWizardry.api.bindingRegistry.BindingRegistry;
import com.cricketcraft.chisel.config.Configurations;
import com.cricketcraft.chisel.init.ChiselItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.util.EnviroChecks;

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

		if (EnviroChecks.isBloodMagicLoaded() && ItemRegistry.chiselBound != null) {
			addBindingRecipe(ChiselItems.chisel);
			addBindingRecipe(ChiselItems.diamondChisel);
			addBindingRecipe(ItemRegistry.chiselRuby);
			addBindingRecipe(ItemRegistry.chiselSapphire);
			addBindingRecipe(ItemRegistry.chiselEmerald);
		}
	}

	private static void addChiselRecipe(Item chisel, String type) {
		if (chisel != null && !OreDictionary.getOres(type).isEmpty())
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " O", "S ", 'O', type, 'S', Items.stick));
	}

	private static void addModifiedChiselRecipe(Item chisel, String type) {
		if (chisel != null && !OreDictionary.getOres(type).isEmpty())
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chisel, 1, 0), " OO", " OO", "S  ", 'O', type, 'S', Items.stick));
	}

	private static void addBindingRecipe(Item chisel) {
		if (chisel != null)
			BindingRegistry.registerRecipe(new ItemStack(ItemRegistry.chiselBound), new ItemStack(chisel));
	}
}
