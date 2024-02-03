package net.androidc4.androidsweapons;

import net.androidc4.androidsweapons.entity.client.VoidProjectileEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;



public class AndroidsweaponsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Androidsweapons.VOIDREAPERPROJECTILE, VoidProjectileEntityRenderer::new);
    }
}
