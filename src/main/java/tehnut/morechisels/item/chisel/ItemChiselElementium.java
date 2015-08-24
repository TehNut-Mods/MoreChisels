package tehnut.morechisels.item.chisel;

import net.minecraft.item.ItemStack;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import vazkii.botania.api.mana.IManaUsingItem;

public class ItemChiselElementium extends ItemChiselBase implements IManaUsingItem {

    public ItemChiselElementium() {
        super(ChiselType.ELEMENTIUM);
    }

    @Override
    public boolean usesMana(ItemStack stack) {
        return true;
    }
}
