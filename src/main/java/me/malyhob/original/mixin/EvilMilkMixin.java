package me.malyhob.original.mixin;

import me.malyhob.original.EffectRegister;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MilkBucketItem.class)
public class EvilMilkMixin {
    @Inject(method="finishUsing",at=@At("HEAD"),cancellable = true)
    private void PreventDrink(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir){
        if (user instanceof PlayerEntity player && player.hasStatusEffect(EffectRegister.Infection)) {
            player.sendMessage(Text.translatable("text.original.infection_milk"),true);
            cir.setReturnValue(stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack);
        }
    }
}
