package com.example.examplemod;

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
public class BlockSound extends Block {
    public IIcon[] icons = new IIcon[6];

    public BlockSound(){
        super(Material.tnt);
        setCreativeTab(CreativeTabs.tabDecorations);
        setBlockName(ExampleMod.MODID + "_" + "blocksound");
        setBlockTextureName(ExampleMod.MODID + ":" + "soundblock");
        setHardness(3.0f);
        setResistance(30.0f);
    }

    @Override
    public void registerBlockIcons(IIconRegister register){
        for (int i = 0; i < 6; i++){
            this.icons[i] = register.registerIcon(textureName + "_" + i);
        }
    }

    @Override
    public IIcon getIcon(int side, int metadata){
        return icons[side];
    }


    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
        if (player == null){
            return;
        }

        if(player.getHeldItem() == null){
            return;
        }

        Item item // 「サウンドブロック ブロックを左クリックした時の処理を書こう！①」の続きから
    }
}
