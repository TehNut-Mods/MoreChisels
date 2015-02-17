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
    public static boolean chiselBoundEnabled;
    public static boolean chiselBedrockiumEnabled;
    public static boolean chiselIronwoodEnabled;
    public static boolean chiselSteeleafEnabled;
    public static String[] gemChiselWhitelist;
    private static String[] gemChiselWhitelistDefaults = { "Emerald:700:#22ED4E", "Ruby:700:#DD0707", "Sapphire:700:#1F52F8" };

    public static int durabilityRuby;
    public static int durabilitySapphire;
    public static int durabilityEmerald;
    public static int durabilityFluxed;
    public static int durabilityBloody;
    public static int durabilityBedrockium;
    public static int durabilityIronwood;
    public static int durabilitySteeleaf;

    public static boolean addEnderIOFluxedChiselRecipes;
    public static boolean addThermalExpansionFluxedChiselRecipes;
    public static boolean addRedstoneArsenalFluxedChiselRecipes;

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig() {
        config.setCategoryComment(chisels, "Toggling of all chisels. If the chisel doesn't find the material it requires, it will not register.");
        config.setCategoryComment(durability, "Setting of durabilities for every chisel.");
        config.setCategoryComment(misc, "Misc settings.");

        chiselRubyEnabled = config.get(chisels, "chiselRubyEnabled", true).getBoolean();
        chiselSapphireEnabled = config.get(chisels, "chiselSapphireEnabled", true).getBoolean();
        chiselEmeraldEnabled = config.get(chisels, "chiselEmeraldEnabled", true).getBoolean();
        chiselFluxedEnabled = config.get(chisels, "chiselFluxedEnabled", true).getBoolean();
        chiselBoundEnabled = config.get(chisels, "chiselBoundEnabled", true).getBoolean();
        chiselBedrockiumEnabled = config.get(chisels, "chiselBedrockiumEnabled", true).getBoolean();
        chiselIronwoodEnabled = config.get(chisels, "chiselIronwoodEnabled", true).getBoolean();
        chiselSteeleafEnabled = config.get(chisels, "chiselSteeleafEnabled", true).getBoolean();
        gemChiselWhitelist = config.get(chisels, "gemChiselWhitelist", gemChiselWhitelistDefaults, "Whitelist for chisels created by Gems. Add the OreDict suffix. \nSyntax is: \nGemName:Durability:HexColor").getStringList();

        durabilityRuby = config.get(durability, "durabilityRuby", 700).getInt();
        durabilitySapphire = config.get(durability, "durabilitySapphire", 700).getInt();
        durabilityEmerald = config.get(durability, "durabilityEmerald", 700).getInt();
        durabilityFluxed = config.get(durability, "durabilityFluxed", 100000).getInt();
        durabilityBloody = config.get(durability, "durabilityBloody", 20000).getInt();
        durabilityBedrockium = config.get(durability, "durabilityBedrockium", Integer.MAX_VALUE).getInt();
        durabilityIronwood = config.get(durability, "durabilityIronwood", 750).getInt();
        durabilitySteeleaf = config.get(durability, "durabilitySteeleaf", 1500).getInt();

        addEnderIOFluxedChiselRecipes = config.get(misc, "addEnderIOFluxedChiselRecipes", false, "Requires EnderIO to be present.").getBoolean();
        addThermalExpansionFluxedChiselRecipes = config.get(misc, "addThermalExpansionFluxedChiselRecipes", true, "Requires ThermalExpansion to be present.").getBoolean();
        addRedstoneArsenalFluxedChiselRecipes = config.get(misc, "addRedstoneArsenalFluxedChiselRecipes", false, "Requires RedstoneArsenal to be present.").getBoolean();

        config.save();
    }
}
