package nesancodev.com.simplegui.gui.components;

import nesancodev.com.simplegui.gui.Component;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.Consumer;

public class Button implements Component {
    private final int slot;
    private final Consumer<InventoryClickEvent> action;

    public Button(int slot, Consumer<InventoryClickEvent> action) {
        this.slot = slot;
        this.action = action;
    }

    public Consumer<InventoryClickEvent> getAction() {
        return action;
    }

    @Override
    public int getSlot() {
        return slot;
    }

    @Override
    public void execute(InventoryClickEvent event) {
        action.accept(event);
    }
}
