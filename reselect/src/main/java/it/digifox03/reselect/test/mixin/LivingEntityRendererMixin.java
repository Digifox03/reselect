package it.digifox03.reselect.test.mixin;

import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static it.digifox03.reselect.test.OverridesKt.getOverrides;
import static it.digifox03.reselect.test.OverridesKt.redirect;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin {
    @ModifyVariable(at = @At("STORE"), method = "getRenderLayer")
    public Identifier getRenderLayer(Identifier id, LivingEntity e) {
        return redirect(e, id);
    }
}
