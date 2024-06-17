package nesancodev.com.simplegui.gui.format;

import nesancodev.com.simplegui.gui.GUI;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Format {
    private String l1;
    private String l2;
    private String l3;
    private String l4;
    private String l5;
    private String l6;
    private HashMap<String, ItemStack> formatHashMap = new HashMap<>();
    private GUI gui;

    public Format(String l1, String l2, String l3, String l4, String l5, String l6) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.l4 = l4;
        this.l5 = l5;
        this.l6 = l6;

        formatHashMap.put(" ", new ItemStack(Material.AIR));
    }

    public Format setFormat(String key, ItemStack stack) {
        formatHashMap.put(key, stack);
        return this;
    }

    public Format build() {
        if (l1 != null) {
            for (int i = 0; i < l1.length(); i++) {
                String value = String.valueOf(l1.charAt(i));
                ItemStack stack = formatHashMap.get(value);
                if (stack == null) continue;
                gui.setItem(i, stack);
            }
        }

        if (l2 != null) {
            for (int i = 0; i < l2.length(); i++) {
                String value = String.valueOf(l2.charAt(i));
                ItemStack stack = formatHashMap.get(value);
                if (stack == null) continue;
                gui.setItem(i + 9, stack);
            }
        }

        if (l3 != null) {
            for (int i = 0; i < l3.length(); i++) {
                String value = String.valueOf(l3.charAt(i));
                ItemStack stack = formatHashMap.get(value);
                if (stack == null) continue;
                gui.setItem(i + 18, stack);
            }
        }

        if (l4 != null) {
            for (int i = 0; i < l4.length(); i++) {
                String value = String.valueOf(l4.charAt(i));
                ItemStack stack = formatHashMap.get(value);
                if (stack == null) continue;
                gui.setItem(i + 27, stack);
            }
        }

        if (l5 != null) {
            for (int i = 0; i < l5.length(); i++) {
                String value = String.valueOf(l5.charAt(i));
                ItemStack stack = formatHashMap.get(value);
                if (stack == null) continue;
                gui.setItem(i + 36, stack);
            }
        }

        if (l6 != null) {
            for (int i = 0; i < l6.length(); i++) {
                String value = String.valueOf(l6.charAt(i));
                ItemStack stack = formatHashMap.get(value);
                if (stack == null) continue;
                gui.setItem(i + 45, stack);
            }
        }
        return this;
    }

    public String getL1() {
        return l1;
    }

    public String getL2() {
        return l2;
    }

    public String getL3() {
        return l3;
    }

    public String getL4() {
        return l4;
    }

    public String getL5() {
        return l5;
    }

    public String getL6() {
        return l6;
    }

    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }
}
