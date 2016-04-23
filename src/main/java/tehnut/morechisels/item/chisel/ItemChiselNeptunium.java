package tehnut.morechisels.item.chisel;

import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

import java.util.List;

public class ItemChiselNeptunium extends ItemChiselBase {

    public ItemChiselNeptunium() {
        super(ChiselType.NEPTUNIUM);

        this.hasModes = true;
    }

    @Override
    public boolean hasModes(ItemStack chisel) {
        return true;
    }
}
