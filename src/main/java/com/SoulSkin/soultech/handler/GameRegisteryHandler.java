package com.SoulSkin.soultech.handler;

import com.SoulSkin.soultech.soultech;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class GameRegisteryHandler {

    public static soultech MOD;

    public static void registerItems() {
        // Register Items//
        GameRegistry.registerItem(MOD.soulSteel, MOD.soulSteel.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulShimmer, MOD.soulShimmer.getUnlocalizedName());
    }

    public static void registerTools() {

        GameRegistry.registerItem(MOD.areaDeath, MOD.areaDeath.getUnlocalizedName());
        GameRegistry.registerItem(MOD.areaMagnet, MOD.areaMagnet.getUnlocalizedName());
        GameRegistry.registerItem(MOD.weathermansCompass, MOD.weathermansCompass.getUnlocalizedName());
        GameRegistry.registerItem(MOD.troll, MOD.troll.getUnlocalizedName());

        GameRegistry.registerItem(MOD.soulShimmerAxe, MOD.soulShimmerAxe.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulShimmerHoe, MOD.soulShimmerHoe.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulShimmerOmniTool, MOD.soulShimmerOmniTool.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulShimmerPick, MOD.soulShimmerPick.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulShimmerShovel, MOD.soulShimmerShovel.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulShimmerSword, MOD.soulShimmerSword.getUnlocalizedName());

        GameRegistry.registerItem(MOD.soulSteelAxe, MOD.soulSteelAxe.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulSteelHoe, MOD.soulSteelHoe.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulSteelOmniTool, MOD.soulSteelOmniTool.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulSteelPick, MOD.soulSteelPick.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulSteelShovel, MOD.soulSteelShovel.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulSteelSword, MOD.soulSteelSword.getUnlocalizedName());
    }

    public static void registerBlocks() {
        GameRegistry.registerBlock(MOD.soulChest, MOD.soulChest.getUnlocalizedName());
    }

    public static void registerTileEntities() {
        //GameRegistry.registerTileEntity( tileCell.class, StringUtils.prefixModID( "Cell" ) );
    }

    public static void registerArmor() {
        // Register Armor//
        GameRegistry.registerItem(MOD.soulSteelHelmet, MOD.soulSteelHelmet.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulSteelChestplate, MOD.soulSteelChestplate.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulSteelLeggings, MOD.soulSteelLeggings.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulSteelBoots, MOD.soulSteelBoots.getUnlocalizedName());

        GameRegistry.registerItem(MOD.soulShimmerHelmet, MOD.soulShimmerHelmet.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulShimmerChestplate, MOD.soulShimmerChestplate.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulShimmerLeggings, MOD.soulShimmerLeggings.getUnlocalizedName());
        GameRegistry.registerItem(MOD.soulShimmerBoots, MOD.soulShimmerBoots.getUnlocalizedName());
    }

    public static void registerAll() {
        registerItems();
        registerTileEntities();
        registerBlocks();
        registerArmor();
        registerTools();
    }
}
