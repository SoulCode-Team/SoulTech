package com.SoulSkin.soultech.block.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by John on 6/1/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class tileSoulChest extends TileEntity implements IInventory {


	private static int         slotCount     = 1;
	/** the contents of the chest */
	private        ItemStack[] chestContents = new ItemStack[slotCount];
	/** The current angle of the lid (between 0 and 1) */
	public  float  lidAngle;
	/** The angle of the lid last tick */
	public  float  prevLidAngle;
	private String customName;

	@Override
	public int getSizeInventory() {
		return slotCount;
	}

	@Override
	public ItemStack getStackInSlot( int slotIn ) {
		return this.chestContents[slotIn];
	}

	public void setCustomName( String p_145976_1_ ) {
		this.customName = p_145976_1_;
	}

	/**
	 * Returns the name of the inventory
	 */
	public String getInventoryName() {
		return this.isCustomInventoryName() ? this.customName : "container.chest";
	}

	/**
	 * Returns if the inventory is named
	 */
	public boolean isCustomInventoryName() {
		return this.customName != null && this.customName.length() > 0;
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */
	public ItemStack decrStackSize( int index, int count ) {
		if ( this.chestContents[index] != null ) {
			ItemStack itemstack;

			if ( this.chestContents[index].stackSize <= count ) {
				itemstack = this.chestContents[index];
				this.chestContents[index] = null;
				this.markDirty();
				return itemstack;
			}
			else {
				itemstack = this.chestContents[index].splitStack( count );

				if ( this.chestContents[index].stackSize == 0 ) {
					this.chestContents[index] = null;
				}

				this.markDirty();
				return itemstack;
			}
		}
		else {
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 */
	public ItemStack getStackInSlotOnClosing( int index ) {
		if ( this.chestContents[index] != null ) {
			ItemStack itemstack = this.chestContents[index];
			this.chestContents[index] = null;
			return itemstack;
		}
		else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents( int index, ItemStack stack ) {

	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}

	@Override
	public boolean isUseableByPlayer( EntityPlayer player ) {
		return false;
	}

	@Override
	public void openChest() {

	}

	@Override
	public void closeChest() {

	}

	@Override
	public boolean isItemValidForSlot( int index, ItemStack stack ) {
		return true;
	}
}
