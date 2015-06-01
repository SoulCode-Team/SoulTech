package com.SoulSkin.soultech.item;

import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

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
		this.setMaxStackSize( 64 );
		this.setCreativeTab( STTAB );
	}

	@SideOnly( CLIENT )
	public void registerIcons( IIconRegister par1registerIcon ) {
		this.itemIcon = par1registerIcon.registerIcon( GetTextureNameFull( this ) );
	}
}
