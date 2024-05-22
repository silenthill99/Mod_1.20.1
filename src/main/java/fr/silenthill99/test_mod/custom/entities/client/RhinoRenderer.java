package fr.silenthill99.test_mod.custom.entities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.custom.entities.custom.RhinoEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class RhinoRenderer extends MobRenderer<RhinoEntity, RhinoModel<RhinoEntity>> {
    public RhinoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RhinoModel<>(pContext.bakeLayer(ModModelLayer.RHINO)), 2f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull RhinoEntity rhinoEntity) {
        return new ResourceLocation(Main.MODID, "textures/entity/rhino.png");
    }

    @Override
    public void render(RhinoEntity pEntity, float pEntityYaw, float pPartialTicks, @NotNull PoseStack pPoseStack,
                       @NotNull MultiBufferSource pBuffer, int pPackedLight) {

        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
