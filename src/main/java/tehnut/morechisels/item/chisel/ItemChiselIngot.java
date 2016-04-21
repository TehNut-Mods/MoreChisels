package tehnut.morechisels.item.chisel;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import tehnut.morechisels.ModInformation;
import tehnut.morechisels.item.ItemChiselBase;
import tehnut.morechisels.registry.RecipeRegistry;
import tehnut.morechisels.util.Utils;

import java.awt.*;

public class ItemChiselIngot extends ItemChiselBase {

    private boolean setDisplayName;
    private String name;
    private String hexColor;

    private IIcon overlayIcon;

    public ItemChiselIngot(String name, int durability, String hexColor, boolean setDisplayName) {
        super(name, durability);

        this.setDisplayName = setDisplayName;
        this.name = name;
        this.hexColor = hexColor;
        this.hasModes = true;

        GameRegistry.registerItem(this, "ItemChiselIngot" + name);
        RecipeRegistry.addConfiguredChiselRecipe(this, "ingot" + name, true);
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
        String materialUnloc = "material." + ModInformation.ID + "." + name.toLowerCase() + ".name";

        if (StatCollector.canTranslate(materialUnloc))
            return StatCollector.translateToLocalFormatted("item.morechisels.chisel.ingot.name", StatCollector.translateToLocal(materialUnloc));
        else
            return Utils.splitAtCapital(StatCollector.translateToLocalFormatted("item.morechisels.chisel.ingot.name", capName));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getColorFromItemStack(ItemStack stack, int pass) {
        return pass == 1 ? Color.decode(hexColor).getRGB() : super.getColorFromItemStack(stack, pass);
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
        return pass == 0 ? this.itemIcon : this.overlayIcon;
    }
}
