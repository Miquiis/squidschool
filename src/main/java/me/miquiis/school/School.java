package me.miquiis.school;

import me.miquiis.school.common.block.ModBlocks;
import me.miquiis.school.common.entity.ModEntityTypes;
import me.miquiis.school.common.entity.custom.MarbleEntity;
import me.miquiis.school.common.entity.render.PlayerRenderer;
import me.miquiis.school.common.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(School.MOD_ID)
public class School
{
    public static final String MOD_ID = "school";

    private static School instance;

    public School() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntityTypes.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);
        modEventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

        GeckoLib.initialize();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        instance = this;
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PLAYER.get(), (ren) -> new PlayerRenderer(ren, false));

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MARBLE_ENTITY.get(), manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.APHMAU_PLAYER.get(), (ren) -> new PlayerRenderer(ren, true));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MRBEAST_PLAYER.get(), (ren) -> new PlayerRenderer(ren, false));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UNSPEAKABLE_PLAYER.get(), (ren) -> new PlayerRenderer(ren, true));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LEAH_ASHE_PLAYER.get(), (ren) -> new PlayerRenderer(ren, true));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DREAM_PLAYER.get(), (ren) -> new PlayerRenderer(ren, false));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FRAGS_PLAYER.get(), (ren) -> new PlayerRenderer(ren, false));
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

    }

    private void processIMC(final InterModProcessEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    public static School getInstance() {
        return instance;
    }
}
