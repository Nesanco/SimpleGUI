package nesancodev.com.simplegui.utils;

import net.md_5.bungee.api.ChatColor;

public abstract class Utils {

    public String t(String m) {
        return ChatColor.translateAlternateColorCodes('&', m);
    }
}
