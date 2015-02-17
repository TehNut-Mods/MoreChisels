package tehnut.morechisels.items.chisel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.oredict.OreDictionary;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.ModInformation;
import tehnut.morechisels.items.ItemChiselBase;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.util.TextHelper;
import tehnut.morechisels.util.Utils;

public class ItemChiselGem extends ItemChiselBase {

    private boolean setDisplayName;
    private String name;

    private IIcon overlayIcon;

    public ItemChiselGem(String name, int durability, boolean setDisplayName) {
        super(name, durability);

        this.setDisplayName = setDisplayName;
        this.name = name;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_base");
        this.overlayIcon = iconRegister.registerIcon(ModInformation.TEXLOC + "chisel_overlay");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        String capName = Character.toUpperCase(name.charAt(0)) + name.substring(1);

        return Utils.splitAtCapital(String.format(TextHelper.localize("item.morechisels.chisel.gem.name"), capName));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getColorFromItemStack(ItemStack stack, int pass) {

        if (pass == 1) {
            return Utils.getColorFromWhitelist(ConfigHandler.gemChiselWhitelist[ItemRegistry.gemChiselCount - 1]);
        } else {
            return super.getColorFromItemStack(stack, pass);
        }
    }

    @Override
    public int getRenderPasses(int metadata) {
        return requiresMultipleRenderPasses() ? 2 : 1;
    }

    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return setDisplayName;
    }

    @Override
    public IIcon getIcon(ItemStack stack, int pass) {
        if (pass == 0) {
            return this.itemIcon;
        } else if (pass == 1) {
            return this.overlayIcon;
        }
        return getIconFromDamageForRenderPass(stack.getItemDamage(), pass);
    }
}
