package net.deva.lance.entity;

import net.deva.lance.Lance;
import net.deva.lance.entity.custom.LanceProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class LanceEntities {
    private static final RegistryKey<EntityType<?>> LANCE_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Lance.MOD_ID, "lance"));

    public static final EntityType<LanceProjectileEntity> LANCE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Lance.MOD_ID, "lance"),
            EntityType.Builder.<LanceProjectileEntity>create(LanceProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f).build(LANCE_KEY));

    public static void registerModEntities() {
        Lance.LOGGER.info("Registering Mod Entities for " + Lance.MOD_ID);
    }
}