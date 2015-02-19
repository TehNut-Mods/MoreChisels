package tehnut.morechisels.items.chisel;

import WayofTime.alchemicalWizardry.api.items.interfaces.IBindable;
import WayofTime.alchemicalWizardry.api.soulNetwork.SoulNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import tehnut.morechisels.util.TextHelper;

import java.util.List;

public class ItemChiselBloody extends ItemChiselBase implements IBindable {

    public ItemChiselBloody() {
        super(ChiselType.BLOODY);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        SoulNetworkHandler.checkAndSetItemOwner(stack, player);

        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity player, int par4, boolean simulate) {
        if (stack != null) {
            if (stack.getItem() instanceof ItemChiselBloody && player instanceof EntityPlayer && !stack.stackTagCompound.getString("ownerName").equals("")) {
                if (world.getTotalWorldTime() % 20 == 0 && stack.getItemDamage() < stack.getMaxDamage()) {
                    SoulNetworkHandler.syphonAndDamageFromNetwork(stack, (EntityPlayer) player, ConfigHandler.lifeEssencePerRepair);
                    stack.damageItem(-1, (EntityPlayer) player);
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        if (!stack.stackTagCompound.getString("ownerName").equals(""))
            list.add(String.format(TextHelper.localize("tip.morechisels.bound.owner"), stack.stackTagCompound.getString("ownerName")));
    }
}
