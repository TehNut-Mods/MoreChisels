package tehnut.morechisels.items.chisel;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import tehnut.morechisels.items.ChiselType;
import tehnut.morechisels.items.ItemChiselBase;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IWarpingGear;

public class ItemChiselVoidmetal extends ItemChiselBase implements IWarpingGear, IRepairable {

    public ItemChiselVoidmetal() {
        super(ChiselType.VOIDMETAL);
    }

    public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        super.onUpdate(stack, world, entity, p_77663_4_, p_77663_5_);

        if(stack.isItemDamaged() && entity != null && entity.ticksExisted % 20 == 0 && entity instanceof EntityLivingBase) {
            stack.damageItem(-1, (EntityLivingBase)entity);
        }
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if(!player.worldObj.isRemote && entity instanceof EntityLivingBase && (!(entity instanceof EntityPlayer) || MinecraftServer.getServer().isPVPEnabled())) {
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.weakness.getId(), 80));
        }

        return super.onLeftClickEntity(stack, player, entity);
    }

    public int getWarp(ItemStack itemstack, EntityPlayer player) {
        return 1;
    }
}
