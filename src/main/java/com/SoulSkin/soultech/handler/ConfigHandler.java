package com.SoulSkin.soultech.handler;

import com.SoulSkin.soultech.lib.Reference;
import com.SoulSkin.soultech.util.ModLogger;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class ConfigHandler {

	public static Configuration config;

	public static void init( File configFile ) {
		if ( config == null ) {
			config = new Configuration( configFile );
		}

		loadConfigs();

	}

	@SubscribeEvent
	public void onConfigurationChangedEvent( ConfigChangedEvent.OnConfigChangedEvent event ) {
		if ( event.modID.equalsIgnoreCase( Reference.MOD_ID ) ) {
			loadConfigs();
		}
	}

	public static final boolean True  = true;
	public static final boolean False = false;

	public static int     rangeAreaDeath;
	public static boolean disableSoulChest;
	public static boolean enableAreaDeath;
	public static boolean areaDeathBlackOrWhitelist;

	public static void loadConfigs() {
		ModLogger.info( "Loading Configs" );
		// Configs for Blocks//
		disableSoulChest = config.get( Reference.DISABLE_FUNCTIONS_CATEGORY, "Disable Soul Chests", false ).getBoolean();

		// Configs for Tools//
		enableAreaDeath = config.get( Reference.TOOLS_CATEGORY, "Enable Area Killer", true, "Area Killer Kills all hostile mobs in a radius (see below)" ).getBoolean();
		rangeAreaDeath = config.get( Reference.TOOLS_CATEGORY, "Area Killer Range", 10, "the distance from the player in which the Area Killer can cause damage." ).getInt();
		areaDeathBlackOrWhitelist = config.get( Reference.TOOLS_CATEGORY, "Is_Area_Killer_Blacklist", true, "determines if the Area Killer uses a blacklist(true or a whitelist(false)" ).getBoolean();

		if ( config.hasChanged() ) {
			config.save();
		}
	}
}