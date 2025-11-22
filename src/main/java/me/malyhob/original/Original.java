package me.malyhob.original;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Original implements ModInitializer {
    public static final String MOD_ID = "original";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Original");
        EffectRegister.registerEffects();
        LOGGER.info("Loaded Original");
    }
}
