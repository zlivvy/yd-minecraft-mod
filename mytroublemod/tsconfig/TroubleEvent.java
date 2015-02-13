package mytroublemod.tsconfig;

import mytroublemod.TroubleMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import cpw.mods.fml.common.ICraftingHandler;




public class TroubleEvent implements ICraftingHandler{
	
	private static boolean troubleComplete = false;
	

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		if (!player.worldObj.isRemote && TroubleMain.TroublePickaxe_1.itemID == item.itemID) {
			troubleComplete = true;
			ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Nice work, now go use it!");
		}
	}

	@ForgeSubscribe
    public void onUsePickaxe(PlayerDestroyItemEvent event) {
		if (!event.entityLiving.worldObj.isRemote && TroubleMain.TroublePickaxe_1.getItemEnchantability() == 12 && troubleComplete && event.original.itemID == TroubleMain.TroublePickaxe_1.itemID) 
		{
	        TSConfig.cNtW(TSConfig.nC, event.entityLiving.worldObj);
	        ModLoader.getMinecraftInstance().thePlayer.addChatMessage(TSConfig.dS + TSConfig.fWC);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		// TODO Auto-generated method stub
		
	}

}
    	     	 
