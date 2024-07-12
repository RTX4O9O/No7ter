package me.rtx4090.no7ter.asm.hooks;

import me.rtx4090.no7ter.config.ConfigHandler;
import me.rtx4090.no7ter.hackerdetector.HackerDetector;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;
import net.minecraft.network.play.server.S23PacketBlockChange;

@SuppressWarnings("unused")
public class NetHandlerPlayClientHook_BlockChangeListener {

    public static void onBlockChange(S23PacketBlockChange packet) {
        if (!ConfigHandler.hackerDetector) return;
        try {
            HackerDetector.addPlacedBlock(packet.getBlockPosition(), packet.getBlockState());
        } catch (Throwable ignored) {}
    }

    public static void onMultiBlockChange(S22PacketMultiBlockChange packet) {
        if (!ConfigHandler.hackerDetector) return;
        try {
            for (final S22PacketMultiBlockChange.BlockUpdateData blockData : packet.getChangedBlocks()) {
                HackerDetector.addPlacedBlock(blockData.getPos(), blockData.getBlockState());
            }
        } catch (Throwable ignored) {}
    }

}
