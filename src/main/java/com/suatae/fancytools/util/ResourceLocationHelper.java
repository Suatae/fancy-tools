package com.suatae.fancytools.util;

import com.suatae.fancytools.lib.Ref;

import net.minecraft.util.ResourceLocation;

public class ResourceLocationHelper {
	public static ResourceLocation getResourceLocation(String modId, String path) {
		return new ResourceLocation(modId, path);
	}

	public static ResourceLocation getResourceLocation(String path) {
		return getResourceLocation(Ref.MOD_ID.toLowerCase(), path);
	}

}
