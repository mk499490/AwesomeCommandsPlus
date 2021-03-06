package com.mk499490.awesomecommandsplus;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;

import java.io.*;
import java.util.HashMap;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0a";

    public static final Block RAINBOW = new BlockRainbow();
    public static final Block blocksound = new BlockSound();

    @EventHandler
    public void serverStart(FMLServerStartingEvent event){
        event.registerServerCommand(new CommandSpawn());
        event.registerServerCommand(new CommandBack());
        event.registerServerCommand(new CommandHome());
        event.registerServerCommand(new CommandSetHome());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code

        //ダイヤブロック
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
                'C', Items.gunpowder);

        GameRegistry.registerBlock(new MyBlock(), "myBlock");

        customSword();
        customFood();

        GameRegistry.registerBlock(RAINBOW, "rainbow");
        GameRegistry.registerBlock(blocksound, "BlockSound");

        GameRegistry.addShapelessRecipe(new ItemStack(RAINBOW), new ItemStack(Blocks.dirt)); //アイテムの数だけ指定している
    }



    public void customSword() {
        Item sword = new MyItem();
        GameRegistry.registerItem(sword, "my_sword");

        GameRegistry.addRecipe(new ItemStack(sword, 1),
                " B ",
                "BAB",
                " B ",
                'A', new ItemStack(Items.diamond_sword),
                'B', Items.gunpowder);
    }

    public void customFood(){

        PotionEffect[] onigiri = {
                new PotionEffect(Potion.regeneration.id, 1200, 1),
                new PotionEffect(Potion.damageBoost.id, 1200, 1),
                new PotionEffect(Potion.moveSpeed.id, 1200, 1),
                new PotionEffect(Potion.jump.id, 600, 0)
        };

        GameRegistry.registerItem(new ItemModFood("Onigiri", "Onigiri", 1, 0.5f, false, onigiri).setAlwaysEdible(), "Onigiri");

        PotionEffect[] poisonusOnigiri = {
                new PotionEffect(Potion.heal.id, 20, 29)
        };

        GameRegistry.registerItem(new ItemModFood("PoisonusOnigiri", "Onigiri", 1, 0.5f, false, poisonusOnigiri).setAlwaysEdible(), "PoisonusOnigiri");
        MinecraftForge.EVENT_BUS.register(new EntityExplodeEventHandler());
        MinecraftForge.EVENT_BUS.register(new EntityDeathEventHandler());
        MinecraftForge.EVENT_BUS.register(new BlockBreakEventHandler());
    }

    public static File dir;
    public static HashMap<String, Object> config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        dir = event.getModConfigurationDirectory();
        if(!dir.exists()){
            dir.mkdirs();
        }
        File file = new File(dir, "conf.conf");
        if(file.exists()){
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
                config = (HashMap<String, Object>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            config = new HashMap<String, Object>();
        }
    }

    public static void save(){
        File file = new File(dir, "conf.conf");
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(config);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
