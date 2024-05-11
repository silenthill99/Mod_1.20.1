package fr.silenthill99.test_mod.data.models_and_blockstates;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModBlocks;
import fr.silenthill99.test_mod.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelsProvider extends ItemModelProvider {
    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Main.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.RAW_SAPPHIRE);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.PINE_CONE);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.SAPPHIRE_HELMET);
        simpleItem(ModItems.SAPPHIRE_CHESTPLATE);
        simpleItem(ModItems.SAPPHIRE_LEGGINGS);
        simpleItem(ModItems.SAPPHIRE_BOOTS);

        simpleBlockItem(ModBlocks.SAPPHIRE_DOOR);

        toolItem(ModItems.SAPPHIRE_AXE.get());
        toolItem(ModItems.SAPPHIRE_HOE.get());
        toolItem(ModItems.SAPPHIRE_PICKAXE.get());
        toolItem(ModItems.SAPPHIRE_SHOVEL.get());
        toolItem(ModItems.SAPPHIRE_SWORD.get());
    }

    public ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Main.MODID, "item/" + item.getId().getPath()));
    }

    private void toolItem(Item item) {
        withExistingParent(ForgeRegistries.ITEMS.getKey(item).getPath(), mcLoc("item/handheld"))
                .texture("layer0", modLoc("item/" + ForgeRegistries.ITEMS.getKey(item).getPath()));
    }

    public ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Main.MODID, "item/" + item.getId().getPath()));
    }
}
