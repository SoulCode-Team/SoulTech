package com.SoulSkin.soultech.proxy;

import static cpw.mods.fml.common.FMLCommonHandler.instance;
import static cpw.mods.fml.relauncher.Side.CLIENT;
import static org.lwjgl.input.Keyboard.KEY_LSHIFT;
import static org.lwjgl.input.Keyboard.isKeyDown;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public abstract class CommonProxy implements IProxy {

	public void registerRenderers() {
	}

	public String getCurrentLanguage() {
		return null;
	}

	public void RegisterCommonTickHandler() {
		// TickRegistry.registerTickHandler(new CommonTickHandler(),
		// Side.SERVER);
	}

	// From MachineMuse's PowerSuits mod
	public static boolean shouldAddAdditionalInfo() {
		if ( instance().getEffectiveSide() == CLIENT ) {
			if ( isKeyDown( KEY_LSHIFT ) ) {
				return true;
			}
		}
		return false;
	}

	public static Object additionalInfoInstructions() {
		String message = "§oPress §b<SHIFT>§7§o for more information.";
		return message;
	}
}