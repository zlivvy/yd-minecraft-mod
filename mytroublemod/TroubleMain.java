/**	TROUBLESHOOTING 2 INSTRUCTIONS
 *-----------------------------------
 *	1.	Fix all the Errors in this Java Class
 *	2. 	Run Minecraft and Open the Troubleshooting 2 Map
 *  3.  Craft Your TroubleSword from the materials provided in the chest
 */

package mytroublemod;

import mytroublemod.items.TroubleSword;
import mytroublemod.tsconfig.TroubleEvent;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
	    TroubleSword_1 = new TroubleSword(3021, EnumToolMaterial.IRON, "TroubleSword_1");
	    GameRegistry.registerItem(TroubleSword_1, "TroubleSword_1");
	    LanguageRegistry.addName(TroubleSword_1, "Trouble Sword");


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
	            " S ",
	            " S ",
	            " X ",
	        'T', Item.sugar,
	        'X', Item.stick,
	    });


/*
 * --------------------------------------------------------------	
 */

	
	
/**
 * 	EXTRA METHODS SECTION
 * =========================================================================
 */


/* ********* | TS CODE - DO NOT TOUCH | ****************/			
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
