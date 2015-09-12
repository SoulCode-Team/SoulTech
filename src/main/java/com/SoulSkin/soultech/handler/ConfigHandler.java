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

    public static void init(File configFile) {
        if (config == null) {
            config = new Configuration(configFile);
        }

        loadConfigs();
    }

    public static void resetConfig(File configFile) {
        config = new Configuration(configFile);
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
            loadConfigs();
        }
    }

    public static final boolean True = true;
    public static final boolean False = false;

    public static boolean disableSoulChest;
    public static boolean disableWeathermansCompass;

    public static int rangeAreaDeath;
    public static boolean disableAreaDeath;
    public static boolean areaDeathBlackOrWhitelist;

    public static boolean disableAreaMagnet;
    public static int rangeAreaMagnet;

    public static int rangeGazeCatcher;
    public static boolean disableGazeCatcher;

    public static boolean useSearchBlacklist;
    public static boolean enableOnlySafesearch;
    public static boolean disablePrivateSearch;
    public static boolean disablePublicSearch;
    public static String googleDevKey;
    public static String[] blacklistPlayerIgnore;

    public static void loadConfigs() {
        ModLogger.info("Loading Configs");
        // Configs for Blocks//
        disableSoulChest = config.get(Reference.DISABLE_FUNCTIONS_CATEGORY, "Disable Soul Chests", false).getBoolean();

        // Configs for Tools//
        disableAreaDeath = config.get(Reference.DISABLE_TOOLS_CATEGORY, "Disable_Area_Killer", false, "Area Killer Kills all hostile mobs in a radius (see below)").getBoolean();
        rangeAreaDeath = config.get(Reference.TOOLS_CATEGORY, "Area_Killer_Range", 5, "the distance from the player in which the Area Killer can cause damage (multiplied by teir/2 in-game).").getInt();
        areaDeathBlackOrWhitelist = config.get(Reference.TOOLS_CATEGORY, "Is_Area_Killer_Blacklist", true, "determines if the Area Killer uses a blacklist(true or a whitelist(false)").getBoolean();

        disableAreaMagnet = config.get(Reference.DISABLE_TOOLS_CATEGORY, "Disable_Dislocation_Magnet", false).getBoolean();
        rangeAreaMagnet = config.get(Reference.TOOLS_CATEGORY, "Dislocation Magnet Range", 5, "the distance from the player in which the Dislocation Magnet can attract items (multiplied by teir/2 in-game).").getInt();

        disableGazeCatcher = config.get(Reference.DISABLE_TOOLS_CATEGORY, "Disable_Gaze_Catcher", false).getBoolean();
        rangeGazeCatcher = config.get(Reference.TOOLS_CATEGORY, "Gaze_Catcher_Range", 5, "the distance from the player in which the gaze Catcher can move gazes.").getInt();

        disableWeathermansCompass = config.get(Reference.DISABLE_TOOLS_CATEGORY, "Disable_Weatherman's_Compass", false).getBoolean();

        // Search Configs //
        useSearchBlacklist = config.get(Reference.SEARCH_CATEGORY, "Use_Search_Blacklist", true, "Set to true to filter out inapropriate search queries and results.").getBoolean();
        enableOnlySafesearch = config.get(Reference.SEARCH_CATEGORY, "Require_Safesearch", true, "Set to true to require Safesearch for all searches /n(Safesearch is required in public searches and default on private searches)").getBoolean();
        disablePrivateSearch = config.get(Reference.SEARCH_CATEGORY, "Disable_Private_Search", false).getBoolean();
        disablePublicSearch = config.get(Reference.SEARCH_CATEGORY, "Disable_Public_Search", false).getBoolean();
        blacklistPlayerIgnore = config.get(Reference.SEARCH_CATEGORY, "Blacklist_player_ignore", new String[]{}, "Comma-separated list of players' UUIDs whose qeries and results are not checked against the blacklist (if enabled)").getStringList();
        googleDevKey = config.get(Reference.SEARCH_CATEGORY, "Google_developer_Key", "", "Developer key used for searches. Please use your own if you have one! (Servers MUST use their own)/nLearn how to get one at http://bit.ly/googleAPIKey").getString();

        if (config.hasChanged()) {
            config.save();
        }
    }
}
