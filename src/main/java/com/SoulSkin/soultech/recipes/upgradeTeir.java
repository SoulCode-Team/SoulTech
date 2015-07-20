package com.SoulSkin.soultech.recipes;

import com.SoulSkin.soultech.soultech;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

/**
 * Created by John on 6/3/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class upgradeTeir implements IRecipe {

	public static soultech MOD;

	// Item and how many required for next teir //
	protected static final int       maxTeir          = 5;
	protected static final ItemStack upgradeItemStack = new ItemStack( Items.diamond );
	protected static final int       upgradeCount     = 4;

	@Override
	public boolean matches( InventoryCrafting inventorycrafting, World world ) {

		int teiredItems  = 0;
		int upgradeItems = 0;

		for ( int i = 0; i < inventorycrafting.getSizeInventory(); i++ ) {
			if ( inventorycrafting.getStackInSlot( i ) == null ) {
				continue;
			}

			ItemStack checkItem = inventorycrafting.getStackInSlot( i );
			if ( checkItem.getItem() == null ) {
				continue;
			}

			if ( checkItem.hasTagCompound() ) {
				if ( checkItem.stackTagCompound.getByte( "teir" ) != 0 && checkItem.stackTagCompound.getByte( "teir" ) < maxTeir ) {
					teiredItems++;
				}
			}

			if ( checkItem.isItemEqual( upgradeItemStack ) ) {
				upgradeItems++;
			}

		}
		if ( upgradeItems == upgradeCount && teiredItems == 1 ) {
			return true;
		}

		return false;

	}

	@Override
	public ItemStack getCraftingResult( InventoryCrafting inventorycrafting ) {
		ItemStack returnStack = null;

		for ( int i = 0; i < inventorycrafting.getSizeInventory(); i++ ) {
			if ( inventorycrafting.getStackInSlot( i ) == null ) {
				continue;
			}

			ItemStack checkItem = inventorycrafting.getStackInSlot( i );
			if ( checkItem.getItem() == null ) {
				continue;
			}

			if ( checkItem.hasTagCompound() ) {
				if ( checkItem.stackTagCompound.getByte( "teir" ) != 0 ) {
					returnStack = checkItem.copy();
					returnStack.stackTagCompound.setByte( "teir", ( ( byte ) ( returnStack.stackTagCompound.getByte( "teir" ) + 1 ) ) );
				}
			}


		}
		return returnStack;
	}

	@Override
	public int getRecipeSize() {
		return upgradeCount + 1;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return null;
	}

}
