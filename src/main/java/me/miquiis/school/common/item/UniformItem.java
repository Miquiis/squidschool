package me.miquiis.school.common.item;

import me.miquiis.school.common.entity.ModEntityTypes;
import me.miquiis.school.common.entity.custom.baby.FragsUniformedBaby;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class UniformItem extends ArmorItem {
    public UniformItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
        super(materialIn, slot, builderIn);
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
        if (target.getEntityWorld().isRemote) return ActionResultType.PASS;

        ItemStack itemstack = playerIn.getHeldItem(hand);
        if (itemstack.getItem().equals(ModItems.TORNED_UNIFORM.get())) return ActionResultType.FAIL;
        if (hand != Hand.MAIN_HAND) return ActionResultType.FAIL;

        if (target.getType() == ModEntityTypes.FRAGS_PLAYER.get())
        {
            target.remove();
            FragsUniformedBaby fragsUniformedBaby = ModEntityTypes.FRAGS_UNIFORMED_PLAYER.get().create(target.getEntityWorld());
            fragsUniformedBaby.setLocationAndAngles(target.getPosX(), target.getPosY(), target.getPosZ(), target.rotationYaw, target.rotationPitch);
            target.getEntityWorld().addEntity(fragsUniformedBaby);
            fragsUniformedBaby.setUniqueId(target.getUniqueID());
            return ActionResultType.SUCCESS;
        }

        return ActionResultType.FAIL;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return ActionResult.resultPass(playerIn.getHeldItem(handIn));
    }
}
