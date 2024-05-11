package fr.silenthill99.test_mod;

import com.mojang.logging.LogUtils;
import fr.silenthill99.test_mod.init.ModBlocks;
import fr.silenthill99.test_mod.init.ModEntityTypes;
import fr.silenthill99.test_mod.init.ModItems;
import fr.silenthill99.test_mod.init.entities.client.RhinoRenderer;
import fr.silenthill99.test_mod.utils.ModItemGroup;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MODID)
public class Main
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "test_mod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Main()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItemGroup.CREATIVE_MODE_TAB.register(modEventBus);
        ModEntityTypes.ENTITIES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        
    }

    private void commonSetup(FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
//        Pour ajouter des éléments dans des Creative tab vanilla
//        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
//        {
//            event.accept(ModItems.SAPPHIRE);
//            event.accept(ModItems.RAW_SAPPHIRE);
//        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT)
        {
            event.accept(ModItems.SAPPHIRE_SWORD);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.RHINO.get(), RhinoRenderer::new);
        }
    }
}
