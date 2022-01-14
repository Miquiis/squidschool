package me.miquiis.school.common.entity.custom;

import me.miquiis.school.common.utils.ColorUtils;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

public class BabyTemplate extends PlayerEntity {
    public BabyTemplate(EntityType<? extends CreatureEntity> type, World worldIn, String name, String prefix, String resourceName) {
        super(type, worldIn);
        setNames(name, prefix, resourceName);
    }

    public void sendMessageInChat(String message)
    {
        if (this.world.isRemote) return;
        this.world.getPlayers().forEach(playerEntity -> {
            playerEntity.sendMessage(new StringTextComponent(ColorUtils.color(getPrefix() + "<" + getBabyName() +"> &r" + message)), new UUID(0, 0));
        });
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(6, new CustomLookAtGoal(this, net.minecraft.entity.player.PlayerEntity.class, 12.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(1, new PickUpLoot(this));
    }
}

class CustomLookRandomlyGoal extends Goal {
    private final MobEntity idleEntity;
    private double lookX;
    private double lookZ;
    private int idleTime;

    public CustomLookRandomlyGoal(MobEntity entitylivingIn) {
        this.idleEntity = entitylivingIn;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean shouldExecute() {
        return !this.idleEntity.getTags().contains("recording") && this.idleEntity.getRNG().nextFloat() < 0.02F;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting() {
        return this.idleTime >= 0;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        double d0 = (Math.PI * 2D) * this.idleEntity.getRNG().nextDouble();
        this.lookX = Math.cos(d0);
        this.lookZ = Math.sin(d0);
        this.idleTime = 20 + this.idleEntity.getRNG().nextInt(20);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        --this.idleTime;
        this.idleEntity.getLookController().setLookPosition(this.idleEntity.getPosX() + this.lookX, this.idleEntity.getPosYEye(), this.idleEntity.getPosZ() + this.lookZ);
    }
}

class CustomLookAtGoal extends Goal {
    protected final MobEntity entity;
    protected Entity closestEntity;
    protected final float maxDistance;
    private int lookTime;
    protected final float chance;
    protected final Class<? extends LivingEntity> watchedClass;
    protected final EntityPredicate targetEntitySelector;

    public CustomLookAtGoal(MobEntity entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
        this(entityIn, watchTargetClass, maxDistance, 1F);
    }

    public CustomLookAtGoal(MobEntity entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance, float chanceIn) {
        this.entity = entityIn;
        this.watchedClass = watchTargetClass;
        this.maxDistance = maxDistance;
        this.chance = chanceIn;
        this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
        if (watchTargetClass == net.minecraft.entity.player.PlayerEntity.class) {
            this.targetEntitySelector = (new EntityPredicate()).setDistance((double)maxDistance).allowFriendlyFire().allowInvulnerable().setSkipAttackChecks().setCustomPredicate((target) -> {
                return EntityPredicates.notRiding(entityIn).test(target);
            });
        } else {
            this.targetEntitySelector = (new EntityPredicate()).setDistance((double)maxDistance).allowFriendlyFire().allowInvulnerable().setSkipAttackChecks();
        }

    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean shouldExecute() {
        if (this.entity.getRNG().nextFloat() >= this.chance) {
            return false;
        } else if (this.entity.getTags().contains("recording")) {
            return false;
        } else {
            if (this.entity.getAttackTarget() != null) {
                this.closestEntity = this.entity.getAttackTarget();
            }

            if (this.watchedClass == net.minecraft.entity.player.PlayerEntity.class) {
                this.closestEntity = this.entity.world.getClosestPlayer(this.targetEntitySelector, this.entity, this.entity.getPosX(), this.entity.getPosYEye(), this.entity.getPosZ());
            } else {
                this.closestEntity = this.entity.world.getClosestEntity(this.watchedClass, this.targetEntitySelector, this.entity, this.entity.getPosX(), this.entity.getPosYEye(), this.entity.getPosZ(), this.entity.getBoundingBox().grow((double)this.maxDistance, 3.0D, (double)this.maxDistance));
            }

            return this.closestEntity != null;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting() {
        if (!this.closestEntity.isAlive()) {
            return false;
        } else if (this.entity.getDistanceSq(this.closestEntity) > (double)(this.maxDistance * this.maxDistance)) {
            return false;
        } else {
            return this.lookTime > 0;
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.lookTime = 40 + this.entity.getRNG().nextInt(40);
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask() {
        this.closestEntity = null;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        this.entity.getLookController().setLookPosition(this.closestEntity.getPosX(), this.closestEntity.getPosYEye(), this.closestEntity.getPosZ());
        --this.lookTime;
    }
}

