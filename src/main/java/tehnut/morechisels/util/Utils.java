package tehnut.morechisels.util;

import cpw.mods.fml.common.Loader;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.MoreChisels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utils {

    /**
     * @param stack  - The ItemStack.
     * @param energy - Energy to set stack to.
     * @return - The ItemStack with an energy tag.
     */
    public static ItemStack setNewEnergyTag(ItemStack stack, int energy) {
        if (stack.stackTagCompound == null)
            stack.setTagCompound(new NBTTagCompound());

        if (stack.stackTagCompound != null && stack.stackTagCompound.getInteger("Energy") <= 0)
            stack.stackTagCompound.setInteger("Energy", energy);

        return stack;
    }

    /**
     * Inserts spaces into a string if a capital is found after a lowercase.
     *
     * @param input - String to split.
     *
     * @return - split string IE: camelCase to camel Case
     */

    public static String splitAtCapital(String input) {
        return input.replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2");
    }

    /**
     * Loads a class if the given modid is found
     *
     * @param clazz - Compatibility class
     * @param modid - Required modid
     */
    public static void registerCompat(Class clazz, String modid) {
        if (Loader.isModLoaded(modid)) {
            try {
                Class.forName(clazz.getCanonicalName());
            } catch (ClassNotFoundException e) {
                LogHelper.error("Could not find compatibility class for mod { " + modid + " }. Please report this.");
            }
        }
    }

    /**
     * Ripped from EnderCore
     *
     * Finds the config value in the file specified (path starting after config/), and for the key specified
     *
     * @param filePathFromConfigFolder
     *            - The path to the file, everything up to config/ is calculated for you
     * @param key
     *            - A key to find the value by, does not need to match exactly
     * @return A parseable string that can be transformed into any of the types of config values, for instance using
     *         <code>Boolean.parseBoolean(String)</code>
     */
    public static String manuallyGetConfigValue(String filePathFromConfigFolder, String key) {
        File config = new File(MoreChisels.configFolder.getAbsolutePath() + "/" + filePathFromConfigFolder);
        Scanner scan = null;

        try {
            scan = new Scanner(config);
        } catch (FileNotFoundException e) {
            return "";
        }

        while (scan.hasNext()) {
            String s = scan.next();

            if (s.contains(key)) {
                scan.close();
                return s.substring(s.indexOf("=") + 1, s.length());
            }
        }

        scan.close();
        return "";
    }
}
