package me.miquiis.school.common.events;

import me.miquiis.record.common.events.custom.RecordEventPlayEvent;
import me.miquiis.school.School;
import me.miquiis.school.common.block.ModBlocks;
import me.miquiis.school.common.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.NetworkHooks;

@Mod.EventBusSubscriber(modid = School.MOD_ID)
public class ForgeEvents {

    @SubscribeEvent
    public static void onRecordPlayEvent(RecordEventPlayEvent e)
    {
        System.out.println("Trigger Event Start");

        if (e.getEventLabel().equalsIgnoreCase("salario")) {
            System.out.println("Trigger Salario");
        }
    }

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.RightClickBlock e)
    {
        if (e.getSide().isClient()) return;
        if (e.getHand() != Hand.MAIN_HAND) return;
        final BlockState blockInteracted = e.getWorld().getBlockState(e.getPos());
        final ServerWorld serverWorld = (ServerWorld) e.getWorld();
        if (e.getItemStack().getItem().equals(ModItems.TORNED_UNIFORM.get()) && blockInteracted.getBlock().matchesBlock(ModBlocks.SEWING_MACHINE.get()))
        {
            e.setCanceled(true);
            CompoundNBT fixedTag = e.getItemStack().getOrCreateTag();
            int repair = fixedTag.getInt("repair");
            if (repair >= 5)
            {
                serverWorld.playSound(null,e.getPos().getX(), e.getPos().getY(), e.getPos().getZ(), SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.NEUTRAL, 0.5f, 1.5f);
                serverWorld.playSound(null,e.getPos().getX(), e.getPos().getY(), e.getPos().getZ(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.NEUTRAL, 0.5f, 1.0f);
                e.getPlayer().setHeldItem(Hand.MAIN_HAND, new ItemStack(ModItems.UNIFORM.get(), 1));
            }
            else {
                serverWorld.playSound(null,e.getPos().getX(), e.getPos().getY(), e.getPos().getZ(), SoundEvents.BLOCK_ANVIL_USE, SoundCategory.NEUTRAL, 0.5f, (1.5f + e.getWorld().rand.nextFloat() * 0.5f));
                serverWorld.spawnParticle(ParticleTypes.HAPPY_VILLAGER, e.getPos().getX() + 0.5, e.getPos().getY() + 0.5, e.getPos().getZ() + 0.5,5, (-0.5 + e.getWorld().rand.nextDouble()), (-0.5 + e.getWorld().rand.nextDouble()), (-0.5 + e.getWorld().rand.nextDouble()), 0.0D);
                fixedTag.putInt("repair", repair + 1);
                e.getItemStack().setTag(fixedTag);
            }
        }
    }

}
