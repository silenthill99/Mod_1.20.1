package fr.silenthill99.test_mod.custom.items;

import fr.silenthill99.test_mod.utils.ModSoundEvents;
import fr.silenthill99.test_mod.utils.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide) {
            BlockPos pos = context.getClickedPos();
            Player player = context.getPlayer();

            boolean foundBlock = false;

            for (int i = 0; i <= pos.getY() + 64; i++) {
                BlockState state = context.getLevel().getBlockState(pos.below(i));
                if (isValuableBlock(state)) {
                    assert player != null;
                    outputValuableCoordinates(pos.below(i), player, state.getBlock());
                    foundBlock = true;

                    context.getLevel().playSeededSound(null, pos.getX(), pos.getY(), pos.getZ(),
                            ModSoundEvents.METAL_DETECTOR_FOUND_ORE.get(), SoundSource.BLOCKS, 1, 1, 0);

                    break;
                }
            }

            if (!foundBlock) if (player != null) {
                player.sendSystemMessage(Component.literal("No valuables found !"));
            }
        }

        context.getItemInHand().hurtAndBreak(1, context.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponent, @NotNull TooltipFlag pIsAdvanced) {
        pTooltipComponent.add(Component.translatable("tooltip.test_mod.metal_detector.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponent, pIsAdvanced);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }
}
