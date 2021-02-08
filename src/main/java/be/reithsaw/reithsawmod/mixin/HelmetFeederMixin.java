package be.reithsaw.reithsawmod.mixin;

import be.reithsaw.reithsawmod.init.items.ModItems;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class HelmetFeederMixin
{
    @Shadow protected HungerManager hungerManager;
    @Shadow PlayerInventory inventory;

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci)
    {
        if(this.inventory.armor.get(3).getItem().equals(ModItems.MALACHITE_HELMET))
        {
                this.hungerManager.setFoodLevel(20);
                this.hungerManager.update((PlayerEntity) (Object) this);
        }
    }
}