package net.deva.lance.item.custom;

import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.deva.lance.entity.custom.LanceProjectileEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.item.consume.UseAction;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class LanceItem extends TridentItem {

    public static final UUID ATTACK_DAMAGE_MODIFIER_ID = UUID.fromString("b1c90102-84f6-4b11-b27f-93f4e9e1cb03");
    public static final UUID ATTACK_SPEED_MODIFIER_ID = UUID.fromString("b1c90102-84f6-4b11-b27f-93f4e9e1cb04");

    public LanceItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return ActionResult.CONSUME;
    }

    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity player)) return false;

        int chargeTime = this.getMaxUseTime(stack) - remainingUseTicks;
        if (chargeTime < 20) return false;

        if (!world.isClient) {
            LanceProjectileEntity lance = new LanceProjectileEntity(world, player);
            lance.setVelocity(player, player.getPitch(), player.getYaw(), 0.0f, 2.5f, 1.0f);
            world.spawnEntity(lance);
        }

        world.playSound(null, player.getX(), player.getY(), player.getZ(),SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS,1.0f, 1.0f);

        player.incrementStat(Stats.USED.getOrCreateStat(this));

        if (!player.getAbilities().creativeMode) {
            stack.decrement(1);
        }
        return true;
    }

    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        ImmutableMultimap.Builder<RegistryEntry<EntityAttribute>, EntityAttributeModifier> builder = ImmutableMultimap.builder();

        if (slot == EquipmentSlot.MAINHAND) {
            builder.put(EntityAttributes.ATTACK_DAMAGE,
                    new EntityAttributeModifier(Identifier.of("lance", "attack_damage"), 20.0, EntityAttributeModifier.Operation.ADD_VALUE));
            builder.put(EntityAttributes.ATTACK_SPEED,
                    new EntityAttributeModifier(Identifier.of("lance", "attack_speed"), -3.0, EntityAttributeModifier.Operation.ADD_VALUE));
        }

        return builder.build();
    }
}