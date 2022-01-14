package me.miquiis.school.common.entity.model;

import me.miquiis.school.School;
import me.miquiis.school.common.entity.custom.PlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class NormalPlayerModel extends AnimatedGeoModel<PlayerEntity> {

    private boolean isSlim;

    public NormalPlayerModel(boolean isSlim)
    {
        this.isSlim = isSlim;
    }

    @Override
    public ResourceLocation getModelLocation(PlayerEntity object) {
        return new ResourceLocation(School.MOD_ID, "geo/player" + (isSlim ? "_slim" : "") + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(PlayerEntity object) {
        return new ResourceLocation(School.MOD_ID, "textures/entity/" + object.getResourceName() + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(PlayerEntity animatable) {
        return new ResourceLocation(School.MOD_ID, "animations/player" + (isSlim ? "_slim" : "") + ".animation.json");
    }

    @Override
    public void setLivingAnimations(PlayerEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head_c");
        LivingEntity entityIn = (LivingEntity) entity;
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}
