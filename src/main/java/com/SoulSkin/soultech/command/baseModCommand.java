package com.SoulSkin.soultech.command;

import com.SoulSkin.soultech.util.StringUtils;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public abstract class baseModCommand implements ICommand {

	private static List   aliases = new ArrayList();
	private static String name    = "";

	public baseModCommand( String str ) {
		this.name = StringUtils.prefixModID( str );
	}

	public static void addAlias( String str ) {
		aliases.add( StringUtils.prefixModID( str ) );
		aliases.add( "ST_" + str );
	}


	@Override
	public String getCommandUsage( ICommandSender sender ) {
		return "command." + name + ".usage";
	}

	@Override
	public String getCommandName() {
		return StringUtils.prefixModID( this.name );
	}

	@Override
	public List getCommandAliases() {
		return this.aliases;
	}

	@Override
	public boolean canCommandSenderUseCommand( ICommandSender sender ) {
		return true;
	}


	@Override
	public int compareTo( Object o ) {
		return 0;
	}
}
