package tehnut.morechisels.item.chisel;

import cofh.api.energy.IEnergyContainerItem;
import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.util.Utils;

import java.util.List;

public class ItemChiselFluxed extends ItemChiselBase implements IEnergyContainerItem {

    private static int capacity = ConfigHandler.durabilityFluxed;

    public ItemChiselFluxed() {
        super(ChiselType.FLUXED);

        setNoRepair();
        setMaxDamage(0);

        this.hasModes = true;
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
        list.add(Utils.setNewEnergyTag(new ItemStack(item, 1), 0));
        list.add(Utils.setNewEnergyTag(new ItemStack(item, 1), capacity));
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        NBTTagCompound tag = stack.stackTagCompound;

        if (tag == null)
            stack.setTagCompound(new NBTTagCompound());

        int currentEnergy = stack.stackTagCompound.getInteger("Energy");

        return 1.0 - ((double) currentEnergy / (double) capacity);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        NBTTagCompound tag = stack.stackTagCompound;

        if (tag == null)
            stack.setTagCompound(new NBTTagCompound());

        list.add(getEnergyColor(StatCollector.translateToLocalFormatted("tip.morechisels.energy", stack.stackTagCompound.getInteger("Energy"), getMaxEnergyStored(stack)), stack));
    }

    private static String getEnergyColor(String string, ItemStack stack) {
        NBTTagCompound tag = stack.stackTagCompound;

        if (tag == null)
            stack.setTagCompound(new NBTTagCompound());

        int currentEnergy = stack.stackTagCompound.getInteger("Energy");

        if (currentEnergy < capacity * .25)
            return EnumChatFormatting.RED + string;
        else if (currentEnergy < capacity * .50)
            return EnumChatFormatting.GOLD + string;
        else if (currentEnergy < capacity * .75)
            return EnumChatFormatting.YELLOW + string;
        else
            return EnumChatFormatting.GREEN + string;
    }

    // Start IEnergyContainerItem
    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {
        if (container.stackTagCompound == null) {
            container.stackTagCompound = new NBTTagCompound();
        }
        int energy = container.stackTagCompound.getInteger("Energy");
        int energyReceived = Math.min(capacity - energy, Math.min(200, maxReceive));

        if (!simulate) {
            energy += energyReceived;
            container.stackTagCompound.setInteger("Energy", energy);
        }

        return energyReceived;
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {
        if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
            return 0;
        }
        int energy = container.stackTagCompound.getInteger("Energy");
        int energyExtracted = Math.min(energy, Math.min(200, maxExtract));

        if (!simulate) {
            energy -= energyExtracted;
            container.stackTagCompound.setInteger("Energy", energy);
        }

        return energyExtracted;
    }

    @Override
    public int getEnergyStored(ItemStack container) {
        NBTTagCompound tag = container.stackTagCompound;

        if (tag == null)
            container.setTagCompound(new NBTTagCompound());

        return tag.getInteger("Energy");
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return capacity;
    }

    // Start IChiselItem
    @Override
    public boolean onChisel(World world, ItemStack chisel, ICarvingVariation target) {

        NBTTagCompound tag = chisel.stackTagCompound;

        if (tag == null)
            chisel.setTagCompound(new NBTTagCompound());

        extractEnergy(chisel, 200, false);
        return false;
    }

    @Override
    public boolean canChisel(World world, ItemStack chisel, ICarvingVariation target) {

        NBTTagCompound tag = chisel.stackTagCompound;

        if (tag == null)
            chisel.setTagCompound(new NBTTagCompound());

        return tag.getInteger("Energy") > 0;
    }

    @Override
    public boolean canChiselBlock(World world, EntityPlayer player, int x, int y, int z, Block block, int metadata) {
        ItemStack stack = player.getHeldItem();

        NBTTagCompound tag = stack.stackTagCompound;

        if (tag == null)
            stack.setTagCompound(new NBTTagCompound());

        return tag.getInteger("Energy") > 0;
    }

    @Override
    public boolean canOpenGui(World world, EntityPlayer player, ItemStack chisel) {
        NBTTagCompound tag = chisel.stackTagCompound;

        if (tag == null)
            chisel.setTagCompound(new NBTTagCompound());

        return tag.getInteger("Energy") > 0;
    }
}
