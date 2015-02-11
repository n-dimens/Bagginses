package nl.lang2619.bagginses.references.interfaces;

import net.minecraft.item.ItemStack;

/**
 * Created by Tim on 10-2-2015.
 */
public interface IInvSlot {

    boolean canPutStackInSlot(ItemStack stack);

    boolean canTakeStackFromSlot(ItemStack stack);

    ItemStack decreaseStackInSlot();

    ItemStack getStackInSlot();

    void setStackInSlot(ItemStack stack);

    int getIndex();

}