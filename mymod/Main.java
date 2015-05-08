 package mymod;

import java.awt.Color;

import mymod.armor.MyArmor;
import mymod.biome.MyBiome;
import mymod.blocks.MyBlock;
import mymod.blocks.MyBlockGen;
import mymod.entity.spider.MyEntitySpider;
import mymod.entity.spider.MyRenderSpider;
import mymod.entity.wraith.MyEntityWraith;
import mymod.entity.wraith.MyModelWraith;
import mymod.entity.wraith.MyRenderWraith;
import mymod.items.MyFood;
import mymod.items.MyItem;
import mymod.items.MyPickaxe;
import mymod.items.MySword;
import mymod.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


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
    
//  DECLARE THE RAINBOW POPCICLE
    public static Item MyFood_1;
    
//  DECLARE THE RAINBOW JUICE
    public static Item MyFood_2;
    
//  DECLARE THE BLOCK
    public static Block MyBlock_1;
    
//  DECLARE THE ARMOR
    public static Item MyHelmet_1;
    public static Item MyChest_1;
    public static Item MyLeggings_1;
    public static Item MyBoots_1;
    
//  DECLARE THE ARMOR MATERIAL
    												/** maxDamageFactor, damageReductionAmountArray, enchantability */
    public static EnumArmorMaterial MyArmorMaterial_1 = EnumHelper.addArmorMaterial("Rainbow", 100, new int[]{3, 8, 6, 3}, 50);
    
//  DECLARE THE BIOME
    public static  BiomeGenBase MyBiome_1; 
    
//  DECLARE THE MOB ID
    static int MyEntityID = 300;
    
//  SEARCH FOR UNIQUE ID    
    public static int getUniqueEntityId() {
        do {
            MyEntityID++;
        }
        while (EntityList.getStringFromID(MyEntityID) != null);
        return MyEntityID++;
    }
    
//  DECLARE A NEW EGG
    public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor) {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    } 

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
    LanguageRegistry.addName(MySword_1, "Rainbow Sword");
    
    
//  LOAD THE PICKAXE
    MyPickaxe_1 = new MyPickaxe(2022, MyToolMaterial, "MyPickaxe_1");
    GameRegistry.registerItem(MyPickaxe_1, "MyPickaxe_1");
    LanguageRegistry.addName(MyPickaxe_1, "Rainbow Pickaxe");

    
//  LOAD THE ITEM
    MyItem_1 = new MyItem(2030, "MyItem_1").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(16);
    GameRegistry.registerItem(MyItem_1, "MyItem_1");
    LanguageRegistry.addName(MyItem_1, "Rainbow Drop");

    
//  LOAD THE RAINBOW POPCICLE
    /** idemID, healAmount, saturationModifier (F), isWolfsFavoriteMeat, Texture Name */
    MyFood_1 = new MyFood(2040, 10, 10.0F, true, "MyFood_1").setAlwaysEdible().setCreativeTab(CreativeTabs.tabFood);
    GameRegistry.registerItem(MyFood_1, "MyFood_1");
    LanguageRegistry.addName(MyFood_1, "Rainbow Popcicle"); 
    
    
//  LOAD THE RAINBOW POPCICLE
    /** idemID, healAmount, saturationModifier (F), isWolfsFavoriteMeat, Texture Name */
    MyFood_2 = new MyFood(2041, 11, 11.0F, true, "MyFood_2").setAlwaysEdible().setCreativeTab(CreativeTabs.tabFood);
    GameRegistry.registerItem(MyFood_2, "MyFood_2");
    LanguageRegistry.addName(MyFood_2, "Rainbow Juice");
    

    //  LOAD THE BLOCK 
    MyBlock_1 = new MyBlock(250, Material.rock, "MyBlock_1").setLightValue(0.9375F).setResistance(5.0F).setHardness(3.0F).setStepSound(Block.soundStoneFootstep);
    GameRegistry.registerBlock(MyBlock_1, "MyBlock_1");
    LanguageRegistry.addName(MyBlock_1, "Rainbow Ore"); 
	MinecraftForge.setBlockHarvestLevel(MyBlock_1, "pickaxe", 0);
	
	
//  LOAD HELMET 
    MyHelmet_1 = new MyArmor(2060, MyArmorMaterial_1, 0, 0, "myarmor");
    GameRegistry.registerItem(MyHelmet_1, "MyHelmet_1");
    LanguageRegistry.addName(MyHelmet_1, "Rainbow Helmet");      

//LOAD CHESTPLATE
    MyChest_1 = new MyArmor(2061, MyArmorMaterial_1, 0, 1, "myarmor");
    GameRegistry.registerItem(MyChest_1, "MyChest_1");
    LanguageRegistry.addName(MyChest_1, "Rainbow Chestplate");

//LOAD LEGGINGS    
    MyLeggings_1 = new MyArmor(2062, MyArmorMaterial_1, 0, 2, "myarmor");
    GameRegistry.registerItem(MyLeggings_1, "MyLeggings_1");
    LanguageRegistry.addName(MyLeggings_1, "Rainbow Leggings");

//LOAD BOOTS   
    MyBoots_1 = new MyArmor(2063, MyArmorMaterial_1, 0, 3, "myarmor");
    GameRegistry.registerItem(MyBoots_1, "MyBoots_1");
    LanguageRegistry.addName(MyBoots_1, "Rainbow Boots");
    
