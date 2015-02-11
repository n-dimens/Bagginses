package nl.lang2619.bagginses.references.interfaces;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Tim on 10-2-2015.
 */
public interface IPickupHandler {

    boolean onItemPickup(EntityPlayer player, EntityItem item);
}
