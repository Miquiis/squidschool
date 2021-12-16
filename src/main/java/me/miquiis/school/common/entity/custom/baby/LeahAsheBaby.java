package me.miquiis.school.common.entity.custom.baby;

import me.miquiis.school.common.entity.custom.BabyTemplate;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class LeahAsheBaby extends BabyTemplate {
    public LeahAsheBaby(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn, "Baby Leah Ashe", "baby_leah_ashe");
    }
}

