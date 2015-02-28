package tehnut.morechisels.items.chisel;

import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import tehnut.morechisels.util.TextHelper;

import java.util.List;

public class ItemChiselBedrockium extends ItemChiselBase {

    public ItemChiselBedrockium() {
        super(ChiselType.BEDROCKIUM);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
        list.add(TextHelper.PURPLE + TextHelper.localize("tip.morechisels.unbreakable"));
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
