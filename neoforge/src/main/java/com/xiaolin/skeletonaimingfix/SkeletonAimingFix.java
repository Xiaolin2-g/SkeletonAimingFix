package com.xiaolin.skeletonaimingfix;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class SkeletonAimingFix {

    public SkeletonAimingFix(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Initializing Skeleton Aiming Fix...");
        CommonClass.init();

    }
}