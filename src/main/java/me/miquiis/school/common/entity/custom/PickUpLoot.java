package me.miquiis.school.common.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

public class PickUpLoot extends Goal {
    private final MobEntity mobEntity;
    private ItemEntity itemTarget;

    public PickUpLoot(MobEntity mobEntity)
    {
        this.mobEntity = mobEntity;
    }

    @Override
    public boolean shouldExecute() {
        if (itemTarget == null || !itemTarget.isAlive())
        {
            List<ItemEntity> itemsClose = mobEntity.getEntityWorld().getEntitiesWithinAABB(EntityType.ITEM, mobEntity.getBoundingBox().grow(1,1,1), itemEntity -> (!itemEntity.cannotPickup()));
            if (itemsClose.isEmpty()) return false;
            itemTarget = itemsClose.get(0);
            return true;
        }
        return false;
    }

    @Override
    public void startExecuting() {
        if (mobEntity.world.isRemote) return;
        ServerWorld serverWorld = (ServerWorld) mobEntity.world;
        serverWorld.playSound(null, mobEntity.getPosX(), mobEntity.getPosY(), mobEntity.getPosZ(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.NEUTRAL, 0.5f, 1.5f);
        itemTarget.remove();
        itemTarget = null;
    }
}