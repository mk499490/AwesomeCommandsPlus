package com.mk499490.awesomecommandsplus;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

/**
 * Created by Owner on 2016/08/11.
 */
public class EntityDeathEventHandler {
    public static double x = 0;
    public static double y = 0;
    public static double z = 0;

    @SubscribeEvent
    public void onEntityDeath(LivingDeathEvent event) {
        if (event.entity instanceof EntityPlayer) {
            x = event.entity.posX;
            y = event.entity.posY;
            z = event.entity.posZ;
        }

    }
}
