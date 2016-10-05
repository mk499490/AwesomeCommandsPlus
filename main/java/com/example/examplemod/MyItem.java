package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by Owner on 2016/08/08.
 */
public class MyItem extends ItemSword {

    public MyItem() {
        super(EnumHelper.addToolMaterial("Original_Sword", 4, 2000, 16.0f, 1.0f, 22));
        setUnlocalizedName(ExampleMod.MODID + "_Original_Sword");
        setTextureName(ExampleMod.MODID + ":Original_Sword");
    }

    @Override
    public boolean hitEntity(ItemStack item, EntityLivingBase enemy, EntityLivingBase attacker){
        if (item == null) {
            return true;
        }

        if (!(attacker instanceof EntityPlayer)){
            return true;
        }

        enemy.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200, 1));

        enemy.worldObj.setBlock((int)enemy.posX + 1, (int)enemy.posY, (int)enemy.posZ, Blocks.glass);
        enemy.worldObj.setBlock((int)enemy.posX - 1, (int)enemy.posY, (int)enemy.posZ, Blocks.glass);
        enemy.worldObj.setBlock((int)enemy.posX, (int)enemy.posY, (int)enemy.posZ + 1, Blocks.glass);
        enemy.worldObj.setBlock((int)enemy.posX, (int)enemy.posY, (int)enemy.posZ - 1, Blocks.glass);

        enemy.worldObj.setBlock((int)enemy.posX + 1, (int)enemy.posY + 1, (int)enemy.posZ, Blocks.glass);
        enemy.worldObj.setBlock((int)enemy.posX - 1, (int)enemy.posY + 1, (int)enemy.posZ, Blocks.glass);
        enemy.worldObj.setBlock((int)enemy.posX, (int)enemy.posY + 1, (int)enemy.posZ + 1, Blocks.glass);
        enemy.worldObj.setBlock((int)enemy.posX, (int)enemy.posY + 1, (int)enemy.posZ - 1, Blocks.glass);

        return true;
    }
}
