package com.SoulSkin.soultech.handler;

import static com.SoulSkin.soultech.util.LoaderHelper.isWildcardModLoaded;
import static cpw.mods.fml.common.Loader.isModLoaded;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class LoadedModsHandler {

	// Mod ID List //
	public static final String BuildCraftNameBase  = "BuildCraft|";
	public static final String BuildCraftCore      = "BuildCraft|Core";
	public static final String BuildCraftBuilders  = "BuildCraft|Builders";
	public static final String BuildCraftFactory   = "BuildCraft|Factory";
	public static final String BuildCraftSilicon   = "BuildCraft|Silicon";
	public static final String BuildCraftEnergy    = "BuildCraft|Energy";
	public static final String BuildCraftTransport = "BuildCraft|Transport";

	public static final String AE2              = "appliedenergistics2";
	public static final String BigReactors      = "BigReactors";
	public static final String BloodMagic       = "AWWayofTime";
	public static final String Botania          = "Botania";
	public static final String CarpentersBlocks = "CarpentersBlocks";
	public static final String ComputerCraft    = "ComputerCraft";
	public static final String EnderIO          = "EnderIO";
	public static final String EnderStorage     = "EnderStorage";
	public static final String ExtraCells       = "extracells";
	public static final String ExtraUtilities   = "ExtraUtilities";
	public static final String Factorization    = "factorization";
	public static final String Forestry         = "Forestry";
	public static final String Gendustry        = "gendustry";
	public static final String IguanaTweaks     = "IguanaTweaksTConstruct";
	public static final String IndustrialCraft2 = "IC2";
	public static final String IC2              = IndustrialCraft2;
	public static final String InventoryTweaks  = "inventorytweaks";
	public static final String IronChests       = "IronChest";
	public static final String Jabba            = "jabba";
	public static final String LogisticsPipes   = "LogisticsPipes|Main";

	public static final String Thaumcraft = "Thaumcraft";
	public static final String Mekanism   = "Mekanism";

	// Mod Loaded Checks //
	public static boolean isBuildcraftLoaded() {
		return isModLoaded( BuildCraftCore );
	}

	public static boolean isBuildcraftLoaded( String subMod ) {
		return isModLoaded( BuildCraftNameBase + subMod );
	}

	public static boolean isThaumcraftLoaded() {
		return isModLoaded( Thaumcraft );
	}

	public static boolean isMekanismLoaded() {
		return isModLoaded( Mekanism );
	}

	public static boolean isAE2Loaded() {
		return isModLoaded( AE2 );
	}

	public static boolean isBigReactorsLoaded() {
		return isModLoaded( BigReactors );
	}

	public static boolean isBloodMagicLoaded() {
		return isModLoaded( BloodMagic );
	}

	public static boolean isBotaniaLoaded() {
		return isModLoaded( Botania );
	}

	public static boolean isCarpentersBlocksLoaded() {
		return isModLoaded( CarpentersBlocks );
	}

	public static boolean isComputercraftLoaded() {
		return isModLoaded( ComputerCraft );
	}

	public static boolean isEnderIOLoaded() {
		return isModLoaded( EnderIO );
	}

	public static boolean isEnderStorageLoaded() {
		return isModLoaded( EnderStorage );
	}

	public static boolean isExtraUtilitiesLoaded() {
		return isModLoaded( ExtraUtilities );
	}

	public static boolean isExtraUtilsLoaded() {
		return isExtraUtilitiesLoaded();
	}

	public static boolean isFactorizationLoaded() {
		return isModLoaded( Factorization );
	}

	public static boolean isForestryLoaded() {
		return isModLoaded( Forestry );
	}

	public static boolean isIguanaTweaksLoaded() {
		return isModLoaded( IguanaTweaks );
	}

	public static boolean isIndustrialCraft2Loaded() {
		return isModLoaded( IndustrialCraft2 );
	}

	public static boolean isIC2Loaded() {
		return isIndustrialCraft2Loaded();
	}

	public static boolean isInventoryTweaksLoaded() {
		return isModLoaded( InventoryTweaks );
	}

	public static boolean isIronChestsLoaded() {
		return isModLoaded( IronChests );
	}

	public static boolean isJabbaLoaded() {
		return isModLoaded( Jabba );
	}

	public static boolean isLogisticsPipesLoaded() {
		return isModLoaded( Jabba );
	}

	// Multi-mod checks //
	public static boolean areChunkLoadersPresent() {
		return isModLoaded( "ChickenChunks" ) || isModLoaded( "RailCraft" );
	}

	public static boolean areMapsPresent() {
		return isModLoaded( "opis" ) || isWildcardModLoaded( "map" );
	}
}
