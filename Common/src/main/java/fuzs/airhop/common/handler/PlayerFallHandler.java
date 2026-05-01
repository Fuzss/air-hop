package fuzs.airhop.common.handler;

import fuzs.airhop.common.AirHop;
import fuzs.airhop.common.config.ServerConfig;
import fuzs.airhop.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.event.v1.core.EventResult;
import fuzs.puzzleslib.common.api.event.v1.data.MutableDouble;
import fuzs.puzzleslib.common.api.event.v1.data.MutableFloat;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class PlayerFallHandler {

    public static EventResult onLivingFall(LivingEntity entity, MutableDouble fallDistance, MutableFloat damageMultiplier) {
        // fires for survival mode only, but this is fine since there is no fall damage in creative mode
        if (entity instanceof Player player) {
            byte airHops = ModRegistry.AIR_HOPS_ATTACHMENT_TYPE.getOrDefault(player, (byte) 0);
            if (!AirHop.CONFIG.get(ServerConfig.class).fallDamage && airHops > 0) {
                fallDistance.mapAsDouble((double distance) -> Math.max(0.0,
                        distance - airHops * getJumpHeight(player)));
            }
        }

        return EventResult.PASS;
    }

    public static void onStartPlayerTick(Player player) {
        if (player.onGround()) {
            ModRegistry.AIR_HOPS_ATTACHMENT_TYPE.set(player, (byte) 0);
        }
    }

    public static float getJumpHeight(Player player) {
        float jumpHeight = 1.25F;
        if (player.hasEffect(MobEffects.JUMP_BOOST)) {
            jumpHeight += 0.6875F * (player.getEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1.0F);
        }

        return jumpHeight;
    }
}
