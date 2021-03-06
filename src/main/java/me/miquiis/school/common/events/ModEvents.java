package me.miquiis.school.common.events;

import me.miquiis.school.School;
import me.miquiis.school.common.block.ModBlocks;
import me.miquiis.school.common.entity.ModEntityTypes;
import me.miquiis.school.common.entity.custom.PlayerEntity;
import me.miquiis.school.common.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = School.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event)
    {
        ModEntityTypes.ENTITY_TYPES.getEntries().forEach(entityTypeRegistryObject -> {
            try {
                event.put((EntityType<? extends LivingEntity>) entityTypeRegistryObject.get(), PlayerEntity.setCustomAttributes().create());
            } catch (Exception e)
            {

            }
        });
    }

}
