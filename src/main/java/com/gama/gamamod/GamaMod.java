package com.gama.gamamod;

import com.gama.gamamod.block.ModBlocks;
import com.gama.gamamod.item.ModItems;
import com.gama.gamamod.networking.ModPacketHandler;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GamaMod.MODID)
public class GamaMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "gamamod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public static LivingEntity target = null;
    
    public GamaMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        
        ModPacketHandler.register();
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.COMBAT) {
        	event.accept(ModItems.COPPER_SWORD);
        	event.accept(ModItems.COPPER_AXE);
        	
        	event.accept(ModItems.STEEL_SWORD);
        	event.accept(ModItems.STEEL_AXE);
        	
        	event.accept(ModItems.COPPER_HELMET);
        	event.accept(ModItems.COPPER_CHESTPLATE);
        	event.accept(ModItems.COPPER_LEGGINGS);
        	event.accept(ModItems.COPPER_BOOTS);
        	
        	event.accept(ModItems.STEEL_HELMET);
        	event.accept(ModItems.STEEL_CHESTPLATE);
        	event.accept(ModItems.STEEL_LEGGINGS);
        	event.accept(ModItems.STEEL_BOOTS);
        }
        else if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
        	event.accept(ModItems.COPPER_SHOVEL);
        	event.accept(ModItems.COPPER_PICKAXE);
        	event.accept(ModItems.COPPER_AXE);
        	event.accept(ModItems.COPPER_HOE);
        	
        	event.accept(ModItems.STEEL_SHOVEL);
        	event.accept(ModItems.STEEL_PICK);
        	event.accept(ModItems.STEEL_AXE);
        	event.accept(ModItems.STEEL_HOE);
        }
        else if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
        	event.accept(ModItems.STEEL_INGOT);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
