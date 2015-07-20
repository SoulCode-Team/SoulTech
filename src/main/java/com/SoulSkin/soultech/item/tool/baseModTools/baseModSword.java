package com.SoulSkin.soultech.item.tool.baseModTools;

import com.SoulSkin.soultech.util.StringUtils;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

import static com.SoulSkin.soultech.lib.ModTextures.GetTextureNameFull;
import static com.SoulSkin.soultech.lib.Reference.STTAB;
import static com.SoulSkin.soultech.lib.Reference.TOOL_FOLDER;
import static cpw.mods.fml.relauncher.Side.CLIENT;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class baseModSword extends ItemSword {

	public static Item materialItem;

	public baseModSword( ToolMaterial mat, Item matItem, String itemName ) {
		super( mat );
		this.setCreativeTab( STTAB );
		this.setUnlocalizedName( itemName + "_Sword" );
		materialItem = matItem;
	}

	@SideOnly( CLIENT )
	public void registerIcons( IIconRegister par1registerIcon ) {
		this.itemIcon = par1registerIcon.registerIcon( GetTextureNameFull( this, TOOL_FOLDER ) );
	}

	public boolean getIsRepairable( ItemStack p_82789_1_, ItemStack p_82789_2_ ) {
		ItemStack mat = new ItemStack( this.materialItem );
		return mat != null && OreDictionary.itemMatches( mat, p_82789_2_, false ) ? true : super.getIsRepairable( p_82789_1_, p_82789_2_ );
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
