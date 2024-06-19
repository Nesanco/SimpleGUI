package nesancodev.com.simplegui.gui.listeners;

import nesancodev.com.simplegui.gui.Component;
import nesancodev.com.simplegui.gui.types.BasicGUI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class ClickEvent implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inventory = e.getInventory();
        if (BasicGUI.guiHashMap.get(inventory) == null) {
            return;
        }

        BasicGUI gui = BasicGUI.guiHashMap.get(inventory);
        int slot = e.getSlot();

        if (gui.isLocked()) {
            int[] excluded = gui.getExclude();
            if (excluded == null || !contains(excluded, slot)) {
                e.setCancelled(true);
            }
        }

        for (Component component : gui.getComponentHashMap().values()) {

            if (component.getSlot() != slot) {
                continue;
            }

            component.execute(e);
        }
    }

    private boolean contains(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
