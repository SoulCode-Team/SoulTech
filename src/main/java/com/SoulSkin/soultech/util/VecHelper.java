package com.SoulSkin.soultech.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;

/**
 * Created by John on 6/14/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class VecHelper {

	public static Vec3 createVecFromEntity( Entity entity ) {
		return Vec3.createVectorHelper( entity.posX, entity.posY, entity.posZ );
	}

	public static double getYaw( Vec3 startVec, Vec3 endVec ) {
		double deltaX   = startVec.xCoord - endVec.xCoord;
		double deltaY   = startVec.yCoord - endVec.yCoord;
		double deltaZ   = startVec.zCoord - endVec.zCoord;
		double distance = Math.sqrt( deltaZ * deltaZ + deltaX * deltaX );

		return Math.atan2( deltaX, deltaZ );
	}

	public static double getPitch( Vec3 startVec, Vec3 endVec ) {
		double deltaX   = startVec.xCoord - endVec.xCoord;
		double deltaY   = startVec.yCoord - endVec.yCoord;
		double deltaZ   = startVec.zCoord - endVec.zCoord;
		double distance = Math.sqrt( deltaZ * deltaZ + deltaX * deltaX );

		return Math.asin( deltaY / distance );
	}

	public static double[] getVectorCoords( Vec3 vec ) {
		double[] returnList = new double[3];
		returnList[0] = vec.xCoord;
		returnList[1] = vec.yCoord;
		returnList[2] = vec.zCoord;
		return returnList;
	}
}
