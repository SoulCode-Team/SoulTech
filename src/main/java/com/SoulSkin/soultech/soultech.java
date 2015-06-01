package com.SoulSkin.soultech;

import com.SoulSkin.soultech.block.soulChest;
import com.SoulSkin.soultech.command.commandKill;
import com.SoulSkin.soultech.handler.*;
import com.SoulSkin.soultech.item.tool.areaDeath;
import com.SoulSkin.soultech.lib.Reference;
import com.SoulSkin.soultech.proxy.CommonProxy;
import com.SoulSkin.soultech.util.ModLogger;
import com.SoulSkin.soultech.util.StringUtils;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
@Mod( name = Reference.MOD_NAME, version = Reference.VERSION, useMetadata = false, modid = Reference.MOD_ID )
public class soultech {

	@Mod.Instance( Reference.MOD_ID )
	public static soultech instance;

	@SidedProxy( clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_COMMON )
	public static CommonProxy proxy;

	public static CreativeTabs tabST = new CreativeTabs( Reference.MOD_ID ) {
		public ItemStack getIconItemStack() {
			return new ItemStack( soultech.soulChest );
		}

		@Override
		public Item getTabIconItem() {
			return null;
		}
	};

	// Define Tools//
	public static Item areaDeath;
	public static Item soulPouch;

	// Define Blocks //
	public static Block soulChest;

	@Mod.EventHandler
	public void preInit( FMLPreInitializationEvent event ) {
		ModLogger.info( "Loading " + Reference.MOD_NAME );
		String tmp_string = "";
		if ( Reference.MOTD != "@DATA@" && !StringUtils.isNullOrEmpty( Reference.MOTD ) ) {
			tmp_string = " would like to say: " + Reference.MOTD;
		}
		else {
			tmp_string = " would like to say nothing.";
		}
		ModLogger.info( Reference.MOD_NAME + tmp_string );
		proxy.registerRenderers();

		ConfigHandler.init( event.getSuggestedConfigurationFile() );

		areaDeath = new areaDeath();
		soulChest = new soulChest();
	}

	public void recurse( int n ) {
		ModLogger.info( n );
		if ( n > 0 ) recurse( n - 1 );
	}

	@Mod.EventHandler
	public void init( FMLInitializationEvent event ) {
		GameRegisteryHandler.registerAll();
		RecipeHandler.craftingAll();
		OreDictionaryHandler.registerAll();
	}

	@Mod.EventHandler
	public void postInit( FMLPostInitializationEvent event ) {
	}

	@Mod.EventHandler
	public void serverLoad( FMLServerStartingEvent event ) {
		event.registerServerCommand( new commandKill() );
	}


	@Mod.EventHandler
	public void imfReceiver( FMLInterModComms.IMCEvent event ) {
		for ( final FMLInterModComms.IMCMessage imcMessage : event.getMessages() ) {
			if ( imcMessage.key.equalsIgnoreCase( "blacklist-areaDeath" ) ) {

			}
		}
	}
}
