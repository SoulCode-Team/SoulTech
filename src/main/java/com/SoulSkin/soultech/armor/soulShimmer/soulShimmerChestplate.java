package com.SoulSkin.soultech.armor.soulShimmer;

import com.SoulSkin.soultech.armor.baseModArmor;
import com.SoulSkin.soultech.soultech;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by John on 6/15/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class soulShimmerChestplate extends baseModArmor {

    public final int id = 1;
    private static soultech MOD;
    public Item[] fullSet = new Item[4];
    private final Item matItem = MOD.soulShimmer;

    public soulShimmerChestplate() {
        this(MOD.soulShimmerArmor, RenderingRegistry.addNewArmourRendererPrefix("soulShimmer"), 1);
    }

    public soulShimmerChestplate(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(par2EnumArmorMaterial, par3, par4);
        this.setUnlocalizedName(matItem.getUnlocalizedName().substring(5) + "Chestplate");
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        fullSet = new Item[]{MOD.soulShimmerHelmet, MOD.soulShimmerChestplate, MOD.soulShimmerLeggings, MOD.soulShimmerBoots};
        if (areAllWorn(player, fullSet)) {
//            if (true) {
            player.extinguish();
            player.setAir(300);
            player.removePotionEffect(Integer.valueOf(Potion.harm.id));
            player.removePotionEffect(Integer.valueOf(Potion.blindness.id));
            player.removePotionEffect(Integer.valueOf(Potion.confusion.id));
            player.removePotionEffect(Integer.valueOf(Potion.digSlowdown.id));
            player.removePotionEffect(Integer.valueOf(Potion.hunger.id));
            player.removePotionEffect(Integer.valueOf(Potion.poison.id));
            player.removePotionEffect(Integer.valueOf(Potion.wither.id));
            player.removePotionEffect(Integer.valueOf(Potion.weakness.id));
            player.removePotionEffect(Integer.valueOf(Potion.moveSlowdown.id));
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40));
        }
    }
}