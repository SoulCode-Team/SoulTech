package com.SoulSkin.soultech.block;

import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

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
public class baseModBlock extends Block {

    public baseModBlock(Material material) {
        super(material);
        this.setCreativeTab(STTAB);
    }

    @SideOnly(CLIENT)
    public void registerIcons(IIconRegister par1registerIcon) {
//		System.out.println( "_______________________________BLOCK TEXTURE_____________________________________________" );
//		ModLogger.info( "TEXTURE_LOC: " + ModTextures.GetTextureNameFull( this ) );
        this.blockIcon = par1registerIcon.registerIcon(GetTextureNameFull(this));
    }
}
