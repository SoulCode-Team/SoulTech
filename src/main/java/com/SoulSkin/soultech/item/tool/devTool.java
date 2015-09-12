package com.SoulSkin.soultech.item.tool;

import com.SoulSkin.soultech.util.StringUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */

public class devTool extends baseModTool {

    devTool() {
        this.setUnlocalizedName(StringUtils.prefixModID("devTool"));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            if (player.isSneaking()) {
            }
        }
        return itemStackIn;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(StringUtils.getFormattedTooltipLocalized(this, 1, player.getCommandSenderName()));//TODO check to make sure this doesn't give tons of empty lines.
        list.add(StringUtils.getTooltipLocalizedChecked(this, 2));
        list.add(StringUtils.getTooltipLocalizedChecked(this, 3));
    }
}
