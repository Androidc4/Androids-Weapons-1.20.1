package net.androidc4.androidsweapons.entity.custom;

import net.androidc4.androidsweapons.Androidsweapons;
import net.androidc4.androidsweapons.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class VoidReaperProjectileEntity extends ThrownItemEntity {
    public VoidReaperProjectileEntity(EntityType<? extends VoidReaperProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public VoidReaperProjectileEntity(World world, LivingEntity owner) {
        super(Androidsweapons.VOIDREAPERPROJECTILE, owner, world); // null will be changed later
    }

    public VoidReaperProjectileEntity(World world, double x, double y, double z) {
        super(Androidsweapons.VOIDREAPERPROJECTILE, x, y, z, world); // null will be changed later
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.VOIDREAPER; // We will configure this later, once we have created the ProjectileItem.
    }

    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
        int i = entity instanceof BlazeEntity ? 3 : 0; // sets i to 3 if the Entity instance is an instance of BlazeEntity
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), i);// deals damage

        if (entity instanceof LivingEntity livingEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
            livingEntity.playSound(SoundEvents.ENTITY_PHANTOM_BITE, 2F, 1F); // plays a sound for the entity hit only
        }
    }
}
