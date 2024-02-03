package net.androidc4.androidsweapons.entity.client;

import net.androidc4.androidsweapons.Androidsweapons;
import net.androidc4.androidsweapons.entity.custom.VoidReaperProjectileEntity;
import net.androidc4.androidsweapons.item.ModItems;
import net.fabricmc.loader.impl.lib.sat4j.core.Vec;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.command.argument.Vec3ArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.*;
import org.joml.Vector3f;

public class VoidProjectileEntityRenderer extends EntityRenderer<VoidReaperProjectileEntity> {
    private static final Identifier TEXTURE =new Identifier(Androidsweapons.MOD_ID, "textures/entity/void_reaper_projectile.png") ;
    private final ItemRenderer itemRenderer;

    public VoidProjectileEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }
    @Override
    public Identifier getTexture(VoidReaperProjectileEntity entity) {
        return TEXTURE;
    }

    @Override
    protected  int getBlockLight(VoidReaperProjectileEntity entity, BlockPos blockPos) {
        return 15;
    }

    @Override
    public void render(VoidReaperProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        float scale = 0.8f;
        matrices.push();
        matrices.scale(scale, scale, scale);
        matrices.multiply(this.dispatcher.getRotation());
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0f));

        this.itemRenderer.renderItem(((FlyingItemEntity)entity).getStack(), ModelTransformationMode.GROUND, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, ((Entity)entity).getWorld(), ((Entity)entity).getId());
        matrices.pop();
        super.render(entity,yaw,tickDelta,matrices,vertexConsumers,light);
    }
}
