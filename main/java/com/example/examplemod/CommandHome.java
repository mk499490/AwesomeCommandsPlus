package com.example.examplemod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

/**
 * Created by Owner on 2016/08/11.
 */
public class CommandHome extends CommandBase {

    @Override
    public String getCommandName(){ return "home"; }

    @Override
    public String getCommandUsage(ICommandSender sender){ return LanguageSwitcher.get("text.usage.home"); }

    @Override
    public void processCommand(ICommandSender player, String[] var){
        //home command
    }

}