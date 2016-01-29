package com.suatae.fancytools.util;

import java.io.File;

import com.suatae.fancytools.lib.Ref;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigUtil {
	
	public static Configuration	configuration;

	public static String		debug			= "DEV MODE";
	public static String		modules			= "Modules";

	// Debug
	public static boolean		DebugMode;
	public static final boolean	Debug			= false;
	public static final String	Debug_comment	= "Set to true if you want log checks.";

	public static void init(File configFile) // Create the configuration object
												// from the given configuration
												// file
	{
		if (configuration == null) {
			try {
				configuration = new Configuration(configFile);
			}
			catch (Exception e) {
				LogHelper.info("Config file already exists");
			}
			finally {
				loadConfiguration();
				LogHelper.info("Config file LOADED");
			}
		}
	}

	@SubscribeEvent
	// Load configuration file
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equalsIgnoreCase(Ref.MOD_ID)) {
			try {
				loadConfiguration();
				LogHelper.info("Config file LOADED");
			}
			catch (Exception e) {
				LogHelper.info("Config file --ERROR--");
			}
		}
	}

	private static void loadConfiguration() // Configuration Elements
	{
		if (ConfigUtil.DebugMode) {
			LogHelper.info("Config Parameters --- BEGIN ---");
		}
		else {}

		// Debug Mode
		DebugMode = configuration.getBoolean("DebugMode", debug, Debug, Debug_comment);


		if (ConfigUtil.DebugMode) {
			LogHelper.info("Debug Mode: " + DebugMode);

			LogHelper.info("Config Parameters --- END ---");
		}
		else {}

		if (configuration.hasChanged()) // Save the configuration file
		{
			configuration.save();
			LogHelper.info("Config Saved");
		}
	}

}
