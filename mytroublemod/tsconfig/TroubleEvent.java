/* *******************************************
 * *******************************************
 * 
 * 			| TS CODE - DO NOT TOUCH |
 * 
 * *******************************************
 * *******************************************	*/

package mytroublemod.tsconfig;

import mytroublemod.TroubleMain;
import mytroublemod.entity.troublecow.EntityTroubleCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import cpw.mods.fml.common.ICraftingHandler;


public class TroubleEvent implements ICraftingHandler
{

	private boolean craftedFood = false;
	private boolean craftedBlock = false;
	private boolean troubleDone = false;
	
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix)
	{
	
		if (!player.worldObj.isRemote
			&&	item.getItem().itemID == TroubleMain.TroubleFood_2.itemID
			&& craftedBlock
			&& !troubleDone) 
		{
				TSConfig.cNtW(TSConfig.nC, player.worldObj);
				ModLoader.getMinecraftInstance().thePlayer.addChatMessage(TSConfig.dS + TSConfig.fWC);
				craftedFood = true;	
				troubleDone = true;
		}
		if (!player.worldObj.isRemote
			&&	item.getItem().itemID == TroubleMain.TroubleFood_2.itemID
			&& !craftedBlock
			&& !troubleDone) 
		{
				TSConfig.cNtW(TSConfig.nC, player.worldObj);
				ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Great! Now Craft that Block!");
				craftedFood = true;	
		}
		if (!player.worldObj.isRemote
			&&	item.getItem().itemID == TroubleMain.TroubleBlock_2.blockID
			&& craftedFood
			&& !troubleDone) 
		{
				TSConfig.cNtW(TSConfig.nC, player.worldObj);
				ModLoader.getMinecraftInstance().thePlayer.addChatMessage(TSConfig.dS + TSConfig.fWC);
				craftedBlock = true;	
				troubleDone = true;
		}
		if (!player.worldObj.isRemote
			&&	item.getItem().itemID == TroubleMain.TroubleBlock_2.blockID
			&& !craftedFood
			&& !troubleDone) 
		{
				TSConfig.cNtW(TSConfig.nC, player.worldObj);
				ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Great! Now Craft that Food!");
				craftedBlock = true;	
		}
	}

	@ForgeSubscribe
	public void onHitTroubleCow (EnderTeleportEvent event) {

		}		
	
	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
	
	}


}
