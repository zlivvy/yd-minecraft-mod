package mytroublemod.tsconfig;

import mytroublemod.TroubleMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.ICraftingHandler;



public class TroubleEvent implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		if (!player.worldObj.isRemote && item.itemID == TroubleMain.TroubleSword_1.itemID) {
	        TSConfig.cNtW(TSConfig.nC, player.worldObj);
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage(TSConfig.dS + TSConfig.fWC);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		// TODO Auto-generated method stub
		
	}

}
    	     	 
// event.entityLiving instanceof EntityCreeper && 