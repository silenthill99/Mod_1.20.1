package fr.silenthill99.test_mod.utils;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModBlocks;
import fr.silenthill99.test_mod.init.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModItemGroup
{
    static String base = "creativetab.";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Main.MODID);

    public static final RegistryObject<CreativeModeTab> SAPPHIRE = CREATIVE_MODE_TAB.register("test", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
            .title(Component.translatable(base + "tutorial_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.SAPPHIRE.get());
                pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                pOutput.accept(ModItems.PINE_CONE.get());
                pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                pOutput.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());
                pOutput.accept(ModItems.METAL_DETECTOR.get());
                pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                pOutput.accept(ModItems.STRAWBERRY.get());
                pOutput.accept(ModBlocks.SAPPHIRE_STAIRS.get());
                pOutput.accept(ModBlocks.SAPPHIRE_SLABS.get());
                pOutput.accept(ModBlocks.SAPPHIRE_BUTTON.get());
                pOutput.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
                pOutput.accept(ModBlocks.SAPPHIRE_FENCE.get());
                pOutput.accept(ModBlocks.SAPPHIRE_FENCE_GATE.get());
                pOutput.accept(ModBlocks.SAPPHIRE_WALL.get());
                pOutput.accept(ModBlocks.SAPPHIRE_DOOR.get());
                pOutput.accept(ModBlocks.SAPPHIRE_TRAPDOOR.get());
                pOutput.accept(ModItems.SAPPHIRE_STAFF.get());

                pOutput.accept(ModItems.SAPPHIRE_AXE.get());
                pOutput.accept(ModItems.SAPPHIRE_PICKAXE.get());
                pOutput.accept(ModItems.SAPPHIRE_SWORD.get());
                pOutput.accept(ModItems.SAPPHIRE_SHOVEL.get());
                pOutput.accept(ModItems.SAPPHIRE_HOE.get());

                pOutput.accept(ModItems.SAPPHIRE_HELMET.get());
                pOutput.accept(ModItems.SAPPHIRE_CHESTPLATE.get());
                pOutput.accept(ModItems.SAPPHIRE_LEGGINGS.get());
                pOutput.accept(ModItems.SAPPHIRE_BOOTS.get());

                pOutput.accept(ModItems.RHINO_SPAWN_EGG.get());

                pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());
                pOutput.accept(ModItems.CORN_SEEDS.get());
                pOutput.accept(ModItems.CORN.get());

                pOutput.accept(ModBlocks.CATMINT.get());
                pOutput.accept(ModItems.BAR_BRAWL_MUSIC_DISC.get());
            }).backgroundSuffix("item_search.png").withSearchBar()
            .build());
}
