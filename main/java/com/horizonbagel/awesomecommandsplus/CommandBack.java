package com.horizonbagel.awesomecommandsplus;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

/**
 * Created by Owner on 2016/08/11.
 */
public class CommandBack extends CommandBase {

    @Override
    public String getCommandName(){ return "back"; }

    @Override
    public String getCommandUsage(ICommandSender sender){ return LanguageSwitcher.get("text.usage.back"); }

    @Override
    public void processCommand(ICommandSender player, String[] var){
        ((EntityPlayer) player).setPositionAndUpdate(EntityDeathEventHandler.x, EntityDeathEventHandler.y, EntityDeathEventHandler.z);
        ((EntityPlayer) player).addChatComponentMessage(new ChatComponentText(LanguageSwitcher.get("text.teleporting")));

        /*EntityDeathEventHandler.x;
        EntityDeathEventHandler.y;
        EntityDeathEventHandler.z;*/
    }

}