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
}
