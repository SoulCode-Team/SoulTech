package com.SoulSkin.soultech.handler;

import com.SoulSkin.soultech.soultech;
import net.minecraft.item.ItemStack;

import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.dye;
import static net.minecraft.init.Items.nether_star;
import static net.minecraftforge.oredict.OreDictionary.registerOre;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class OreDictionaryHandler {

	public static soultech MOD;

	public static void registerBlocks() {
		// Vanilla //
		registerOre( "blockSponge", new ItemStack( sponge ) );
		registerOre( "blockGlowstone", new ItemStack( glowstone ) );
		registerOre( "blockObsidian", new ItemStack( obsidian ) );
		registerOre( "dirt", new ItemStack( dirt ) );
		registerOre( "blockClay", new ItemStack( clay ) );
		registerOre( "blockSnow", new ItemStack( snow ) );
		registerOre( "blockBrick", new ItemStack( brick_block ) );
	}

	public static void registerQuartz() {
		registerOre( "blockQuartz", new ItemStack( quartz_block, 1, 1 ) );
		registerOre( "blockQuartz", new ItemStack( quartz_block, 1, 2 ) );
	}

	public static void registerStairs() {
		registerOre( "stairQuartz", new ItemStack( quartz_stairs ) );
		registerOre( "stairNetherBrick", new ItemStack( nether_brick_stairs ) );
		registerOre( "stairBrick", new ItemStack( brick_stairs ) );
		registerOre( "stairStoneBrick", new ItemStack( stone_brick_stairs ) );
		registerOre( "stairSandstone", new ItemStack( sandstone_stairs ) );
		registerOre( "stairStone", new ItemStack( stone_stairs ) );
	}

	public static void registerItems() {
		// Vanilla //
		registerOre( "itemNetherStar", new ItemStack( nether_star ) );
	}


	public static void registerDyes() {
		String[] dyeColorNames = {"Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "LightGray", "Gray", "Pink", "Lime", "Yellow", "LightBlue", "Magenta", "Orange", "White"};
		for ( int i = 0; i < dyeColorNames.length; i++ ) {
			registerOre( "dye" + dyeColorNames[i], new ItemStack( dye, 1, i ) );
		}
	}

	public static void registerAll() {
		registerBlocks();
		registerItems();
		registerStairs();
		registerQuartz();
		// ***Already done in forge*** //
		// registerDyes();
	}
}
