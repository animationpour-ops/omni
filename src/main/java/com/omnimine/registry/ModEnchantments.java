package com.omnimine.registry;

import com.omnimine.Omnimine;
import com.omnimine.enchant.OmniMiningEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Omnimine.MODID);

    public static final RegistryObject<Enchantment> OMNI_MINING =
            ENCHANTMENTS.register("omni_mining", OmniMiningEnchantment::new);

    private ModEnchantments() {}
}
