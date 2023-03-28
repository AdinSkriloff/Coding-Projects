import java.util.ArrayList;

/**
 * Keeps track of the slots in the vending machine.
 *
 * @author adin Skriloff
 * @version 03-02-2023
 *
 */
public class Slot {

    public static final int SLOT_SIZE = 10;
    private ArrayList<Product> products;

    /**
     * The Slot() constructor creates an empty array list of products.
     *
     */

    public Slot() {
        products = new ArrayList<Product>();

    }

    /**
     * Initializes a new Slot instance with a list of SLOT_SIZE number of Product objects.
     *
     * @param product object
     */

    public Slot(Product product) {
        this.products = new ArrayList<Product>();
        load(product);
    }

    /**
     * Adds a specific number of Product objects to the slot up to the maximum capacity of SLOT_SIZE.
     *
     * @param product object
     * @return productsToAdd
     */

    public int load(Product product) {
        // Calculates the number of products that can be added to the slot
        int count = SLOT_SIZE - products.size();
        // Add products to the slot until it is full
        return load(product, count);
    }
    // Return the number of products added to the slot

    /**
     * Calculates the number of products that can be added to slot.
     *
     * @param product object
     * @param count int
     * @return productsToAdd
     *
     * Kyle To helped me with this.
     */

    public int load(Product product, int count) {
        int ncount = count;
        while (this.products.size() < SLOT_SIZE && ncount > 0) {
            Product nProduct = new Product(product.getName(), product.getCost(), product.getPrice());
            products.add(nProduct);
            ncount--;
        }

        return count - ncount;

    }

    /**
     * Checks to see if there are any more products in the slot and if there are then return the first product.
     *
     * @return null if there are no products in the slot
     */

    public Product nextProduct() {
        if (products.size() > 0) {
            return products.get(0);
        }
        // else if there are no more products return null

        return null;
    }

    /**
     * if there are products remove the first slot.
     *
     * @return null if there are no products in the slot
     */

    public Product buyOne() {
        if (nextProduct() != null) {
            Product deleted = products.get(0);
            products.remove(0);
            return deleted;
        }
        return null;
    }

    // Kyle To helped me with this.
    @Override
    public String toString() {
        String result = "SlotCount: " + products.size() + " of\n";
        for (int i = 0; i < products.size(); i++) {
            result += products.get(i).toString() + "\n";

        }
        return result;
    }

}
