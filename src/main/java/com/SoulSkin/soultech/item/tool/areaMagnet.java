package com.SoulSkin.soultech.item.tool;

import com.SoulSkin.soultech.handler.ConfigHandler;
import com.SoulSkin.soultech.item.ITaggedItem;
import com.SoulSkin.soultech.util.StringUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

/**
 * Created by John on 6/3/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class areaMagnet extends baseModTool implements ITaggedItem {

	public Random rand = new Random();

	public areaMagnet() {
		super();
		this.setUnlocalizedName( "areaMagnet" );
	}

	@Override
	public NBTTagCompound initTagCompound() {
		NBTTagCompound returnTag = new NBTTagCompound();
		returnTag.setByte( "teir", ( byte ) 1 );
		returnTag.setString( "status", "tooltips.status.deactivated" );

		return returnTag;
	}

	@Override
	public void onCreated( ItemStack stack, World world, EntityPlayer ePlayer ) {
		for ( int i = 0; i <= 100; i++ ) {
			world.spawnParticle( "portal", ePlayer.posX, ePlayer.posY, ePlayer.posZ, ( rand.nextDouble() - rand.nextDouble() ) * 2, ( rand.nextDouble() - rand.nextDouble() ) * 1.5, ( rand.nextDouble() - rand.nextDouble() ) * 2 );

		}
		if ( !world.isRemote ) {

			if ( !stack.hasTagCompound() ) {
				stack.stackTagCompound = initTagCompound();
			}
		}
	}

	@Override
	public void addInformation( ItemStack stack, EntityPlayer player, List list, boolean par4 ) {
		list.add( StringUtils.getTooltipLocalized( this, 1 ) );
		if ( stack.hasTagCompound() ) {
			list.add( StringUtils.getFormattedTooltipLocalized( this, 2, stack.stackTagCompound.getByte( "teir" ) ) );
			list.add( StringUtils.localizeString( stack.stackTagCompound.getString( "status" ) ) );
		}
		else {
			stack.stackTagCompound = initTagCompound();
		}
		if ( ConfigHandler.disableAreaMagnet ) {
			list.add( StringUtils.localizeString( "tooltips.status.disabled" ) );
		}
	}

	public void onUpdate( ItemStack stack, World worldIn, Entity entityIn, int p_77663_4_, boolean p_77663_5_ ) {
		if ( !ConfigHandler.disableAreaMagnet ) {
			if ( !worldIn.isRemote ) {
				int radius = ConfigHandler.rangeAreaMagnet;

				EntityPlayer ePlayer = null;
				if ( entityIn instanceof EntityPlayer ) {
					ePlayer = ( EntityPlayer ) entityIn;
				}

				if ( stack.hasTagCompound() && stack.stackTagCompound.getString( "status" ) == "tooltips.status.activated" ) {

					int teir = stack.hasTagCompound() ? ( stack.stackTagCompound.getByte( "teir" ) != 0 ) ? stack.stackTagCompound.getByte( "teir" ) : 1 : 1;
					for ( int i = 1; i < worldIn.loadedEntityList.size(); i++ ) {
						//TODO work on fixing this localization problem
						Entity entity = ( Entity ) worldIn.loadedEntityList.get( i );
						if ( entity.getDistanceToEntity( entityIn ) <= radius * ( ( teir + 1 ) / 2 ) ) {

							if ( entity instanceof EntityItem ) {

								if ( ( ( EntityItem ) entity ).getThrower() != ePlayer.getCommandSenderName() ) {
									entity.setPosition( ePlayer.posX, ePlayer.posY, ePlayer.posZ );
									if ( ( ( EntityItem ) entity ).delayBeforeCanPickup > 10 - teir * 2 ) {
										( ( EntityItem ) entity ).delayBeforeCanPickup = ( 10 - teir * 2 );
									}
								}
							}

							if ( entity instanceof EntityXPOrb ) {
								entity.setPosition( ePlayer.posX, ePlayer.posY, ePlayer.posZ );
							}
						}
					}
				}
			}
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
}
