package com.gama.gamamod.item;

import com.gama.gamamod.GamaMod;
import com.gama.gamamod.networking.ModPacketHandler;
import com.gama.gamamod.networking.packet.LightningPacket;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class LightningSword extends SwordItem {
	public LightningSword(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);
	}
	
	@Override public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		GamaMod.target = target;
		ModPacketHandler.sendToServer(new LightningPacket());
		
	    return super.hurtEnemy(stack, target, attacker);
	}
	
	// This runs on RIGHT click
	@Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		GamaMod.LOGGER.info("use");
		GamaMod.target = player;
		ModPacketHandler.sendToServer(new LightningPacket());
		
		return super.use(level, player, hand);
	}
}
