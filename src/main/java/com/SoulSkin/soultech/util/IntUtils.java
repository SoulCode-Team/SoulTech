package com.SoulSkin.soultech.util;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class IntUtils {

	public static boolean isBetween( int check, int min, int max ) {
		return check >= min && check <= max;
	}

	public static Integer[] intListToIntegerList( int[] input ) {
		Integer[] returnList = new Integer[input.length];
		for ( int i = 0; i < input.length; i++ ) {
			returnList[i] = input[i];
		}
		return returnList;
	}

	public static int[] IntegerListToIntList( Integer[] input ) {
		int[] returnList = new int[input.length];
		for ( int i = 0; i < input.length; i++ ) {
			returnList[i] = input[i];
		}
		return returnList;
	}
}
