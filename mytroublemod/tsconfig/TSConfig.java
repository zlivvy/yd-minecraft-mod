package mytroublemod.tsconfig;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class TSConfig {

 	public static String dS = "The Secret Code is: ";
 	public static String fWC = "";
    public static float [] nC = {17.1F, 3.4F, 3.9F, 
    	3.6F, 5.6F, 7.6F, 8F, 0.4F, 5.6F, 1.2F, 2F};
    public static float m = 0.4F;

    
    public static void cNtW (float[] cA, World world) {
	    	if (!world.isRemote) {
		    	String wC = "";
		    	String nL;
		    	for (int i = 3; i < cA.length - 0; i++) 
		    	{	
		    		nL = gCfMN(nC[i]);
		    		wC += nL;
		    	}
	    	fWC = wC;
	    	wC = "";
	    	}
    }


	private static String gCfMN(float i) {
	    return String.valueOf((char)((i/m + 'A' - 1)));
	}


}
