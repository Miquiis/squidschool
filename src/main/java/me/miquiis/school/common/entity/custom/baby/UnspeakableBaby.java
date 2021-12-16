package me.miquiis.school.common.entity.custom.baby;

import me.miquiis.school.common.entity.custom.BabyTemplate;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class UnspeakableBaby extends BabyTemplate {
    public UnspeakableBaby(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn, "Baby Unspeakable", "baby_unspeakable");
    }
}

