package nl.lang2619.bagginses.references.interfaces;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Created by Tim on 2/11/2015.
 */
public class PickupHandlerCore implements IPickupHandler {
    @Override
    public boolean onItemPickup(EntityPlayer player, EntityItem item) {
        ItemStack itemStack = item.getEntityItem();
        if(itemStack == null || itemStack.stackSize <= 0)
            return false;

        return true;
    }
}
