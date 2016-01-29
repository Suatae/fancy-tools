package com.suatae.fancytools.proxy;

import com.suatae.fancytools.client.render.IRWoodSword;

import net.minecraft.init.Items;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerItemRenders(){
		MinecraftForgeClient.registerItemRenderer(Items.wooden_sword, new IRWoodSword());
	}

}
