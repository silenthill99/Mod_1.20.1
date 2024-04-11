package fr.silenthill99.test_mod.init.entities.client;

import fr.silenthill99.test_mod.Main;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayer {
    public static final ModelLayerLocation RHINO = new ModelLayerLocation(
            new ResourceLocation(Main.MODID, "rhino"), "main"
    );
}
