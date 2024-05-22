package fr.silenthill99.test_mod.data;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.data.loots.loot_modifier.ModGlobalLootModifiersProvider;
import fr.silenthill99.test_mod.data.loots.ModLootTableProvider;
import fr.silenthill99.test_mod.data.models_and_blockstates.ModBlockStateProvider;
import fr.silenthill99.test_mod.data.models_and_blockstates.ModItemModelsProvider;
import fr.silenthill99.test_mod.data.recipes.RecipeGenerator;
import fr.silenthill99.test_mod.data.tags.ModBlockTagGenerator;
import fr.silenthill99.test_mod.data.tags.ModItemTagGenerator;
import fr.silenthill99.test_mod.data.tags.ModPoiTypeTagsProvider;
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

        boolean client = event.includeClient();
        boolean server = event.includeServer();

        generator.addProvider(server, new RecipeGenerator(packOutput));
        generator.addProvider(server, ModLootTableProvider.create(packOutput));

        generator.addProvider(client, new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(client, new ModItemModelsProvider(packOutput, existingFileHelper));

        ModBlockTagGenerator blockTagGenerator = generator.addProvider(server,
                new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(server, new ModItemTagGenerator(packOutput, lookupProvider,
                blockTagGenerator.contentsGetter(), existingFileHelper));
        generator.addProvider(server, new ModGlobalLootModifiersProvider(packOutput));
        generator.addProvider(server, new ModPoiTypeTagsProvider(packOutput, lookupProvider, existingFileHelper));
    }
}
