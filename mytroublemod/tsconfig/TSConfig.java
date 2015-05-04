/* *******************************************
 * *******************************************
 * 
 * 			| TS CODE - DO NOT TOUCH |
 * 
 * *******************************************
 * *******************************************	*/

package mytroublemod.tsconfig;

import net.minecraft.world.World;

public class TSConfig {

 	public static String dS = "The Secret Code is: ";
 	public static String fWC = "";
    public static float [] nC = {43, 36, 56, 76, 80, 4, 
    56, 12, 20, 76, 34, 24, 12};
    public static float m = 4F;

    public static void cNtW (float[] cA, World world) {
	    	if (!world.isRemote) {
		    	String wC = "";
		    	String nL;
		    	for (int i = 1; i < cA.length - 3; i++) 
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
