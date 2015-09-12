package com.SoulSkin.soultech.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by John on 9/6/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class troll extends baseModItem {

    private static String str = "TROLL";
    private static int count = 0;

    public troll() {
        this.setUnlocalizedName("troll");
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
        return false;
    }

    public int getEntityLifespan(ItemStack itemStack, World world) {
        return Integer.MAX_VALUE;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        count++;
        if (count > 5) {
            count -= 5;
            str += "!";
        }

        list.add(str);
/*
        Collection strArray = null;
        int splitNum = str.length() / 20;

        String tmpString = "";
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != 0) {
                tmpString += str.charAt(i);
            }
            if (i != 0 && i % 20 == 0) {
                strArray.add(tmpString);
            }
        }
        if (strArray != null) ModLogger.info(strArray);*/
    }

    public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
        return (stack.getItem() == this) && (armorType == 0);
    }
}
