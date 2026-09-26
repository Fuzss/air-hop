package fuzs.airhop.common.data.client;

import fuzs.airhop.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.client.data.v3.language.AbstractLanguageProvider;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations() {
        this.add(ModRegistry.AIR_HOP_ENCHANTMENT, "Air Hop");
        this.add(ModRegistry.AIR_HOP_ENCHANTMENT, "desc", "Enables jumping in mid-air.");
        this.add(ModRegistry.ENTITY_PLAYER_HOP_SOUND_EVENT.value(), "Player hops");
    }
}
