package mymod;

import mymod.blocks.MyBlock;
import mymod.items.MyFood;
import mymod.items.MyItem;
import mymod.items.MyPickaxe;
import mymod.items.MySword;
import mymod.proxies.CommonProxy;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;


/* 	MOD INFO */
	@Mod( modid = "mymod", name = "My Awesome Mod", version = "1.0")
	@NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class Main {

/*	PROXY INFO */
	@SidedProxy(clientSide = "mymod.proxies.ClientProxy", serverSide = "mymod.proxies.CommonProxy")
	public static CommonProxy proxy;
		
	
/**	
 * DECLARATION SECTION 
 * *********************************************************** */
	
//  DECLARE THE SWORD 
    public static Item MySword_1;

//  DECLARE THE PICKAXE 
    public static Item MyPickaxe_1;
    
//  DECLARE NEW TOOL MATERIAL
    /** Harvest Level, Max Uses, Efficiency (f), Damage (f), Enchantability */ 
    public static EnumToolMaterial MyToolMaterial = EnumHelper.addToolMaterial("Rainbow", 3, 600, 12.0F, 18.0F, 24);

    //  DECLARE THE ITEM
    public static Item MyItem_1;
    
//  DECLARE THE FOOD
    public static Item MyFood_1;
    
//  DECLARE THE BLOCK
    public static Block MyBlock_1;

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{
/**	
 * LOAD SECTION 
 * *********************************************************** */ 
//  LOAD THE SWORD
    MySword_1 = new MySword(2021, MyToolMaterial, "MySword_1");
    GameRegistry.registerItem(MySword_1, "MySword_1");
    LanguageRegistry.addName(MySword_1, "Ultimate Element Sword");
    
    
//  LOAD THE PICKAXE
    MyPickaxe_1 = new MyPickaxe(2022, MyToolMaterial, "MyPickaxe_1");
    GameRegistry.registerItem(MyPickaxe_1, "MyPickaxe_1");
    LanguageRegistry.addName(MyPickaxe_1, "Rainbow Pickaxe");

    
//  LOAD THE ITEM
    MyItem_1 = new MyItem(2030, "MyItem_1").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(16);
    GameRegistry.registerItem(MyItem_1, "MyItem_1");
    LanguageRegistry.addName(MyItem_1, "Rainbow Drop");

    
//  LOAD THE FOOD
    /** idemID, healAmount, saturationModifier (F), isWolfsFavoriteMeat, Texture Name */
    MyFood_1 = new MyFood(2040, 10, 10.0F, true, "MyFood_1").setAlwaysEdible().setCreativeTab(CreativeTabs.tabFood);
    GameRegistry.registerItem(MyFood_1, "MyFood_1");
    LanguageRegistry.addName(MyFood_1, "Rainbow Popcicle"); 
    

    //  LOAD THE BLOCK 
    MyBlock_1 = new MyBlock(250, Material.rock, "MyBlock_1").setLightValue(0.9375F).setResistance(5.0F).setHardness(0.5F);
    GameRegistry.registerBlock(MyBlock_1, "MyBlock_1");
    LanguageRegistry.addName(MyBlock_1, "Cloud"); 
	MinecraftForge.setBlockHarvestLevel(MyBlock_1, "pickaxe", 0);
	
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	}

@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{
	
/**	
 * RECIPES SECTION 
 * *********************************************************** */
//  SWORD RECIPE  
    GameRegistry.addRecipe(new ItemStack(MySword_1, 1), new Object[]
    {
            "XXX",
            "XXX",
            " S ",
        'S', Item.stick,
        'X', MyItem_1,
    });
    

    //  PICKAXE RECIPE  
    GameRegistry.addRecipe(new ItemStack(MyPickaxe_1, 1), new Object[]
    {
            "XXX",
            " S ",
            " S ",
        'S', Item.stick,
        'X', MyItem_1,
    });
    
    
    //  ITEM RECIPE         
    GameRegistry.addRecipe(new ItemStack(MyItem_1, 1), new Object[]
    {
            "S S",
            " S ",
            "S S",
        'S', Block.waterMoving,
       
    });
    
    
//  FOOD RECIPE         
    GameRegistry.addRecipe(new ItemStack(MyFood_1, 1), new Object[]
    {
            "XS",
            "SX",
        'S', MyItem_1,
        'X', Block.ice
    
    });
    
    
//  SMELTING RECIPE
    GameRegistry.addSmelting(MyBlock_1.blockID, (new ItemStack(MyBlock_1, 1)), 1);


	

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */


        


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	
}
