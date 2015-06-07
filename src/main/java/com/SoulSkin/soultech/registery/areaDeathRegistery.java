package com.SoulSkin.soultech.registery;

import net.minecraft.entity.Entity;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class areaDeathRegistery {

	private static Set< Entity > whitelist;
	private static Set< Entity > blacklist;

	// WHITELIST //
	public static void addEntityToWhitelist( Entity entity ) {
		whitelist.add( entity );
	}

	public static void removeEntityFromWhitelist( Entity entity ) {
		whitelist.remove( entity );
	}

	public static boolean isEntityInWhitelist( Entity entity ) {
		Iterator< Entity > iterator = whitelist.iterator();
		while ( iterator.hasNext() ) {
			Entity setElement = iterator.next();
			if ( setElement == entity ) {
				return true;
			}
		}
		return false;
	}

	// BLACKLIST //
	public static void addEntityToBlacklist( Entity entity ) {
		blacklist.add( entity );
	}

	public static void removeEntityFromBlacklist( Entity entity ) {
		blacklist.remove( entity );
	}

	public static boolean isEntityInBlacklist( Entity entity ) {
		Iterator< Entity > iterator = blacklist.iterator();
		while ( iterator.hasNext() ) {
			Entity setElement = iterator.next();
			if ( setElement == entity ) {
				return true;
			}
		}
		return false;
	}

	areaDeathRegistery() {

	}


}
