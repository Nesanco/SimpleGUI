package nesancodev.com.simplegui.gui;

import nesancodev.com.simplegui.gui.format.Format;
import nesancodev.com.simplegui.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class GUI extends Utils {
    private String name;
    private int size;
    private @Nullable Player owner;
    private Inventory inventory;
    private int @Nullable [] exclude;
    private boolean locked;
    private HashMap<Integer, Component> componentHashMap = new HashMap<>();

    public static HashMap<Inventory, GUI> guiHashMap = new HashMap<>();

    //
    // Constructor
    //
    public GUI(String name, int size, @Nullable Player owner) {
        this.name = name;
        this.size = size;
        this.owner = owner;

        inventory = Bukkit.createInventory(owner, size, name);
        guiHashMap.put(inventory, this);
    }

    //
    // Add an item to the GUI
    //
    public void setItem(int slot, ItemStack stack) {
        inventory.setItem(slot, stack);
    }

    //
    // Remove an item from the GUI
    //
    public void removeItem(int slot) {
        inventory.setItem(slot, null);
    }

    //
    // Remove an item from the GUI
    //
    public void removeItem(ItemStack stack) {
        inventory.remove(stack);
    }

    //
    // Lock the GUI from any player modifications, you can exclude certain slots if needed, example:
    // gui.lock(new int[]{1,2,3,4,5});
    //
    public void lock(int @Nullable [] exclude) {
        this.exclude = exclude;
        locked = true;
    }

    //
    // Unlock the GUI from any player modifications, you can exclude certain slots if needed, example:
    // gui.unlock(new int[]{1,2,3,4,5});
    //
    public void unlock() {
        this.exclude = null;
        locked = false;
    }

    //
    // Removes all items from the GUI
    //
    public void clear() {
        inventory.clear();
    }

    //
    // Create the layout of the GUI using text characters
    // Note that spaces will be interpreted as air
    //
    public void setFormat(Format format) {
        format.setGui(this);
        format.build();
    }

    //
    // Set the border of the GUI
    //
    public void border(ItemStack stack) {
        for (int i = 0; i < getSize(); i++) {
            if (i <= 8) {
                inventory.setItem(i, stack);
            }
            if (i >= getSize() - 8) {
                inventory.setItem(i, stack);
            }
            if (i == 9 || i == 18 || i == 27 || i == 36) {
                inventory.setItem(i, stack);
            }
            if (i == 17 || i == 26 || i == 35 || i == 44) {
                inventory.setItem(i, stack);
            }
        }
    }

    //
    // Closes the GUI for the player
    //
    public void close(Player player) {
        player.closeInventory();
    }

    //
    // Adds component to the GUI
    //
    public void addComponent(Component component) {
        componentHashMap.put(component.getSlot(), component);
    }

    //
    // Removes a component from the GUI
    //
    public void removeComponent(int slot) {
        componentHashMap.remove(slot);
    }

    //
    // Removes a component from the GUI
    //
    public void removeComponent(Component component) {
        for (int value : componentHashMap.keySet()) {
            Component key = componentHashMap.get(value);
            if (key != component) continue;

            componentHashMap.remove(value);
        }
    }

    //
    // Open the GUI a player
    //
    public void open(Player player) {
        player.openInventory(inventory);
    }


    //
    // Getters
    //
    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Nullable
    public Player getOwner() {
        return owner;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int[] getExclude() {
        return exclude;
    }

    public boolean isLocked() {
        return locked;
    }

    public ArrayList<Player> getViewers() {
        ArrayList<Player> players = new ArrayList<>();
        for (HumanEntity entity : inventory.getViewers()) {
            players.add((Player) entity);
        }
        return players;
    }

    public HashMap<Integer, Component> getComponentHashMap() {
        return componentHashMap;
    }
}
