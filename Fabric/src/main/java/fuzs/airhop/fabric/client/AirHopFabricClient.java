package fuzs.airhop.fabric.client;

import fuzs.airhop.common.AirHop;
import fuzs.airhop.common.client.AirHopClient;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class AirHopFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(AirHop.MOD_ID, AirHopClient::new);
    }
}
