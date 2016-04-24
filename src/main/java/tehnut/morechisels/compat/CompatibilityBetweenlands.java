package tehnut.morechisels.compat;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.item.chisel.ItemChiselSyrmorite;
import tehnut.morechisels.item.chisel.ItemChiselOctine;
import tehnut.morechisels.item.chisel.ItemChiselValonite;
import tehnut.morechisels.util.LogHelper;

import static tehnut.morechisels.ConfigHandler.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class CompatibilityBetweenlands {

    public static Item chiselSyrmorite;
    public static Item chiselOctine;
    public static Item chiselValonite;

    static {
        LogHelper.info("Betweenlands compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselSyrmorite =  new ItemChiselSyrmorite();
        ItemRegistry.registerCompatItem(chiselSyrmorite, "ItemChiselSyrmorite", chiselSyrmoriteEnabled);

        chiselOctine =  new ItemChiselOctine();
        ItemRegistry.registerCompatItem(chiselOctine, "ItemChiselOctine", chiselOctineEnabled);

        chiselValonite =  new ItemChiselValonite();
        ItemRegistry.registerCompatItem(chiselValonite, "ItemChiselValonite", chiselValoniteEnabled);
    }

    private static void registerRecipes() {
        Item syrmorite = GameRegistry.findItem("thebetweenlands", "unknownGeneric");
        Item octine = GameRegistry.findItem("thebetweenlands", "unknownGeneric");
        Item valonite = GameRegistry.findItem("thebetweenlands", "unknownGeneric");
        Item weedstick = GameRegistry.findItem("thebetweenlands", "unknownGeneric");
        int syrmoriteMeta = 14;
        int octineMeta = 15;
        int valoniteMeta = 22;
        int weedstickMeta = 23;

        GameRegistry.addRecipe(new ShapedOreRecipe(chiselSyrmorite, " I", "S ", 'I', new ItemStack(syrmorite, 1, syrmoriteMeta), 'S', new ItemStack(weedstick, 1, weedstickMeta)));
        GameRegistry.addRecipe(new ShapedOreRecipe(chiselOctine, " I", "S ", 'I', new ItemStack(octine, 1, octineMeta), 'S', new ItemStack(weedstick, 1, weedstickMeta)));
        GameRegistry.addRecipe(new ShapedOreRecipe(chiselValonite, " I", "S ", 'I', new ItemStack(valonite, 1, valoniteMeta), 'S', new ItemStack(weedstick, 1, weedstickMeta)));
    }
}
