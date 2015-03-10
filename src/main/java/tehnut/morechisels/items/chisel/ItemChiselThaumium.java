package tehnut.morechisels.items.chisel;

import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import thaumcraft.api.IRepairable;

public class ItemChiselThaumium extends ItemChiselBase implements IRepairable {

    public ItemChiselThaumium() {
        super(ChiselType.THAUMIUM);
    }
}
