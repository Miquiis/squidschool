package me.miquiis.school.common.events;

import me.miquiis.school.School;
import me.miquiis.school.common.entity.ModEntityTypes;
import me.miquiis.school.common.entity.custom.BabyPlayerEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = School.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntityTypes.BABY_PLAYER.get(), BabyPlayerEntity.setCustomAttributes().create());
    }

}
