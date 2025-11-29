package com.xiaolin.skeletonaimingfix.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.Monster;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;


@Mixin(RangedBowAttackGoal.class)
public abstract class SkeletonAimingFixMixin {

   @Final
    private Monster mob;

    @Inject(method = "tick()V",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/monster/Monster;lookAt(Lnet/minecraft/world/entity/Entity;FF)V",
                            shift = At.Shift.AFTER),
            locals = LocalCapture.CAPTURE_FAILSOFT)

    public void skeletonAimingFix(CallbackInfo ci, LivingEntity livingEntity){
        this.mob.getLookControl().setLookAt(livingEntity, 30.0f, 30.0f);
    }

}
