package net.deva.lance;

import net.fabricmc.api.ModInitializer;
import net.deva.lance.entity.LanceEntities;
import net.deva.lance.item.LanceItemGroups;
import net.deva.lance.item.LanceItems;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lance implements ModInitializer {
	public static final String MOD_ID = "lance";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final SoundEvent LANCE_ROAR = new SoundEvent(Identifier.of(MOD_ID, "lance_roar"), Optional.empty());

	@Override
	public void onInitialize() {
		LanceItemGroups.registerItemGroups();
		LanceItems.registerModItems();
		LanceEntities.registerModEntities();
		Registry.register(Registries.SOUND_EVENT, Identifier.of(MOD_ID, "lance_roar"), LANCE_ROAR);

	}
}