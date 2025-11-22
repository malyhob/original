package me.malyhob.original;

import me.malyhob.original.Effects.InfectionStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EffectRegister {
    public static final StatusEffect Infection = Registry.register(Registries.STATUS_EFFECT, new Identifier(Original.MOD_ID,"infection"),new InfectionStatusEffect());

    public static void registerEffects(){
        Original.LOGGER.info("Loaded effects");

    }
}
