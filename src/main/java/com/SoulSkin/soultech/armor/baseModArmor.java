package com.SoulSkin.soultech.armor;

import com.SoulSkin.soultech.lib.ModTextures;
import com.SoulSkin.soultech.lib.Reference;
import com.SoulSkin.soultech.util.StringUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import java.util.List;

public class baseModArmor extends ItemArmor {

	public baseModArmor( ArmorMaterial par2EnumArmorMaterial, int par3, int par4 ) {
		super( par2EnumArmorMaterial, par3, par4 );
		this.setCreativeTab( Reference.STTAB );
	}

	@SideOnly( Side.CLIENT )
	public void registerIcons( IIconRegister par1registerIcon ) {
		this.itemIcon = par1registerIcon.registerIcon( ModTextures.GetTextureNameFull( this, Reference.ARMOR_FOLDER ) );
	}

	@Override
	public String getArmorTexture( ItemStack stack, Entity entity, int slot, String type ) {
		int    layer        = ( slot == 2 ? 2 : 1 );
		String returnString = "";

		if ( getUnlocalizedName( stack ).contains( "soulSteel_" ) ) {
			returnString = ModTextures.GetTextureFolder( Reference.ARMOR_OVERLAY_FOLDER ) + "soulSteel_layer_" + layer + Reference.IMG_EXTENSION;
		}
		if ( getUnlocalizedName( stack ).contains( "soulShimmer_" ) ) {
			returnString = ModTextures.GetTextureFolder( Reference.ARMOR_OVERLAY_FOLDER ) + "soulShimmer_layer_" + layer + Reference.IMG_EXTENSION;
		}
		else {
			returnString = ModTextures.GetTextureFolder( Reference.ARMOR_OVERLAY_FOLDER ) + "default_layer_" + layer + Reference.IMG_EXTENSION;
		}
		return returnString;
	}

	@Override
	public void addInformation( ItemStack stack, EntityPlayer player, List list, boolean par4 ) {
		if ( !StringUtils.getTooltipLocalized( this, 1 ).equals( StringUtils.getTooltipUnlocalized( this, 1 ) ) ) {
			list.add( StringUtils.getTooltipLocalizedChecked( this, 1 ) );
		}
		if ( !StringUtils.getTooltipLocalized( this, 2 ).equals( StringUtils.getTooltipUnlocalized( this, 2 ) ) ) {
			list.add( StringUtils.getTooltipLocalizedChecked( this, 2 ) );
		}
		if ( !StringUtils.getTooltipLocalized( this, 3 ).equals( StringUtils.getTooltipUnlocalized( this, 3 ) ) ) {
			list.add( StringUtils.getTooltipLocalizedChecked( this, 3 ) );
		}
	}
}
