package fr.silenthill99.test_mod.data.recipes;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModBlocks;
import fr.silenthill99.test_mod.init.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider
{
    public RecipeGenerator(PackOutput p_248933_)
    {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SAPPHIRE.get())
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SAPPHIRE.get()))
                .save(consumer);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.RAW_SAPPHIRE.get()), RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.7f, 100)
                .group("sapphire")
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_SAPPHIRE.get()))
                .save(consumer, new ResourceLocation(Main.MODID, "sapphire_from_blasting_raw_sapphire"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_SAPPHIRE.get()), RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.7f, 200)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_SAPPHIRE.get()))
                .group("sapphire")
                .save(consumer, new ResourceLocation(Main.MODID, "sapphire_from_smelting_raw_sapphire"));


        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.SAPPHIRE_DOOR.get(), 3)
                .group("door")
                .pattern("00")
                .pattern("00")
                .pattern("00")
                .define('0', ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_PICKAXE.get())
                .pattern("000")
                .pattern(" 1 ")
                .pattern(" 1 ")
                .define('0', ModItems.SAPPHIRE.get())
                .define('1', Items.STICK)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SAPPHIRE.get(),
                        Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_AXE.get())
                .pattern("00")
                .pattern("01")
                .pattern(" 1")
                .define('0', ModItems.SAPPHIRE.get())
                .define('1', Items.STICK)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SAPPHIRE.get(),
                        Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_HOE.get())
                .pattern("00")
                .pattern(" 1")
                .pattern(" 1")
                .define('0', ModItems.SAPPHIRE.get())
                .define('1', Items.STICK)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SAPPHIRE.get(),
                        Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_SHOVEL.get())
                .pattern("0")
                .pattern("1")
                .pattern("1")
                .define('0', ModItems.SAPPHIRE.get())
                .define('1', Items.STICK)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SAPPHIRE.get(),
                        Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_SWORD.get())
                .pattern("0")
                .pattern("0")
                .pattern("1")
                .define('0', ModItems.SAPPHIRE.get())
                .define('1', Items.STICK)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SAPPHIRE.get(),
                        Items.STICK))
                .save(consumer);
    }
}
