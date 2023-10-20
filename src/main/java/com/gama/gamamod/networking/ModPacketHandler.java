package com.gama.gamamod.networking;

import com.gama.gamamod.GamaMod;
import com.gama.gamamod.networking.packet.LightningPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModPacketHandler {
	public static SimpleChannel INSTANCE;
	
	private static int packetId = 0;
	
	private static int id() {
		return packetId++;
	}
	
	public static void register() {
		SimpleChannel net = NetworkRegistry.ChannelBuilder
				.named(new ResourceLocation(GamaMod.MODID, "messages"))
				.networkProtocolVersion(() -> "1.0")
				.clientAcceptedVersions(s -> true)
				.serverAcceptedVersions(s -> true)
				.simpleChannel();
		
		INSTANCE = net;
		
		net.messageBuilder(LightningPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
		.decoder(LightningPacket::new)
		.encoder(LightningPacket::toBytes)
		.consumerMainThread(LightningPacket::handle)
		.add();
	}
	
	public static <MSG> void sendToServer(MSG message) {
		INSTANCE.sendToServer(message);
	}
	
	public static <MSG> void sendToPlayer(MSG message) {
		// borked
		//INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
	}
}
