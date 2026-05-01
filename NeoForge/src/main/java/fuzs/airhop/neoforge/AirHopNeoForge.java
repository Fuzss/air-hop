package fuzs.airhop.neoforge;

import fuzs.airhop.common.AirHop;
import fuzs.airhop.common.data.ModEnchantmentTagProvider;
import fuzs.airhop.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import net.neoforged.fml.common.Mod;

@Mod(AirHop.MOD_ID)
public class AirHopNeoForge {

    public AirHopNeoForge() {
        ModConstructor.construct(AirHop.MOD_ID, AirHop::new);
        DataProviderHelper.registerDataProviders(AirHop.MOD_ID,
                ModRegistry.REGISTRY_SET_BUILDER,
                ModEnchantmentTagProvider::new);
    }
}
