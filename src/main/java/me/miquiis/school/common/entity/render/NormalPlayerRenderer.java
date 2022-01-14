package me.miquiis.school.common.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import me.miquiis.school.common.entity.custom.PlayerEntity;
import me.miquiis.school.common.entity.model.NormalPlayerModel;
import me.miquiis.school.common.entity.model.PlayerModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class NormalPlayerRenderer extends GeoEntityRenderer<PlayerEntity> {

    public NormalPlayerRenderer(EntityRendererManager renderManager, boolean isSlim)
    {
        super(renderManager, new NormalPlayerModel(isSlim));
        this.shadowSize = 0.5F;
        this.addLayer(new HeldItemLayer(this));
    }

    @Override
    public void render(PlayerEntity entity, float entityYaw, float partialTicks, MatrixStack stack, IRenderTypeBuffer bufferIn, int packedLightIn) {
        renderKindaName(entity, new StringTextComponent(entity.getBabyName()), stack, bufferIn, packedLightIn);
        super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
    }

    protected void renderKindaName(Entity entityIn, ITextComponent displayNameIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        double d0 = this.renderManager.squareDistanceTo(entityIn);
        if (net.minecraftforge.client.ForgeHooksClient.isNameplateInRenderDistance(entityIn, d0)) {
            boolean flag = !entityIn.isDiscrete();
            float f = entityIn.getHeight() + 0.5F;
            int i = "deadmau5".equals(displayNameIn.getString()) ? -10 : 0;
            matrixStackIn.push();
            matrixStackIn.translate(0.0D, (double)f, 0.0D);
            matrixStackIn.rotate(this.renderManager.getCameraOrientation());
            matrixStackIn.scale(-0.025F, -0.025F, 0.025F);
            Matrix4f matrix4f = matrixStackIn.getLast().getMatrix();
            float f1 = Minecraft.getInstance().gameSettings.getTextBackgroundOpacity(0.25F);
            int j = (int)(f1 * 255.0F) << 24;
            FontRenderer fontrenderer = this.getFontRendererFromRenderManager();
            float f2 = (float)(-fontrenderer.getStringPropertyWidth(displayNameIn) / 2);

            //fontrenderer.func_243247_a(displayNameIn, f2, (float)i, 553648127, false, matrix4f, bufferIn, flag,j, packedLightIn);

            if (flag) {
                fontrenderer.func_243247_a(displayNameIn, f2, (float)i, -1, false, matrix4f, bufferIn, false, j, packedLightIn);
            }

            matrixStackIn.pop();
        }
    }

    @Override
    public ResourceLocation getEntityTexture(PlayerEntity entity) {
        return null;
    }
}
