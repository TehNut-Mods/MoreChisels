package tehnut.morechisels.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import static tehnut.morechisels.ConfigHandler.*;

public class ItemRegistry {

	// Items
	public static Item chiselRuby;
	public static Item chiselSapphire;
	public static Item chiselEmerald;
	public static Item chiselFluxed;

	public static void registerItems() {

		// Gems
		chiselRuby = new ItemChiselBase(ChiselType.RUBY);
		registerOreItem(chiselRuby, "ItemChiselRuby", chiselRubyEnabled, "gemRuby");
		chiselSapphire = new ItemChiselBase(ChiselType.SAPPHIRE);
		registerOreItem(chiselSapphire, "ItemChiselSapphire", chiselSapphireEnabled, "gemSapphire");
		chiselEmerald = new ItemChiselBase(ChiselType.EMERALD);
		registerOreItem(chiselEmerald, "ItemChiselEmerald", chiselEmeraldEnabled, "gemEmerald");
	}

	private static void registerOreItem(Item item, String name, boolean config, String ore) {
		if (config && !OreDictionary.getOres(ore).isEmpty())
			GameRegistry.registerItem(item, name);
	}

	public static void registerCompatItem(Item item, String name, boolean config, boolean modLoaded) {
		if (config && modLoaded)
			GameRegistry.registerItem(item, name);
	}
}
