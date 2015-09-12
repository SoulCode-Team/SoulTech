package com.SoulSkin.soultech.item.tool;

import com.SoulSkin.soultech.handler.ConfigHandler;
import com.SoulSkin.soultech.item.ITaggedItem;
import com.SoulSkin.soultech.lib.ModTextures;
import com.SoulSkin.soultech.lib.Reference;
import com.SoulSkin.soultech.util.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class gazeCatcher extends baseModTool implements ITaggedItem {

    public gazeCatcher() {
        super();
        this.setUnlocalizedName("gazeCatcher");
    }

    public NBTTagCompound initTagCompound() {
        NBTTagCompound returnTag = new NBTTagCompound();
        returnTag.setBoolean("direction", true);
        returnTag.setString("status", "tooltips.status.deactivated");

        return returnTag;
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer ePlayer) {
        if (!world.isRemote) {
            world.spawnEntityInWorld(new EntityLightningBolt(world, ePlayer.posX, ePlayer.posY, ePlayer.posZ));
            chatUtils.sendAllPlayersMessage(ePlayer.getDisplayName() + " " + StringUtils.localizeString("item.areaDeath.warning"));
            if (!stack.hasTagCompound()) {
                stack.stackTagCompound = initTagCompound();
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(StringUtils.getTooltipLocalized(this, 1));
        if (stack.hasTagCompound()) {
            list.add(stack.stackTagCompound.getBoolean("direction") ? StringUtils.localizeString("tooltips.directions.towards") : StringUtils.localizeString("tooltips.directions.towards"));
        }
        if (ConfigHandler.disableGazeCatcher) {
            list.add(StringUtils.localizeString("tooltips.status.disabled"));
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {

        if (!worldIn.isRemote) {
            if (player.isSneaking()) {
                if (itemStackIn.hasTagCompound()) {
                    if (!StringUtils.isNullOrEmpty(itemStackIn.stackTagCompound.getString("status"))) {
                        boolean activated = false;
                        if (itemStackIn.stackTagCompound.getString("status").equals("tooltips.status.deactivated")) {
                            itemStackIn.stackTagCompound.setString("status", "tooltips.status.activated");
                            activated = true;
                        }
                        if (itemStackIn.stackTagCompound.getString("status").equals("tooltips.status.activated") && !activated) {
                            itemStackIn.stackTagCompound.setString("status", "tooltips.status.deactivated");
                        }
                        activated = false;
                    }
                }
                else {
                    itemStackIn.stackTagCompound = initTagCompound();
                }
            }
        }

        return itemStackIn;
    }


    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int p_77663_4_, boolean p_77663_5_) {
        if (!ConfigHandler.disableGazeCatcher) {
            if (!worldIn.isRemote) {
                int radius = ConfigHandler.rangeGazeCatcher;

                EntityPlayer ePlayer = null;
                if (entityIn instanceof EntityPlayer) {
                    ePlayer = (EntityPlayer) entityIn;
                }

                if (stack.hasTagCompound() && stack.stackTagCompound.getString("status").equals("tooltips.status.activated")) {

                    for (int i = 1; i < worldIn.loadedEntityList.size(); i++) {
                        Entity entity = (Entity) worldIn.loadedEntityList.get(i);
                        this.changeAllLookingRanged(radius, entityIn, worldIn);
                    }
                }
            }
        }
    }

    public void changeAllLookingRanged(int radius, Entity lookingAt, World world) {
        for (int i = 1; i < world.loadedEntityList.size(); i++) {
            Entity entity = (Entity) world.loadedEntityList.get(i);
            if (entity.getDistanceToEntity(lookingAt) <= radius) {
                entity.setAngles((float) VecUtils.getYaw(VecUtils.createVecFromEntity(lookingAt), VecUtils.createVecFromEntity(entity)), (float) VecUtils.getPitch(VecUtils.createVecFromEntity(lookingAt), VecUtils.createVecFromEntity(entity)));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1registerIcon) {
        this.itemIcon = par1registerIcon.registerIcon(ModTextures.GetTextureNameFull(this, Reference.TOOL_FOLDER));
    }
}
