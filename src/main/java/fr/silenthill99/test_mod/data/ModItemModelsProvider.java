package fr.silenthill99.test_mod.data;

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

        simpleBlockItem(ModBlocks.SAPPHIRE_DOOR);

        fenceItem(ModBlocks.SAPPHIRE_FENCE, ModBlocks.SAPPHIRE_BLOCK);
        buttonItem(ModBlocks.SAPPHIRE_BUTTON, ModBlocks.SAPPHIRE_BLOCK);
        wallItem(ModBlocks.SAPPHIRE_WALL, ModBlocks.SAPPHIRE_BLOCK);

        customBlock(ModBlocks.SAPPHIRE_STAIRS);
        customBlock(ModBlocks.SAPPHIRE_SLABS);
        customTrapDoor(ModBlocks.SAPPHIRE_TRAPDOOR);
    }


    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(Main.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(Main.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("texture", new ResourceLocation(Main.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Main.MODID, "item/" + item.getId().getPath()));
    }

    public ItemModelBuilder customBlock(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation(Main.MODID, "block/" + item.getId().getPath()));
    }
    public ItemModelBuilder customTrapDoor(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation(Main.MODID, "block/" + item.getId().getPath() + "_bottom"));
    }

    public ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Main.MODID, "item/" + item.getId().getPath()));
    }
}
