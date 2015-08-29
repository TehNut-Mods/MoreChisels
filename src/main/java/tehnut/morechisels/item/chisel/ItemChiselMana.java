package tehnut.morechisels.item.chisel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import team.chisel.api.carving.ICarvingVariation;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.common.item.equipment.tool.ToolCommons;

public class ItemChiselMana extends ItemChiselBase implements IManaUsingItem {

    private static final int MANA_PER_USE = 60;

    public ItemChiselMana(ChiselType type) {
        super(type);

        this.hasModes = true;
    }

    @Override
    public boolean onChisel(World world, EntityPlayer player, ItemStack chisel, ICarvingVariation target) {
        ToolCommons.damageItem(chisel, 1, player, MANA_PER_USE);
        return false;
    }

    // IManaUsingItem

    @Override
    public boolean usesMana(ItemStack stack) {
        return true;
    }
}
