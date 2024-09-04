package fr.silenthill99.test_mod.custom.screens;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class GemPolishingStationMenu extends AbstractContainerMenu {
    protected GemPolishingStationMenu(@Nullable MenuType<?> pMenuType, int pContainerId) {
        super(pMenuType, pContainerId);
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return false;
    }

    public boolean isCrafting() {
        return false;
    }

    public int getScaledProgress() {
        return 0;
    }
}
