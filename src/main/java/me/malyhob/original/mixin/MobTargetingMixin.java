package me.malyhob.original.mixin;

import me.malyhob.original.Powers.IgnoredByEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public class MobTargetingMixin {
    @Inject(method = "setTarget", at = @At("HEAD"), cancellable = true)
    private void ignoreTarget(LivingEntity target, CallbackInfo ci) {
        if (IgnoredByEntity.shouldIgnore(target, (MobEntity)(Object)this)) {
            ci.cancel();
        }
    }
}
