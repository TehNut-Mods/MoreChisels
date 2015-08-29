package tehnut.morechisels.item.chisel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import team.chisel.api.carving.ICarvingVariation;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

import java.util.List;

public class ItemChiselBedrockium extends ItemChiselBase {

    public ItemChiselBedrockium() {
        super(ChiselType.BEDROCKIUM);

        this.hasModes = true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
        list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("tip.morechisels.unbreakable"));
    }
    
    @Override
    public boolean onChisel(World world, EntityPlayer player, ItemStack chisel, ICarvingVariation target) {
        return false;
    }

    @Override
    public boolean hasModes(EntityPlayer player, ItemStack chisel) {
        return true;
    }
}
