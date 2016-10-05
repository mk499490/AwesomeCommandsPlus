package com.horizonbagel.awesomecommandsplus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
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

        Item item = player.getHeldItem().getItem();

        if (item != Items.stick){
            return;
        }

        int meta = world.getBlockMetadata(x, y, z); //ブロックのメタデータを取得、代入。

        world.playSoundAtEntity(player, ExampleMod.MODID + ":" + "Sound" + meta, 0.3f, 1.0f);   //meta変数の値と音源の番号が対応するようにしている

        if(!world.isRemote){    //チャットに2回出ない様にするための対策
            String s = Integer.toString(meta + 1);  //型変換と代入
            player.addChatComponentMessage(new ChatComponentText(s + "番目の曲を再生中です"));
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float posX, float posY, float posZ) {
        int meta = world.getBlockMetadata(x, y, z); //メタデータ取得

        meta = meta + 1; //1を足す

        if (meta > 2) {
            meta = 0;   //2を超えていたら0にする
        }

        world.setBlockMetadataWithNotify(x, y, z, meta, 2); //ブロックのmetaデータに値を戻す

        if(!world.isRemote){
            if (meta == 0){
                player.addChatComponentMessage(new ChatComponentText(LanguageSwitcher.get("text.blockSound.changedToThe1stSong")));
            }
            if (meta == 1){
                player.addChatComponentMessage(new ChatComponentText(LanguageSwitcher.get("text.blockSound.changedToThe2ndSong")));
            }
            if (meta == 2){
                player.addChatComponentMessage(new ChatComponentText(LanguageSwitcher.get("text.blockSound.changedToThe3rdSong")));
            }
        }

        return true;
    }
}
