package tehnut.morechisels;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

	public static Configuration config;

	// Categories
	public static String chisels = "Chisels";
	public static String durability = "Durability";
	public static String misc = "Misc";

	// Options
	public static boolean chiselRubyEnabled;
	public static boolean chiselSapphireEnabled;
	public static boolean chiselEmeraldEnabled;
	public static boolean chiselWoodEnabled;
	public static boolean chiselStoneEnabled;
	public static boolean chiselGoldEnabled;

	public static int durabilityRuby;
	public static int durabilitySapphire;
	public static int durabilityEmerald;
	public static int durabilityWood;
	public static int durabilityStone;
	public static int durabilityGold;

	public static void init(File file) {
		config = new Configuration(file);
		syncConfig();
	}

	public static void syncConfig() {
		config.setCategoryComment(chisels, "Toggling of all chisels. If the chisel doesn't find the material it requires, it will not register.");
		config.setCategoryComment(durability, "Setting of durabilities for every chisel.");
		config.setCategoryComment(misc, "Misc settings,");

		chiselRubyEnabled = config.get(chisels, "chiselRubyEnabled", true).getBoolean();
		chiselSapphireEnabled = config.get(chisels, "chiselSapphireEnabled", true).getBoolean();
		chiselEmeraldEnabled = config.get(chisels, "chiselEmeraldEnabled", true).getBoolean();
		chiselWoodEnabled = config.get(chisels, "chiselWoodEnabled", true).getBoolean();
		chiselStoneEnabled = config.get(chisels, "chiselStoneEnabled", true).getBoolean();
		chiselGoldEnabled = config.get(chisels, "chiselGoldEnabled", true).getBoolean();

		durabilityRuby = config.get(durability, "durabilityRuby", 700).getInt();
		durabilitySapphire = config.get(durability, "durabilitySapphire", 700).getInt();
		durabilityEmerald = config.get(durability, "durabilityEmerald", 700).getInt();
		durabilityWood = config.get(durability, "durabilityWood", 50).getInt();
		durabilityStone = config.get(durability, "durabilityStone", 150).getInt();
		durabilityGold = config.get(durability, "durabilityGold", 200).getInt();

		config.save();
	}
}
