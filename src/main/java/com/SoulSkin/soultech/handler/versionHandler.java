package com.SoulSkin.soultech.handler;

import com.SoulSkin.soultech.lib.Reference;
import com.SoulSkin.soultech.util.StringUtils;

import java.io.*;
import java.net.URL;

/**
 * Created by John on 6/2/2015.
 * is a Minecraft mod, and as such follows Mojang's TOS
 * and license.
 * GOL is licensed under GPLv. See COPYING* files for more.
 * Copyright (c) 2015 SoulSkin and SoulCode Team.
 */
public class versionHandler {

    /**
     * Retrieves latest
     *
     * @return String of version
     */
    private static String getLatestVersion() {
        String version = "";
        try {
            URL buildFile = new URL("https://rawgit.com/SoulSkin/SoulTech/master/build.properties");
            BufferedReader in = new BufferedReader(new InputStreamReader(buildFile.openStream()));
            String inputLine = in.readLine();
            version = inputLine.substring(inputLine.indexOf(" = ") + 3);
            in.close();
        }
        catch (IOException e) {
            version = "No version file found on server.";
        }
        return version;
    }

    public static boolean isDevVersion() {
        return Reference.VERSION == "@VERSION@";
    }

    public static String getVersionMessage() {
        return isLatestVersion() ? StringUtils.localizeString("message.version.current") : (isDevVersion() ? StringUtils.localizeString("message.version.dev") : StringUtils.localizeString("message.version.old"));
    }

    public static boolean isLatestVersion() {
        return Reference.VERSION == getLatestVersion();
    }
}
