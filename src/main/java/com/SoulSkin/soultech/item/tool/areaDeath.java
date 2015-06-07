package com.SoulSkin.soultech.item.tool;

import com.SoulSkin.soultech.handler.ConfigHandler;
import com.SoulSkin.soultech.item.ITaggedItem;
import com.SoulSkin.soultech.lib.ModTextures;
import com.SoulSkin.soultech.lib.Reference;
import com.SoulSkin.soultech.util.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class areaDeath extends baseModTool implements ITaggedItem {

	public areaDeath() {
		super();
		this.setUnlocalizedName( "areaDeath" );
	}

	public NBTTagCompound initTagCompound() {
		NBTTagCompound returnTag = new NBTTagCompound();
		returnTag.setByte( "teir", ( byte ) 1 );
		returnTag.setString( "status", "tooltips.status.deactivated" );

		return returnTag;
	}

	@Override
	public void onCreated( ItemStack stack, World world, EntityPlayer ePlayer ) {
		if ( !world.isRemote ) {
			world.spawnEntityInWorld( new EntityLightningBolt( world, ePlayer.posX, ePlayer.posY, ePlayer.posZ ) );
			chatHelper.sendAllPlayersMessage( ePlayer.getDisplayName() + " " + StringUtils.localizeString( "item.areaDeath.warning" ) );
			if ( !stack.hasTagCompound() ) {
				stack.stackTagCompound = initTagCompound();
			}
		}
	}

	@Override
	public void addInformation( ItemStack stack, EntityPlayer player, List list, boolean par4 ) {
		list.add( String.format( StringUtils.getTooltipLocalized( this, 1 ), ConfigHandler.rangeAreaDeath ) );
		list.add( StringUtils.getTooltipLocalized( this, 2 ) );
		if ( stack.hasTagCompound() ) {
//			list.add( String.format( StringUtils.getTooltipLocalized( this, 3 ), stack.stackTagCompound.getByte( "teir" ) ) );
			list.add( "Teir " + stack.stackTagCompound.getByte( "teir" ) );
			list.add( StringUtils.localizeString( stack.stackTagCompound.getString( "status" ) ) );
		}
		else {
			stack.stackTagCompound = initTagCompound();
		}
	}

	@Override
	public ItemStack onItemRightClick( ItemStack itemStackIn, World worldIn, EntityPlayer player ) {
		if ( !worldIn.isRemote ) {
			if ( player.isSneaking() ) {
				if ( itemStackIn.hasTagCompound() ) {
					if ( !StringUtils.isNullOrEmpty( itemStackIn.stackTagCompound.getString( "status" ) ) ) {
						boolean activated = false;
						if ( itemStackIn.stackTagCompound.getString( "status" ).equals( "tooltips.status.deactivated" ) ) {
							itemStackIn.stackTagCompound.setString( "status", "tooltips.status.activated" );
							activated = true;
						}
						if ( itemStackIn.stackTagCompound.getString( "status" ).equals( "tooltips.status.activated" ) && !activated ) {
							itemStackIn.stackTagCompound.setString( "status", "tooltips.status.deactivated" );
						}
						activated = false;
					}
				}
				else {
					itemStackIn.stackTagCompound = initTagCompound();
				}
			}
		}
		return itemStackIn;
	}

	public void onUpdate( ItemStack stack, World worldIn, Entity entityIn, int p_77663_4_, boolean p_77663_5_ ) {
		if ( !worldIn.isRemote ) {
			int radius = ConfigHandler.rangeAreaDeath;

			EntityPlayer ePlayer = null;
			if ( entityIn instanceof EntityPlayer ) {
				ePlayer = ( EntityPlayer ) entityIn;
			}

			if ( stack.hasTagCompound() && stack.stackTagCompound.getString( "status" ) == "tooltips.status.activated" ) {

				int teir = stack.hasTagCompound() ? ( stack.stackTagCompound.getByte( "teir" ) != 0 ) ? stack.stackTagCompound.getByte( "teir" ) : 1 : 1;
				for ( int i = 1; i < worldIn.loadedEntityList.size(); i++ ) {
					Entity entity = ( Entity ) worldIn.loadedEntityList.get( i );
					if ( entity.getDistanceToEntity( entityIn ) <= radius * ( Math.ceil( ( teir + 1 ) / 2 ) ) && ( entity instanceof IMob || entity instanceof EntityWither || entity instanceof EntityDragonPart ) ) {
						entity.attackEntityFrom( DamageSource.causePlayerDamage( ePlayer ), Math.max( ( ( radius + teir ) - entity.getDistanceToEntity( entityIn ) ) + ( ( teir + 1 ) / 2 ), 1.0F ) );
						PlayerHelper.sentMessageToPlayer( ePlayer, String.valueOf( Math.max( ( ( radius + teir ) - entity.getDistanceToEntity( entityIn ) ) + teir + 1, 1.0F ) ) );
						worldIn.spawnParticle( "spell", ePlayer.posX, ePlayer.posY, ePlayer.posZ, 0D, 2D, 0D );
					}
				}
			}
		}
		else {
			int radius = ConfigHandler.rangeAreaDeath;

			EntityPlayer ePlayer = null;
			if ( entityIn instanceof EntityPlayer ) {
				ePlayer = ( EntityPlayer ) entityIn;
			}

			if ( stack.hasTagCompound() && stack.stackTagCompound.getString( "status" ) == "tooltips.status.activated" ) {

				int teir = stack.hasTagCompound() ? ( stack.stackTagCompound.getByte( "teir" ) != 0 ) ? stack.stackTagCompound.getByte( "teir" ) : 1 : 1;
				for ( int i = 1; i < worldIn.loadedEntityList.size(); i++ ) {
					Entity entity = ( Entity ) worldIn.loadedEntityList.get( i );
					if ( entity.getDistanceToEntity( entityIn ) <= radius * ( Math.ceil( ( teir + 1 ) / 2 ) ) && ( entity instanceof IMob || entity instanceof EntityWither || entity instanceof EntityDragonPart ) ) {
						Vec3 entityVec = Vec3.createVectorHelper( entity.posX, entity.posY, entity.posZ );
						Vec3 playerVec = Vec3.createVectorHelper( ePlayer.posX, ePlayer.posY, ePlayer.posZ );

						worldIn.spawnParticle( "portal", ePlayer.posX, ePlayer.posY, ePlayer.posZ, ( entity.posX - ePlayer.posX ) / 1, ( entity.posY - ePlayer.posY - 1 ) / 1, ( entity.posZ - ePlayer.posZ ) / 1 );
						worldIn.spawnParticle( "flame", ePlayer.posX, ePlayer.posY, ePlayer.posZ, ( entity.posX - ePlayer.posX ) / 9, ( entity.posY - ePlayer.posY - 1 ) / 9, ( entity.posZ - ePlayer.posZ ) / 9 );
//						worldIn.spawnParticle( "largesmoke", ePlayer.posX, ePlayer.posY, ePlayer.posZ, ( entity.posX - ePlayer.posX )/9, ( entity.posY - ePlayer.posY-1 )/9, ( entity.posZ - ePlayer.posZ )/9 );
//						worldIn.spawnParticle( "spell", ePlayer.posX, ePlayer.posY, ePlayer.posZ, ( entity.posX - ePlayer.posX )*9, (( entity.posY - ePlayer.posY-1 )+1)*9, ( entity.posZ - ePlayer.posZ )*9 );
//						worldIn.spawnParticle( "blockcrack_" + Block.getIdFromBlock(Blocks.obsidian) + "_0", ePlayer.posX, ePlayer.posY, ePlayer.posZ, ( entity.posX - ePlayer.posX )/2, ( entity.posY - ePlayer.posY )/2, ( entity.posZ - ePlayer.posZ )/2 );
					}
				}
			}
		}
	}

	@SideOnly( Side.CLIENT )
	public void registerIcons( IIconRegister par1registerIcon ) {
		this.itemIcon = par1registerIcon.registerIcon( ModTextures.GetTextureNameFull( this, Reference.TOOL_FOLDER ) );
	}
}
