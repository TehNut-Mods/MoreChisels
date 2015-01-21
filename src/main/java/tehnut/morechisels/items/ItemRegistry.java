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

	public static Item chiselWood;
	public static Item chiselStone;
	public static Item chiselGold;

	public static void registerItems() {

		// Gems
		if (chiselRubyEnabled && !OreDictionary.getOres("gemRuby").isEmpty()) {
			chiselRuby = new ItemChiselBase("gem.ruby", "chisel_ruby", durabilityRuby);
			GameRegistry.registerItem(chiselRuby, "ItemChiselRuby");
		}
		if (chiselSapphireEnabled && !OreDictionary.getOres("gemSapphire").isEmpty()) {
			chiselSapphire = new ItemChiselBase("gem.sapphire", "chisel_sapphire", durabilitySapphire);
			GameRegistry.registerItem(chiselSapphire, "ItemChiselSapphire");
		}
		if (chiselEmeraldEnabled && !OreDictionary.getOres("gemEmerald").isEmpty()) {
			chiselEmerald = new ItemChiselBase("gem.emerald", "chisel_emerald", durabilityEmerald);
			GameRegistry.registerItem(chiselEmerald, "ItemChiselEmerald");
		}

		// Materials
		if (chiselWoodEnabled && !OreDictionary.getOres("plankWood").isEmpty()) {
			chiselWood = new ItemChiselBase("material.wood", "chisel_wood", durabilityWood);
			GameRegistry.registerItem(chiselWood, "ItemChiselWood");
		}
		if (chiselStoneEnabled && !OreDictionary.getOres("cobblestone").isEmpty()) {
			chiselStone  = new ItemChiselBase("material.stone", "chisel_stone", durabilityStone);
			GameRegistry.registerItem(chiselStone, "ItemChiselStone");
		}
		if (chiselGoldEnabled && !OreDictionary.getOres("ingotGold").isEmpty()) {
			chiselGold = new ItemChiselBase("material.gold", "chisel_gold", durabilityGold);
			GameRegistry.registerItem(chiselGold, "ItemChiselGold");
		}
	}
}
