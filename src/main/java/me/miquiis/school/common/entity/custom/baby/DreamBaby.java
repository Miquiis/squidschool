package me.miquiis.school.common.entity.custom.baby;

import me.miquiis.school.common.entity.custom.BabyTemplate;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class DreamBaby extends BabyTemplate {
    public DreamBaby(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn, "Baby Dream", "baby_dream");
    }
}

