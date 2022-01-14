package me.miquiis.school.common.entity;

import me.miquiis.school.School;
import me.miquiis.school.common.entity.custom.PlayerEntity;
import me.miquiis.school.common.entity.custom.baby.*;
import me.miquiis.school.common.entity.custom.fnaf.FreddyEntity;
import me.miquiis.school.common.entity.custom.fnaf.GuardEntity;
import me.miquiis.school.common.entity.custom.fnaf.RoxanneEntity;
import me.miquiis.school.common.entity.custom.fnaf.VannyEntity;
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

    public static final RegistryObject<EntityType<BusDriver>> BUS_DRIVER =
            ENTITY_TYPES.register("bus_driver",
                    () -> EntityType.Builder.create(BusDriver::new, EntityClassification.CREATURE)
                            .size(0.6f, 1.8f)
                            .build(new ResourceLocation(School.MOD_ID, "bus_driver").toString())
            );

    public static final RegistryObject<EntityType<GuardEntity>> SECURITY_GUARD =
            ENTITY_TYPES.register("security_guard",
                    () -> EntityType.Builder.create(GuardEntity::new, EntityClassification.CREATURE)
                            .size(0.8f, 3.0f)
                            .build(new ResourceLocation(School.MOD_ID, "security_guard").toString())
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

    public static final RegistryObject<EntityType<FragsUniformedBaby>> FRAGS_UNIFORMED_PLAYER =
            ENTITY_TYPES.register("frags_uniformed_player",
                    () -> EntityType.Builder.create(FragsUniformedBaby::new, EntityClassification.CREATURE)
                            .size(0.35f, 0.75f)
                            .build(new ResourceLocation(School.MOD_ID, "frags_uniformed_player").toString())
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

    public static final RegistryObject<EntityType<FreddyEntity>> FREDDY_ENTITY =
            ENTITY_TYPES.register("freddy",
                    () -> EntityType.Builder.create(FreddyEntity::new, EntityClassification.CREATURE)
                            .size(1f, 3f)
                            .build(new ResourceLocation(School.MOD_ID, "freddy").toString())
            );

    public static final RegistryObject<EntityType<VannyEntity>> VANNY_ENTITY =
            ENTITY_TYPES.register("vanny",
                    () -> EntityType.Builder.create(VannyEntity::new, EntityClassification.CREATURE)
                            .size(1f, 3f)
                            .build(new ResourceLocation(School.MOD_ID, "vanny").toString())
            );

    public static final RegistryObject<EntityType<RoxanneEntity>> ROXANNE_ENTITY =
            ENTITY_TYPES.register("roxanne",
                    () -> EntityType.Builder.create(RoxanneEntity::new, EntityClassification.CREATURE)
                            .size(1f, 3f)
                            .build(new ResourceLocation(School.MOD_ID, "roxanne").toString())
            );

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }

}
