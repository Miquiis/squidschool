package me.miquiis.school.common.entity.custom;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.LookController;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BabyPlayerEntity extends CreatureEntity implements IAnimatable {

    private String name;
    private String resourceName;

    private AnimationFactory factory = new AnimationFactory(this);

    public BabyPlayerEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
        this.ignoreFrustumCheck = true;
        this.lookController = new BabyLookControler(this);
        setNames("Baby Template", "baby_template");
    }

    public void setNames(String name, String resourceName)
    {
        this.name = name;
        this.resourceName = resourceName;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.33D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 50.0D);
    }

    @Override
    protected void registerGoals() {
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
//        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.baby.panic", true));
        if ((getMotion().getX() >= 0.0001 || getMotion().getX() <= -0.0001) || (getMotion().getZ() >= 0.0001 || getMotion().getZ() <= -0.0001))
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.baby.walk", true));
        } else
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.baby.idle", true));
        }
        return PlayState.CONTINUE;
    }

    private <E extends IAnimatable> PlayState amrsPredicate(AnimationEvent<E> event)
    {
        if (isSwingInProgress && swingProgress == 0f)
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.baby.swing", false));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "walk_controller", 5, this::predicate));
        data.addAnimationController(new AnimationController(this, "arms_controller", 5, this::amrsPredicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    public String getBabyName() {
        return name;
    }

    public String getResourceName() {
        return resourceName;
    }
}

class BabyLookControler extends LookController {

    public BabyLookControler(MobEntity mob) {
        super(mob);
    }

    @Override
    protected boolean shouldResetPitch() {
        return false;
    }
}

