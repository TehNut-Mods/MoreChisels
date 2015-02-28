package tehnut.morechisels.items.chisel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IWarpingGear;

public class ItemChiselVoidmetal extends ItemChiselBase implements IWarpingGear, IRepairable {

    public ItemChiselVoidmetal() {
        super(ChiselType.VOIDMETAL);
    }

    public int getWarp(ItemStack itemstack, EntityPlayer player) {
        return 1;
    }
}
