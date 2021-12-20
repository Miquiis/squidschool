package me.miquiis.school.common.entity.custom;

import me.miquiis.school.common.entity.ModEntityTypes;
import me.miquiis.school.common.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.Random;

public class MarbleEntity extends ProjectileItemEntity {

   private Random random;

   public MarbleEntity(EntityType<MarbleEntity> entityType, World world) {
      super(entityType, world);
      random = new Random();
   }

   public MarbleEntity(World worldIn, LivingEntity throwerIn) {
      super(ModEntityTypes.MARBLE_ENTITY.get(), throwerIn, worldIn);
      random = new Random();
   }

   @OnlyIn(Dist.CLIENT)
   public MarbleEntity(World worldIn, double x, double y, double z) {
      super(ModEntityTypes.MARBLE_ENTITY.get(), x, y, z, worldIn);
      random = new Random();
   }

   protected Item getDefaultItem() {
      return ModItems.MARBLE.get();
   }

   @Override
   public IPacket<?> createSpawnPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   /**
    * Called when the arrow hits an entity
    */
   protected void onEntityHit(EntityRayTraceResult result) {
      super.onEntityHit(result);
      result.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), 0.0F);
   }

   /**
    * Called when this EntityFireball hits a block or entity.
    */
   protected void onImpact(RayTraceResult result) {
      super.onImpact(result);

      this.world.addParticle(ParticleTypes.EXPLOSION, this.getPosX(), this.getPosY(), this.getPosZ(), this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
      this.world.playSound((net.minecraft.entity.player.PlayerEntity)null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

      if (!this.world.isRemote && this.isAlive()) {
         ItemEntity itemEntity = EntityType.ITEM.create(this.world);
         itemEntity.setItem(new ItemStack(ModItems.MARBLE.get(), 1));
         itemEntity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
         this.world.addEntity(itemEntity);

         this.remove();
      }

   }

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      Entity entity = this.getShooter();
      if (entity instanceof PlayerEntity && !entity.isAlive()) {
         this.remove();
      } else {
         super.tick();
      }

   }
}