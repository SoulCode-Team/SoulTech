package com.SoulSkin.soultech.armor.soulShimmer;

import com.SoulSkin.soultech.armor.baseModArmor;
import com.SoulSkin.soultech.soultech;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

/**
 * Created by John on 6/15/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class soulShimmerChestplate extends baseModArmor {

	private static soultech MOD;
	private final Item matItem = MOD.soulShimmer;

	public soulShimmerChestplate() {
		this( MOD.soulShimmerArmor, RenderingRegistry.addNewArmourRendererPrefix( "soulShimmer" ), 1 );
	}

	public soulShimmerChestplate( ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4 ) {
		super( par2EnumArmorMaterial, par3, par4 );
		this.setUnlocalizedName( matItem.getUnlocalizedName().substring( 5 ) + "Chestplate" );
	}
}