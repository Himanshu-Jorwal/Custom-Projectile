package net.deva.lance.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.deva.lance.Lance;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.item.Items;

public class LanceItemGroups {
    public static final ItemGroup DIVINE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Lance.MOD_ID, "divine"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.NETHER_STAR))
                    .displayName(Text.translatable("Divine"))
                    .entries((displayContext, entries) -> {

                        entries.add(LanceItems.LANCE);

                    }).build());

    public static void registerItemGroups() {
        Lance.LOGGER.info("Registering Item Groups for " + Lance.MOD_ID);
    }
}