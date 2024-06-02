package fr.silenthill99.test_mod.data.models_and_blockstates;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.custom.blocks.CornCropBlock;
import fr.silenthill99.test_mod.custom.blocks.StrawberryCropBlock;
import fr.silenthill99.test_mod.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    private ResourceLocation path;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Main.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.RAW_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.MODEL_BLOCK);

        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.END_STONE_SAPPHIRE_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock((StairBlock) ModBlocks.SAPPHIRE_STAIRS.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.SAPPHIRE_SLABS.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        buttonBlock((ButtonBlock) ModBlocks.SAPPHIRE_BUTTON.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.SAPPHIRE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        fenceBlock((FenceBlock) ModBlocks.SAPPHIRE_FENCE.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.SAPPHIRE_FENCE_GATE.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.SAPPHIRE_WALL.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.SAPPHIRE_DOOR.get(), modLoc("block/sapphire_door_bottom"), modLoc("block/sapphire_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.SAPPHIRE_TRAPDOOR.get(), modLoc("block/sapphire_trapdoor"), true, "cutout");

        makeStrawberryCrop((CropBlock) ModBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
        makeCornCrop((CropBlock) ModBlocks.CORN_CROP.get(), "corn_stage_", "corn_stage_");

        flowerBlock(ModBlocks.CATMINT.get());
        flowerPotBlock(ModBlocks.POTTED_CATMINT.get(), ModBlocks.CATMINT.get());

        simpleBlockWithItem(ModBlocks.GEM_POLISHING_STATION.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/gem_polishing_station")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    @Override
    public void fenceBlock(FenceBlock block, ResourceLocation texture) {
        super.fenceBlock(block, texture);
        path = ForgeRegistries.BLOCKS.getKey(block);
        simpleBlockItem(block, models().fenceInventory(path.getPath() +
                "_inventory", texture));
    }

    @Override
    public void buttonBlock(ButtonBlock block, ResourceLocation texture) {
        path = ForgeRegistries.BLOCKS.getKey(block);
        super.buttonBlock(block, texture);
        simpleBlockItem(block, models().buttonInventory(path.getPath() + "_inventory", texture));
    }

    @Override
    public void wallBlock(WallBlock block, ResourceLocation texture) {
        path = ForgeRegistries.BLOCKS.getKey(block);
        super.wallBlock(block, texture);
        simpleBlockItem(block, models().wallInventory(path.getPath() + "_inventory", texture));
    }

    @Override
    public void stairsBlock(StairBlock block, ResourceLocation texture) {
        path = ForgeRegistries.BLOCKS.getKey(block);
        super.stairsBlock(block, texture);
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + path.getPath())));
    }

    @Override
    public void slabBlock(SlabBlock block, ResourceLocation doubleslab, ResourceLocation texture) {
        path = ForgeRegistries.BLOCKS.getKey(block);
        super.slabBlock(block, doubleslab, texture);
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + path.getPath())));
    }

    @Override
    public void trapdoorBlockWithRenderType(TrapDoorBlock block, ResourceLocation texture, boolean orientable, String renderType) {
        path = ForgeRegistries.BLOCKS.getKey(block);
        super.trapdoorBlockWithRenderType(block, texture, orientable, renderType);
        simpleBlockItem(block, models().trapdoorOrientableBottom(path.getPath() + "_bottom", texture));
    }

    @Override
    public void pressurePlateBlock(PressurePlateBlock block, ResourceLocation texture) {
        path = ForgeRegistries.BLOCKS.getKey(block);
        super.pressurePlateBlock(block, texture);
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + path.getPath())));
    }

    @Override
    public void fenceGateBlock(FenceGateBlock block, ResourceLocation texture) {
        path = ForgeRegistries.BLOCKS.getKey(block);
        super.fenceGateBlock(block, texture);
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + path.getPath())));
    }

    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(Main.MODID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeCornCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
                new ResourceLocation(Main.MODID, "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void flowerBlock(Block block) {
        path = ForgeRegistries.BLOCKS.getKey(block);
        simpleBlockWithItem(block, models().cross(path.getPath(), blockTexture(block)).renderType("cutout"));
    }

    private void flowerPotBlock(Block block, Block block2) {
        path = ForgeRegistries.BLOCKS.getKey(block);
        simpleBlockWithItem(block, models().singleTexture(path.getPath(), mcLoc("flower_pot_cross"), "plant",
                blockTexture(block2)).renderType("cutout"));
    }
}
