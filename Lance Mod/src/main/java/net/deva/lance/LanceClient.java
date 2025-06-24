package net.deva.lance;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.deva.lance.entity.LanceEntities;
import net.deva.lance.entity.client.*;

public class LanceClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(LanceProjectileModel.LANCE, LanceProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(LanceEntities.LANCE, LanceProjectileRenderer::new);
    }
}