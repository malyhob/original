package me.malyhob.original.Powers;

import io.github.apace100.apoli.component.PowerHolderComponent;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;

public class IgnoredByEntity extends Power {
    public IgnoredByEntity(PowerType<?> type, LivingEntity entity) {
        super(type, entity);
    }

    public static boolean shouldIgnore(Entity target, Entity attacker){
        if (!(attacker instanceof MobEntity mob)) return false;
        if (!(target instanceof PlayerEntity player)) return false;

        return PowerHolderComponent.hasPower(player,IgnoredByEntity.class);
    }
}
