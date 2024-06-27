package nesancodev.com.simplegui.utils;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemEditer {
    private ItemStack stack;
    private ArrayList<String> lore = new ArrayList<>();

    public ItemEditer(ItemStack stack) {
        this.stack = stack;
    }

    public ItemEditer setName(String name) {
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        stack.setItemMeta(meta);
        return this;
    }

    public ItemEditer setLore(List<String> lore) {
        ItemMeta meta = stack.getItemMeta();
        meta.setLore(lore);
        stack.setItemMeta(meta);
        return this;
    }

    public ItemEditer setEnchantEffect() {
        ItemMeta meta = stack.getItemMeta();
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        stack.setItemMeta(meta);
        return this;
    }

    public ItemEditer addEnchant(Enchantment enchantment, int level) {
        ItemMeta meta = stack.getItemMeta();
        meta.addEnchant(enchantment, level, true);
        stack.setItemMeta(meta);
        return this;
    }

    public ItemEditer addFlag(ItemFlag flag) {
        ItemMeta meta = stack.getItemMeta();
        meta.addItemFlags(flag);
        stack.setItemMeta(meta);
        return this;
    }

    public ItemEditer addLore(String lore) {
        this.lore.add(lore);

        ItemMeta meta = stack.getItemMeta();
        meta.setLore(this.lore);
        stack.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return stack;
    }
}
