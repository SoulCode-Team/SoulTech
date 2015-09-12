package com.SoulSkin.soultech.armor.soulSteel;

import com.SoulSkin.soultech.armor.baseModArmor;
import com.SoulSkin.soultech.soultech;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by John on 6/15/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class soulSteelChestplate extends baseModArmor {

    public final int id = 1;
    private static soultech MOD;
    private Item fullSet[];
    private final Item matItem = MOD.soulSteel;

    public soulSteelChestplate() {
        this(MOD.soulSteelArmor, RenderingRegistry.addNewArmourRendererPrefix("soulSteel"), 1);
    }

    public soulSteelChestplate(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(par2EnumArmorMaterial, par3, par4);
        this.setUnlocalizedName(matItem.getUnlocalizedName().substring(5) + "Chestplate");
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        fullSet = new Item[]{MOD.soulSteelHelmet, MOD.soulSteelChestplate, MOD.soulSteelLeggings, MOD.soulSteelBoots};
        if (areAllWorn(player, fullSet)) {
            player.extinguish();
        }
    }
}