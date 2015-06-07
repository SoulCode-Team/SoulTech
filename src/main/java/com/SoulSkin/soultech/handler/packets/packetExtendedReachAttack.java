package com.SoulSkin.soultech.handler.packets;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.*;
import io.netty.buffer.ByteBuf;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class packetExtendedReachAttack implements IMessage {

	private int entityId;

	public packetExtendedReachAttack() {
		// need this constructor
	}

	public packetExtendedReachAttack( int parEntityId ) {
		entityId = parEntityId;
		// DEBUG
//		System.out.println( "Constructor" );
	}

	@Override
	public void fromBytes( ByteBuf buf ) {
		entityId = ByteBufUtils.readVarInt( buf, 4 );
		// DEBUG
//		System.out.println( "fromBytes" );
	}

	@Override
	public void toBytes( ByteBuf buf ) {
		ByteBufUtils.writeVarInt( buf, entityId, 4 );
		// DEBUG
//		System.out.println( "toBytes encoded" );
	}

	public static class Handler implements IMessageHandler< packetExtendedReachAttack, IMessage > {

		@Override
		public IMessage onMessage( final packetExtendedReachAttack message, MessageContext ctx ) {
			// DEBUG
//			System.out.println( "Message received" );
			// Know it will be on the server so make it thread-safe
/*			final EntityPlayerMP thePlayer = ( EntityPlayerMP ) soultech.proxy.getPlayerEntityFromContext( ctx );
			thePlayer.getServerForPlayer().addScheduledTask(
					new Runnable() {
						@Override
						public void run() {
							Entity theEntity = thePlayer.worldObj.getEntityByID( message.entityId );
							// DEBUG
							System.out.println( "Entity = " + theEntity );

							// Need to ensure that hackers can't cause trick kills,
							// so double check weapon type and reach
							if ( thePlayer.getCurrentEquippedItem() == null ) {
								return;
							}
							if ( thePlayer.getCurrentEquippedItem().getItem() instanceof IExtendedReach ) {
								IExtendedReach theExtendedReachWeapon =
										( IExtendedReach ) thePlayer.getCurrentEquippedItem().getItem();
								double distanceSq = thePlayer.getDistanceSqToEntity( theEntity );
								double reachSq = theExtendedReachWeapon.getReach() * theExtendedReachWeapon.getReach();
								if ( reachSq >= distanceSq ) {
									thePlayer.attackTargetEntityWithCurrentItem( theEntity );
								}
							}
							return; // no response in this case
						}
					}
			);
*/
			return null; // no response message
		}
	}
}