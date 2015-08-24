package tehnut.morechisels.compat;

import net.minecraft.item.Item;

public class CompatibilitySteamcraft {

    public static Item chiselSteam;

    static {
//        LogHelper.info("Flaxbeard's Steam Power compatibility is enabled and running");
//        registerItems();
//        registerRecipes();
    }

//    private static void registerItems() {
//        chiselSteam = new ItemChiselSteam();
//        ItemRegistry.registerCompatItem(chiselSteam, "ItemChiselSteam", chiselSteamEnabled, EnviroChecks.isSteamcraftLoaded());
//    }
//
//    private static void registerRecipes() {
//        Item steamGauge = GameRegistry.findItem("Steamcraft", "meter");
//        Item brassPiston = GameRegistry.findItem("Steamcraft", "steamcraftCrafting");
//
//        if (chiselSteamEnabled && steamGauge != null && brassPiston != null)
//            GameRegistry.addRecipe(new ShapedOreRecipe(Utils.setNewSteamTag(new ItemStack(chiselSteam), 0), "GI", "SP", 'G', steamGauge, 'P', brassPiston, 'I', "ingotBrass", 'S', "stickWood"));
//    }
}
