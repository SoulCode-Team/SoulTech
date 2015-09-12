package com.SoulSkin.soultech.item.tool;

import com.SoulSkin.soultech.handler.ConfigHandler;
import com.SoulSkin.soultech.lib.ModTextures;
import com.SoulSkin.soultech.lib.Reference;
import com.SoulSkin.soultech.util.StringUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

import java.util.List;
import java.util.Random;

public class weathermansCompass extends baseModTool {

    private IIcon itemIcon0;
    private IIcon itemIcon1;
    private IIcon itemIcon2;
    private IIcon itemIcon3;

    public weathermansCompass() {
        super();
        this.setUnlocalizedName("weathermans_Compass");
        this.setHasSubtypes(true);
        this.setMaxDurability(0);
    }


    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (par3EntityPlayer.isSneaking()) {
            this.setDamage(par1ItemStack, getDamage(par1ItemStack) < 3 ? getDamage(par1ItemStack) + 1 : 0);
        }
        else {
            int t = (300 + (new Random()).nextInt(600)) * 20;

            WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
            WorldInfo worldinfo = worldserver.getWorldInfo();
            worldinfo.setRainTime(t);
            worldinfo.setThunderTime(t);

            switch (getDamage(par1ItemStack)) {
                case 0:
                    worldinfo.setRaining(false);
                    worldinfo.setThundering(false);
                    break;

                case 1:
                    worldinfo.setRaining(true);
                    worldinfo.setThundering(false);
                    break;

                case 2:
                    worldinfo.setRaining(true);
                    worldinfo.setThundering(true);
                    break;

                case 3:
                    float f = 1.0F;
                    float f1 = par3EntityPlayer.prevRotationPitch + (par3EntityPlayer.rotationPitch - par3EntityPlayer.prevRotationPitch) * f;
                    float f2 = par3EntityPlayer.prevRotationYaw + (par3EntityPlayer.rotationYaw - par3EntityPlayer.prevRotationYaw) * f;
                    double d = par3EntityPlayer.prevPosX + (par3EntityPlayer.posX - par3EntityPlayer.prevPosX) * (double) f;
                    double d1 = (par3EntityPlayer.prevPosY + (par3EntityPlayer.posY - par3EntityPlayer.prevPosY) * (double) f + 1.6200000000000001D) - (double) par3EntityPlayer.yOffset;
                    double d2 = par3EntityPlayer.prevPosZ + (par3EntityPlayer.posZ - par3EntityPlayer.prevPosZ) * (double) f;
                    Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
                    float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
                    float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
                    float f5 = -MathHelper.cos(-f1 * 0.01745329F);
                    float f6 = MathHelper.sin(-f1 * 0.01745329F);
                    float f7 = f4 * f5;
                    float f8 = f6;
                    float f9 = f3 * f5;
                    double d3 = 5000D;
                    Vec3 vec3d1 = vec3d.addVector((double) f7 * d3, (double) f8 * d3, (double) f9 * d3);
                    MovingObjectPosition movingobjectposition = par2World.rayTraceBlocks(vec3d, vec3d1, false);
                    if (movingobjectposition == null) {
                        return par1ItemStack;
                    }
                    if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                        int i = movingobjectposition.blockX;
                        int j = movingobjectposition.blockY;
                        int k = movingobjectposition.blockZ;
                        par2World.spawnEntityInWorld(new EntityLightningBolt(par2World, i, j, k));
                    }
                    return par1ItemStack;

                default:
                    ;
            }
        }

        return par1ItemStack;
    }

    @Override
    public IIcon getIconFromDamage(int par1) {
        switch (par1) {
            case 0:
                return this.itemIcon0;
            case 1:
                return this.itemIcon1;
            case 2:
                return this.itemIcon2;
            case 3:
                return this.itemIcon3;
            default:
                return this.itemIcon0;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister par1registerIcon) {
        // this.itemIcon =
        // par1registerIcon.registerIcon("AdvancedCraft:tool/Weathermans_Compass");
        String universal = ModTextures.GetTextureFolder(Reference.TOOL_FOLDER) + this.getUnlocalizedName().substring(5);
        this.itemIcon0 = par1registerIcon.registerIcon(universal + "_Sun");
        this.itemIcon1 = par1registerIcon.registerIcon(universal + "_Rain");
        this.itemIcon2 = par1registerIcon.registerIcon(universal + "_Thunder");
        this.itemIcon3 = par1registerIcon.registerIcon(universal + "_Lighting");
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List list, boolean par4) {
        if (!ConfigHandler.disableWeathermansCompass) {
            switch (getDamage(par1ItemStack)) {
                case 0:
                    list.add(StringUtils.localizeString("tooltips.weather.sun"));
                    break;
                case 1:
                    list.add(StringUtils.localizeString("tooltips.weather.rain"));
                    break;
                case 2:
                    list.add(StringUtils.localizeString("tooltips.weather.thunder"));
                    break;
                case 3:
                    list.add(StringUtils.localizeString("tooltips.weather.lightning"));
                    break;
            }
            list.add(StringUtils.getTooltipLocalized(this, 1));
        }
        else {
            list.add(StringUtils.localizeString("tooltips.status.disabled"));
        }
    }
}