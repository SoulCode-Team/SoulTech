package com.SoulSkin.soultech.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

import java.util.Iterator;

/**
 * Created by John on 6/1/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class chatUtils {

    public static void sendPlayerMessage(EntityPlayer player, String message) {
        player.addChatComponentMessage(new ChatComponentText(message));
    }

    public static void sendAllPlayersMessage(String message) {
        Iterator iterator = MinecraftServer.getServer().getConfigurationManager().playerEntityList.iterator();
        while (iterator.hasNext()) {
            EntityPlayer entityplayer = (EntityPlayer) iterator.next();
            sendPlayerMessage(entityplayer, message);
        }
    }
}
