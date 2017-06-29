package com.rwtema.funkylocomotion.particles;

import java.util.Random;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.particle.ParticleRedstone;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class ParticleObstruction extends ParticleRedstone {
	public static final Random RANDOM = new Random();
	public static final float r = 98 / 255.0F;
	public static final float g = 142 / 255.0F;
	public static final float b = 94 / 255.0F;

	public ParticleObstruction(World world, int x, int y, int z, byte side) {
		super(world,
				x + (side == 4 ? 0 : side == 5 ? 1 : RANDOM.nextDouble()),
				y + (side == 0 ? 0 : side == 1 ? 1 : RANDOM.nextDouble()),
				z + (side == 2 ? 0 : side == 3 ? 1 : RANDOM.nextDouble()),
				0, 0, 0);
		this.canCollide = false;
		this.particleMaxAge *= 2;
	}

	@Override
	public void renderParticle(BufferBuilder bufferBuilderIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		if (!ObstructionHelper.shouldRenderParticles()) return;
		super.renderParticle(bufferBuilderIn, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);

		Tessellator tessellator = Tessellator.getInstance();
		tessellator.draw();

		GL11.glDisable(GL11.GL_DEPTH_TEST);
		BufferBuilder bufferBuilder = tessellator.getBuffer();
		bufferBuilder.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
		super.renderParticle(bufferBuilderIn, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
		tessellator.draw();
		GL11.glEnable(GL11.GL_DEPTH_TEST);

		bufferBuilder.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
	}
}

