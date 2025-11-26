package me.malyhob.original;

import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import me.malyhob.original.Powers.IgnoredByEntity;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PowerRegister {
    public static final PowerFactory<?> IGNORED_BY_ENTITY_POWER_FACTORY = new PowerFactory<>(
            new Identifier(Original.MOD_ID, "ignored_by_entity"),
            new SerializableData(),
            data -> (type, player) -> new IgnoredByEntity(type, player)
    ).allowCondition();

    public static void register() {
        Registry.register(ApoliRegistries.POWER_FACTORY, new Identifier(Original.MOD_ID, "ignored_by_entity"), IGNORED_BY_ENTITY_POWER_FACTORY);
    }
}
