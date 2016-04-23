package tehnut.morechisels.item.chisel;

import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

import java.util.List;

public class ItemChiselInfinity extends ItemChiselBase {

    public ItemChiselInfinity() {
        super(ChiselType.INFINITY);

        this.hasModes = true;
    }

    @Override
    public boolean onChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return false;
    }

    @Override
    public boolean hasModes(ItemStack chisel) {
        return true;
    }
}
