package com.SoulSkin.soultech.command;

import net.minecraft.command.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by John on 7/20/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class commandSearch extends CommandBase implements ICommand {

	private static List aliases = Arrays.asList( new String[] {"query", "google"} );
	;
	private static String name = "search";

	@Override
	public String getCommandUsage( ICommandSender sender ) {
		return "commands." + name + ".usage";
	}

	@Override
	public String getCommandName() {
		return this.name;
	}

	@Override
	public List getCommandAliases() {
		return this.aliases;
	}

	@Override
	public void processCommand( ICommandSender sender, String[] args ) {
		//TODO make search work
	}

	@Override
	public boolean canCommandSenderUseCommand( ICommandSender sender ) {
		return true;
	}

	@Override
	public List addTabCompletionOptions( ICommandSender sender, String[] args ) {
		return null;
	}

	@Override
	public boolean isUsernameIndex( String[] args, int index ) {
		return false;
	}


	@Override
	public int compareTo( Object o ) {
		return this.compareTo( ( ICommand ) o );
	}
}
