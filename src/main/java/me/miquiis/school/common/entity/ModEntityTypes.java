package me.miquiis.school.common.entity;

import me.miquiis.school.School;
import me.miquiis.school.common.entity.custom.BabyPlayerEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, School.MOD_ID);

    public static final RegistryObject<EntityType<BabyPlayerEntity>> BABY_PLAYER =
            ENTITY_TYPES.register("baby_player",
                    () -> EntityType.Builder.create(BabyPlayerEntity::new, EntityClassification.CREATURE)
                            .size(0.35f, 0.75f)
                            .build(new ResourceLocation(School.MOD_ID, "baby_player").toString())
            );

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }

}
