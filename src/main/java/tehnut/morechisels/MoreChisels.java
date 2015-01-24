package tehnut.morechisels;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import tehnut.morechisels.compat.BloodMagicCompat;
import tehnut.morechisels.compat.RedstoneFluxCompat;
import tehnut.morechisels.items.ItemRecipeRegistry;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.proxies.CommonProxy;
import tehnut.morechisels.util.EnviroChecks;
import tehnut.morechisels.util.EventHandler;
import tehnut.morechisels.util.OreDictHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND, guiFactory = ModInformation.GUIFACTORY)
public class MoreChisels {

	@SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
	public static CommonProxy proxy;

	public static Logger logger = LogManager.getLogger(ModInformation.NAME);

	@Mod.Instance
	public static MoreChisels instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());

		OreDictHandler.registerOreDict();
		FMLCommonHandler.instance().bus().register(new EventHandler());
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		ItemRegistry.registerItems();
		ItemRecipeRegistry.registerRecipes();
		if (EnviroChecks.isBloodMagicLoaded())
			BloodMagicCompat.load();
		if (EnviroChecks.isRFAPILoaded())
			RedstoneFluxCompat.load();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
