package com.SoulSkin.soultech.util;

import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

import static com.SoulSkin.soultech.lib.Reference.MOD_NAME;
import static java.lang.String.valueOf;
import static org.apache.logging.log4j.Level.*;

/**
 * Created by John on 6/2/2015.
 * SoulTech is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * SoulTech is licensed under GPLv2. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class ModLogger {

    public static void log(Level logLevel, Object object) {
        FMLLog.log(MOD_NAME, logLevel, valueOf(object));
    }

    public static void all(Object object) {
        log(ALL, object);
    }

    public static void debug(Object object) {
        log(DEBUG, object);
    }

    public static void error(Object object) {
        log(ERROR, object);
    }

    public static void fatal(Object object) {
        log(FATAL, object);
    }

    public static void info(Object object) {
        log(INFO, object);
    }

    public static void off(Object object) {
        log(OFF, object);
    }

    public static void trace(Object object) {
        log(TRACE, object);
    }

    public static void warn(Object object) {
        log(WARN, object);
    }
}
