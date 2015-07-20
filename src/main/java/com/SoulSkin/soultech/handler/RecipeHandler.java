package com.SoulSkin.soultech.handler;

import com.SoulSkin.soultech.recipes.upgradeTeir;
import com.SoulSkin.soultech.soultech;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import static java.lang.Short.MAX_VALUE;
import static net.minecraft.init.Blocks.dirt;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class RecipeHandler {

	private static soultech MOD;

	public static final int WILDCARD_VALUE = MAX_VALUE;

	public static void craftingAll() {

		craftingBlocks();
//		craftingItems();
		craftingTools();
		craftingCustom();
		addArmorRecipes( ( MOD.soulSteel ), stackOf( MOD.soulSteelBoots ), stackOf( MOD.soulSteelLeggings ), stackOf( MOD.soulSteelChestplate ), stackOf( MOD.soulSteelHelmet ) );
		addArmorRecipes( ( MOD.soulShimmer ), stackOf( MOD.soulShimmerBoots ), stackOf( MOD.soulShimmerLeggings ), stackOf( MOD.soulShimmerChestplate ), stackOf( MOD.soulShimmerHelmet ) );
	}

	public static void smeltingAll() {
	}

	public static void addRecipe( ItemStack result, Object... recipe ) {
		GameRegistry.addRecipe( new ShapedOreRecipe( result, recipe ) );
	}

	public static void addShapelessRecipe( ItemStack result, Object... recipe ) {
		GameRegistry.addRecipe( new ShapelessOreRecipe( result, recipe ) );
	}

	/**
	 * registers crafting recipes for armor given material and output armor.
	 * (ore dictionary enabled)
	 *
	 * @param material
	 * @param output   [boots, leggings, chestplate, helmet]
	 */
	public static void addArmorRecipes( Object material, ItemStack... output ) {
		if ( output[0] != null ) {
			addRecipe( output[0], true, "X X", "X X", 'X', material );
		}
		if ( output[1] != null ) {
			addRecipe( output[1], true, "XXX", "X X", "X X", 'X', material );
		}
		if ( output[2] != null ) {
			addRecipe( output[2], true, "X X", "XXX", "XXX", 'X', material );
		}
		if ( output[3] != null ) {
			addRecipe( output[3], true, "XXX", "X X", 'X', material );
		}
	}

	public static ItemStack stackOf( Item item ) {
		return new ItemStack( item );
	}

	public static void craftingBlocks() {

		// Recipes for Blocks //

		addShapelessRecipe( new ItemStack( dirt ), new ItemStack( dirt, 1, 1 ) );
	}

	public static void craftingItems() {
		// Recipes for Items //
		addRecipe( new ItemStack( Items.snowball, 4 ), "blockSnow" );
	}

	public static void craftingTools() {
		// Recipes for Tools //
		addRecipe( new ItemStack( MOD.areaDeath ), true, "nsn", "sds", "nsn", 's', Items.diamond_sword, 'n', "itemNetherStar", 'd', "blockDiamond" );
		addRecipe( new ItemStack( MOD.areaMagnet ), true, "rir", "idi", "rnr", 'r', "blockRedstone", 'i', "ingotIron", 'd', "blockDiamond", 'n', "itemNetherStar" );

	}

	public static void craftingCustom() {
		GameRegistry.addRecipe( new upgradeTeir() );
	}
}
