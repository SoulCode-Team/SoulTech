package com.SoulSkin.soultech.item.tool;

import com.SoulSkin.soultech.handler.ConfigHandler;
import com.SoulSkin.soultech.util.chatHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Iterator;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class areaDeath extends baseModTool {

	public areaDeath() {
		super();
		this.setUnlocalizedName( "areaDeath" );
	}

	@Override
	public void onCreated( ItemStack stack, World world, EntityPlayer ePlayer ) {
		world.spawnEntityInWorld( new EntityLightningBolt( world, ePlayer.posX, ePlayer.posY, ePlayer.posZ ) );
		chatHelper.sendAllPlayersMessage( ePlayer.getDisplayName() + " has created an Area Killer." );
	}

	public void onUpdate( ItemStack stack, World worldIn, Entity entityIn, int p_77663_4_, boolean p_77663_5_ ) {
		if ( !worldIn.isRemote ) {
			int radius = ConfigHandler.rangeAreaDeath;

			EntityPlayer ePlayer = null;
			if ( entityIn instanceof EntityPlayer ) {
				ePlayer = ( EntityPlayer ) entityIn;
			}

			Iterator iter = worldIn.loadedEntityList.iterator();
			while ( iter.hasNext() ) {
				Entity entity = ( Entity ) iter.next();
				if ( entity.getDistanceToEntity( entityIn ) <= radius && entity instanceof IMob ) {
					entity.attackEntityFrom( DamageSource.causePlayerDamage( ePlayer ), 2F );
				}
			}
		}
	}
}
