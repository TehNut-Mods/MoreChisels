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

	public static void registerItems() {
		// Gems
		if (chiselRubyEnabled && !OreDictionary.getOres("gemRuby").isEmpty()) {
			chiselRuby = new ItemChiselBase(ChiselType.RUBY);
			GameRegistry.registerItem(chiselRuby, "ItemChiselRuby");
		}
		if (chiselSapphireEnabled && !OreDictionary.getOres("gemSapphire").isEmpty()) {
			chiselSapphire = new ItemChiselBase(ChiselType.SAPPHIRE);
			GameRegistry.registerItem(chiselSapphire, "ItemChiselSapphire");
		}
		if (chiselEmeraldEnabled && !OreDictionary.getOres("gemEmerald").isEmpty()) {
			chiselEmerald = new ItemChiselBase(ChiselType.EMERALD);
			GameRegistry.registerItem(chiselEmerald, "ItemChiselEmerald");
		}
	}
}
