package com.SoulSkin.soultech.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import java.util.*;

import static cpw.mods.fml.common.registry.GameRegistry.findItem;
import static java.util.Collections.addAll;
import static net.minecraft.item.crafting.CraftingManager.getInstance;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class removeVanillaRecipe {

	@SuppressWarnings( "unchecked" )
	public static void remove( Item removeItem ) {
		Collection< Item > removeSet = new HashSet< Item >();
		addAll( removeSet, removeItem );
		Iterator< IRecipe > iterator = getInstance().getRecipeList().iterator();

		while ( iterator.hasNext() ) {
			IRecipe recipe = iterator.next();
			if ( recipe == null ) {
				continue;
			}
			ItemStack output = recipe.getRecipeOutput();
			if ( output != null && output.getItem() != null && removeSet.contains( output.getItem() ) ) {
				iterator.remove();
			}
		}
	}

	public static void removeFromString( String sItem ) {
		String[] splitItem = sItem.split( ":" );
		Item     item      = findItem( splitItem[0], splitItem[1] );
		remove( item );
	}
}
