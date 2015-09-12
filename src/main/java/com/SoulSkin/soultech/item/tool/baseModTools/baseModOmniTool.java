package com.SoulSkin.soultech.item.tool.baseModTools;

import com.SoulSkin.soultech.lib.ModTextures;
import com.SoulSkin.soultech.lib.Reference;
import com.SoulSkin.soultech.util.StringUtils;
import com.google.common.collect.Sets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

/**
 * Created by John on 6/16/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class baseModOmniTool extends ItemTool {

    public static Item materialItem;

    public baseModOmniTool(ToolMaterial mat, Item matItem, String itemName) {
        super(mat.getDamageVsEntity(), mat, Sets.newHashSet(new Block[]{}));
        this.setCreativeTab(Reference.STTAB);
        this.setUnlocalizedName(itemName + "_OmniTool");
        materialItem = matItem;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1registerIcon) {
        this.itemIcon = par1registerIcon.registerIcon(ModTextures.GetTextureNameFull(this, Reference.TOOL_FOLDER));
    }

    @Override
    public float getStrVsBlock(ItemStack p_150893_1_, Block p_150893_2_) {
        return this.efficiencyOnProperMaterial;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_) {
        stack.damageItem(1, p_77644_3_);
        return true;
    }

    @Override
    public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_) {
        ItemStack mat = new ItemStack(this.materialItem);
        return mat != null && OreDictionary.itemMatches(mat, p_82789_2_, false) ? true : super.getIsRepairable(p_82789_1_, p_82789_2_);
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
}
