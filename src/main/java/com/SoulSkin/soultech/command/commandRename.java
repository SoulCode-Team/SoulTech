package com.SoulSkin.soultech.command;

import com.SoulSkin.soultech.util.StringUtils;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

import java.util.List;

import static net.minecraft.command.CommandBase.*;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class commandRename extends baseModCommand {

	public commandRename() {
		super( "rename" );
		this.addAlias( "name" );
		this.addAlias( "rname" );
		this.addAlias( "rn" );
	}

	@Override
	public void processCommand( ICommandSender sender, String[] args ) {
		int[] location = new int[3];

		if ( args.length < 1 ) {
			throw new WrongUsageException( "commands." + this.getCommandName() + ".usage", new Object[0] );
		}
		else {
			EntityPlayerMP entityplayermp;

			if ( args.length == 2 && !StringUtils.isInt( args[1] ) ) {
				entityplayermp = getPlayer( sender, args[1] );

				if ( entityplayermp == null ) {
					throw new PlayerNotFoundException();
				}
			}
			else {
				entityplayermp = getCommandSenderAsPlayer( sender );
			}

			ItemStack curStack = entityplayermp.getCurrentEquippedItem();
			if ( curStack.hasTagCompound() ) {
				curStack.getTagCompound();
				//TODO make change/add name to stack.
			}
		}
	}


	@Override
	public List addTabCompletionOptions( ICommandSender sender, String[] args ) {
		return args.length == 2 ? getListOfStringsMatchingLastWord( args, MinecraftServer.getServer().getAllUsernames() ) : null;
	}

	@Override
	public boolean isUsernameIndex( String[] args, int index ) {
		return index == 1;
	}
}
