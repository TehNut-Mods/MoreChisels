package tehnut.morechisels.item.chisel;

import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import thaumcraft.api.IRepairable;

public class ItemChiselThaumium extends ItemChiselBase implements IRepairable {

    public ItemChiselThaumium() {
        super(ChiselType.THAUMIUM);
    }
}
