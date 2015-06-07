package com.SoulSkin.soultech.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class PlayerHelper {

	public static void sentMessageToPlayer( EntityPlayer player, String message ) {
		player.addChatMessage( new ChatComponentText( message ) );
	}

	public static void playSoundForPlayer( EntityPlayer player, String sound, float volume, float pitch ) {
		player.playSound( sound, volume, pitch );
	}

	public static void playSoundForPlayer( EntityPlayer player, String sound ) {
		player.playSound( sound, 0.5F, 1.0F );
	}

	public static void closePlayerGUI( EntityPlayer player ) {
		player.closeScreen();
	}

	public static void mountEntity( EntityPlayer player, Entity entity ) {
		player.mountEntity( entity );
	}

	public Block findBlockUnderPlayer( EntityPlayer player ) {
		int blockX = MathHelper.floor_double( player.posX );
		int blockY = MathHelper.floor_double( player.boundingBox.minY ) - 1;
		int blockZ = MathHelper.floor_double( player.posZ );
		return player.worldObj.getBlock( blockX, blockY, blockZ );
	}
}
