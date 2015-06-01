package com.SoulSkin.soultech.handler;

import com.SoulSkin.soultech.soultech;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
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
	}

	public static void smeltingAll() {
	}

	public static void addRecipe( ItemStack result, Object... recipe ) {
		GameRegistry.addRecipe( new ShapedOreRecipe( result, recipe ) );
	}

	// public static void addShapelessRecipe(ItemStack result, Object... recipe)
	// {
	// CraftingManager.getInstance().getRecipeList().add(new
	// ShapelessOreRecipe(result, recipe));
	// }

	public static void addShapelessRecipe( ItemStack result, Object... recipe ) {
		GameRegistry.addRecipe( new ShapelessOreRecipe( result, recipe ) );
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
		addRecipe( new ItemStack( MOD.areaDeath ), true, "igi", "bdb", "ibi", 'g', "blockGlass", 'b', "blockRedstone", 'i', "ingotIron" );

	}
}
