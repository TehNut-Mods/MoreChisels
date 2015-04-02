package tehnut.morechisels.items;

import com.cricketcraft.chisel.api.IChiselItem;
import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import com.cricketcraft.chisel.config.Configurations;
import com.cricketcraft.chisel.init.ChiselTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tehnut.morechisels.ModInformation;

public class ItemChiselBase extends Item implements IChiselItem {

    private ChiselType type;

    /**
     *
     * @param type - Pre-defined chisel type from {@link tehnut.morechisels.items.ChiselType}
     */
    public ItemChiselBase(ChiselType type) {
        this(type.name(), type.durability);

        this.type = type;
    }

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
        if (Configurations.allowChiselDamage)
            setMaxDamage(durability);
    }

    /**
     * @return - Returns teh {@link tehnut.morechisels.items.ChiselType} of the given Chisel.
     */
    public ChiselType getType() {
        return this.type;
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
        return false;
    }
}
