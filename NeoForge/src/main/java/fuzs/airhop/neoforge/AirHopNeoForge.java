package fuzs.airhop.neoforge;

import fuzs.airhop.common.AirHop;
import fuzs.airhop.common.data.ModEnchantmentTagProvider;
import fuzs.airhop.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v3.core.DataProviderBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.fml.common.Mod;

@Mod(AirHop.MOD_ID)
public class AirHopNeoForge {

    public AirHopNeoForge() {
        ModConstructor.construct(AirHop.MOD_ID, AirHop::new);
        DataProviderBuilder.of(AirHop.MOD_ID)
                .addWorldBootstrap(Registries.ENCHANTMENT, ModRegistry::bootstrapEnchantments)
                .addProvider(ModEnchantmentTagProvider::new);
    }
}
