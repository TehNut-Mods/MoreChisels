package tehnut.morechisels.item.chisel;

import net.minecraft.item.ItemStack;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import vazkii.botania.api.mana.IManaUsingItem;

public class ItemChiselMana extends ItemChiselBase implements IManaUsingItem {

    public ItemChiselMana(ChiselType type) {
        super(type);
    }

    @Override
    public boolean usesMana(ItemStack stack) {
        return true;
    }
}
