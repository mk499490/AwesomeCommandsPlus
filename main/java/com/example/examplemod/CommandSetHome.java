package com.example.examplemod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

/**
 * Created by Owner on 2016/08/11.
 */
public class CommandSetHome extends CommandBase {

    @Override
    public String getCommandName(){ return "sethome"; }

    @Override
    public String getCommandUsage(ICommandSender player){ return LanguageSwitcher.get("text.usage.sethome"); }

    @Override
    public void processCommand(ICommandSender player, String[] var){
        //sethome command
    }
}