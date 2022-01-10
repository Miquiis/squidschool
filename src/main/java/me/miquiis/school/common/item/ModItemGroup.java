package me.miquiis.school.common.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup SCHOOL_GROUP = new ItemGroup("schooltab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.UNIFORM.get());
        }
    };

}
