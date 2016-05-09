package tehnut.morechisels.item.chisel;

import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import thebetweenlands.items.ICorrodible;

import java.util.List;

public class ItemChiselSyrmorite extends ItemChiselBase implements ICorrodible {

	private IIcon[] corrosionIcons;

    public ItemChiselSyrmorite() {
        super(ChiselType.SYRMORITE);
    }

	@Override
	public IIcon[] getIcons() {
		return new IIcon[] { itemIcon };
	}

	@Override
	public void setCorrosionIcons(IIcon[][] corrosionIcons) {
		this.corrosionIcons = corrosionIcons[0];		
	}
}
