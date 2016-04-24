package tehnut.morechisels;

import net.minecraftforge.common.config.Configuration;
import tehnut.morechisels.util.Utils;

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
    public static boolean chiselUnstableEnabled;
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
    public static boolean chiselThaumiumEnabled;
    public static boolean chiselVoidmetalEnabled;
    public static boolean chiselSouliumEnabled;
    public static boolean chiselCheeseEnabled;
    public static boolean chiselDeshEnabled;
    public static boolean chiselNeptuniumEnabled;
    public static boolean chiselInfinityEnabled;
    public static boolean chiselWalrusEnabled;
    public static boolean chiselCertusQuartzEnabled;
    public static boolean chiselReinforcedMetalEnabled;
    public static boolean chiselGalgadorianMetalEnabled;
    public static boolean chiselSyrmoriteEnabled;
    public static boolean chiselOctineEnabled;
    public static boolean chiselValoniteEnabled;
    public static String[] gemChiselWhitelist;
    private static String[] gemChiselWhitelistDefaults = { "Emerald:700:#22ED4E", "Lapis:200:#0000ff", "Quartz:250:#fff0f0", "Ruby:700:#DD0707", "Sapphire:700:#1F52F8", "Amethyst:2500:#FF00CE", "Peridot:700:#43A749", "Topaz:700:#f43E00", "Tanzanite:700:#59008B", "Malachite:700:#26E5CD", "Amber:300:#FFCE00" };
    public static String[] ingotChiselWhitelist;
    private static String[] ingotChiselWhitelistDefaults = { "Gold:300:#eadc59", "Iron:700:#22ED4E", "Brick:700:#22ED4E", "BrickNether:700:#22ED4E", "Copper:700:#22ED4E", "Aluminum:700:#22ED4E", "Tin:700:#22ED4E", "Bronze:700:#22ED4E", "RefinedObsidian:2500:#22ED4E", "Osmium:500:#22ED4E", "RefinedGlowstone:300:#22ED4E" };

    public static int durabilityFluxed;
    public static int durabilityBloody;
    public static int durabilityUnstable;
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
    public static int durabilityThaumium;
    public static int durabilityVoidmetal;
    public static int durabilitySoulium;
    public static int durabilityCheese;
    public static int durabilityDesh;
    public static int durabilityNeptunium;
    public static int durabilityWalrus;
    public static int durabilityCertusQuartz;
    public static int durabilityReinforcedMetal;
    public static int durabilityGalgadorianMetal;
    public static int durabilitySyrmorite;
    public static int durabilityOctine;
    public static int durabilityValonite;

    public static boolean enableLogging;
    public static int lifeEssencePerRepair;
    public static boolean addCoolStuffForCoolPeople;

    public static boolean addEnderIOFluxedChiselRecipes;
    public static boolean addThermalExpansionFluxedChiselRecipes;
    public static boolean addRedstoneArsenalFluxedChiselRecipes;
    public static boolean chiselRecipeType;

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
        chiselFluxedEnabled = config.getBoolean("chiselFluxedEnabled", chisels, true, "");
        chiselBoundEnabled = config.getBoolean("chiselBoundEnabled", chisels, true, "");
        chiselBedrockiumEnabled = config.getBoolean("chiselBedrockiumEnabled", chisels, true, "");
        chiselUnstableEnabled = config.getBoolean("chiselUnstableEnabled", chisels, true, "");
        chiselIronwoodEnabled = config.getBoolean("chiselIronwoodEnabled", chisels, true, "");
        chiselSteeleafEnabled = config.getBoolean("chiselSteeleafEnabled", chisels, true, "");
        chiselKnightmetalEnabled = config.getBoolean("chiselKnightmetalEnabled", chisels, true, "");
        chiselFieryEnabled = config.getBoolean("chiselFieryEnabled", chisels, true, "");
        chiselSkyrootEnabled = config.getBoolean("chiselSkyrootEnabled", chisels, true, "");
        chiselHolystoneEnabled = config.getBoolean("chiselHolystoneEnabled", chisels, true, "");
        chiselZaniteEnabled = config.getBoolean("chiselZaniteEnabled", chisels, true, "");
        chiselGravititeEnabled = config.getBoolean("chiselGravititeEnabled", chisels, true, "");
        chiselThaumiumEnabled = config.getBoolean("chiselThaumiumEnabled", chisels, true, "");
        chiselVoidmetalEnabled = config.getBoolean("chiselVoidmetalEnabled", chisels, true, "");
        chiselSouliumEnabled = config.getBoolean("chiselSouliumEnabled", chisels, true, "");
        chiselCheeseEnabled = config.getBoolean("chiselCheeseEnabled", chisels, true, "");
        chiselDeshEnabled = config.getBoolean("chiselDeshEnabled", chisels, true, "");
        chiselNeptuniumEnabled = config.getBoolean("chiselNeptuniumEnabled", chisels, true, "");
        chiselInfinityEnabled = config.getBoolean("chiselInfinityEnabled", chisels, true, "");
        chiselWalrusEnabled = config.getBoolean("chiselWalrusEnabled", chisels, true, "");
        chiselCertusQuartzEnabled = config.getBoolean("chiselCertusQuartzEnabled", chisels, true, "");
        chiselReinforcedMetalEnabled = config.getBoolean("chiselReinforcedMetalEnabled", chisels, true, "");
        chiselGalgadorianMetalEnabled = config.getBoolean("chiselGalgadorianMetalEnabled", chisels, true, "");
        chiselSyrmoriteEnabled = config.getBoolean("chiselSyrmoriteEnabled", chisels, true, "");
        chiselOctineEnabled = config.getBoolean("chiselOctineEnabled", chisels, true, "");
        chiselValoniteEnabled = config.getBoolean("chiselValoniteEnabled", chisels, true, "");
        gemChiselWhitelist = config.getStringList("gemChiselWhitelist", chisels, gemChiselWhitelistDefaults, "Whitelist for chisels created by Gems. Add the OreDict suffix.\nSyntax is:\nGemName:Durability:HexColor");
        ingotChiselWhitelist = config.getStringList("ingotChiselWhitelist", chisels, ingotChiselWhitelistDefaults, "Whitelist for chisels created by Ingots. Add the OreDict suffix.\nSyntax is:\nIngotName:Durability:HexColor");

        // DURABILITY
        durabilityFluxed = config.getInt("durabilityFluxed", durability, 100000, 0, Short.MAX_VALUE, "");
        durabilityUnstable = config.getInt("durabilityUnstable", durability, 1800, 0, Short.MAX_VALUE, "");
        durabilityIronwood = config.getInt("durabilityIronwood", durability, 750, 0, Short.MAX_VALUE, "");
        durabilitySteeleaf = config.getInt("durabilitySteeleaf", durability, 200, 0, Short.MAX_VALUE, "");
        durabilityKnightmetal = config.getInt("durabilityKnightmetal", durability, 650, 0, Short.MAX_VALUE, "");
        durabilityFiery = config.getInt("durabilityFiery", durability, 1300, 0, Short.MAX_VALUE, "");
        durabilityManasteel = config.getInt("durabilityManasteel", durability, 300, 0, Short.MAX_VALUE, "");
        durabilityElementium = config.getInt("durabilityElementium", durability, 720, 0, Short.MAX_VALUE, "");
        durabilitySkyroot = config.getInt("durabilitySkyroot", durability, 60, 0, Short.MAX_VALUE, "");
        durabilityHolystone = config.getInt("durabilityHolystone", durability, 130, 0, Short.MAX_VALUE, "");
        durabilityZanite = config.getInt("durabilityZanite", durability, 720, 0, Short.MAX_VALUE, "");
        durabilityGravitite = config.getInt("durabilityGravitite", durability, 720, 0, Short.MAX_VALUE, "");
        durabilityThaumium = config.getInt("durabilityThaumium", durability, 400, 0, Short.MAX_VALUE, "");
        durabilityVoidmetal = config.getInt("durabilityVoidmetal", durability, 150, 0, Short.MAX_VALUE, "");
        durabilitySoulium = config.getInt("durabilitySoulium", durability, 1030, 0, Short.MAX_VALUE, "");
        durabilityCheese = config.getInt("durabilityCheese", durability, 12, 0, Short.MAX_VALUE, "");
        durabilityDesh = config.getInt("durabilityDesh", durability, 1024, 0, Short.MAX_VALUE, "");
        durabilityNeptunium = config.getInt("durabilityNeptunium", durability, 2500, 0, Short.MAX_VALUE, "");
        durabilityWalrus = config.getInt("durabilityWalrus", durability, 42, 0, Short.MAX_VALUE, "");
        durabilityCertusQuartz = config.getInt("durabilityCertusQuartz", durability, 250, 0, Short.MAX_VALUE, "");
        durabilityReinforcedMetal = config.getInt("durabilityReinforcedMetal", durability, 10000, 0, Short.MAX_VALUE, "");
        durabilitySyrmorite = config.getInt("durabilitySyrmorite", durability, 200, 0, Short.MAX_VALUE, "");
        durabilityOctine = config.getInt("durabilityOctine", durability, 900, 0, Short.MAX_VALUE, "");
        durabilityValonite = config.getInt("durabilityValonite", durability, 2500, 0, Short.MAX_VALUE, "");

        enableLogging = config.getBoolean("enableLogging", misc, true, "Allows MoreChisels to log things to console. This must be enabled when submitting a log for support.");
        addCoolStuffForCoolPeople = config.getBoolean("addCoolStuffForCoolPeople", misc, true, "Disable this if you don't like cool people.");

        addEnderIOFluxedChiselRecipes = config.getBoolean("addEnderIOFluxedChiselRecipes", recipes, false, "Requires EnderIO to be present.");
        addThermalExpansionFluxedChiselRecipes = config.getBoolean("addThermalExpansionFluxedChiselRecipes", recipes, true, "Requires ThermalExpansion to be present.");
        addRedstoneArsenalFluxedChiselRecipes = config.getBoolean("addRedstoneArsenalFluxedChiselRecipes", recipes, false, "Requires RedstoneArsenal to be present.");
        chiselRecipeType = Boolean.parseBoolean(Utils.manuallyGetConfigValue("chisel.cfg", "chiselAlternateRecipe"));

        config.save();
    }
}
