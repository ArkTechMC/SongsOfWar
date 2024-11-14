package com.iafenvoy.sow.render.particle;

import com.iafenvoy.neptune.util.RandomHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class AggroblastParticle extends SpriteBillboardParticle {
    private final SpriteProvider spriteSet;

    protected AggroblastParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i, SpriteProvider sprite) {
        super(clientWorld, d, e, f);
        this.spriteSet = sprite;
        this.setVelocity(g + RandomHelper.nextDouble(-0.5, 0.5), h + RandomHelper.nextDouble(-0.5, 0.5), i + RandomHelper.nextDouble(-0.5, 0.5));
        this.setSpriteForAge(sprite);
        this.setBoundingBoxSpacing(0.2F, 0.2F);
        this.maxAge = 14 + this.random.nextInt(42);
        this.gravityStrength = 0.0F;
        this.collidesWithWorld = false;
    }

    @Override
    public int getBrightness(float partialTick) {
        return 15728880;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.dead) this.setSprite(this.spriteSet.getSprite(this.age / 2 % 7, 6));
    }

    public static ParticleFactory<DefaultParticleType> create(SpriteProvider sprite) {
        return (parameters, world, x, y, z, r, g, b) -> new AggroblastParticle(world, x, y, z, r, g, b, sprite);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }
}
