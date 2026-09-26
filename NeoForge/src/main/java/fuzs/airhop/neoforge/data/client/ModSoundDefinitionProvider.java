package fuzs.airhop.neoforge.data.client;

import fuzs.airhop.common.AirHop;
import fuzs.airhop.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;
import fuzs.puzzleslib.neoforge.api.client.data.v3.sounds.AbstractSoundProvider;

public class ModSoundDefinitionProvider extends AbstractSoundProvider {

    public ModSoundDefinitionProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void registerSounds() {
        this.add(ModRegistry.ENTITY_PLAYER_HOP_SOUND_EVENT.value(),
                sound(AirHop.id("entity/player/hop1")).volume(0.2F),
                sound(AirHop.id("entity/player/hop2")).volume(0.2F));
    }
}
