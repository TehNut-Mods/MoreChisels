package tehnut.morechisels.util;

import cpw.mods.fml.common.Loader;

public class EnviroChecks {

    public static boolean isBloodMagicLoaded() {
        return Loader.isModLoaded("AWWayofTime");
    }
}
