package com.SoulSkin.soultech.item.tool.soulSteel;


import com.SoulSkin.soultech.item.tool.baseModTools.baseModSword;
import com.SoulSkin.soultech.soultech;

/**
 * Created by John on 6/16/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class soulSteelSword extends baseModSword {

	private static soultech MOD;

	public soulSteelSword() {
		super( MOD.soulSteelTool, MOD.soulSteel, "soulSteel" );
	}
}
