package fr.silenthill99.test_mod.recipes;

import fr.silenthill99.test_mod.Main;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPES_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Main.MODID);

    public static final RegistryObject<RecipeSerializer<GemPolishingRecipe>> GEM_POLISHING_SERIALIZER =
            RECIPES_SERIALIZER.register("gem_polishing", () -> GemPolishingRecipe.Serializer.INSTANCE);

}
