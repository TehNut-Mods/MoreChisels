package tehnut.morechisels;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    // Categories
    public static String chisels = "Chisels";
    public static String durability = "Durability";
    public static String misc = "Misc";
    public static String recipes = "Recipes";

    // Options
    public static boolean chiselFluxedEnabled;
    public static boolean chiselBoundEnabled;
    public static boolean chiselBloodyEnabled;
    public static boolean chiselBedrockiumEnabled;
    public static boolean chiselIronwoodEnabled;
    public static boolean chiselSteeleafEnabled;
    public static boolean chiselKnightmetalEnabled;
    public static boolean chiselFieryEnabled;
    public static boolean chiselManasteelEnabled = false;
    public static boolean chiselElementiumEnabled = false;
    public static boolean chiselSkyrootEnabled;
    public static boolean chiselHolystoneEnabled;
    public static boolean chiselZaniteEnabled;
    public static boolean chiselGravititeEnabled;
    public static String[] gemChiselWhitelist;
    private static String[] gemChiselWhitelistDefaults = { "Emerald:700:#22ED4E", "Ruby:700:#DD0707", "Sapphire:700:#1F52F8" };

    public static int durabilityFluxed;
    public static int durabilityBloody;
    public static int durabilityBedrockium;
    public static int durabilityIronwood;
    public static int durabilitySteeleaf;
    public static int durabilityKnightmetal;
    public static int durabilityFiery;
    public static int durabilityManasteel;
    public static int durabilityElementium;
    public static int durabilitySkyroot;
    public static int durabilityHolystone;
    public static int durabilityZanite;
    public static int durabilityGravitite;

    public static boolean enableLogging;
    public static int manaPerChiseling;
    public static int lifeEssencePerRepair;

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
        config.setCategoryComment(recipes, "Recipe settings.");

        // CHISELS
        chiselFluxedEnabled = config.get(chisels, "chiselFluxedEnabled", true).getBoolean();
        chiselBoundEnabled = config.get(chisels, "chiselBoundEnabled", true).getBoolean();
//        chiselBloodyEnabled = config.get(chisels, "chiselBloodyEnabled", true).getBoolean();
        chiselBedrockiumEnabled = config.get(chisels, "chiselBedrockiumEnabled", true).getBoolean();
        chiselIronwoodEnabled = config.get(chisels, "chiselIronwoodEnabled", true).getBoolean();
        chiselSteeleafEnabled = config.get(chisels, "chiselSteeleafEnabled", true).getBoolean();
        chiselKnightmetalEnabled = config.get(chisels, "chiselKnightmetalEnabled", true).getBoolean();
        chiselFieryEnabled = config.get(chisels, "chiselFieryEnabled", true).getBoolean();
//        chiselManasteelEnabled = config.get(chisels, "chiselManasteelEnabled", true).getBoolean();
//        chiselElementiumEnabled = config.get(chisels, "chiselElementiumEnabled", true).getBoolean();
        chiselSkyrootEnabled = config.get(chisels, "chiselSkyrootEnabled", true).getBoolean();
        chiselHolystoneEnabled = config.get(chisels, "chiselHolystoneEnabled", true).getBoolean();
        chiselZaniteEnabled = config.get(chisels, "chiselZaniteEnabled", true).getBoolean();
        chiselGravititeEnabled = config.get(chisels, "chiselGravititeEnabled", true).getBoolean();
        gemChiselWhitelist = config.get(chisels, "gemChiselWhitelist", gemChiselWhitelistDefaults, "Whitelist for chisels created by Gems. Add the OreDict suffix. \nSyntax is: \nGemName:Durability:HexColor").getStringList();

        // DURABILITY
        durabilityFluxed = config.get(durability, "durabilityFluxed", 100000).getInt();
//        durabilityBloody = config.get(durability, "durabilityBloody", 500).getInt();
        durabilityBedrockium = config.get(durability, "durabilityBedrockium", Integer.MAX_VALUE).getInt();
        durabilityIronwood = config.get(durability, "durabilityIronwood", 750).getInt();
        durabilitySteeleaf = config.get(durability, "durabilitySteeleaf", 200).getInt();
        durabilityKnightmetal = config.get(durability, "durabilityKnightmetal", 650).getInt();
        durabilityFiery = config.get(durability, "durabilityFiery", 1300).getInt();
//        durabilityManasteel = config.get(durability, "durabilityManasteel", 300).getInt();
//        durabilityElementium = config.get(durability, "durabilityElementium", 720).getInt();
        durabilitySkyroot = config.get(durability, "durabilitySkyroot", 720).getInt();
        durabilityHolystone = config.get(durability, "durabilityHolystone", 720).getInt();
        durabilityZanite = config.get(durability, "durabilityZanite", 720).getInt();
        durabilityGravitite = config.get(durability, "durabilityGravitite", 720).getInt();

        enableLogging = config.get(misc, "enableLogging", true, "Allows MoreChisels to log things to console. This must be enabled when submitting a log for support.").getBoolean();
        manaPerChiseling = config.get(misc, "manaPerChiseling", 20, "Amount of Mana to drain from the player's inventory everytime you chisel something.").getInt();
        lifeEssencePerRepair = config.get(misc, "lifeEssencePerRepair", 200, "Amount of LP to drain from the player each time the Bloody Chisel repairs itself.").getInt();

        addEnderIOFluxedChiselRecipes = config.get(recipes, "addEnderIOFluxedChiselRecipes", false, "Requires EnderIO to be present.").getBoolean();
        addThermalExpansionFluxedChiselRecipes = config.get(recipes, "addThermalExpansionFluxedChiselRecipes", true, "Requires ThermalExpansion to be present.").getBoolean();
        addRedstoneArsenalFluxedChiselRecipes = config.get(recipes, "addRedstoneArsenalFluxedChiselRecipes", false, "Requires RedstoneArsenal to be present.").getBoolean();

        config.save();
    }
}
