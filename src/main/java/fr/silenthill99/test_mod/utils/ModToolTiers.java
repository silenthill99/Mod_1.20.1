package fr.silenthill99.test_mod.utils;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public enum ModToolTiers implements Tier {
    SAPPHIRE("sapphire", 5, 1500, 5f, 4, 25,
            ModTags.Blocks.NEEDS_SAPPHIRE_TOOLS, () -> Ingredient.of(ModItems.SAPPHIRE.get()), List.of(Tiers.NETHERITE),
            List.of())
    ;
    private final int level;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final @NotNull TagKey<Block> tag;
    private final @NotNull Supplier<Ingredient> repairIngredient;

    ModToolTiers(String name, int level, int uses, float speed, float attackDamageBonus, int enchantmentValue,
                 @NotNull TagKey<Block> tag, @NotNull Supplier<Ingredient> repairIngredient, List<Object> after,
                 List<Object> before) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.tag = tag;
        this.repairIngredient = repairIngredient;
        TierSortingRegistry.registerTier(new ForgeTier(level, uses, speed, attackDamageBonus, enchantmentValue, tag,
                repairIngredient), new ResourceLocation(Main.MODID, name), after, before);
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public @NotNull TagKey<Block> getTag() {
        return tag;
    }
}
