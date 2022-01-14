package me.miquiis.school.common.entity.custom.baby;

import me.miquiis.school.common.entity.custom.BabyTemplate;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class BusDriver extends BabyTemplate {
    public BusDriver(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn, "Bus Driver", "&e", "bus_driver");
    }
}
