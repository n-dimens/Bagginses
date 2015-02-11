package nl.lang2619.bagginses.references.events;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import nl.lang2619.bagginses.Bagginses;
import nl.lang2619.bagginses.references.interfaces.IPickupHandler;

/**
 * Created by Tim on 10-2-2015.
 */
public class EventHandlers {

    @SubscribeEvent
    public void handleItemPickup(EntityItemPickupEvent event){
        System.out.println("Fire handle.");
        if(event.isCanceled()) {
            System.out.println("Canceled");
            return;
        }
        for(IPickupHandler handler : Bagginses.pickupHandlers)
            if(!handler.onItemPickup(event.entityPlayer,event.item)){
                System.out.println("!handler picked");
                event.setResult(Event.Result.ALLOW);
                System.out.println("allowed");
                return;
            }
    }
}
