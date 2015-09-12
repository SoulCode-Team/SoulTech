package com.SoulSkin.soultech.item;

import com.SoulSkin.soultech.util.StringUtils;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

import static com.SoulSkin.soultech.lib.ModTextures.GetTextureNameFull;
import static com.SoulSkin.soultech.lib.Reference.STTAB;
import static cpw.mods.fml.relauncher.Side.CLIENT;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class baseModItem extends Item {

    public baseModItem() {
        super();
        this.setMaxStackSize(64);
        this.setCreativeTab(STTAB);
    }

    @SideOnly(CLIENT)
    public void registerIcons(IIconRegister par1registerIcon) {
        this.itemIcon = par1registerIcon.registerIcon(GetTextureNameFull(this));
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
