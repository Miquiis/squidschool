package me.miquiis.school.common.entity.model;

import me.miquiis.school.School;
import me.miquiis.school.common.entity.custom.fnaf.GuardEntity;
import me.miquiis.school.common.entity.custom.fnaf.VannyEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class GuardModel extends AnimatedGeoModel<GuardEntity> {

    @Override
    public ResourceLocation getModelLocation(GuardEntity object) {
        return new ResourceLocation(School.MOD_ID, "geo/vanny.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GuardEntity object) {
        return new ResourceLocation(School.MOD_ID, "textures/entity/vanny.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GuardEntity animatable) {
        return new ResourceLocation(School.MOD_ID, "animations/vanny.animation.json");
    }

    @Override
    public void setLivingAnimations(GuardEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        LivingEntity entityIn = (LivingEntity) entity;
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}
