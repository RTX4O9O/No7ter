package me.rtx4090.no7ter.asm.hooks;

import me.rtx4090.no7ter.config.ConfigHandler;
import me.rtx4090.no7ter.hackerdetector.HackerDetector;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;

@SuppressWarnings("unused")
public class C08PacketPlayerBlockPlacementHook {

    public static void onBlockPlace(BlockPos pos, int placedBlockDirectionIn, ItemStack stack) {
        if (!ConfigHandler.hackerDetector) return;
        try {
            if (placedBlockDirectionIn == 255) return;
            if (pos == null || stack == null || !(stack.getItem() instanceof ItemBlock)) return;
            HackerDetector.onPlayerBlockPacket(pos, placedBlockDirectionIn, ((ItemBlock) stack.getItem()).getBlock());
        } catch (Throwable ignored) {}
    }

}
