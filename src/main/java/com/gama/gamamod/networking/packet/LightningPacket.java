package com.gama.gamamod.networking.packet;

import java.util.function.Supplier;

import com.gama.gamamod.GamaMod;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

public class LightningPacket {
	public LightningPacket() {}
	
	public LightningPacket(FriendlyByteBuf buf) {
		
	}
	
	public void toBytes(FriendlyByteBuf buf) {
		
	}
	
	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		
		context.enqueueWork(() -> {
			// On the server
			ServerPlayer player = context.getSender();
			ServerLevel level = player.getLevel();
			GamaMod.LOGGER.info("packet sent");
			
			EntityType.LIGHTNING_BOLT.spawn(level, null, player, GamaMod.target.blockPosition(), MobSpawnType.COMMAND, true, false);
		});
		
		return true;
	}
}
