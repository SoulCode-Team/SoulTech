package com.SoulSkin.soultech.handler;

import com.SoulSkin.soultech.soultech;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class GameRegisteryHandler {

	public static soultech MOD;

	public static void registerItems() {
		// Register Items//
		if ( !ConfigHandler.disableAreaDeath ) {
			GameRegistry.registerItem( MOD.areaDeath, MOD.areaDeath.getUnlocalizedName() );
		}
		if ( !ConfigHandler.disableAreaDeath ) {
			GameRegistry.registerItem( MOD.areaMagnet, MOD.areaMagnet.getUnlocalizedName() );
		}
	}

	public static void registerBlocks() {
		GameRegistry.registerBlock( MOD.soulChest, MOD.soulChest.getUnlocalizedName() );
	}

	public static void registerTileEntities() {
		//GameRegistry.registerTileEntity( tileCell.class, StringUtils.prefixModID( "Cell" ) );
	}

	public static void registerAll() {
		registerItems();
		registerTileEntities();
		registerBlocks();

	}
}
