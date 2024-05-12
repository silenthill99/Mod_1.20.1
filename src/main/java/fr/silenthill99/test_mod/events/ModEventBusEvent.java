package fr.silenthill99.test_mod.events;

import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.init.ModEntityTypes;
import fr.silenthill99.test_mod.custom.entities.custom.RhinoEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEventBusEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.RHINO.get(), RhinoEntity.createAttributes().build());
    }
}
