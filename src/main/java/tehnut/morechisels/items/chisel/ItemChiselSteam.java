package tehnut.morechisels.items.chisel;

import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import flaxbeard.steamcraft.api.ISteamChargable;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import tehnut.morechisels.util.TextHelper;
import tehnut.morechisels.util.Utils;

import java.util.List;

public class ItemChiselSteam extends ItemChiselBase implements ISteamChargable {

    private static int steamPerUse = ConfigHandler.steamPerUse;
    private static int maxSteam = ConfigHandler.durabilitySteam;

    public ItemChiselSteam() {
        super(ChiselType.STEAM);

        setNoRepair();
        setMaxDamage(0);
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
        list.add(Utils.setNewSteamTag(new ItemStack(item, 1), 0));
        list.add(Utils.setNewSteamTag(new ItemStack(item, 1), maxSteam));
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(TextHelper.WHITE + String.format(TextHelper.localize("tip.morechisels.steam"), Utils.getCurrentSteam(stack), maxSteam, stack));
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return 1.0 - ((double) Utils.getCurrentSteam(stack) / (double) maxSteam);
    }

    @Override
    public int steamPerDurability() {
        return steamPerUse;
    }

    @Override
    public boolean canCharge(ItemStack me) {
        return true;
    }

    @Override
    public boolean onChisel(World world, ItemStack chisel, ICarvingVariation target) {
        int currentSteam = Utils.getCurrentSteam(chisel);

        Utils.reduceSteamLevel(chisel, steamPerUse);

        if (currentSteam < 0)
            Utils.setNewSteamTag(chisel, 0);

        return false;
    }

    @Override
    public boolean canChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return Utils.getCurrentSteam(chisel) > 0;
    }

    @Override
    public boolean canChiselBlock(World world, EntityPlayer player, int x, int y, int z, Block block, int metadata) {
        ItemStack chisel = player.getHeldItem();

        return Utils.getCurrentSteam(chisel) > 0;
    }

    @Override
    public boolean canOpenGui(World world, EntityPlayer player, ItemStack chisel) {
        return Utils.getCurrentSteam(chisel) > 0;
    }
}
