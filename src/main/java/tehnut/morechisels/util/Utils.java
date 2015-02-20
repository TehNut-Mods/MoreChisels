package tehnut.morechisels.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class Utils {

    public static final ResourceLocation textureBlock = TextureMap.locationBlocksTexture;
    public static final ResourceLocation textureItem = TextureMap.locationItemsTexture;

    /**
     * @param stack  - The ItemStack.
     * @param energy - Energy to set stack to.
     * @return - The ItemStack with an energy tag.
     */
    public static ItemStack setNewEnergyTag(ItemStack stack, int energy) {
        if (stack.stackTagCompound == null)
            stack.setTagCompound(new NBTTagCompound());

        if (stack.stackTagCompound != null && stack.stackTagCompound.getInteger("Energy") <= 0)
            stack.stackTagCompound.setInteger("Energy", energy);

        return stack;
    }

    /**
     * Inserts spaces into a string if a capital is found after a lowercase.
     *
     * @param input - String to split.
     *
     * @return - split string IE: camelCase to camel Case
     */

    public static String splitAtCapital(String input) {
        return input.replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2");
    }

    /**
     *
     * @param stack - Binds the ItemStack's texture
     */
    public static void bindItemTexture(ItemStack stack) {
        Minecraft.getMinecraft().renderEngine.bindTexture(stack.getItemSpriteNumber() == 0 ? textureBlock : textureItem);
    }

    /**
     *
     * @param stack - ItemStack to render on player
     * @param coolPeople - The cooliest of the cool (List of names to render on)
     * @param player - EntityPlayer
     */
    public static void renderItemOnPlayersBack(ItemStack stack, String[] coolPeople, EntityPlayer player) {

        bindItemTexture(stack);
        IIcon stackIcon = stack.getIconIndex();

        for (String names : coolPeople) {
            if (player.getUniqueID().toString().equals(names)) {
                GL11.glPushMatrix();

                GL11.glTranslated(0.6, 0.8, 0.125);
                GL11.glRotated(180, 0, 0, 0);

                if (player.isSneaking()) {
                    GL11.glTranslated(0.0, 0.1, -0.4);
                    GL11.glRotatef(28.64789F, 1.0F, 0.0F, 0.0F);
                }

                float f9 = 0.0625F;
                float minU = stackIcon.getMinU();
                float maxU = stackIcon.getMaxU();
                float minV = stackIcon.getMinV();
                float maxV = stackIcon.getMaxV();
                ItemRenderer.renderItemIn2D(Tessellator.instance, maxU, minV, minU, maxV, stackIcon.getIconWidth(), stackIcon.getIconHeight(), f9);

                GL11.glPopMatrix();
            }
        }
    }
}
