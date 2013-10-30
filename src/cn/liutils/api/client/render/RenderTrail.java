package cn.liutils.api.client.render;

import java.util.LinkedList;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;

import org.lwjgl.opengl.GL11;

import cn.liutils.api.client.util.RenderUtils;
import cn.liutils.api.entity.EntityTrailFX;
import cn.liutils.api.entity.SamplePoint;

public class RenderTrail extends Render {
	
	private static Tessellator t = Tessellator.instance;

	public RenderTrail() {
	}

	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		EntityTrailFX ent = (EntityTrailFX) par1Entity;
		LinkedList<SamplePoint> list = ent.getSamplePoints();
		double width = ent.getTrailWidth();
		boolean hasLight = ent.getHasLight();
		for (int i = 0; i < list.size() - 1; i++) {
			GL11.glPushMatrix();

			if (i == 0 && ent.doesRenderEnd())
				bindTexture(new ResourceLocation(ent.getTexEnd()));
			else
				bindTexture(new ResourceLocation(ent.getTexNormal()));

			SamplePoint sp1 = list.get(i), sp2 = list.get(i + 1);

			Vec3 v1 = getVec3(0, 0, -width).addVector(sp1.x, sp1.y, sp1.z), v2 = getVec3(
					0, 0, width).addVector(sp1.x, sp1.y, sp1.z), v3 = getVec3(
					0, 0, width).addVector(sp2.x, sp2.y, sp2.z), v4 = getVec3(
					0, 0, -width).addVector(sp2.x, sp2.y, sp2.z);

			Vec3 v5 = getVec3(-width, 0, 0).addVector(sp1.x, sp1.y, sp1.z), v6 = getVec3(
					width, 0, 0).addVector(sp1.x, sp1.y, sp1.z), v7 = getVec3(
					width, 0, 0).addVector(sp2.x, sp2.y, sp2.z), v8 = getVec3(
					-width, 0, 0).addVector(sp2.x, sp2.y, sp2.z);

			Vec3 v9 = getVec3(0, -width, 0).addVector(sp1.x, sp1.y, sp1.z), v10 = getVec3(
					0, width, 0).addVector(sp1.x, sp1.y, sp1.z), v11 = getVec3(
					0, width, 0).addVector(sp2.x, sp2.y, sp2.z), v12 = getVec3(
					0, -width, 0).addVector(sp2.x, sp2.y, sp2.z);

			float dt = ent.ticksExisted - sp1.tick;
			float alpha = 1.0F;
			if (dt > ent.getDecayTime()) {
				alpha = 1.0F - (dt - ent.getDecayTime()) / ent.getDecayTime();
			}
			GL11.glTranslated(par2, par4, par6);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
			GL11.glDisable(GL11.GL_CULL_FACE);
			if(!hasLight) {
				GL11.glDisable(GL11.GL_LIGHTING);
				OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);
			}
			
			t.startDrawingQuads();
			t.setColorRGBA_F(0.8F, 0.8F, 0.8F, alpha);
			if(!hasLight)
				t.setBrightness(15728880);
			
			RenderUtils.addVertex(v1, 0, 0);
			RenderUtils.addVertex(v2, 0, 1);
			RenderUtils.addVertex(v3, 1, 1);
			RenderUtils.addVertex(v4, 1, 0);

			RenderUtils.addVertex(v5, 0, 0);
			RenderUtils.addVertex(v6, 0, 1);
			RenderUtils.addVertex(v7, 1, 1);
			RenderUtils.addVertex(v8, 1, 0);

			RenderUtils.addVertex(v9, 0, 0);
			RenderUtils.addVertex(v10, 0, 1);
			RenderUtils.addVertex(v11, 1, 1);
			RenderUtils.addVertex(v12, 1, 0);
			
			t.draw();
			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}

	}

	private Vec3 getVec3(double x, double y, double z) {
		return Vec3.createVectorHelper(x, y, z);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return null;
	}

}
