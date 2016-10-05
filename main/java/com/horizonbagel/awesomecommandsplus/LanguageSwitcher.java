package com.horizonbagel.awesomecommandsplus;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

/**
 * Created by Owner on 2016/08/10.
 */
public class LanguageSwitcher {
    public static String get(String key){
        String str = LanguageRegistry.instance().getStringLocalization(key);
        if (str.length() == 0) {
            str = LanguageRegistry.instance().getStringLocalization(key, "en_US");
        } else {
            str = LanguageRegistry.instance().getStringLocalization(key);
        }
        return str;
    }
}
