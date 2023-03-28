import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test my slot class.
 *
 * @author adins
 * @version 03-02-2023
 *
 */
class SlotTest {

    private Slot slot;
    private Product product;

    /**
     * Test the slot constructor.
     */

    @Test
    public void testConstructor() {
        Slot slot = new Slot();
        assertNotNull(slot);
    }

    /**
     * Tests the products added.
     */

    @Test
    void addProductsToSlot() {
        Product product = new Product("Soda", 150, 200);
        int productsAdded = slot.load(product);
        Assertions.assertEquals(Slot.SLOT_SIZE, productsAdded);
    }

    /**
     * Test the space in the slot.
     */

    @Test
    void addMoreProductsToSlotThanAvailableSpace() {
        Product product = new Product("Soda", 150, 200);
        int productsAdded = slot.load(product, Slot.SLOT_SIZE + 1);
        Assertions.assertEquals(Slot.SLOT_SIZE, productsAdded);
    }

    /**
     * Add Products with a count less than available space.
     */

    @Test
    void addProductsToSlotWithCountLessThanAvailableSpace() {
        Product product = new Product("Soda", 150, 200);
        int count = 3;
        int productsAdded = slot.load(product, count);
        Assertions.assertEquals(count, productsAdded);
    }

    /**
     * Test buying one product form the slot.
     */

    @Test
    void buyOneProductFromSlot() {
        Product product = new Product("Soda", 150, 200);
        slot.load(product);
        Product boughtProduct = slot.buyOne();
        Assertions.assertEquals(product, boughtProduct);
    }

    /**
     * Test buying a product from an empty slot.
     */

    @Test
    void buyProductFromEmptySlot() {
        Product boughtProduct = slot.buyOne();
        Assertions.assertNull(boughtProduct);
    }

    /**
     * tests empty slot.
     */

    @Test
    void testNextProductWithEmptySlot() {
        Product nextProduct = slot.nextProduct();
        assertNull(nextProduct);
    }

    /**
     * Tests the toString.
     */

    @Test
    void testToStringWithMultipleProducts() {
        Product product1 = new Product("Soda", 150, 200);
        Product product2 = new Product("Chips", 100, 150);
        slot.load(product1, 3);
        slot.load(product2, 2);
        String expected = "SlotCount: 5 of\n" + "Product: Soda Cost: 150.00 Price: 200.00.\n"
                + "Product: Soda Cost: 150.00 Price: 200.00.\n" + "Product: Soda Cost: 150.00 Price: 200.00.\n"
                + "Product: Chips Cost: 100.00 Price: 150.00.\n" + "Product: Chips Cost: 100.00 Price: 150.00.\n";
    }

}
