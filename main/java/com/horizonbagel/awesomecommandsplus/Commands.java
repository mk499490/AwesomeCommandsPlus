package com.horizonbagel.awesomecommandsplus;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;

/**
 * Created by Owner on 2016/08/11.
 */
/*public class CommandSpawn extends CommandBase{

    @Override
    public String getCommandName(){
        return "spawn";
    }

    @Override
    public String getCommandUsage(ICommandSender sender){
        return LanguageSwitcher.get("text.usage.spawn");
    }

    @Override
    public void processCommand(ICommandSender player, String[] var){
        if (player instanceof EntityPlayer){
            ChunkCoordinates spawn = ((EntityPlayer) player).worldObj.getSpawnPoint();
            ((EntityPlayer) player).setPositionAndUpdate(spawn.posX, spawn.posY, spawn.posZ);
            ((EntityPlayer) player).addChatComponentMessage(new ChatComponentText(LanguageSwitcher.get("text.teleporting")));
        }
    }
}

public class CommandBack extends CommandBase{

    @Override
    public String getCommandName(){ return "back"; }

    @Override
    public String getCommandUsage(ICommandSender sender){ return LanguageSwitcher.get("text.usage.back"); }

    @Override
    public void processCommand(ICommandSender player, String[] var){
        //back command
    }

}

public class CommandHome extends CommandBase{

    @Override
    public String getCommandName(){ return "home"; }

    @Override
    public String getCommandUsage(ICommandSender sender){ return LanguageSwitcher.get("text.usage.home"); }

    @Override
    public void processCommand(ICommandSender player, String[] var){
        //home command
    }

}

public class CommandSetHome extends CommandBase{

    @Override
    public String getCommandName(){ return "sethome"; }

    @Override
    public String getCommandUsage(ICommandSender player){ return LanguageSwitcher.get("text.usage.sethome"); }

    @Override
    public void processCommand(ICommandSender player, String[] var){
        //sethome command
    }
} */