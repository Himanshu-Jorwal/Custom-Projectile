package net.deva.lance.entity.client;

import net.deva.lance.Lance;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.util.Identifier;

public class LanceProjectileModel extends EntityModel<EntityRenderState> {
    public static final EntityModelLayer LANCE = new EntityModelLayer(Identifier.of(Lance.MOD_ID, "lance"), "main");
    private final ModelPart lance;

    public LanceProjectileModel(ModelPart root) {
        super(root);
        this.lance = root.getChild("lance");
    }

    public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData lance = modelPartData.addChild("lance", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -30.0F, -0.5F, 1.0F, 30.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 0).cuboid(-1.5F, -40.0F, -0.5F, 1.0F, 12.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 0).cuboid(0.5F, -40.0F, -0.5F, 1.0F, 12.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 11).cuboid(-1.0F, -28.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		return TexturedModelData.of(modelData, 32, 32);
	}
}