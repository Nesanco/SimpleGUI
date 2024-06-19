package nesancodev.com.simplegui;

import lombok.Getter;
import nesancodev.com.simplegui.gui.listeners.ClickEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleGUI extends JavaPlugin {
    @Getter
    public static Plugin plugin;

    public static void register(Plugin plugin) {
        SimpleGUI.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(new ClickEvent(), plugin);
    }
}
