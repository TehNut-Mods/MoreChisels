package tehnut.morechisels.item.chisel;

import WayofTime.alchemicalWizardry.api.items.interfaces.IBindable;
import WayofTime.alchemicalWizardry.api.soulNetwork.SoulNetworkHandler;
import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import tehnut.morechisels.ModInformation;
import tehnut.morechisels.item.ChiselType;
import tehnut.morechisels.item.ItemChiselBase;

import java.util.List;

public class ItemChiselBound extends ItemChiselBase implements IBindable {

    private static IIcon active;
    private static IIcon passive;

    public ItemChiselBound() {
        super(ChiselType.BOUND);

        this.hasModes = true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        SoulNetworkHandler.checkAndSetItemOwner(stack, player);

        if (player.isSneaking()) {
            setActivated(stack, !getActivated(stack));
            stack.stackTagCompound.setInteger("worldTimeDelay", (int) (world.getWorldTime() - 1) % 100);
            return stack;
        }

        if (!getActivated(stack))
            return stack;

        return stack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_bound");
        active = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_bound");
        passive = iconRegister.registerIcon("AlchemicalWizardry:SheathedItem");
    }

    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        if (stack.stackTagCompound == null) {
            stack.setTagCompound(new NBTTagCompound());
        }

        NBTTagCompound tag = stack.stackTagCompound;

        if (tag.getBoolean("isActive"))
            return active;
        else
            return passive;

    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
        if (!(entity instanceof EntityPlayer))
            return;

        EntityPlayer player = (EntityPlayer) entity;

        if (stack.stackTagCompound == null)
            stack.setTagCompound(new NBTTagCompound());

        if (world.getWorldTime() % 200 == stack.stackTagCompound.getInteger("worldTimeDelay") && stack.stackTagCompound.getBoolean("isActive")) {
            if (!player.capabilities.isCreativeMode)
                SoulNetworkHandler.syphonAndDamageFromNetwork(stack, player, 20);
        }

        stack.setItemDamage(0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(StatCollector.translateToLocal("tip.morechisels.pretty"));
        if (stack.stackTagCompound != null) {
            if (stack.stackTagCompound.getBoolean("isActive"))
                list.add(StatCollector.translateToLocal("tip.morechisels.activated"));
            else
                list.add(StatCollector.translateToLocal("tip.morechisels.deactivated"));

            if (!stack.stackTagCompound.getString("ownerName").equals(""))
                list.add(StatCollector.translateToLocalFormatted("tip.morechisels.bound.owner", stack.stackTagCompound.getString("ownerName")));
        }
    }

    // Bound stuff
    public void setActivated(ItemStack stack, boolean newActivated) {
        NBTTagCompound itemTag = stack.stackTagCompound;

        if (itemTag == null)
            stack.setTagCompound(new NBTTagCompound());

        itemTag.setBoolean("isActive", newActivated);
    }

    public boolean getActivated(ItemStack stack) {
        NBTTagCompound itemTag = stack.stackTagCompound;

        if (itemTag == null)
            stack.setTagCompound(new NBTTagCompound());


        return itemTag.getBoolean("isActive");
    }

    // Chisel API
    @Override
    public boolean onChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return false;
    }

    @Override
    public boolean canChisel(World world, ItemStack chisel, ICarvingVariation target) {

        NBTTagCompound itemTag = chisel.stackTagCompound;

        if (itemTag == null)
            chisel.setTagCompound(new NBTTagCompound());

        return itemTag.getBoolean("isActive");
    }

    @Override
    public boolean canChiselBlock(World world, EntityPlayer player, int x, int y, int z, Block block, int metadata) {
        ItemStack stack = player.getHeldItem();

        NBTTagCompound tag = stack.stackTagCompound;

        if (tag == null)
            stack.setTagCompound(new NBTTagCompound());

        return tag.getBoolean("isActive");
    }

    @Override
    public boolean canOpenGui(World world, EntityPlayer player, ItemStack chisel) {
        NBTTagCompound tag = chisel.stackTagCompound;

        if (tag == null)
            chisel.setTagCompound(new NBTTagCompound());

        return tag.getBoolean("isActive") && !player.isSneaking();
    }
}
