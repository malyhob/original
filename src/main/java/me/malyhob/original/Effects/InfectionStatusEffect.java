package me.malyhob.original.Effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class InfectionStatusEffect extends StatusEffect {
    private double durationActive = 0;
    public InfectionStatusEffect(){
        super(
                StatusEffectCategory.HARMFUL,
                0xE60026
        );
    }

    public double getDurationActive() {
        return durationActive;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        durationActive+=.05;
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier){
        if (entity instanceof PlayerEntity player){
            if (getDurationActive() > 140 && player.getHealth() >= 14) {
                player.setHealth(14);
            }
        } else {
            entity.damage(entity.getWorld().getDamageSources().generic(),1.0F);
        }
    }
}
