package me.miquiis.school.common.events;

import me.miquiis.school.School;
import me.miquiis.school.common.entity.ModEntityTypes;
import me.miquiis.school.common.entity.render.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = School.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PLAYER.get(), (ren) -> new PlayerRenderer(ren, false));

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BUS_DRIVER.get(), (ren) -> new NormalPlayerRenderer(ren, false));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SECURITY_GUARD.get(), GuardRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FREDDY_ENTITY.get(), FreddyRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ROXANNE_ENTITY.get(), RoxanneRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.VANNY_ENTITY.get(), VannyRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.APHMAU_PLAYER.get(), (ren) -> new PlayerRenderer(ren, true));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MRBEAST_PLAYER.get(), (ren) -> new PlayerRenderer(ren, false));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UNSPEAKABLE_PLAYER.get(), (ren) -> new PlayerRenderer(ren, true));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LEAH_ASHE_PLAYER.get(), (ren) -> new PlayerRenderer(ren, true));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DREAM_PLAYER.get(), (ren) -> new PlayerRenderer(ren, false));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FRAGS_PLAYER.get(), (ren) -> new PlayerRenderer(ren, false));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FRAGS_UNIFORMED_PLAYER.get(), (ren) -> new PlayerRenderer(ren, false));
    }

}
