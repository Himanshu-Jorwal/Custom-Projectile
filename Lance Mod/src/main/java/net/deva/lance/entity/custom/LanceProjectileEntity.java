package net.deva.lance.entity.custom;

import java.util.HashSet;
import java.util.Set;

import net.deva.lance.Lance;
import net.deva.lance.entity.LanceEntities;
import net.deva.lance.item.LanceItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class LanceProjectileEntity extends PersistentProjectileEntity {
    private final Set<Entity> piercedEntities = new HashSet<>();

    public LanceProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public LanceProjectileEntity(World world, PlayerEntity player) {
        super(LanceEntities.LANCE, player, world, new ItemStack(LanceItems.LANCE), null);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(LanceItems.LANCE);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();

        if (piercedEntities.contains(entity)) return;
        piercedEntities.add(entity);

        if (!this.getWorld().isClient()) {
            entity.damage(((ServerWorld) this.getWorld()), this.getDamageSources().thrown(this, this.getOwner()), 100);
            this.getWorld().sendEntityStatus(this, (byte)3);

            if (entity instanceof LivingEntity livingEntity && !livingEntity.isAlive()){
                this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), 
                Lance.LANCE_ROAR, SoundCategory.PLAYERS, 1.0F, 1.0F);
            }
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);

    }
    
    @Override
    public void onPlayerCollision(PlayerEntity player) {
        if (!this.getWorld().isClient && this.inGroundTime>0) {
            
            if (player.getAbilities().creativeMode) {
                this.discard();
                return;
            }

            if (this.tryPickup(player)) {
                player.sendPickup(this, 1);
                this.discard();
            }
        }
    }
}