package mymod.biome;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyBiome extends BiomeGenBase
{
    public MyBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("The Rainbow Biome");
        
        this.topBlock = (byte)Main.MyBlock_1.blockID;
        this.fillerBlock = (byte)Main.MyBlock_1.blockID;
        
        this.theBiomeDecorator.bigMushroomsPerChunk = 15;
        this.theBiomeDecorator.waterlilyPerChunk = 20;

        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantZombie.class, 4, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBat.class, 30, 5, 25));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityDragon.class, 9, 3, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCaveSpider.class, 25, 5, 20));
        
        this.setMinMaxHeight(0.5F, 1.0F);
        this.setTemperatureRainfall(0.4F, 1.5F);
   
    }
}