package fuzs.airhop.common;

import fuzs.airhop.common.config.ServerConfig;
import fuzs.airhop.common.handler.PlayerFallHandler;
import fuzs.airhop.common.init.ModRegistry;
import fuzs.airhop.common.network.client.ServerboundAirHopMessage;
import fuzs.puzzleslib.common.api.config.v3.ConfigHolder;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.common.api.core.v1.context.PayloadTypesContext;
import net.minecraft.resources.Identifier;
import fuzs.puzzleslib.common.api.event.v1.entity.living.LivingFallCallback;
import fuzs.puzzleslib.common.api.event.v1.entity.player.PlayerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AirHop implements ModConstructor {
    public static final String MOD_ID = "airhop";
    public static final String MOD_NAME = "Air Hop";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final ConfigHolder CONFIG = ConfigHolder.builder(MOD_ID).server(ServerConfig.class);

    @Override
    public void onConstructMod() {
        ModRegistry.bootstrap();
    }

    @Override
    public void onCommonSetup() {
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        LivingFallCallback.EVENT.register(PlayerFallHandler::onLivingFall);
        PlayerTickEvents.START.register(PlayerFallHandler::onStartPlayerTick);
    }

    @Override
    public void onRegisterPayloadTypes(PayloadTypesContext context) {
        context.playToServer(ServerboundAirHopMessage.class, ServerboundAirHopMessage.STREAM_CODEC);
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
