package nesancodev.com.simplegui.gui;

import org.bukkit.event.inventory.InventoryClickEvent;

public interface Component {
    int getSlot();

    void execute(InventoryClickEvent event);
}
