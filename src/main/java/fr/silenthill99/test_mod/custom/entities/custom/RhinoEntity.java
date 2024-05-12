package fr.silenthill99.test_mod.custom.entities.custom;

import fr.silenthill99.test_mod.init.ModEntityTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class RhinoEntity extends Animal {
    public RhinoEntity(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.15d));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2d, Ingredient.of(Items.COOKED_BEEF), false));

        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1d));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.1d));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class,  3f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.FOLLOW_RANGE, 24d)
                .add(Attributes.MOVEMENT_SPEED, 0.25f)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 2);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntityTypes.RHINO.get().create(serverLevel);
    }

    @Override
    public boolean isFood(ItemStack p_27600_) {
        return p_27600_.is(Items.COOKED_BEEF);
    }
}
