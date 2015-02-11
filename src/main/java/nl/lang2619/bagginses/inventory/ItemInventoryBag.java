package nl.lang2619.bagginses.inventory;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nl.lang2619.bagginses.items.bags.Bag;

/**
 * Created by Tim on 10-2-2015.
 */
public class ItemInventoryBag extends ItemInventory {
    public ItemInventoryBag(Class<? extends Item> itemClass, int size, ItemStack itemStack) {
        super(itemClass, size, itemStack);

        if (parent == null)
            throw new IllegalArgumentException("Parent cannot be null.");

        Item item = parent.getItem();
        if (!(item instanceof Bag))
            throw new IllegalArgumentException("Parent must be a backpack.");
    }
}
