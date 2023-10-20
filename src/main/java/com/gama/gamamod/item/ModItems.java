package com.gama.gamamod.item;

import java.util.List;

import com.gama.gamamod.GamaMod;
import com.gama.gamamod.ModTags;
import com.gama.gamamod.base.ModArmorMaterial;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.sounds.SoundEvents;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GamaMod.MODID);
	
	public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
	
	public static final Properties props = new Item.Properties().stacksTo(1);
	
	public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pick", () -> new PickaxeItem(ToolTiers.COPPER, 0, 0, props));
	public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(ToolTiers.COPPER, 0, 0, props));
	public static final RegistryObject<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(ToolTiers.COPPER, 0, 0, props));
	public static final RegistryObject<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(ToolTiers.COPPER, 0, 0, props));
	public static final RegistryObject<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(ToolTiers.COPPER, 0, 0, props));
	
	public static final RegistryObject<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ArmorItem(ArmorTiers.COPPER, EquipmentSlot.HEAD, props));
	public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ArmorItem(ArmorTiers.COPPER, EquipmentSlot.CHEST, props));
	public static final RegistryObject<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ArmorItem(ArmorTiers.COPPER, EquipmentSlot.LEGS, props));
	public static final RegistryObject<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ArmorItem(ArmorTiers.COPPER, EquipmentSlot.FEET, props));
	
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
	public static final RegistryObject<PickaxeItem> STEEL_PICK = ITEMS.register("steel_pick", () -> new PickaxeItem(ToolTiers.STEEL, 0, 0, props));
	public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> new AxeItem(ToolTiers.STEEL, 0, 0, props));
	public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ShovelItem(ToolTiers.STEEL, 0, 0, props));
	public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> new HoeItem(ToolTiers.STEEL, 0, 0, props));
	public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(ToolTiers.STEEL, 0, 0, props));
	
	public static final RegistryObject<ArmorItem> STEEL_HELMET = ITEMS.register("steel_helmet", () -> new ArmorItem(ArmorTiers.STEEL, EquipmentSlot.HEAD, props));
	public static final RegistryObject<ArmorItem> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () -> new ArmorItem(ArmorTiers.STEEL, EquipmentSlot.CHEST, props));
	public static final RegistryObject<ArmorItem> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () -> new ArmorItem(ArmorTiers.STEEL, EquipmentSlot.LEGS, props));
	public static final RegistryObject<ArmorItem> STEEL_BOOTS = ITEMS.register("steel_boots", () -> new ArmorItem(ArmorTiers.STEEL, EquipmentSlot.FEET, props));
	
	public static class ToolTiers {
		public static final Tier COPPER = TierSortingRegistry.registerTier(
	            new ForgeTier(1, 190, 5.0f, 3.5f, 17, ModTags.COPPER_TIER_TAG, () -> Ingredient.of(Items.COPPER_INGOT)),
	            new ResourceLocation("tag_based_tool_types:copper_tier"),
	            List.of(Tiers.STONE), List.of(Tiers.IRON));
		
		public static final Tier STEEL = TierSortingRegistry.registerTier(
	            new ForgeTier(2, 500, 8.0f, 5.0f, 0, ModTags.STEEL_TIER_TAG, () -> Ingredient.of(ModItems.STEEL_INGOT.get())),
	            new ResourceLocation("tag_based_tool_types:steel_tier"),
	            List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
	}
	
	public static class ArmorTiers {
		public static final ArmorMaterial COPPER = new ModArmorMaterial("copper", 12, new int[] {2, 4, 3, 1}, 15, SoundEvents.ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.of(Items.COPPER_INGOT));
		
		public static final ArmorMaterial STEEL = new ModArmorMaterial("steel", 25, new int[] {2, 7, 5, 3}, 0, SoundEvents.ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.of(ModItems.STEEL_INGOT.get()));
	}
}
