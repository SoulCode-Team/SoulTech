package com.SoulSkin.soultech.util;

import static cpw.mods.fml.common.Loader.instance;
import static cpw.mods.fml.common.Loader.isModLoaded;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class LoaderUtils {

    public static boolean isWildcardModLoaded(String modidSubstring) {
        return (getWildcardModId(modidSubstring).length > 0);
    }

    public static String[] getWildcardModId(String modidSubstring) {
        String[] returnStringArray = null;
        String[] setStrings = (String[]) instance().getIndexedModList().keySet().toArray();
        for (String s : setStrings) {
            if (s.contains(modidSubstring) && isModLoaded(s)) {
                returnStringArray[returnStringArray.length] = s;
            }
        }
        return returnStringArray;
    }
}
