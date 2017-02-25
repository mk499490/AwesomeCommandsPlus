package com.mk499490.awesomecommandsplus;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

/**
 * Created by Owner on 2016/08/11.
 */
public class CommandSetHome extends CommandBase {

    @Override
    public String getCommandName() {
        return "sethome";
    }

    @Override
    public String getCommandUsage(ICommandSender player) {
        return LanguageSwitcher.get("text.usage.sethome");
    }

    @Override
    public void processCommand(ICommandSender sender, String[] var) {
        if (!(sender instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer player = ((EntityPlayer) sender);
        String name = "";
        if (var.length != 0) {
            name = var[0];
        }
        double x = player.posX;
        double y = player.posY;
        double z = player.posZ;

        ExampleMod.config.put(name, new double[]{x, y, z});

        ExampleMod.save();

        ((EntityPlayer) sender).addChatComponentMessage(new ChatComponentText(LanguageSwitcher.get("text.homeSetSuccessful")));
    }
}