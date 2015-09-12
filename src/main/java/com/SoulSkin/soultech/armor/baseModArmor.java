package com.SoulSkin.soultech.armor;

import com.SoulSkin.soultech.lib.ModTextures;
import com.SoulSkin.soultech.lib.Reference;
import com.SoulSkin.soultech.util.PlayerUtils;
import com.SoulSkin.soultech.util.StringUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;

import java.util.List;

public class baseModArmor extends ItemArmor {

    public baseModArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(par2EnumArmorMaterial, par3, par4);
        this.setCreativeTab(Reference.STTAB);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1registerIcon) {
        this.itemIcon = par1registerIcon.registerIcon(ModTextures.GetTextureNameFull(this, Reference.ARMOR_FOLDER));
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        int layer = (slot == 2 ? 2 : 1);
        String returnString = "";

        if (getUnlocalizedName(stack).contains("soulSteel")) {
            returnString = ModTextures.GetTextureFolder(Reference.ARMOR_OVERLAY_FOLDER) + "soulSteel_layer_" + layer + Reference.IMG_EXTENSION;
        }
        else if (getUnlocalizedName(stack).contains("soulShimmer")) {
            returnString = ModTextures.GetTextureFolder(Reference.ARMOR_OVERLAY_FOLDER) + "soulShimmer_layer_" + layer + Reference.IMG_EXTENSION;
        }
        else {
            returnString = ModTextures.GetTextureFolder(Reference.ARMOR_OVERLAY_FOLDER) + "default_layer_" + layer + Reference.IMG_EXTENSION;
        }

        return returnString;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        if (!StringUtils.getTooltipLocalized(this, 1).equals(StringUtils.getTooltipUnlocalized(this, 1))) {
            list.add(StringUtils.getTooltipLocalizedChecked(this, 1));
        }
        if (!StringUtils.getTooltipLocalized(this, 2).equals(StringUtils.getTooltipUnlocalized(this, 2))) {
            list.add(StringUtils.getTooltipLocalizedChecked(this, 2));
        }
        if (!StringUtils.getTooltipLocalized(this, 3).equals(StringUtils.getTooltipUnlocalized(this, 3))) {
            list.add(StringUtils.getTooltipLocalizedChecked(this, 3));
        }
    }

    /**
     * Returns true if all ItemStacks in @armorStack are being worn by @player.
     * Matches are exact; if the stacks have different damage, NBT, etc. they will not match.
     */
    public static boolean areAllWorn(EntityPlayer player, ItemStack[] armorStack) {
        ItemStack[] armorInv = player.inventory.armorInventory;
        int total = 0;
        for (int i = 1; i < armorStack.length; i++) {
            if (PlayerUtils.isPlayerWearingStack(player, armorStack[i])) {
                total++;
            }
        }
        return false;
    }

    /**
     * Returns true if all ItemStacks in @armorStack are being worn by @player.
     * Ignores armor's damage, NBT, etc.
     */
    public static boolean areAllWorn(EntityPlayer player, Item[] armorItems) {
        int total = 0;
        for (int i = 0; i < armorItems.length; i++) {
            if (PlayerUtils.isPlayerWearingItem(player, armorItems[i])) {
                total++;
            }
        }
        if (total == armorItems.length) {
            return true;
        }
        return false;
    }
}
