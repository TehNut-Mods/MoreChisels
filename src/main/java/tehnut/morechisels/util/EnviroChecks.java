package tehnut.morechisels.util;

import cpw.mods.fml.common.Loader;

public class EnviroChecks {

    public static boolean isAetherIILoaded() {
        return Loader.isModLoaded("aether");
    }

    public static boolean isBloodMagicLoaded() {
        return Loader.isModLoaded("AWWayofTime");
    }

    public static boolean isBotaniaLoaded() {
        return Loader.isModLoaded("Botania");
    }

    public static boolean isEnderIOLoaded() {
        return Loader.isModLoaded("EnderIO");
    }

    public static boolean isExtraUtilitiesLoaded() {
        return Loader.isModLoaded("ExtraUtilities");
    }

    public static boolean isSteamcraftLoaded() {
        return Loader.isModLoaded("Steamcraft");
    }

    public static boolean isThaumcraftLoaded() {
        return Loader.isModLoaded("Thaumcraft");
    }

    public static boolean isThermalExpansionLoaded() {
        return Loader.isModLoaded("ThermalExpansion");
    }

    public static boolean isRedstoneArsenalLoaded() {
        return Loader.isModLoaded("RedstoneArsenal");
    }

    public static boolean isTwilightForestLoaded() {
        return Loader.isModLoaded("TwilightForest");
    }

    public static boolean isRFAPILoaded() {
        boolean checked = false;
        boolean foundRF = false;

        if (!checked) {
            try {
                Class.forName("cofh.api.energy.IEnergyHandler");
                foundRF = true;
            } catch (ClassNotFoundException e) {
                // Not found
            } finally {
                checked = true;
            }
        }

        return foundRF;
    }
}
