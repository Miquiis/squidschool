package me.miquiis.school.common.entity.model;

import me.miquiis.school.School;
import me.miquiis.school.common.entity.custom.fnaf.FreddyEntity;
import me.miquiis.school.common.entity.custom.fnaf.RoxanneEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class RoxanneModel extends AnimatedGeoModel<RoxanneEntity> {

    @Override
    public ResourceLocation getModelLocation(RoxanneEntity object) {
        return new ResourceLocation(School.MOD_ID, "geo/roxanne.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(RoxanneEntity object) {
        return new ResourceLocation(School.MOD_ID, "textures/entity/roxanne.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(RoxanneEntity animatable) {
        return new ResourceLocation(School.MOD_ID, "animations/roxanne.animation.json");
    }

    @Override
    public void setLivingAnimations(RoxanneEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        LivingEntity entityIn = (LivingEntity) entity;
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}
