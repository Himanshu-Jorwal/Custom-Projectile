package net.deva.lance.entity.client;

import net.deva.lance.Lance;
import net.deva.lance.entity.custom.LanceProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class LanceProjectileRenderer extends EntityRenderer<LanceProjectileEntity, EntityRenderState>{
    private final LanceProjectileModel model;

    public LanceProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new LanceProjectileModel(context.getPart(LanceProjectileModel.LANCE));
    }

    @Override
    public void render(EntityRenderState state, MatrixStack matrices,
                VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

    VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(vertexConsumers,
            this.model.getLayer(Identifier.of(Lance.MOD_ID, "textures/entity/lance.png")), false, false);

        this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();
        super.render(state, matrices, vertexConsumers, light);
    }

    
    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

}
