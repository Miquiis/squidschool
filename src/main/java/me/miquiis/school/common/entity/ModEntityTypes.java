package me.miquiis.school.common.entity;

import me.miquiis.school.School;
import me.miquiis.school.common.entity.custom.MarbleEntity;
import me.miquiis.school.common.entity.custom.PlayerEntity;
import me.miquiis.school.common.entity.custom.baby.*;
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

    public static final RegistryObject<EntityType<PlayerEntity>> PLAYER =
            ENTITY_TYPES.register("player",
                    () -> EntityType.Builder.create(PlayerEntity::new, EntityClassification.CREATURE)
                            .size(0.35f, 0.75f)
                            .build(new ResourceLocation(School.MOD_ID, "player").toString())
            );

    public static final RegistryObject<EntityType<AphmauBaby>> APHMAU_PLAYER =
            ENTITY_TYPES.register("aphmau_player",
                    () -> EntityType.Builder.create(AphmauBaby::new, EntityClassification.CREATURE)
                            .size(0.35f, 0.75f)
                            .build(new ResourceLocation(School.MOD_ID, "aphmau_player").toString())
            );

    public static final RegistryObject<EntityType<DreamBaby>> DREAM_PLAYER =
            ENTITY_TYPES.register("dream_player",
                    () -> EntityType.Builder.create(DreamBaby::new, EntityClassification.CREATURE)
                            .size(0.35f, 0.75f)
                            .build(new ResourceLocation(School.MOD_ID, "dream_player").toString())
            );

    public static final RegistryObject<EntityType<FragsBaby>> FRAGS_PLAYER =
            ENTITY_TYPES.register("frags_player",
                    () -> EntityType.Builder.create(FragsBaby::new, EntityClassification.CREATURE)
                            .size(0.35f, 0.75f)
                            .build(new ResourceLocation(School.MOD_ID, "frags_player").toString())
            );

    public static final RegistryObject<EntityType<LeahAsheBaby>> LEAH_ASHE_PLAYER =
            ENTITY_TYPES.register("leah_ashe_player",
                    () -> EntityType.Builder.create(LeahAsheBaby::new, EntityClassification.CREATURE)
                            .size(0.35f, 0.75f)
                            .build(new ResourceLocation(School.MOD_ID, "leah_ashe_player").toString())
            );

    public static final RegistryObject<EntityType<MrBeastBaby>> MRBEAST_PLAYER =
            ENTITY_TYPES.register("mrbeast_player",
                    () -> EntityType.Builder.create(MrBeastBaby::new, EntityClassification.CREATURE)
                            .size(0.35f, 0.75f)
                            .build(new ResourceLocation(School.MOD_ID, "mrbeast_player").toString())
            );

    public static final RegistryObject<EntityType<UnspeakableBaby>> UNSPEAKABLE_PLAYER =
            ENTITY_TYPES.register("unspeakable_player",
                    () -> EntityType.Builder.create(UnspeakableBaby::new, EntityClassification.CREATURE)
                            .size(0.35f, 0.75f)
                            .build(new ResourceLocation(School.MOD_ID, "unspeakable_player").toString())
            );

    public static final RegistryObject<EntityType<MarbleEntity>> MARBLE_ENTITY =
            ENTITY_TYPES.register("marble",
                    () -> EntityType.Builder.<MarbleEntity>create(MarbleEntity::new, EntityClassification.MISC)
                            .size(0.25F, 0.25F).trackingRange(4).updateInterval(10)
                            .build(new ResourceLocation(School.MOD_ID, "marble").toString())
            );

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }

}
