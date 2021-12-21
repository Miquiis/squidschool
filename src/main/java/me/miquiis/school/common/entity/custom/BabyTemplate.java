package me.miquiis.school.common.entity.custom;

import me.miquiis.school.common.utils.ColorUtils;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.brain.task.LookAtEntityTask;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BabyTemplate extends PlayerEntity {
    public BabyTemplate(EntityType<? extends CreatureEntity> type, World worldIn, String name, String prefix, String resourceName) {
        super(type, worldIn);
        setNames(name, prefix, resourceName);
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        sendMessageInChat("Hello, world");
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    public void sendMessageInChat(String message)
    {
        if (this.world.isRemote) return;
        this.world.getPlayers().forEach(playerEntity -> {
            playerEntity.sendMessage(new StringTextComponent(ColorUtils.color(getPrefix() + "<" + getBabyName() +"> &r" + message)), null);
        });
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new LookAtGoal(this, net.minecraft.entity.player.PlayerEntity.class, 20.0F));
        System.out.println("Getting called");
    }
}

