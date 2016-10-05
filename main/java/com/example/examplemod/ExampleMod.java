package com.example.examplemod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        /* ダイヤブロック
        GameRegistry.addRecipe(new ItemStack(Blocks.diamond_block),
                "AAA",
                "AAA",
                "AAA",
                'A', Blocks.dirt);

        // クリーパースポーンエッグ
        GameRegistry.addRecipe(new ItemStack(Items.spawn_egg, 1, 50),
                " A ",
                "CBC",
                "CBC",
                'A', new ItemStack(Items.skull, 1,4),
                'B', Blocks.tnt,
                'C', Items.gunpowder); */

        GameRegistry.registerBlock(new MyBlock(), "myBlock");

        customsword();
    }

    public void customsword() {
        Item sword = new MyItem();
        GameRegistry.registerItem(sword, "my_sword");

        GameRegistry.addRecipe(new ItemStack(sword, 1),
                " B ",
                "BAB",
                " B ",
                'A', new ItemStack(Items.diamond_sword),
                'B', Items.gunpowder);
    }
}
