package com.SoulSkin.soultech.item;

import com.SoulSkin.soultech.lib.ModTextures;
import com.SoulSkin.soultech.lib.Reference;
import com.SoulSkin.soultech.soultech;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSword;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class longSword extends ItemSword implements IExtendedReach {

    longSword() {
        super(soultech.soulSteelTool);
        this.setCreativeTab(Reference.STTAB);
        this.setUnlocalizedName("longSword");
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1registerIcon) {
        this.itemIcon = par1registerIcon.registerIcon(ModTextures.GetTextureNameFull(this));
    }

    @Override
    public float getReach() {
        return 2.0F;
    }
}
