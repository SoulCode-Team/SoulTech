package com.SoulSkin.soultech.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static com.SoulSkin.soultech.lib.Reference.IMG_EXTENSION;
import static com.SoulSkin.soultech.lib.Reference.MOD_ID;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class ModTextures {

    public static String FormatUnlocalized(Item item) {
        return item.getUnlocalizedName().substring(5);
    }

    public static String FormatUnlocalized(Block block) {
        return block.getUnlocalizedName().substring(5);
    }

    public static String GetTextureNameFull(Item item) {
        return GetTextureNameFull(item, "");
    }

    public static String GetTextureNameFull(Block block) {
        return GetTextureNameFull(block, "");
    }

    public static String GetTextureNameFull(Item item, String subFolders) {
        return RESOURCE_CONTEXT + ":" + subFolders + FormatUnlocalized(item);
    }

    public static String GetTextureNameFull(Block block, String subFolders) {
        return RESOURCE_CONTEXT + ":" + subFolders + FormatUnlocalized(block);
    }

    public static String GetTextureFolder(String subFolders) {
        return RESOURCE_CONTEXT + ":" + subFolders;
    }

    public static String GetTextureFolder() {
        return GetTextureFolder("");
    }

    public static final String RESOURCE_CONTEXT = MOD_ID.toLowerCase();

    // Guis //
    public static final ResourceLocation GUI_COBBLESTONE_GENERATOR = new ResourceLocation(RESOURCE_CONTEXT, "textures/gui/cobblestone_generator" + IMG_EXTENSION);

    // Models //
}
