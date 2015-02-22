package tehnut.morechisels.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

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
     * @param stack  - The ItemStack.
     * @param steam - Energy to set stack to.
     * @return - The ItemStack with an energy tag.
     */
    public static ItemStack setNewSteamTag(ItemStack stack, int steam) {
        if (stack.stackTagCompound == null)
            stack.setTagCompound(new NBTTagCompound());

        if (stack.stackTagCompound != null && stack.stackTagCompound.getInteger("steamFill") <= 0)
            stack.stackTagCompound.setInteger("steamFill", steam);

        return stack;
    }

    /**
     *
     * @param stack - Item to check Steam of
     * @return - Amount of Steam stored
     */
    public static int getCurrentSteam(ItemStack stack) {
        NBTTagCompound tag = stack.stackTagCompound;

        if (tag == null)
            stack.setTagCompound(new NBTTagCompound());

        return tag.getInteger("steamFill");
    }

    /**
     *
     * @param stack - Item to check Steam of
     * @return - Amount of Steam stored
     */
    public static void reduceSteamLevel(ItemStack stack, int reduce) {
        NBTTagCompound tag = stack.stackTagCompound;

        if (tag == null)
            stack.setTagCompound(new NBTTagCompound());

        tag.setInteger("steamFill", getCurrentSteam(stack) - reduce);
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
}
