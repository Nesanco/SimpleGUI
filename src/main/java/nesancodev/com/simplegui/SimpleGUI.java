package nesancodev.com.simplegui;

import nesancodev.com.simplegui.listeners.ClickEvent;
import nesancodev.com.simplegui.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleGUI extends JavaPlugin {
    public static Plugin plugin;

    public static void register(Plugin plugin) {
        SimpleGUI.plugin = plugin;
        registerEvents();
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static void registerEvents() {
        plugin.getServer().getPluginManager().registerEvents(new ClickEvent(), plugin);
    }
}
