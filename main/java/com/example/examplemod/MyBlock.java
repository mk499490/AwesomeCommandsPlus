package com.example.examplemod;

/**
 * Created by Owner on 2016/08/08.
 */

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class MyBlock extends Block {
    public MyBlock() {
        super(Material.tnt);
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName(ExampleMod.MODID + "_" + "myblock");
        setBlockTextureName(ExampleMod.MODID + ":" + "myblock");
        setHardness(10.0f);
        setResistance(30.0f);
    }

}
