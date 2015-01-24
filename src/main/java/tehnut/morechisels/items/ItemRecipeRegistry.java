package tehnut.morechisels.items;

import WayofTime.alchemicalWizardry.api.bindingRegistry.BindingRegistry;
import com.cricketcraft.chisel.config.Configurations;
import com.cricketcraft.chisel.init.ChiselItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import tehnut.morechisels.ConfigHandler;
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

		if (!EnviroChecks.isRFAPILoaded()) {
			addNonRFFluxedRecipe(ChiselItems.chisel, "ingotIron");
			addNonRFFluxedRecipe(ChiselItems.diamondChisel, "gemDiamond");
			addNonRFFluxedRecipe(ItemRegistry.chiselRuby, "gemRuby");
			addNonRFFluxedRecipe(ItemRegistry.chiselSapphire, "gemSapphire");
			addNonRFFluxedRecipe(ItemRegistry.chiselEmerald, "gemEmerald");
		}

		if (EnviroChecks.isEnderIOLoaded() && ConfigHandler.addEnderIOFluxedChiselRecipes) {
			ItemStack basicCapacitor = GameRegistry.findItemStack("EnderIO", "itemBasicCapacitor", 1);

			GameRegistry.addRecipe(new ShapelessOreRecipe(ItemRegistry.chiselFluxed, ChiselItems.chisel, basicCapacitor));
		}

		if (EnviroChecks.isThermalExpansionLoaded() && ConfigHandler.addThermalExpansionFluxedChiselRecipes) {
			ItemStack hardenedFluxCapacitor = new ItemStack(GameRegistry.findItem("ThermalExpansion", "capacitor"), 1, 3);

			GameRegistry.addRecipe(new ShapelessOreRecipe(ItemRegistry.chiselFluxed, ChiselItems.chisel, hardenedFluxCapacitor));
		}

		if (EnviroChecks.isRedstoneArsenalLoaded() && ConfigHandler.addRedstoneArsenalFluxedChiselRecipes)
			GameRegistry.addRecipe(new ShapedOreRecipe(ItemRegistry.chiselFluxed, " I", "S ", 'I', "ingotElectrumFlux", 'S', "stickWood"));

		if (EnviroChecks.isBloodMagicLoaded() && ItemRegistry.chiselBound != null) {
			addBindingRecipe(ChiselItems.chisel, "ingotIron");
			addBindingRecipe(ChiselItems.diamondChisel, "gemDiamond");
			addBindingRecipe(ItemRegistry.chiselRuby, "gemRuby");
			addBindingRecipe(ItemRegistry.chiselSapphire, "gemSapphire");
			addBindingRecipe(ItemRegistry.chiselEmerald, "gemEmerald");
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

	private static void addBindingRecipe(Item chisel, String type) {
		if (!OreDictionary.getOres(type).isEmpty())
			BindingRegistry.registerRecipe(new ItemStack(ItemRegistry.chiselBound), new ItemStack(chisel));
	}

	private static void addNonRFFluxedRecipe(Item input, String type) {
		if (!OreDictionary.getOres(type).isEmpty())
			GameRegistry.addRecipe(new ShapedOreRecipe(ItemRegistry.chiselFluxed, "RG", "CR", 'R', "dustRedstone", 'G', "ingotGold", 'C', input));
	}
}
