package fuzs.airhop.common.data;

import fuzs.airhop.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.common.api.data.v2.tags.AbstractTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModEnchantmentTagProvider extends AbstractTagProvider<Enchantment> {

    public ModEnchantmentTagProvider(DataProviderContext context) {
        super(Registries.ENCHANTMENT, context);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        this.tag(EnchantmentTags.TREASURE).add(ModRegistry.AIR_HOP_ENCHANTMENT);
        this.tag(EnchantmentTags.ON_RANDOM_LOOT).add(ModRegistry.AIR_HOP_ENCHANTMENT);
        this.tag(EnchantmentTags.TRADEABLE).add(ModRegistry.AIR_HOP_ENCHANTMENT);
    }
}
