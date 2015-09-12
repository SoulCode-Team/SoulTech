package com.SoulSkin.soultech.command;

import com.SoulSkin.soultech.util.StringUtils;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

import java.util.List;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class commandKill extends baseModCommand {

    public commandKill() {
        super("kill");
        this.addAlias("end");
        this.addAlias("stop");
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        int[] location = new int[3];

        if (args.length < 1) {
            throw new WrongUsageException("commands.kill.usage", new Object[0]);
        }
        else {
            EntityPlayerMP entityplayermp;

            if (args.length == 2 && !StringUtils.isInt(args[1])) {
                entityplayermp = getPlayer(sender, args[1]);

                if (entityplayermp == null) {
                    throw new PlayerNotFoundException();
                }
            }
            else {
                entityplayermp = getCommandSenderAsPlayer(sender);
            }

            if (args.length >= 4) {
                //add x,y,z to location if given
                for (int i = 2; i <= 4; i++) {
                    if (StringUtils.isInt(args[i])) {
                        location[i] = Integer.parseInt(args[i]);
                    }
                }
            }
            else if (entityplayermp != null) {
                location[0] = (int) entityplayermp.posX;
                location[1] = (int) entityplayermp.posY;
                location[2] = (int) entityplayermp.posZ;
            }
            int radius = Integer.parseInt(args[0]);

            for (int i = -radius; i <= radius; i++) {
                for (int j = -radius; j <= radius; j++) {
                    for (int k = -radius; k <= radius; k++) {
                        if (i * i + j * j + k * k >= (radius + 0.50f) * (radius + 0.50f)) {
                            continue;
                        }
                        //do stuff
                    }
                }
            }
        }
    }


    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] args) {
        return args.length == 2 ? getListOfStringsMatchingLastWord(args, MinecraftServer.getServer().getAllUsernames()) : null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return index == 1;
    }
}