//  LOAD BIOME
    MyBiome_1 = new MyBiome(30);
    GameRegistry.addBiome(MyBiome_1);
    
//REMOVE OTHER BIOMES
    GameRegistry.removeBiome(BiomeGenBase.beach);
    //GameRegistry.removeBiome(BiomeGenBase.desert);
    GameRegistry.removeBiome(BiomeGenBase.desertHills);
    GameRegistry.removeBiome(BiomeGenBase.desertHills);
    GameRegistry.removeBiome(BiomeGenBase.extremeHills);
    GameRegistry.removeBiome(BiomeGenBase.extremeHillsEdge);
    GameRegistry.removeBiome(BiomeGenBase.forest);
    GameRegistry.removeBiome(BiomeGenBase.forestHills);
    GameRegistry.removeBiome(BiomeGenBase.frozenOcean);
    GameRegistry.removeBiome(BiomeGenBase.frozenRiver);
    //GameRegistry.removeBiome(BiomeGenBase.iceMountains);
    //GameRegistry.removeBiome(BiomeGenBase.icePlains);
    //GameRegistry.removeBiome(BiomeGenBase.jungle);
    //GameRegistry.removeBiome(BiomeGenBase.jungleHills);
    GameRegistry.removeBiome(BiomeGenBase.mushroomIsland);
    GameRegistry.removeBiome(BiomeGenBase.ocean);
    GameRegistry.removeBiome(BiomeGenBase.plains);
    GameRegistry.removeBiome(BiomeGenBase.river);
    GameRegistry.removeBiome(BiomeGenBase.swampland);
    GameRegistry.removeBiome(BiomeGenBase.taiga);
    GameRegistry.removeBiome(BiomeGenBase.taigaHills);
    
//  REGISTER YOUR ENTITY
    EntityRegistry.registerGlobalEntityID(MyEntitySpider.class, "Rainbow Spider", EntityRegistry.findGlobalUniqueEntityId());
    EntityRegistry.addSpawn(MyEntitySpider.class, 70, 5, 25, EnumCreatureType.monster, BiomeGenBase.jungle); 
    EntityRegistry.addSpawn(MyEntitySpider.class, 70, 5, 25, EnumCreatureType.monster, MyBiome_1);      
    EntityRegistry.addSpawn(MyEntitySpider.class, 70, 5, 25, EnumCreatureType.monster, BiomeGenBase.jungleHills); 
    registerEntityEgg(MyEntitySpider.class, (new Color(255, 255, 255)).getRGB(), (new Color(255, 255, 255)).getRGB());
    RenderingRegistry.registerEntityRenderingHandler(MyEntitySpider.class, new MyRenderSpider());
    ModLoader.addLocalization("entity.Rainbow Spider.name", "Rainbow Spider");
    
//  REGISTER YOUR ENTITY
    EntityRegistry.registerGlobalEntityID(MyEntityWraith.class, "Raith", EntityRegistry.findGlobalUniqueEntityId());
    EntityRegistry.addSpawn(MyEntitySpider.class, 70, 5, 25, EnumCreatureType.monster, BiomeGenBase.jungle); 
    EntityRegistry.addSpawn(MyEntitySpider.class, 70, 5, 25, EnumCreatureType.monster, MyBiome_1);      
    EntityRegistry.addSpawn(MyEntitySpider.class, 70, 5, 25, EnumCreatureType.monster, BiomeGenBase.jungleHills);  
    registerEntityEgg(MyEntityWraith.class, (new Color(0, 0, 0)).getRGB(), (new Color(0, 0, 0)).getRGB());
    RenderingRegistry.registerEntityRenderingHandler(MyEntityWraith.class, new MyRenderWraith(new MyModelWraith(), 0.3F));
    ModLoader.addLocalization("entity.Raith.name", "Raith");
	
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
            "SSS",
            "SXS",
            "SSS",
        'S', Item.bucketWater,
        'X', Block.glowStone,
       
    });
    
    
//  RAINBOW POPCICLE RECIPE         
    GameRegistry.addRecipe(new ItemStack(MyFood_1, 1), new Object[]
    {
            "XS",
            "SX",
        'S', MyItem_1,
        'X', Block.ice,
    
    });
    
    
//  RAINBOW JUICE RECIPE        
    GameRegistry.addRecipe(new ItemStack(MyFood_1, 1), new Object[]
    {
            " S ",
            "SSS",
            "SSS",
        'S', MyItem_1,
    
    });
    
    
//  SMELTING RECIPE
    GameRegistry.addSmelting(MyBlock_1.blockID, (new ItemStack(MyItem_1, 1)), 1);


//  HELMET RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyHelmet_1, 1), new Object[]
    {
            "XXX",
            "X X",
        'X', MyItem_1,
    });         

//  CHESTPLATE RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyChest_1, 1), new Object[]
    {
            "X X",
            "XXX",
            "XXX",
        'X', MyItem_1,
    });         

//  LEGGINGS RECIPE 
    GameRegistry.addRecipe(new ItemStack(MyLeggings_1, 1), new Object[]
    {
            "XXX",
            "X X",
            "X X",
        'X', MyItem_1,
    });         

//  BOOTS RECIPE    
    GameRegistry.addRecipe(new ItemStack(MyBoots_1, 1), new Object[]
    {
            "X X",
            "X X",
        'X', MyItem_1,
    });  

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */

//  REGISTER THE ORE GENERATION 
    GameRegistry.registerWorldGenerator(new MyBlockGen());
        


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	
}
