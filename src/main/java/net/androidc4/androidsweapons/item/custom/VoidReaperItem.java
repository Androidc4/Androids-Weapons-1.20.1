package net.androidc4.androidsweapons.item.custom;

import net.androidc4.androidsweapons.entity.custom.VoidReaperProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class VoidReaperItem extends SwordItem {
    public VoidReaperItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent
		user.getItemCooldownManager().set(this, 5);
        if (!world.isClient) {
            VoidReaperProjectileEntity voidprojectile = new VoidReaperProjectileEntity(world,user);
            voidprojectile.setItem(itemStack);
            voidprojectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 0F, 0F);
                        /*
                        snowballEntity.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
                        In 1.17,we will use setProperties instead of setVelocity.
                        */
            world.spawnEntity(voidprojectile); // spawns entity
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
