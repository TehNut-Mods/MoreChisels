package tehnut.morechisels.compat;

import WayofTime.alchemicalWizardry.api.bindingRegistry.BindingRegistry;
import com.cricketcraft.chisel.init.ChiselItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.items.chisel.ItemChiselBound;
import tehnut.morechisels.util.EnviroChecks;

import static tehnut.morechisels.ConfigHandler.chiselBoundEnabled;
import static tehnut.morechisels.ConfigHandler.gemChiselWhitelist;

public class BloodMagicCompat {

    public static Item chiselBound;

    public static void load() {
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselBound = new ItemChiselBound();
        ItemRegistry.registerCompatItem(chiselBound, "ItemChiselBound", chiselBoundEnabled, EnviroChecks.isBloodMagicLoaded());
    }

    private static void registerRecipes() {
        addBindingRecipe(ChiselItems.chisel, "ingotIron");
        addBindingRecipe(ChiselItems.diamondChisel, "gemDiamond");

        // TODO - Add gem chisel binding recipes
    }

    private static void addBindingRecipe(Item chisel, String type) {
        if (!OreDictionary.getOres(type).isEmpty())
            BindingRegistry.registerRecipe(new ItemStack(chiselBound), new ItemStack(chisel));
    }
}
