package tehnut.morechisels.items.chisel;

import net.minecraft.item.ItemStack;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
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
