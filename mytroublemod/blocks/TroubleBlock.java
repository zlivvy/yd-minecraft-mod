/* *******************************************
 * *******************************************
 * 
 * 			| TS CODE - DO NOT TOUCH |
 * 
 * *******************************************
 * *******************************************	*/

package mytroublemod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class TroubleBlock extends Block 
{
    
	private String texturePath = "troublemod:";
	private int thisBlockID;
	
    public TroubleBlock(int par1, Material blockMaterial, String textureName) 
    {
        super(par1, blockMaterial);
		this.setUnlocalizedName(textureName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		thisBlockID = par1;
		texturePath += textureName;
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return thisBlockID;
    }
    
    public int quantityDropped(Random random)
    {
        return 1;
    }

@Override
@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(texturePath);
    }
    

}