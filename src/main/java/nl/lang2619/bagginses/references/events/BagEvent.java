package nl.lang2619.bagginses.references.events;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;


/**
 * Created by Tim on 10-2-2015.
 */
public abstract class BagEvent extends Event {

    public final EntityPlayer player;
    public final String color;
    public final IInventory inventory;

    public BagEvent(EntityPlayer player, String color, IInventory inventory) {
        this.player = player;
        this.color = color;
        this.inventory = inventory;
    }
}
