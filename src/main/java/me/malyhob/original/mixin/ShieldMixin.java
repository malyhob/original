package me.malyhob.original.mixin;

import me.malyhob.original.EffectRegister;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class ShieldMixin {

    @Inject(method = "blockedByShield", at = @At("HEAD"), cancellable = true)
    private void disableShieldBlock(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity instanceof PlayerEntity player && player.hasStatusEffect(EffectRegister.Infection)) {
            cir.setReturnValue(false);
        }
    }
}
