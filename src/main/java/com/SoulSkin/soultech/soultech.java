package com.SoulSkin.soultech;

import com.SoulSkin.soultech.block.soulChest;
import com.SoulSkin.soultech.command.commandRename;
import com.SoulSkin.soultech.handler.*;
import com.SoulSkin.soultech.item.tool.areaDeath;
import com.SoulSkin.soultech.item.tool.areaMagnet;
import com.SoulSkin.soultech.lib.Reference;
import com.SoulSkin.soultech.proxy.CommonProxy;
import com.SoulSkin.soultech.util.ModLogger;
import com.SoulSkin.soultech.util.StringUtils;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

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
	public static Item areaMagnet;
	public static Item soulPouch;
	public static Item soulSteel;

	// Define Blocks //
	public static Block soulChest;

	// Define Tool Material //
	public static Item.ToolMaterial soulSteelTool   = EnumHelper.addToolMaterial( "soulSteel", 2, 1024, 7.0F, 4.0F, 15 );
	public static Item.ToolMaterial soulShimmerTool = EnumHelper.addToolMaterial( "soulSHimmer", 3, 4096, 10.0F, 5.0F, 30 );

	// Define Armor Material //
	public static ItemArmor.ArmorMaterial soulSteelArmor   = EnumHelper.addArmorMaterial( "soulSteel", 200, new int[] {5, 10, 8, 5}, 15 );
	public static ItemArmor.ArmorMaterial soulShimmerArmor = EnumHelper.addArmorMaterial( "soulShimmer", 800, new int[] {5, 10, 8, 5}, 30 );


	@Mod.EventHandler
	public void preInit( FMLPreInitializationEvent event ) {
		ModLogger.info( "Loading " + Reference.MOD_NAME );
		String tmp_string = "";
		if ( !StringUtils.isNullOrEmpty( Reference.MOTD ) && Reference.MOTD != "@DATA@" ) {
			tmp_string = " would like to say: " + Reference.MOTD;
		}
		else {
			tmp_string = " would like to say nothing.";
		}
		ModLogger.info( Reference.MOD_NAME + tmp_string );
		proxy.registerRenderers();

		ConfigHandler.init( event.getSuggestedConfigurationFile() );

		areaDeath = new areaDeath();
		areaMagnet = new areaMagnet();
		soulChest = new soulChest();

		ModLogger.info( versionHandler.getLatestVersionTEST() );
	}

	public void recurse( int n ) {
		ModLogger.info( n );
		if ( n > 0 ) recurse( n - 1 );
	}

	@Mod.EventHandler
	public void init( FMLInitializationEvent event ) {
		GameRegisteryHandler.registerAll();
		OreDictionaryHandler.registerAll();
		RecipeHandler.craftingAll();

	}

	@Mod.EventHandler
	public void postInit( FMLPostInitializationEvent event ) {
	}

	@Mod.EventHandler
	public void serverLoad( FMLServerStartingEvent event ) {
		event.registerServerCommand( new commandRename() );
		event.registerServerCommand( new commandRename() );

	}


	@Mod.EventHandler
	public void imfReceiver( FMLInterModComms.IMCEvent event ) {
		for ( final FMLInterModComms.IMCMessage imcMessage : event.getMessages() ) {
			if ( imcMessage.key.equalsIgnoreCase( "areaDeathBlacklist_add" ) ) {
//				areaDeathRegistery.addEntityToBlacklist( imcMessage.getStringValue() );
			}
		}
	}
}
