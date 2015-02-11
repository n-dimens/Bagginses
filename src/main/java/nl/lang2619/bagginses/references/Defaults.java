package nl.lang2619.bagginses.references;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Collection;
import java.util.Random;

/**
 * Created by Tim on 8/24/2014.
 */
public class Defaults {
    private static Random rand;

    public static int getUID() {
        if (rand == null)
            rand = new Random();

        return rand.nextInt();
    }


    public static final String MODID = "bagginses";
    public static final String VERSION = "@MODVERSION@";
    public static final String NAME = "Bagginses";
    public static final String CLIENTPROXY = "nl.lang2619.bagginses.proxy.ClientProxy";
    public static final String COMMONPROXY = "nl.lang2619.bagginses.proxy.CommonProxy";
    public static final int WILDCARD = OreDictionary.WILDCARD_VALUE;

    public static ItemStack moveItemStack(ItemStack stack, IInventory dest) {
        InventoryManipulator im = InventoryManipulator.get(dest);
        return im.addStack(stack);
    }

    public static boolean isItemEqual(ItemStack a, ItemStack b) {
        return isItemEqual(a, b, true, true);
    }

    public static boolean isItemEqual(final ItemStack a, final ItemStack b, final boolean matchDamage, final boolean matchNBT) {
        if (a == null || b == null)
            return false;
        if (a.getItem() != b.getItem())
            return false;
        if (matchNBT && !ItemStack.areItemStackTagsEqual(a, b))
            return false;
        if (matchDamage && a.getHasSubtypes()) {
            if (isWildcard(a) || isWildcard(b))
                return true;
            if (a.getItemDamage() != b.getItemDamage())
                return false;
        }
        return true;
    }

    /**
     * Returns true if the item is equal to any one of several possible matches.
     */
    public static boolean isItemEqual(ItemStack stack, ItemStack... matches) {
        for (ItemStack match : matches) {
            if (isItemEqual(stack, match))
                return true;
        }
        return false;
    }

    /**
     * Returns true if the item is equal to any one of several possible matches.
     */
    public static boolean isItemEqual(ItemStack stack, Collection<ItemStack> matches) {
        for (ItemStack match : matches) {
            if (isItemEqual(stack, match))
                return true;
        }
        return false;
    }

    public static boolean isWildcard(ItemStack stack) {
        return isWildcard(stack.getItemDamage());
    }

    public static boolean isWildcard(int damage) {
        return damage == -1 || damage == OreDictionary.WILDCARD_VALUE;
    }
}
