/**
 *	TROUBLESHOOTING 3 INSTRUCTIONS
 *-----------------------------------
 *	1.	Set the Tool Material's Enchantability to 12
 *	2. 	Lower the Tool's Max Uses to 1 so that it is easy to break
 *	3. 	Fix any errors in the Pickaxe crafting recipe 
 *	4. 	Run Minecraft and open the Troubleshooting 3 map
 *	5.	Craft your Pickaxe from the materials from the chest
 *	6.	Mine the ore between the chest and crafting table to break your Pickaxe
 */

package mytroublemod;

import mytroublemod.items.TroublePickaxe;
import mytroublemod.items.TroubleSword;
import mytroublemod.tsconfig.TroubleEvent;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



/*
 *	MOD INFO
 */
		@Mod( modid = "troublemod", name = "Troublesome Mod", version = "T.S.")
		@NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class TroubleMain {
			
	
/**	DECLARATION SECTION 
 * =============================================================
 */

	//  DECLARE THE SWORD 
		public static Item TroubleSword_1;
	
	//  DECLARE THE PICKAXE 
		public static Item TroublePickaxe_1;
		
    //  DECLARE NEW TOOL MATERIAL
		public static EnumToolMaterial TroubleToolMaterial = EnumHelper.addToolMaterial("Trouble", 3, 1, 8.0F, 3.0F, 12);
		
		
/*
 * -------------------------------------------------------------	
 */

@EventHandler
	public  void preInit( FMLPreInitializationEvent event ) 
	{

/**	
 * 	LOAD SECTION 
 * ==========================================================	
 */
	
	//  LOAD THE SWORD
	    TroubleSword_1 = new TroubleSword(3021, TroubleToolMaterial, "TroubleSword_1");
	    GameRegistry.registerItem(TroubleSword_1, "TroubleSword_1");
	    LanguageRegistry.addName(TroubleSword_1, "Trouble Sword");

	//  LOAD THE PICKAXE
	    TroublePickaxe_1 = new TroublePickaxe(3022, TroubleToolMaterial, "TroublePickaxe_1");
	    GameRegistry.registerItem(TroublePickaxe_1, "TroublePickaxe_1");
	    LanguageRegistry.addName(TroublePickaxe_1, "Trouble Pickaxe");	    

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

}

@EventHandler
public static void init( FMLInitializationEvent event ) 
{

/**	
* RECIPES SECTION 
* *********************************************************** */

	//	SWORD RECIPE  
	    GameRegistry.addRecipe(new ItemStack(TroubleSword_1, 1), new Object[]
	    {
	            "X",
	            "X",
	            "S",
	        'S', Item.stick,
	        'X', Item.sugar,
	    });

	//	PICKAXE RECIPE  
	    GameRegistry.addRecipe(new ItemStack(TroublePickaxe_1, 1), new Object[]
	    {
	            "XXX",
	            " S ",
	            " S ",
	        'S', Item.stick,
	        'X', Item.sugar,
	    });	    

/*
 * --------------------------------------------------------------	
 */

	
	
/**
 * 	EXTRA SECTION
 * =========================================================================
 */


/* ********* | TS CODE - DO NOT TOUCH | ***************/			
	MinecraftForge.EVENT_BUS.register(new TroubleEvent());
	final TroubleEvent Trouble = new TroubleEvent();
    GameRegistry.registerCraftingHandler(Trouble);
/* ****************************************************/			
		

/*
 * --------------------------------------------------------------	
 */
	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}

}
