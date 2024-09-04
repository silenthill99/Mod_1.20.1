package fr.silenthill99.test_mod;

import fr.silenthill99.test_mod.init.ModBlockEntities;
import fr.silenthill99.test_mod.init.ModBlocks;
import fr.silenthill99.test_mod.init.ModEntityTypes;
import fr.silenthill99.test_mod.init.ModItems;
import fr.silenthill99.test_mod.custom.entities.client.RhinoRenderer;
import fr.silenthill99.test_mod.loot.ModLootModifier;
import fr.silenthill99.test_mod.utils.ModItemGroup;
import fr.silenthill99.test_mod.utils.ModMenuTypes;
import fr.silenthill99.test_mod.utils.ModSoundEvents;
import fr.silenthill99.test_mod.villagers.ModVillagers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MODID)
public class Main
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "test_mod";

    public Main()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItemGroup.CREATIVE_MODE_TAB.register(modEventBus);
        ModEntityTypes.ENTITIES.register(modEventBus);
        ModLootModifier.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
        ModVillagers.POI_TYPES.register(modEventBus);
        ModVillagers.VILLAGER_PROFESSIONS.register(modEventBus);
        ModSoundEvents.SOUND_EVENTS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModMenuTypes.MENU_TYPES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        
    }

    private void commonSetup(FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CATMINT.getId(),
                ModBlocks.POTTED_CATMINT));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
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
