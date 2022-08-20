package com.lumination.backrooms.world.dimensions;

import com.lumination.backrooms.BackroomsMod;
import com.lumination.backrooms.items.ModItems;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.util.PortalLink;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class BackroomDimensions {
    // Level 0
    public static final RegistryKey<World> LVL0_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(BackroomsMod.MOD_ID, "level_0"));
    public static final RegistryKey<DimensionType> BR_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, LVL0_DIMENSION_KEY.getRegistry());

    // Level 1

    public static void registerDims() {
        level(LVL0_DIMENSION_KEY, Blocks.IRON_BLOCK, ModItems.SILK); // Level 0

        BackroomsMod.print("Registered custom dimensions and portals");
    }

    private static PortalLink level(RegistryKey<World> dimensionKey, Block frame, Item lighter) {
        BackroomsMod.print("Registered custom portal of " + dimensionKey.getValue());
        return CustomPortalBuilder
                .beginPortal()
                .destDimID(dimensionKey.getValue())
                .frameBlock(frame)
                .lightWithItem(lighter)
                .tintColor(56, 48, 71)
                .onlyLightInOverworld()
                .registerPortal();
    }
}
