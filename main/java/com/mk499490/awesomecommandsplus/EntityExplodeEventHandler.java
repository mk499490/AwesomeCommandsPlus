package com.mk499490.awesomecommandsplus;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.world.ExplosionEvent;

/**
 * Created by Owner on 2016/08/10.
 */
public class EntityExplodeEventHandler {
    @SubscribeEvent
    public void onEntityExplode(ExplosionEvent event){
        Entity exploder = event.explosion.exploder;
        if (exploder instanceof EntityCreeper) {
            event.setCanceled(true);
            //System.out.println("EntityExplodeEventHandler.onEntityExplode");
        }
    }
}
