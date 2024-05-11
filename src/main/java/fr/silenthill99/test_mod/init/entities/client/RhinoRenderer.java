package fr.silenthill99.test_mod.init.entities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.entities.custom.RhinoEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RhinoRenderer extends MobRenderer<RhinoEntity, RhinoModel<RhinoEntity>> {
    public RhinoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RhinoModel<>(pContext.bakeLayer(ModModelLayer.RHINO)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(RhinoEntity p_114482_) {
        return new ResourceLocation(Main.MODID, "textures/entities/rhino.png");
    }

    @Override
    public void render(RhinoEntity p_115455_, float p_115456_, float p_115457_, PoseStack p_115458_,
                       MultiBufferSource p_115459_, int p_115460_) {

        if (p_115455_.isBaby()) {
            p_115458_.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(p_115455_, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
    }
}
