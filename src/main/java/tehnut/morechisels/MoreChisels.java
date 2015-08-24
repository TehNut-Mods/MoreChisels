package tehnut.morechisels;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import tehnut.morechisels.compat.*;
import tehnut.morechisels.item.ItemRecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.proxy.CommonProxy;
import tehnut.morechisels.util.EventHandler;
import tehnut.morechisels.util.LogHelper;
import tehnut.morechisels.util.Utils;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND, guiFactory = ModInformation.GUIFACTORY)
public class MoreChisels {

    @SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
    public static CommonProxy proxy;

    @Mod.Instance
    public static MoreChisels instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.init(event.getSuggestedConfigurationFile());

        LogHelper.checkLogger();

        MinecraftForge.EVENT_BUS.register(new EventHandler());
        FMLCommonHandler.instance().bus().register(new EventHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.load();

        ItemRegistry.registerItems();
        ItemRecipeRegistry.registerRecipes();

        Utils.registerCompat(CompatibilityAetherII.class, "aether");
        Utils.registerCompat(CompatibilityBloodMagic.class, "AWWayofTime");
        Utils.registerCompat(CompatibilityBotania.class, "Botania");
        Utils.registerCompat(CompatibilityExtraUtilities.class, "ExtraUtilities");
        Utils.registerCompat(CompatibilityGalacticraft.class, "GalacticraftMars");
        Utils.registerCompat(CompatibilitySoulShards.class, "SSTOW");
        Utils.registerCompat(CompatibilityThaumcraft.class, "Thaumcraft");
        Utils.registerCompat(CompatibilityTwilightForest.class, "TwilightForest");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
