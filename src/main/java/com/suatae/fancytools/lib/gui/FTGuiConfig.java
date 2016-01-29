package com.suatae.fancytools.lib.gui;

import com.suatae.fancytools.lib.Ref;
import com.suatae.fancytools.util.ConfigUtil;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import cpw.mods.fml.client.config.GuiConfig;

public class FTGuiConfig extends GuiConfig{
	
	public FTGuiConfig(GuiScreen parent) {
		super(parent, new ConfigElement(ConfigUtil.configuration.getCategory("dev mode")).getChildElements(),
				Ref.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigUtil.configuration.toString()));
	}

}
