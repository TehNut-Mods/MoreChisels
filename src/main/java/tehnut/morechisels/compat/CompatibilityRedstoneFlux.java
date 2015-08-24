package tehnut.morechisels.compat;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import team.chisel.init.ChiselItems;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.item.chisel.ItemChiselFluxed;
import tehnut.morechisels.util.LogHelper;
import tehnut.morechisels.util.Utils;

import static tehnut.morechisels.ConfigHandler.chiselFluxedEnabled;

public class CompatibilityRedstoneFlux {

    public static Item chiselFluxed;

    static {
        LogHelper.info("RF compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselFluxed = new ItemChiselFluxed();
        ItemRegistry.registerCompatItem(chiselFluxed, "ItemChiselFluxed", chiselFluxedEnabled);
    }

    // Somebody please do these better...
    private static void registerRecipes() {
        if ((!ConfigHandler.addEnderIOFluxedChiselRecipes && !ConfigHandler.addThermalExpansionFluxedChiselRecipes && !ConfigHandler.addRedstoneArsenalFluxedChiselRecipes) || (!Loader.isModLoaded("EnderIO") && !Loader.isModLoaded("ThermalExpansion") && !Loader.isModLoaded("RedstoneArsenal")))
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(chiselFluxed), ChiselItems.diamondChisel, Blocks.redstone_block, Blocks.redstone_block, Blocks.redstone_block));

        if (Loader.isModLoaded("EnderIO") && ConfigHandler.addEnderIOFluxedChiselRecipes) {
            ItemStack basicCapacitor = new ItemStack(GameRegistry.findItem("EnderIO", "itemBasicCapacitor"), 1, 0);

            GameRegistry.addRecipe(new ShapelessOreRecipe(Utils.setNewEnergyTag(new ItemStack(chiselFluxed), 0), ChiselItems.chisel, basicCapacitor));
        }

        if (Loader.isModLoaded("ThermalExpansion") && ConfigHandler.addThermalExpansionFluxedChiselRecipes) {
            ItemStack hardenedFluxCapacitor = new ItemStack(GameRegistry.findItem("ThermalExpansion", "capacitor"), 1, 3);

            GameRegistry.addRecipe(new ShapelessOreRecipe(Utils.setNewEnergyTag(new ItemStack(chiselFluxed), 0), ChiselItems.chisel, hardenedFluxCapacitor));
        }

        if (Loader.isModLoaded("RedstoneArsenal") && ConfigHandler.addRedstoneArsenalFluxedChiselRecipes)
            GameRegistry.addRecipe(new ShapedOreRecipe(Utils.setNewEnergyTag(new ItemStack(chiselFluxed), 0), " I", "S ", 'I', "ingotElectrumFlux", 'S', "stickWood"));
    }
}
