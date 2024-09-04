package fr.silenthill99.test_mod.utils;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.custom.screens.GemPolishingStationMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES,
            Main.MODID);

    public static final RegistryObject<MenuType<GemPolishingStationMenu>> GEM_POLISHING_MENU =
            registerMenuTypes("gem_polishing_menu", GemPolishingStationMenu::new);

    @SuppressWarnings("SameParameterValue")
    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuTypes(String name, IContainerFactory<T> factory) {
        return MENU_TYPES.register(name, () -> IForgeMenuType.create(factory));
    }

}
