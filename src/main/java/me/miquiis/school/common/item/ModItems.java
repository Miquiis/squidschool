package me.miquiis.school.common.item;

import me.miquiis.school.School;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, School.MOD_ID);

    public static final RegistryObject<Item> COOKING_POT = ITEMS.register("cooking_pot",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> FLASHLIGHT = ITEMS.register("flashlight",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.DECORATIONS)));

    public static final RegistryObject<Item> FIRE_EXTINGUISHER = ITEMS.register("fire_extinguisher",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));

    public static final RegistryObject<Item> EMPTY_CAN = ITEMS.register("empty_can",
            () -> new Item(new Item.Properties().maxStackSize(64).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> CANNED_UMBRELLA = ITEMS.register("canned_umbrella",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> BROKEN_UMBRELLA = ITEMS.register("broken_umbrella",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> COOKIE_UMBRELLA = ITEMS.register("cookie_umbrella",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> CANNED_TRIANGLE = ITEMS.register("canned_triangle",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> BROKEN_TRIANGLE = ITEMS.register("broken_triangle",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> COOKIE_TRIANGLE = ITEMS.register("cookie_triangle",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> CANNED_CIRCLE = ITEMS.register("canned_circle",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> BROKEN_CIRCLE = ITEMS.register("broken_circle",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> COOKIE_CIRCLE = ITEMS.register("cookie_circle",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> MARBLE = ITEMS.register("marble",
            () -> new MarbleItem(new Item.Properties().maxStackSize(5).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> DEVICE = ITEMS.register("device",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> ID = ITEMS.register("id",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));

    public static final RegistryObject<Item> CHICKEN_SANDWICH = ITEMS.register("chicken_sandwich",
            () -> new Item(new Item.Properties().maxStackSize(64).food(new Food.Builder().saturation(0.6f).hunger(10).build()).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
            () -> new Item(new Item.Properties().maxStackSize(64).food(new Food.Builder().setAlwaysEdible().fastToEat().saturation(0.1f).hunger(4).build()).group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg",
            () -> new Item(new Item.Properties().food(new Food.Builder().saturation(0.3f).hunger(6).build()).maxStackSize(12).group(ItemGroup.FOOD)));

    public static void register(IEventBus bus)
    {
        ITEMS.register(bus);
    }
}
