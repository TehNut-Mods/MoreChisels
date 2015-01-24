package tehnut.morechisels.items;

import com.cricketcraft.chisel.api.IChiselItem;
import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import com.cricketcraft.chisel.config.Configurations;
import com.cricketcraft.chisel.init.ChiselTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.MoreChisels;
import tehnut.morechisels.ModInformation;
import net.minecraft.item.Item;

import java.util.List;

public class ItemChiselBase extends Item implements IChiselItem {

	private ChiselType type;

	public ItemChiselBase(ChiselType type) {
		super();

		this.type = type;

		setUnlocalizedName(ModInformation.ID + ".chisel." + type.toString());
		setTextureName(ModInformation.TEXLOC + "chisel_" + type.toString());
		setCreativeTab(ChiselTabs.tabChisel);
		setMaxStackSize(1);
		if (Configurations.allowChiselDamage)
			setMaxDamage(type.durability);
	}

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
		return false;
	}
}
