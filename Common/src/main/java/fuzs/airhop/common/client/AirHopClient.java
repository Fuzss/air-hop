package fuzs.airhop.common.client;

import fuzs.airhop.common.client.handler.AirHopClientHandler;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.common.api.event.v1.entity.player.PlayerTickEvents;

public class AirHopClient implements ClientModConstructor {

    @Override
    public void onConstructMod() {
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        PlayerTickEvents.END.register(AirHopClientHandler::onEndPlayerTick);
    }
}
