package com.SoulSkin.soultech.armor.soulSteel;

import com.SoulSkin.soultech.armor.baseModArmor;
import com.SoulSkin.soultech.soultech;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;

/**
 * Created by John on 6/15/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class soulSteelLeggings extends baseModArmor {

	private static soultech MOD;
	private final Item matItem = MOD.soulSteel;

	public soulSteelLeggings() {
		this( MOD.soulSteelArmor, RenderingRegistry.addNewArmourRendererPrefix( "soulSteel" ), 2 );
	}

	public soulSteelLeggings( ArmorMaterial par2EnumArmorMaterial, int par3, int par4 ) {
		super( par2EnumArmorMaterial, par3, par4 );
		this.setUnlocalizedName( matItem.getUnlocalizedName().substring( 5 ) + "Leggings" );
	}

}
