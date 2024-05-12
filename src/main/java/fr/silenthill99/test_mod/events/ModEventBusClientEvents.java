package fr.silenthill99.test_mod.events;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.custom.entities.client.ModModelLayer;
import fr.silenthill99.test_mod.custom.entities.client.RhinoModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayer.RHINO, RhinoModel::createBodyLayer);
    }
}
