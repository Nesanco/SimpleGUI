## SimpleGUI

Many GUI libraries are very complicated for no reason, which is why SimpleGUI allows you to create advanced GUIs with ease

# Examples

BasicGUI
```java
        ItemStack background = new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("").build();
        ItemStack close = new ItemBuilder(Material.RED_CONCRETE).setName("Close").build();
        ItemStack moveableSword = new ItemBuilder(Material.DIAMOND_SWORD).setName("The Great Sword").setEnchantEffect().build();

        BasicGUI gui = new BasicGUI("Example GUI", 54, null);
        gui.setFormat(new Format(
                        "#########",
                        "#########",
                        "#.  #####",
                        "#   #####",
                        "#########",
                        "####+####"
                )
                        .setFormat("#", background)
                        .setFormat(".", moveableSword)
                        .setFormat("+", close)
        );
        gui.lock(new int[]{19,20,21,28,29,30});
        gui.addComponent(new Button(49, event -> {
            Player player = (Player) event.getWhoClicked();
            player.closeInventory();
            player.sendMessage("You have closed the GUI");
        }));
        gui.open((Player) sender);
```
![image](https://github.com/Nesanco/SimpleGUI/assets/80917510/f04ea3b5-574e-4e80-9799-9873590b4df8)

PagedGUI
```java
        ItemStack background = new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("").build();
        ItemStack back = new ItemBuilder(Material.RED_CONCRETE).setName("Back").build();
        ItemStack next = new ItemBuilder(Material.LIME_CONCRETE).setName("Next").build();

        Player player = (Player) sender;

        PagedGUI gui = new PagedGUI("Page 0", 54);
        gui.setFormat(new Format(
                        "#########",
                        "         ",
                        "         ",
                        "         ",
                        "         ",
                        "###+#.###"
                )
                        .setFormat("#", background)
                        .setFormat(".", next)
                        .setFormat("+", back)
        );
        gui.lock(null);

        for (Material material : Material.values()) {
            ItemStack stack = new ItemStack(material);
            gui.addItem(stack);
        }

        gui.addComponent(new Button(50, e -> {
            String name = gui.getName().replace("Page ", "");
            int page = Integer.parseInt(name);

            gui.setName("Page " + (page+1));
            gui.open(page + 1, player);
        }));

        gui.addComponent(new Button(48, e -> {
            String name = gui.getName().replace("Page ", "");
            int page = Integer.parseInt(name);

            gui.setName("Page " + (page-1));
            gui.open(page - 1, player);
        }));
        gui.open(0, player);
```

# Maven

```
        <dependency>
            <groupId>com.github.Nesanco</groupId>
            <artifactId>SimpleGUI</artifactId>
            <version>1.0</version>
        </dependency>
```
```
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
```

# Format

When using the format method, make sure each line only has 9 characters since a GUI only has 9 lines per row. If you wanted to make a GUI that is 3 rows instead of 6, put null in the unused rows

Note that spaces are interpreted as blank spaces within the GUI

# Locking

Using the lock method will prevent players from removing/adding items to the GUI, you can exclude certain slots from being locked, if you want all slots to be locked, put null in the lock method

# ItemBuilder

The library comes with a utility to quickly build item stacks and modify them. Using the ItemBuilder constructor, you can customize the itemstack to change its name, flags, enchants, etc

# Paged GUIs

The paged GUIs are intented to help make GUIs for things such as shops, vaults, lists, etc.

The format, component, and locking aspect of the paged GUIs work the same way as the BasicGUIs, except, they will be applied to all pages within the paged GUI. The items added to the GUI will automatically move to the next page when there isnt enough space left

# Need more help?

Go into the GUI classes to view every method, each method has a short description of what it does

# TODO

- <s>Paged GUIs</s>
- Animations
