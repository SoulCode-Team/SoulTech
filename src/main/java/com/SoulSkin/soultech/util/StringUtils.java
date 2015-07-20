package com.SoulSkin.soultech.util;

import com.SoulSkin.soultech.lib.Reference;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class StringUtils {

	public static String[] GetStringList( String str ) {
		return GetStringList( str, "," );
	}

	public static String[] GetStringList( String str, String splitter ) {
		return str.split( splitter );
	}

	/**
	 * Returns a value indicating whether the given string is null or empty.
	 */
	public static boolean isNullOrEmpty( String str ) {
		return str == null || "".equals( str );
	}

	public static boolean isNullOrEmpty( String[] str ) {
		return ( str == null || str.length <= 0 || "".equals( str ) );
	}

	public static String prefixModID( String str ) {
		return Reference.MOD_ID + "_" + str;
	}

	public static boolean isInt( String str ) {
		if ( str == null ) {
			return false;
		}
		int length = str.length();
		if ( length == 0 ) {
			return false;
		}
		int i = 0;
		if ( str.charAt( 0 ) == '-' ) {
			if ( length == 1 ) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++ ) {
			char c = str.charAt( i );
			if ( c <= '/' || c >= ':' ) {
				return false;
			}
		}
		return true;
	}

	public static String localizeString( String unlocalizedStr ) {
		return ( "" + StatCollector.translateToLocal( unlocalizedStr ) ).trim();
	}

	public static String localizeStringFormatted( String unlocalizedStr, Object... obj ) {
		return ( "" + StatCollector.translateToLocalFormatted( unlocalizedStr, obj ) ).trim();
	}

	public static String getTooltipUnlocalized( Item item, int tooltipRow ) {
		return ( "" + "tooltips.tooltip" + tooltipRow + "." + item.getUnlocalizedName().substring( 5 ) ).trim();
	}

	public static String getTooltipLocalized( Item item, int tooltipRow ) {
		return localizeString( getTooltipUnlocalized( item, tooltipRow ) );
	}

	public static String getTooltipLocalizedChecked( Item item, int tooltipRow ) {
		return ( localizeString( getTooltipUnlocalized( item, tooltipRow ) ).equals( getTooltipUnlocalized( item, tooltipRow ) ) ) ? null : localizeString( getTooltipUnlocalized( item, tooltipRow ) );
	}

	public static String getFormattedTooltipLocalized( Item item, int tooltipRow, Object... obj ) {
		return localizeStringFormatted( getTooltipUnlocalized( item, tooltipRow ), obj );
	}
}
