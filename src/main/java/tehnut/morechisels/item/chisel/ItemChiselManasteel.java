package tehnut.morechisels.item.chisel;

import net.minecraft.item.ItemStack;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
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
