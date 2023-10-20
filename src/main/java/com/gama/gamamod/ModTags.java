package com.gama.gamamod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
	public static final TagKey<Block> COPPER_TIER_TAG = BlockTags.create(new ResourceLocation("tag_based_tool_types:needs_copper_tier_tool"));
	public static final TagKey<Block> STEEL_TIER_TAG = BlockTags.create(new ResourceLocation("tag_based_tool_types:needs_steel_tier_tool"));
}
