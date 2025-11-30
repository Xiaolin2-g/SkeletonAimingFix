package com.xiaolin.skeletonaimingfix.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.logging.Logger;


@Mixin(net.minecraft.world.entity.ai.goal.RangedBowAttackGoal.class)
public abstract class SkeletonAimingFixMixin {

    @Shadow @Final
    private Mob mob;

    @Inject(method = "tick", at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/Mob;lookAt(Lnet/minecraft/world/entity/Entity;FF)V",
            shift = At.Shift.AFTER),
            locals = LocalCapture.CAPTURE_FAILSOFT)

    public void skeletonAimingFix(CallbackInfo ci, LivingEntity livingEntity){
        this.mob.getLookControl().setLookAt(livingEntity, 30.0f, 30.0f);
    }

}
