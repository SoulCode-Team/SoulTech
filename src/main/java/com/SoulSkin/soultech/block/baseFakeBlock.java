package com.SoulSkin.soultech.block;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class baseFakeBlock extends baseModBlock {

    private static boolean remove = false;

    public baseFakeBlock(Material material) {
        this(material, false);
    }

    public baseFakeBlock(Material material, boolean remv) {
        super(material);
        remove = remv;
    }

    public int quantityDropped(Random par1Random) {
        return 0;
    }

    // Removal Section //


    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (remove) {
            par1World.setBlockToAir(par2, par3, par4);
        }
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
        if (remove) {
            par1World.setBlockToAir(par2, par3, par4);
        }
    }
}
