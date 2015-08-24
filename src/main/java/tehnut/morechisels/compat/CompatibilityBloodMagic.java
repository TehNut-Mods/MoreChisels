package tehnut.morechisels.compat;

import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.api.bindingRegistry.BindingRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import team.chisel.init.ChiselItems;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.item.chisel.ItemChiselBloody;
import tehnut.morechisels.item.chisel.ItemChiselBound;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.chiselBloodyEnabled;
import static tehnut.morechisels.ConfigHandler.chiselBoundEnabled;

public class CompatibilityBloodMagic {

    public static Item chiselBound;
    public static Item chiselBloody;

    static {
        LogHelper.info("BloodMagic compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselBound = new ItemChiselBound();
        ItemRegistry.registerCompatItem(chiselBound, "ItemChiselBound", chiselBoundEnabled);

        chiselBloody = new ItemChiselBloody();
        ItemRegistry.registerCompatItem(chiselBloody, "ItemChiselBloody", chiselBloodyEnabled);
    }

    private static void registerRecipes() {
        addBindingRecipe(ChiselItems.diamondChisel, chiselBoundEnabled);
        addAltarRecipe(ChiselItems.diamondChisel, chiselBloodyEnabled);
    }

    private static void addAltarRecipe(Item chisel, boolean chiselEnabled) {
        if (chiselEnabled)
            AltarRecipeRegistry.registerAltarRecipe(new ItemStack(chiselBloody), new ItemStack(chisel), 2, 1000, 10, 10, false);
    }

    private static void addBindingRecipe(Item chisel,boolean chiselEnabled) {
        if (chiselEnabled)
            BindingRegistry.registerRecipe(new ItemStack(chiselBound), new ItemStack(chisel));
    }
}
