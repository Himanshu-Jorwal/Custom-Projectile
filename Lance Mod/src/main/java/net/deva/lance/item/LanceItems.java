package net.deva.lance.item;

import java.util.function.Function;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;

import net.deva.lance.Lance;
import net.deva.lance.item.custom.LanceItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class LanceItems {

    public static final Item LANCE = registerItem("lance", settings -> {
        AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();

        builder.add(
            EntityAttributes.ATTACK_DAMAGE,
            new EntityAttributeModifier(
                Identifier.of(Lance.MOD_ID, "attack_damage"),
                20.0,
                EntityAttributeModifier.Operation.ADD_VALUE
            ),
            AttributeModifierSlot.MAINHAND
        );

        builder.add(
            EntityAttributes.ATTACK_SPEED,
            new EntityAttributeModifier(
                Identifier.of(Lance.MOD_ID, "attack_speed"),
                -3.0,
                EntityAttributeModifier.Operation.ADD_VALUE
            ),
            AttributeModifierSlot.MAINHAND
        );

        AttributeModifiersComponent attributeModifiers = builder.build();

        return new LanceItem(settings
            .attributeModifiers(attributeModifiers)
            .maxCount(1)
            .maxDamage(750)
            .rarity(net.minecraft.util.Rarity.EPIC)
        );
    });

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Lance.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Lance.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Lance.LOGGER.info("Registering Mod Items for " + Lance.MOD_ID);
    }
}
