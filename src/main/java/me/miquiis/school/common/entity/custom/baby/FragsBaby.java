package me.miquiis.school.common.entity.custom.baby;

import me.miquiis.school.common.entity.custom.BabyTemplate;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class FragsBaby extends BabyTemplate {
    public FragsBaby(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn, "Baby Preston", "&c", "baby_frags");
    }
}

