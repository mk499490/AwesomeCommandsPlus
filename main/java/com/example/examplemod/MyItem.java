package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Owner on 2016/08/08.
 */
public class MyItem extends Item {

    public MyItem() {
        setUnlocalizedName(ExampleMod.MODID + "_Original_Sword");
        setTextureName(ExampleMod.MODID + ":Original_Sword");
        setCreativeTab(CreativeTabs.tabTools);
    }
}
