package com.omnimine.item;

import com.omnimine.registry.ModEnchantments;
import com.omnimine.registry.ModItems;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Pioche en bedrock : une pioche vanilla, tres rapide et incassable. Avec l'enchantement Omniminage elle mine aussi
 * les mobs, le soleil, la lune, les eclairs et (accroupi) les structures. Elle ne fait jamais apparaitre d'eclair :
 * ceux qu'elle mine sont les vrais eclairs d'orage qui frappent un paratonnerre en cuivre.
 */
public class BedrockPickaxeItem extends PickaxeItem {
    public BedrockPickaxeItem(Properties properties) {
        super(Tiers.NETHERITE, 1, -2.4F, properties);
    }

    @Override
    public boolean canBeDepleted() {
        return false;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        float base = super.getDestroySpeed(stack, state);
        return base > 1.0F ? base * 2.5F : base;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tip, TooltipFlag flag) {
        tip.add(Component.translatable("item.omnimine.bedrock_pickaxe.desc1").withStyle(ChatFormatting.GRAY));
        tip.add(Component.translatable("item.omnimine.bedrock_pickaxe.desc2").withStyle(ChatFormatting.GRAY));
        tip.add(Component.translatable("item.omnimine.bedrock_pickaxe.desc3").withStyle(ChatFormatting.DARK_AQUA));
        tip.add(Component.translatable(hasOmni(stack) ? "tooltip.omnimine.omni_on" : "tooltip.omnimine.omni_off")
                .withStyle(hasOmni(stack) ? ChatFormatting.GREEN : ChatFormatting.RED));
    }

    // ---- aides ----

    /** La pioche porte-t-elle l'enchantement Omniminage ? */
    public static boolean hasOmni(ItemStack stack) {
        return stack.getItem() instanceof BedrockPickaxeItem
                && EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.OMNI_MINING.get(), stack) > 0;
    }

    /** Le joueur tient-il la pioche enchantee en main principale ? */
    public static boolean holdsOmni(Player player) {
        return hasOmni(player.getMainHandItem());
    }

    /** Le joueur porte-t-il la pioche enchantee quelque part (inventaire, barre rapide ou seconde main) ? */
    public static boolean carriesOmni(Player player) {
        for (ItemStack s : player.getInventory().items) {
            if (hasOmni(s)) {
                return true;
            }
        }
        return hasOmni(player.getOffhandItem());
    }

    public static ItemStack enchantedPickaxe() {
        ItemStack stack = new ItemStack(ModItems.BEDROCK_PICKAXE.get());
        stack.enchant(ModEnchantments.OMNI_MINING.get(), 1);
        return stack;
    }

    public static ItemStack enchantedBook() {
        return EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ModEnchantments.OMNI_MINING.get(), 1));
    }
}
