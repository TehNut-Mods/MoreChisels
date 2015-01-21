package tehnut.morechisels.items;

import com.cricketcraft.chisel.api.IChiselItem;
import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import com.cricketcraft.chisel.config.Configurations;
import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.morechisels.MoreChisels;
import tehnut.morechisels.ModInformation;
import net.minecraft.item.Item;

public class ItemChiselBase extends Item implements IChiselItem {

	public ItemChiselBase(String unlocName, String textureName) {
		super();

		setUnlocalizedName(ModInformation.ID + ".chisel." + unlocName);
		setTextureName(ModInformation.TEXLOC + textureName);
		setCreativeTab(ChiselTabs.tabChisel);
		setMaxStackSize(0);
	}

	public ItemChiselBase(String unlocName, String textureName, int maxDamage) {
		super();

		setUnlocalizedName(ModInformation.ID + ".chisel." + unlocName);
		setTextureName(ModInformation.TEXLOC + textureName);
		setCreativeTab(ChiselTabs.tabChisel);
		setMaxStackSize(0);
		if (Configurations.allowChiselDamage)
			setMaxDamage(maxDamage);
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
	public boolean canChiselBlock(World world, int x, int y, int z, Block block, int metadata) {
		return true;
	}

	@Override
	public boolean hasModes(ItemStack chisel) {
		return false;
	}
}
