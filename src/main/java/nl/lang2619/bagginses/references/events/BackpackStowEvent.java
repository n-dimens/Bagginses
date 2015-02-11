package nl.lang2619.bagginses.references.events;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import nl.lang2619.bagginses.inventory.ItemInventory;

/**
 * Created by Tim on 10-2-2015.
 */
@Cancelable
public class BackpackStowEvent extends BagEvent {

    public final ItemStack stackToStow;

    public BackpackStowEvent(EntityPlayer player, String color, ItemInventory inventory, ItemStack stack) {
        super(player,color,inventory);
        this.stackToStow = stack;

    }
}
