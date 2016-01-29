package com.suatae.fancytools;

import com.suatae.fancytools.lib.Ref;
import com.suatae.fancytools.proxy.CommonProxy;
import com.suatae.fancytools.util.ConfigUtil;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Ref.MOD_ID, name = Ref.MOD_NAME, version = Ref.VERSION, guiFactory = Ref.GUI_FACTORY_CLASS)
public class FancyTools {
	@Mod.Instance(Ref.MOD_ID)
	public static FancyTools instance;

	@SidedProxy(clientSide = Ref.CLIENTSIDE, serverSide = Ref.SERVERSIDE)
	public static CommonProxy		proxy;
	
	@Mod.EventHandler
	public static void PreLoad(FMLPreInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new ConfigUtil());
		ConfigUtil.init(event.getSuggestedConfigurationFile());
		
		proxy.registerItemRenders();
	}

	@Mod.EventHandler
	public static void Load(FMLInitializationEvent event) {}

	@Mod.EventHandler
	public static void PostLoad(FMLPostInitializationEvent event) {}
}
