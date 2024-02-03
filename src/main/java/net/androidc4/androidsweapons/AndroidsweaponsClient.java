package net.androidc4.androidsweapons;

import net.androidc4.androidsweapons.entity.ModEntities;
import net.androidc4.androidsweapons.entity.client.VoidProjectileEntityRenderer;
import net.androidc4.androidsweapons.entity.custom.VoidReaperProjectileEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;


public class AndroidsweaponsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Androidsweapons.VOIDREAPERPROJECTILE, VoidProjectileEntityRenderer::new);
    }
}
