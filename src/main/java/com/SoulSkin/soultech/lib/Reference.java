package com.SoulSkin.soultech.lib;

import net.minecraft.creativetab.CreativeTabs;

import static com.SoulSkin.soultech.soultech.tabST;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class Reference {

	// General @Mod related constants //
	public static final String MOD_ID       = "soultech";
	public static final String MOD_NAME     = "SoulTech";
	public static final String VERSION      = "@VERSION@";
	public static final String BASE_PACKAGE = "com.SoulSkin.soultech";
	public static final String MOTD         = "@DATA@";
	public static final String FINGERPRINT  = "@FINGERPRINT@";
//	public static final String GUI_FACTORY_CLASS = "com.SoulSkin.soultech.client.gui.GuiFactory";

	// Creative tab //
	public static final CreativeTabs STTAB = tabST;

	// Proxy locations //
	public static final String PROXY_CLIENT = BASE_PACKAGE + ".proxy." + "ClientProxy";
	public static final String PROXY_COMMON = BASE_PACKAGE + ".proxy." + "CommonProxy";

	// Config Categories//
	public static final String DISABLE_BLOCKS_CATEGORY    = "Disable_Blocks";
	public static final String DISABLE_FUNCTIONS_CATEGORY = "Disable_Functions";
	public static final String DISABLE_TOOLS_CATEGORY     = "Disable_Tools";
	public static final String TOOLS_CATEGORY             = "Tools";

	// Texture locations //
	public static final String TOOL_FOLDER          = "tool/";
	public static final String FOOD_FOLDER          = "food/";
	public static final String ARMOR_FOLDER         = "armor/";
	public static final String ARMOR_SUIT_FOLDER    = "armor/suit/";
	public static final String ARMOR_OVERLAY_FOLDER = "textures/models/armor/";
	public static final String GUI_FOLDER           = "gui/";

	// General texture references //
	public static final String IMG_EXTENSION = ".png";
}