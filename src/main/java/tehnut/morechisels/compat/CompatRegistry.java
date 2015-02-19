package tehnut.morechisels.compat;

import static tehnut.morechisels.util.EnviroChecks.*;

public class CompatRegistry {

    public static void registerCompat() {
        if (isBloodMagicLoaded())
            BloodMagicCompat.load();
        if (isRFAPILoaded())
            RedstoneFluxCompat.load();
        if (isExtraUtilitiesLoaded())
            ExtraUtilitiesCompat.load();
        if (isTwilightForestLoaded())
            TwilightForestCompat.load();
        if (isBotaniaLoaded())
            BotaniaCompat.load();
        if (isAetherIILoaded())
            AetherIICompat.load();
    }
}
