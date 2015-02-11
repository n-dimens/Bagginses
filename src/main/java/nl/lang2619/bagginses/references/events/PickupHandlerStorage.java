package nl.lang2619.bagginses.references.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import nl.lang2619.bagginses.items.bags.Bag;
import nl.lang2619.bagginses.items.bags.BagTier1;
import nl.lang2619.bagginses.items.bags.BagTier2;
import nl.lang2619.bagginses.items.bags.container.BagContainer;
import nl.lang2619.bagginses.references.BlockList;
import nl.lang2619.bagginses.references.interfaces.IPickupHandler;

/**
 * Created by Tim on 10-2-2015.
 */
public class PickupHandlerStorage implements IPickupHandler {
    @Override
    public boolean onItemPickup(EntityPlayer player, EntityItem item) {
        ItemStack itemStack = item.getEntityItem();
        if (itemStack == null || itemStack.stackSize <= 0) {
            return false;
        }

        if (player.openContainer instanceof BagContainer) {
            return true;
        }

        topOffPlayerInventory(player, itemStack);

        for (ItemStack pack : player.inventory.mainInventory) {
            if (pack == null || pack.stackSize <= 0) {
                continue;
            }
            if (itemStack.stackSize <= 0) {
                break;
            }
            if (!(pack.getItem() instanceof Bag)) {
                continue;
            }

            if (pack.getItem() instanceof BagTier1) {
                BagTier1 bagTier1 = ((BagTier1) pack.getItem());
                if (BlockList.contains(item.getEntityItem().getItem(), item.getEntityItem().getItemDamage(), bagTier1.getColor())) {
                    bagTier1.tryStowing(player, pack, itemStack);
                }
            }
            if (pack.getItem() instanceof BagTier2) {
                BagTier2 bagTier2 = ((BagTier2) pack.getItem());
                if (BlockList.contains(itemStack.getItem(), itemStack.getItemDamage(), bagTier2.getColor())) {
                    bagTier2.tryStowing(player, pack, itemStack);
                }
            }
        }
        return itemStack.stackSize > 0;
    }

    private void topOffPlayerInventory(EntityPlayer player, ItemStack itemStack) {
        for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
            ItemStack inventoryStack = player.inventory.getStackInSlot(i);
            if (inventoryStack == null) {
                continue;
            }

            if (inventoryStack.stackSize >= inventoryStack.getMaxStackSize()) {
                continue;
            }

            if (inventoryStack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(inventoryStack, itemStack)) {
                int space = inventoryStack.getMaxStackSize() - inventoryStack.stackSize;

                if (space > itemStack.stackSize) {
                    inventoryStack.stackSize += itemStack.stackSize;
                    itemStack.stackSize = 0;
                    break;
                } else {
                    inventoryStack.stackSize = inventoryStack.getMaxStackSize();
                    itemStack.stackSize -= space;
                }
            }

        }
    }
}
