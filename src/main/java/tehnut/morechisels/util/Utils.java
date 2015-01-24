package tehnut.morechisels.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Utils {

    public static ItemStack setNewEnergyTag(ItemStack stack, int energy) {
        if (stack.stackTagCompound == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        stack.stackTagCompound.setInteger("Energy", energy);

        return stack;
    }
}
