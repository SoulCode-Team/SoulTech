package com.SoulSkin.soultech.armor;

import com.SoulSkin.soultech.item.tool.baseModTool;
import com.SoulSkin.soultech.lib.ModTextures;
import com.SoulSkin.soultech.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class suitOfArmorBase extends baseModTool {

	public static Map< Item, ItemStack[] > data = new HashMap< Item, ItemStack[] >();

	public ItemStack toolStack[];

	/**
	 * * Constuctor. Params: int-item id, ItemStack[]-array of armor and
	 * sword(boots, leggings, chestplate, helmet, sword)
	 */
	public suitOfArmorBase( ItemStack[] toolItemStack ) {
		super();
		this.setUnlocalizedName( "suitOfArmor" );
		this.setData( this, toolItemStack );
	}

	public static void setData( Item idItem, ItemStack[] stacks ) {
		data.put( idItem, stacks );
	}

	public static ItemStack[] getData( Item idItem ) {
		return data.get( idItem );
	}

	@SideOnly( Side.CLIENT )
	public void registerIcons( IIconRegister par1registerIcon ) {
		this.itemIcon = par1registerIcon.registerIcon( ModTextures.GetTextureNameFull( this, Reference.ARMOR_SUIT_FOLDER ) );
		// System.out.println("texture:" + this.getUnlocalizedName(new
		// ItemStack(Item.itemsList[this.itemID])));
	}

	@Override
	public ItemStack onItemRightClick( ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer ) {
		toolStack = getData( par1ItemStack.getItem() );

		for ( int i = 0; i < 4; i++ ) {
			ItemStack itemstack1 = par3EntityPlayer.getCurrentArmor( i );

			toolStack[i].stackSize = 1;
			if ( itemstack1 == null ) {
				par3EntityPlayer.setCurrentItemOrArmor( i + 1, toolStack[i] );
			}
			else {
				par3EntityPlayer.inventory.addItemStackToInventory( toolStack[i] );
			}
		}

		return toolStack[4];
	}
}
