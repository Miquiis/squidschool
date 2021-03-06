package me.miquiis.school.common.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import me.miquiis.school.School;
import me.miquiis.school.common.entity.custom.PlayerEntity;
import me.miquiis.school.common.entity.model.PlayerModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

@OnlyIn(Dist.CLIENT)
public class HeldItemLayer extends GeoLayerRenderer<PlayerEntity> {

    private ResourceLocation modelLocation = new ResourceLocation(School.MOD_ID, "geo/player.geo.json");
    private ItemStack mainHand;

    public HeldItemLayer(IGeoRenderer<PlayerEntity> entityRendererIn) {
        super(entityRendererIn);
    }

    private void func_229135_a_(LivingEntity p_229135_1_, ItemStack p_229135_2_, ItemCameraTransforms.TransformType p_229135_3_, HandSide p_229135_4_, MatrixStack p_229135_5_, IRenderTypeBuffer p_229135_6_, int p_229135_7_) {
        if (!p_229135_2_.isEmpty()) {
            p_229135_5_.push();

            boolean flag = p_229135_4_ == HandSide.LEFT;
            GeoModel model = this.getEntityModel().getModel(modelLocation);
            GeoBone rightArm = model.getBone(flag ? "left_arm_c" : "right_arm_c").get();

            p_229135_5_.translate((double)(rightArm.rotationPointX / 64f), (double)(rightArm.rotationPointY / 32f), (double)(rightArm.rotationPointZ / 64f));

            if (rightArm.getRotationZ() != 0.0F) {
                p_229135_5_.rotate(Vector3f.ZN.rotation(rightArm.getRotationZ()));
            }

            if (rightArm.getRotationY() != 0.0F) {
                p_229135_5_.rotate(Vector3f.YP.rotation(rightArm.getRotationY()));
            }

            if (rightArm.getRotationX() != 0.0F) {
                p_229135_5_.rotate(Vector3f.XN.rotation(rightArm.getRotationX()));
            }

            p_229135_5_.rotate(Vector3f.XP.rotationDegrees(-90.0F));
            p_229135_5_.rotate(Vector3f.YP.rotationDegrees(180.0F));

            p_229135_5_.translate((double)((float)(flag ? -1 : 1) / 2.2), 0.125D * 2, -0.625D * 2);
            Minecraft.getInstance().getFirstPersonRenderer().renderItemSide(p_229135_1_, p_229135_2_, p_229135_3_, flag, p_229135_5_, p_229135_6_, p_229135_7_);
            p_229135_5_.pop();
        }
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, PlayerEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        boolean flag = entitylivingbaseIn.getPrimaryHand() == HandSide.RIGHT;
        ItemStack itemstack = flag ? entitylivingbaseIn.getHeldItemOffhand() : entitylivingbaseIn.getHeldItemMainhand();
        ItemStack itemstack1 = flag ? entitylivingbaseIn.getHeldItemMainhand() : entitylivingbaseIn.getHeldItemOffhand();
        if (!itemstack.isEmpty() || !itemstack1.isEmpty()) {
            matrixStackIn.push();
            this.func_229135_a_(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, HandSide.RIGHT, matrixStackIn, bufferIn, packedLightIn);
            this.func_229135_a_(entitylivingbaseIn, itemstack1, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, HandSide.LEFT, matrixStackIn, bufferIn, packedLightIn);
            matrixStackIn.pop();
        }
    }
}