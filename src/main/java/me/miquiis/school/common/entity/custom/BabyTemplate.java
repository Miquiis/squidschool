package me.miquiis.school.common.entity.custom;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class BabyTemplate extends BabyPlayerEntity {
    public BabyTemplate(EntityType<? extends CreatureEntity> type, World worldIn, String name, String resourceName) {
        super(type, worldIn);
        setNames(name, resourceName);
    }
}

