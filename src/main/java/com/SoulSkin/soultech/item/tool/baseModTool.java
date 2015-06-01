package com.SoulSkin.soultech.item.tool;

import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import static com.SoulSkin.soultech.lib.ModTextures.GetTextureNameFull;
import static com.SoulSkin.soultech.lib.Reference.STTAB;
import static com.SoulSkin.soultech.lib.Reference.TOOL_FOLDER;
import static cpw.mods.fml.relauncher.Side.CLIENT;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class baseModTool extends Item {

	public baseModTool() {
		super();
		this.setMaxStackSize( 1 );
		this.setCreativeTab( STTAB );
	}

	@SideOnly( CLIENT )
	public void registerIcons( IIconRegister par1registerIcon ) {
		this.itemIcon = par1registerIcon.registerIcon( GetTextureNameFull( this, TOOL_FOLDER ) );
	}
}
