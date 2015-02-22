package tehnut.morechisels.compat;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.items.chisel.ItemChiselSteam;
import tehnut.morechisels.util.EnviroChecks;
import tehnut.morechisels.util.LogHelper;
import tehnut.morechisels.util.Utils;

import static tehnut.morechisels.ConfigHandler.chiselSteamEnabled;

public class SteamcraftCompat {

    public static Item chiselSteam;

    public static void load() {
        LogHelper.info("Flaxbeard's Steam Power compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselSteam = new ItemChiselSteam();
        ItemRegistry.registerCompatItem(chiselSteam, "ItemChiselSteam", chiselSteamEnabled, EnviroChecks.isSteamcraftLoaded());
    }

    private static void registerRecipes() {
        Item steamGauge = GameRegistry.findItem("Steamcraft", "meter");
        Item brassPiston = GameRegistry.findItem("Steamcraft", "steamcraftCrafting");

        if (chiselSteamEnabled && steamGauge != null && brassPiston != null)
            GameRegistry.addRecipe(new ShapedOreRecipe(Utils.setNewSteamTag(new ItemStack(chiselSteam), 0), "GI", "SP", 'G', steamGauge, 'P', brassPiston, 'I', "ingotBrass", 'S', "stickWood"));
    }
}
