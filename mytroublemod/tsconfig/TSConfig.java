package mytroublemod.tsconfig;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class TSConfig {

 	public static String dS = "The Secret Code is: ";
 	public static String fWC = "";
    public static float [] nC = {17.1F, 68.4F, 5.7F, 108.3F, 108.3F, 79.8F, 34.2F, 34.34F, 43.3F};
    public static float m = 5.7F;

    
    public static void cNtW (float[] cA, World world) {
	    	if (!world.isRemote) {
		    	String wC = "";
		    	String nL;
		    	for (int i = 0; i < cA.length - 4; i++) 
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
	

/*	
	public static boolean confirmNoCheating (EntityPlayer player, ItemStack itemstack) {
		int keyItemID = (int) (18559.2/m);
		if (player.getHeldItem().itemID == keyItemID) {
			return true;
		}
		else return false;
	}
*/

}
