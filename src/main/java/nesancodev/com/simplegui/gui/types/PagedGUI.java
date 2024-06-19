package nesancodev.com.simplegui.gui.types;

import lombok.Getter;
import nesancodev.com.simplegui.gui.Component;
import nesancodev.com.simplegui.gui.Format;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class PagedGUI {
    private String name;
    private int size;
    private ArrayList<Component> components = new ArrayList<>();
    private HashMap<Integer, ItemStack> itemsHashMap = new HashMap<>();
    private Format format;
    private int @Nullable [] exclude = null;
    private boolean locked = false;

    //
    // Constructor
    //
    public PagedGUI(String name, int size) {
        this.size = size;
        this.name = name;
    }

    //
    // Add an item to the GUI
    //
    public void addItem(ItemStack stack) {
        int size = itemsHashMap.size();
        itemsHashMap.put(size, stack);
    }

    //
    // Add an item to the GUI in a specific slot
    //
    public void setItem(int slot, ItemStack stack) {
        itemsHashMap.put(slot, stack);
    }

    //
    // Remove an item from the GUI
    //
    public void removeItem(int slot) {
        itemsHashMap.remove(slot);
    }

    //
    // Add a component to the GUI
    //
    public void addComponent(Component component) {
        components.add(component);
    }

    //
    // Set the format for the GUI
    //
    public void setFormat(Format format) {
        this.format = format;
    }

    //
    // Set the name of the GUI
    //
    public void setName(String name) {
        this.name = name;
    }

    //
    // Lock the GUI
    //
    public void lock(int @Nullable [] exclude) {
        this.exclude = exclude;
        locked = true;
    }

    //
    // Open the GUI for a player
    //
    public void open(int page, Player player) {
        BasicGUI gui = new BasicGUI(name, size);
        gui.setFormat(format);

        if (locked) {
            gui.lock(exclude);
        }

        for (Component component : components) {
            gui.addComponent(component);
        }

        Inventory inventory = gui.getInventory();
        ArrayList<Integer> emptySlots = getEmptySlots(gui);

        int emptySlotsSize = getEmptySlots(gui).size();

        int iterations = 0;
        for (ItemStack item : inventory.getContents()) {
            if (item != null) continue;

            ItemStack stack = itemsHashMap.get((emptySlotsSize * page) + iterations);
            gui.setItem(emptySlots.get(iterations), stack);

            iterations++;
        }
        gui.open(player);
    }

    //
    //
    //
    private ArrayList<Integer> getEmptySlots(BasicGUI gui) {
        Inventory inventory = gui.getInventory();

        ArrayList<Integer> slots = new ArrayList<>();

        int iterations = 0;
        for (ItemStack item : inventory.getContents()) {
            if (item == null || item.getType() == Material.AIR) {
                slots.add(iterations);
            }
            iterations++;
        }
        return slots;
    }
}
