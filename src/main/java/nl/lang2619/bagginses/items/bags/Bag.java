package nl.lang2619.bagginses.items.bags;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import nl.lang2619.bagginses.inventory.ItemInventory;
import nl.lang2619.bagginses.inventory.ItemInventoryBag;
import nl.lang2619.bagginses.references.Defaults;
import nl.lang2619.bagginses.references.events.BackpackStowEvent;

/**
 * Created by Tim on 10-2-2015.
 */
public class Bag extends Item {

    int size = 0;

    public String getColor() {
        return color;
    }

    String color = "";

    public ItemStack tryStowing(EntityPlayer player, ItemStack backpackStack, ItemStack stack) {
        if (backpackStack.getItem() instanceof BagTier1) {

            BagTier1 backpack = ((BagTier1) backpackStack.getItem());
            ItemInventory inventory = new ItemInventoryBag(BagTier1.class, backpack.getBackpackSize(), backpackStack);
            if (backpackStack.getItemDamage() == 1)
                return stack;

            Event event = new BackpackStowEvent(player, backpack.getColor(), inventory, stack);
            MinecraftForge.EVENT_BUS.post(event);
            if (stack.stackSize <= 0)
                return null;
            if (event.isCanceled())
                return stack;

            ItemStack remainder = Defaults.moveItemStack(stack, inventory);
            stack.stackSize = remainder == null ? 0 : remainder.stackSize;

            inventory.save();
            return null;
        }
        if (backpackStack.getItem() instanceof BagTier2) {
            BagTier2 backpack = ((BagTier2) backpackStack.getItem());
            ItemInventory inventory = new ItemInventoryBag(BagTier2.class, backpack.getBackpackSize(), backpackStack);
            if (backpackStack.getItemDamage() == 1)
                return stack;

            Event event = new BackpackStowEvent(player, backpack.getColor(), inventory, stack);
            MinecraftForge.EVENT_BUS.post(event);
            if (stack.stackSize <= 0)
                return null;
            if (event.isCanceled())
                return stack;

            ItemStack remainder = Defaults.moveItemStack(stack, inventory);
            stack.stackSize = remainder == null ? 0 : remainder.stackSize;

            inventory.save();
            return null;
        }
        return null;
    }

    public int getBackpackSize(){
        return size;
    }
}
