package tehnut.morechisels;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import tehnut.morechisels.compat.*;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.registry.ItemRegistry;
import tehnut.morechisels.proxy.CommonProxy;
import tehnut.morechisels.util.EventHandler;
import tehnut.morechisels.util.Utils;

import java.io.File;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND, guiFactory = ModInformation.GUIFACTORY)
public class MoreChisels {

    @SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
    public static CommonProxy proxy;

    @Mod.Instance
    public static MoreChisels instance;

    public static File configFolder;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configFolder = event.getModConfigurationDirectory();
        ConfigHandler.init(event.getSuggestedConfigurationFile());

        EventHandler handler = new EventHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        FMLCommonHandler.instance().bus().register(handler);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.load();

        ItemRegistry.registerItems();
        RecipeRegistry.registerRecipes();

        Utils.registerCompat(CompatibilityAetherII.class, "aether");
        Utils.registerCompat(CompatibilityBloodMagic.class, "AWWayofTime");
        Utils.registerCompat(CompatibilityBotania.class, "Botania");
        Utils.registerCompat(CompatibilityExtraUtilities.class, "ExtraUtilities");
        Utils.registerCompat(CompatibilityGalacticraft.class, "GalacticraftMars");
        Utils.registerCompat(CompatibilitySoulShards.class, "SSTOW");
        Utils.registerCompat(CompatibilityThaumcraft.class, "Thaumcraft");
        Utils.registerCompat(CompatibilityTwilightForest.class, "TwilightForest");
        Utils.registerCompat(CompatibilityAquaculture.class, "Aquaculture");
        Utils.registerCompat(CompatibilityAvaritia.class, "Avaritia");
        Utils.registerCompat(CompatibilityExtraCells.class, "extracells");
        Utils.registerCompat(CompatibilityAppliedEnergistics.class, "appliedenergistics2");
        Utils.registerCompat(CompatibilityStevesCarts.class, "StevesCarts");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
