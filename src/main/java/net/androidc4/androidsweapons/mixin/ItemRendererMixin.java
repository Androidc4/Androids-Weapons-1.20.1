package net.androidc4.androidsweapons.mixin;

import net.androidc4.androidsweapons.Androidsweapons;
import net.androidc4.androidsweapons.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public  abstract  class ItemRendererMixin {
     @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
        public BakedModel userVoidReaperModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean lefthanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
         if (stack.isOf(ModItems.VOIDREAPER) && renderMode != ModelTransformationMode.GUI) {
             return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Androidsweapons.MOD_ID, "void_reaper_3d", "inventory"));
         }
         return value;
     }
    }

