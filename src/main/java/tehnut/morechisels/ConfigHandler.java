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
	public static boolean chiselFluxedEnabled;
	public static boolean chiselBloodyEnabled;
	public static boolean chiselBoundEnabled;

	public static int durabilityRuby;
	public static int durabilitySapphire;
	public static int durabilityEmerald;
	public static int durabilityFluxed;
	public static int durabilityBloody;

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
//		chiselFluxedEnabled = config.get(chisels, "chiselFluxedEnabled", true).getBoolean();
//		chiselBloodyEnabled = config.get(chisels, "chiselBloodyEnabled", true).getBoolean();
//		chiselBoundEnabled = config.get(chisels, "chiselBoundEnabled", true).getBoolean();

		durabilityRuby = config.get(durability, "durabilityRuby", 700).getInt();
		durabilitySapphire = config.get(durability, "durabilitySapphire", 700).getInt();
		durabilityEmerald = config.get(durability, "durabilityEmerald", 700).getInt();
		durabilityFluxed = config.get(durability, "durabilityFluxed", 100000).getInt();
		durabilityBloody = config.get(durability, "durabilityBloody", 20000).getInt();

		config.save();
	}
}
