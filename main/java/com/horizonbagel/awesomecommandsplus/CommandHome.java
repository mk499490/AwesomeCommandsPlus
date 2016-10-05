package com.horizonbagel.awesomecommandsplus;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

/**
 * Created by Owner on 2016/08/11.
 */
public class CommandHome extends CommandBase {

    @Override
    public String getCommandName(){ return "home"; }

    @Override
    public String getCommandUsage(ICommandSender sender){ return LanguageSwitcher.get("text.usage.home"); }

    @Override
    public void processCommand(ICommandSender sender, String[] var){
        //home command
        if (!(sender instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer player = ((EntityPlayer) sender);
        String name = "";
        if (var.length != 0) {
            name = var[0];
        }

        if (ExampleMod.config.containsKey(name)) {
            double[] position = (double[]) ExampleMod.config.get(name);
            ((EntityPlayer) player).setPositionAndUpdate(position[0], position[1], position[2]);
            ((EntityPlayer) player).addChatComponentMessage(new ChatComponentText(LanguageSwitcher.get("text.teleporting")));
        } else {
            ((EntityPlayer) player).addChatComponentMessage(new ChatComponentText(LanguageSwitcher.get("text.homeNotFound")));
        }
    }

}