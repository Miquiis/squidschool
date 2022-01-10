package me.miquiis.school.common.item;

import me.miquiis.school.School;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, School.MOD_ID);

    public static final RegistryObject<Item> FLASHLIGHT = ITEMS.register("flashlight",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.SCHOOL_GROUP)));

    public static final RegistryObject<Item> DEVICE = ITEMS.register("device",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.SCHOOL_GROUP)));

    public static final RegistryObject<Item> ID = ITEMS.register("id",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.SCHOOL_GROUP)));

    public static final RegistryObject<Item> CHICKEN_SANDWICH = ITEMS.register("chicken_sandwich",
            () -> new Item(new Item.Properties().maxStackSize(64).food(new Food.Builder().saturation(0.6f).hunger(10).build()).group(ModItemGroup.SCHOOL_GROUP)));

    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg",
            () -> new Item(new Item.Properties().food(new Food.Builder().saturation(0.3f).hunger(6).build()).maxStackSize(16).group(ModItemGroup.SCHOOL_GROUP)));

    public static final RegistryObject<Item> TORNED_UNIFORM = ITEMS.register("torn_uniform",
            () -> new UniformItem(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, (new Item.Properties()).group(ModItemGroup.SCHOOL_GROUP)));

    public static final RegistryObject<Item> UNIFORM = ITEMS.register("uniform",
            () -> new UniformItem(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, (new Item.Properties()).group(ModItemGroup.SCHOOL_GROUP)));

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
