package com.mk499490.awesomecommandsplus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Owner on 2016/08/09.
 */
public class BlockRainbow extends Block {
    public IIcon[] icons = new IIcon[7];

    public BlockRainbow(){
        super(Material.tnt);
        setCreativeTab(CreativeTabs.tabBlock);

        setBlockName(ExampleMod.MODID + "BlockRainbow");    //ブロックの名前
        setBlockTextureName(ExampleMod.MODID + ":" + "rainbow"); //テクスチャの名前

        setHardness(100F); //ブロックの硬さ
    }

    //ブロックを叩くごとに色の違うテクスチャを貼る
    @Override
    public void registerBlockIcons(IIconRegister register){
        for(int i = 0; i < 7; i++){
            this.icons[i] = register.registerIcon(textureName + "_" + i);
        }
    }

    @Override
    public IIcon getIcon(int side, int metadata){
        return icons[metadata];
    }

    //ブロックを叩くごとに色が変わる
    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
        int meta = world.getBlockMetadata(x, y, z);
        meta = meta + 1;
        if (meta >= 7){
            meta = 0;
        }
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }
}
