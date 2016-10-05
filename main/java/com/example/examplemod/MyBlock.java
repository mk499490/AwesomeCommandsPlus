package com.example.examplemod;

/**
 * Created by Owner on 2016/08/08.
 */

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
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

    public IIcon[] icons = new IIcon[6];

    @Override
    public boolean isOpaqueCube() {
        return true;    //普通のブロックと同じ判定にする。
    }

    @Override
    public void registerBlockIcons(IIconRegister register){
        for (int i = 0; i < 6; i++) {
            this.icons[i] = register.registerIcon(textureName + "_" + i); //画像貼り
        }
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        return icons[side];
    }

}
