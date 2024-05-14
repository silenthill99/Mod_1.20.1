package fr.silenthill99.test_mod.data;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.data.loots.ModGlobalLootModifiersProvider;
import fr.silenthill99.test_mod.data.loots.ModLootTableProvider;
import fr.silenthill99.test_mod.data.models_and_blockstates.ModBlockStateProvider;
import fr.silenthill99.test_mod.data.models_and_blockstates.ModItemModelsProvider;
import fr.silenthill99.test_mod.data.recipes.RecipeGenerator;
import fr.silenthill99.test_mod.data.tags.ModBlockTagGenerator;
import fr.silenthill99.test_mod.data.tags.ModItemTagGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration
{
    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new RecipeGenerator(packOutput));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelsProvider(packOutput, existingFileHelper));

        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, lookupProvider,
                blockTagGenerator.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModGlobalLootModifiersProvider(packOutput));
    }
}
