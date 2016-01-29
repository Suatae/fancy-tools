package com.suatae.fancytools.client.render;

import org.lwjgl.opengl.GL11;

import com.suatae.fancytools.lib.Ref;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class IRWoodSword implements IItemRenderer{
	
	//static WavefrontObject modelobj = 
	private IModelCustom model;
	private ResourceLocation texture;
	
	public IRWoodSword(){
		model = AdvancedModelLoader.loadModel(new ResourceLocation(Ref.MOD_ID + ":models/test.obj"));
		texture = new ResourceLocation(Ref.MOD_ID + ":textures/test.png");
	}


	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
			case EQUIPPED:
				if (Minecraft.getMinecraft().isFancyGraphicsEnabled() == true) {
					return true;
				}
				else {
					return false;
				}
			case EQUIPPED_FIRST_PERSON:
				if (Minecraft.getMinecraft().isFancyGraphicsEnabled() == true) {
					return true;
				}
				else {
					return false;
				}
			case ENTITY:
				if (Minecraft.getMinecraft().isFancyGraphicsEnabled() == true) {
					return true;
				}
				else {
					return false;
				}
			default:
				return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
			case EQUIPPED:
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);

				//GL11.glTranslatef(0.5F, -0.5F, 0.5F);

				model.renderAll();

				GL11.glPopMatrix();
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);

				//GL11.glTranslatef(-0.5F, 0.3F, 0.63F);
				//GL11.glScalef(0.8F, 0.8F, 0.8F);

				model.renderAll();

				GL11.glPopMatrix();
				break;

			case ENTITY:
				if (RenderItem.renderInFrame == true) {
					GL11.glPushMatrix();

					Minecraft.getMinecraft().renderEngine.bindTexture(texture);

					// GL11.glRotatef(180F, 1.0f, 0.0f, 0.0f);
					//GL11.glTranslatef(-0.03F, -0.75F, 0F);
					//GL11.glScalef(0.75f, 0.75f, 0.75f);
					model.renderAll();
					GL11.glPopMatrix();

				}
				else {
					GL11.glPushMatrix();
					Minecraft.getMinecraft().renderEngine.bindTexture(texture);

					// GL11.glRotatef(180F, 1.0f, 0.0f, 0.0f);
					// GL11.glTranslatef(0F, -1.2F, 0F);

					model.renderAll();

					GL11.glPopMatrix();
				}
				break;
			default:
				break;
		}
		
	}}
