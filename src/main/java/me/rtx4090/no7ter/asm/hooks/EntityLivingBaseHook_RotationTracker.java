package me.rtx4090.no7ter.asm.hooks;

import me.rtx4090.no7ter.asm.accessors.EntityPlayerAccessor;
import me.rtx4090.no7ter.config.ConfigHandler;
import me.rtx4090.no7ter.hackerdetector.HackerDetector;
import net.minecraft.entity.EntityLivingBase;

@SuppressWarnings("unused")
public class EntityLivingBaseHook_RotationTracker {
    public static void setRotationYawHead(EntityLivingBase entity, float yawHead) {
        if (ConfigHandler.hackerDetector && entity instanceof EntityPlayerAccessor) {
            HackerDetector.addScheduledTask(() ->
                    ((EntityPlayerAccessor) entity).getPlayerDataSamples().setRotationYawHead(yawHead)
            );
        }
    }
}
