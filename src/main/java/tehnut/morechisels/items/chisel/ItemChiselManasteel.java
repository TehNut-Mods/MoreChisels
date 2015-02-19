package tehnut.morechisels.items.chisel;

import net.minecraft.item.ItemStack;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import vazkii.botania.api.mana.IManaUsingItem;

public class ItemChiselManasteel extends ItemChiselBase implements IManaUsingItem {

    public ItemChiselManasteel() {
        super(ChiselType.MANASTEEL);
    }

    @Override
    public boolean usesMana(ItemStack stack) {
        return true;
    }
}
