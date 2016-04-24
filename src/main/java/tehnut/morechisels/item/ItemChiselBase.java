package tehnut.morechisels.item;

import com.cricketcraft.chisel.api.ChiselTabs;
import com.cricketcraft.chisel.api.IChiselItem;
import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.morechisels.ModInformation;

public class ItemChiselBase extends Item implements IChiselItem {

    private ChiselType type;
    protected boolean hasModes = false;

    /**
     *
     * @param name - Unlocalized name for chisel.
     * @param durability - Effective durability of chisel.
     */
    public ItemChiselBase(String name, int durability) {
        super();

        setUnlocalizedName(ModInformation.ID + ".chisel." + name.toLowerCase());
        setTextureName(ModInformation.TEXLOC + "chisel_" + name.toLowerCase());
        setCreativeTab(ChiselTabs.tabChisel);
        setMaxStackSize(1);
        setMaxDamage(durability);
    }

    /**
     *
     * @param type - Pre-defined chisel type from {@link tehnut.morechisels.item.ChiselType}
     */
    public ItemChiselBase(ChiselType type) {
        this(type.name(), type.durability);

        this.type = type;
    }

    /**
     * @return - Returns the {@link tehnut.morechisels.item.ChiselType} of the given Chisel.
     */
    public ChiselType getType() {
        return this.type;
    }

    /**
     * @return - Returns weather the chisel should be rendered like a tool in third persson.
     */
	public boolean isFull3D() {
		return true;
	}

    // Start Chisel API

    @Override
    public boolean canOpenGui(World world, EntityPlayer player, ItemStack chisel) {
        return true;
    }

    @Override
    public boolean onChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return true;
    }

    @Override
    public boolean canChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return true;
    }

    @Override
    public boolean canChiselBlock(World world, EntityPlayer player, int x, int y, int z, Block block, int metadata) {
        return true;
    }

    @Override
    public boolean hasModes(ItemStack chisel) {
        return hasModes;
    }
}
