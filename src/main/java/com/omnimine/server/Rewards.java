package com.omnimine.server;

import com.omnimine.data.StructureKind;
import com.omnimine.net.VfxPacket;
import com.omnimine.net.VfxType;
import com.omnimine.registry.ModSounds;
import java.util.List;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;

/** Ouverture d'une structure evoluee : ceremonie de lumiere puis les items cheat tombent dans l'inventaire un par un. */
public final class Rewards {

    public static void open(ServerLevel level, ServerPlayer p, StructureKind kind) {
        Vec3 pos = p.position();
        VfxPacket.of(VfxType.REWARD, pos).follow(p).color(kind.color).duration(80).send(level);
        ModSounds.play(level, pos, ModSounds.REWARD, 4.0F, 1.0F);
        ModSounds.play(level, pos, SoundEvents.TOTEM_USE, 1.0F, 1.0F);
        List<ItemStack> items = kind.rewards();
        for (int i = 0; i < items.size(); i++) {
            ItemStack stack = items.get(i);
            int index = i;
            ServerEffects.delay(level, 16 + i * 9, () -> {
                if (!p.isAlive() || p.isRemoved()) {
                    return;
                }
                ItemHandlerHelper.giveItemToPlayer(p, stack);
                ModSounds.play(level, p.position(), SoundEvents.AMETHYST_BLOCK_CHIME, 1.6F, 0.8F + index * 0.15F);
                ModSounds.play(level, p.position(), SoundEvents.ITEM_PICKUP, 0.8F, 1.0F);
            });
        }
    }

    private Rewards() {}
}
