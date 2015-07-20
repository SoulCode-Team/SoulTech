package com.SoulSkin.soultech;

import com.SoulSkin.soultech.armor.soulShimmer.*;
import com.SoulSkin.soultech.armor.soulSteel.*;
import com.SoulSkin.soultech.armor.suitOfArmorBase;
import com.SoulSkin.soultech.block.soulChest;
import com.SoulSkin.soultech.command.commandRename;
import com.SoulSkin.soultech.handler.*;
import com.SoulSkin.soultech.item.soulShimmer;
import com.SoulSkin.soultech.item.soulSteel;
import com.SoulSkin.soultech.item.tool.*;
import com.SoulSkin.soultech.item.tool.soulShimmer.*;
import com.SoulSkin.soultech.item.tool.soulSteel.*;
import com.SoulSkin.soultech.lib.Reference;
import com.SoulSkin.soultech.proxy.CommonProxy;
import com.SoulSkin.soultech.util.ModLogger;
import com.SoulSkin.soultech.util.StringUtils;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashMap;
import java.util.Map;

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
	public static Item gazeCatcher;
	public static Item soulPouch;
	public static Item weathermansCompass;

	public static Item soulSteelSword;
	public static Item soulSteelPick;
	public static Item soulSteelAxe;
	public static Item soulSteelShovel;
	public static Item soulSteelHoe;
	public static Item soulSteelOmniTool;

	public static Item soulShimmerSword;
	public static Item soulShimmerPick;
	public static Item soulShimmerAxe;
	public static Item soulShimmerShovel;
	public static Item soulShimmerHoe;
	public static Item soulShimmerOmniTool;

	// Define Items //
	public static Item soulSteel;
	public static Item soulShimmer;

	// Define Armor //
	public static Item soulSteelHelmet;
	public static Item soulSteelChestplate;
	public static Item soulSteelLeggings;
	public static Item soulSteelBoots;

	public static Item soulShimmerHelmet;
	public static Item soulShimmerChestplate;
	public static Item soulShimmerLeggings;
	public static Item soulShimmerBoots;

	// Define Suits of Armor //
	public static Item suitOfArmor_Iron;
	public static Item suitOfArmor_Gold;
	public static Item suitOfArmor_Diamond;
	public static Item suitOfArmor_soulShimmer;
	public static Item suitOfArmor_soulSteel;

	// Define Blocks //
	public static Block soulChest;

	// Define Tool Material //
	public static Item.ToolMaterial soulSteelTool   = EnumHelper.addToolMaterial( "soulSteel", 2, 1024, 7.0F, 4.0F, 15 );
	public static Item.ToolMaterial soulShimmerTool = EnumHelper.addToolMaterial( "soulShimmer", 3, 4096, 10.0F, 5.0F, 30 );

	// Define Armor Material //
	public static ItemArmor.ArmorMaterial soulSteelArmor   = EnumHelper.addArmorMaterial( "soulSteel", 200, new int[] {5, 10, 8, 5}, 15 );
	//	soulSteelArmor.customCraftingMaterial=soulSteel; TODO make this work.
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

		// Inti Blocks //
		soulChest = new soulChest();

		// Init Tools //
		areaDeath = new areaDeath();
		areaMagnet = new areaMagnet();
		gazeCatcher = new gazeCatcher();
		weathermansCompass = new weathermansCompass();


		soulSteelSword = new soulSteelSword();
		soulSteelPick = new soulSteelPick();
		soulSteelAxe = new soulSteelAxe();
		soulSteelShovel = new soulSteelShovel();
		soulSteelHoe = new soulSteelHoe();
		soulSteelOmniTool = new soulSteelOmniTool();

		soulShimmerSword = new soulShimmerSword();
		soulShimmerPick = new soulShimmerPick();
		soulShimmerAxe = new soulShimmerAxe();
		soulShimmerShovel = new soulShimmerShovel();
		soulShimmerHoe = new soulShimmerHoe();
		soulShimmerOmniTool = new soulShimmerOmniTool();

		// Init Items //

		soulShimmer = new soulShimmer();
		soulSteel = new soulSteel();

		// Init Armor //

		soulShimmerHelmet = new soulShimmerHelmet();
		soulShimmerChestplate = new soulShimmerChestplate();
		soulShimmerLeggings = new soulShimmerLeggings();
		soulShimmerBoots = new soulShimmerBoots();

		soulSteelHelmet = new soulSteelHelmet();
		soulSteelChestplate = new soulSteelChestplate();
		soulSteelLeggings = new soulSteelLeggings();
		soulSteelBoots = new soulSteelBoots();

		// Inti Suits Of Armor//
		suitOfArmor_soulShimmer = new suitOfArmorBase( new ItemStack[] {new ItemStack( this.soulShimmerBoots ), new ItemStack( this.soulShimmerLeggings ), new ItemStack( this.soulShimmerChestplate ), new ItemStack( this.soulShimmerHelmet ), new ItemStack( this.soulShimmerSword )} ).setUnlocalizedName( "suitOfArmor_soulShimmer" );
		suitOfArmor_soulSteel = new suitOfArmorBase( new ItemStack[] {new ItemStack( this.soulSteelBoots ), new ItemStack( this.soulSteelLeggings ), new ItemStack( this.soulSteelChestplate ), new ItemStack( this.soulSteelHelmet ), new ItemStack( this.soulSteelSword )} ).setUnlocalizedName( "suitOfArmor_soulSteel" );
		suitOfArmor_Diamond = new suitOfArmorBase( new ItemStack[] {new ItemStack( Items.diamond_boots ), new ItemStack( Items.diamond_leggings ), new ItemStack( Items.diamond_chestplate ), new ItemStack( Items.diamond_helmet ), new ItemStack( Items.diamond_sword )} ).setUnlocalizedName( "suitOfArmor_Diamond" );
		suitOfArmor_Iron = new suitOfArmorBase( new ItemStack[] {new ItemStack( Items.iron_boots ), new ItemStack( Items.iron_leggings ), new ItemStack( Items.iron_chestplate ), new ItemStack( Items.iron_helmet ), new ItemStack( Items.iron_sword )} ).setUnlocalizedName( "suitOfArmor_Iron" );
		suitOfArmor_Gold = new suitOfArmorBase( new ItemStack[] {new ItemStack( Items.golden_boots ), new ItemStack( Items.golden_leggings ), new ItemStack( Items.golden_chestplate ), new ItemStack( Items.golden_helmet ), new ItemStack( Items.golden_sword )} ).setUnlocalizedName( "suitOfArmor_Gold" );

		ModLogger.info( versionHandler.getLatestVersionTEST() );
		StringUtils.getFormattedTooltipLocalized( areaDeath, 1, ConfigHandler.rangeAreaDeath );
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

	@Mod.EventHandler
	public void depricationHandler( FMLMissingMappingsEvent event ) {
		final Map< Item, Item >   itemsToChange  = new HashMap< Item, Item >();
		final Map< Block, Block > blocksToChange = new HashMap< Block, Block >();

//		itemsToChange.put( , );

		for ( int i = 0; i < event.getAll().size(); i++ ) {
			if ( itemsToChange.containsKey( event.get().get( i ) ) ) {
				event.get().get( i ).warn();
				event.get().get( i ).remap( itemsToChange.get( event.get().get( i ) ) );
			}
			if ( blocksToChange.containsKey( event.get().get( i ) ) ) {
				event.get().get( i ).warn();
				event.get().get( i ).remap( blocksToChange.get( event.get().get( i ) ) );
			}
		}
	}
}
