import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests my product class.
 *
 * @author adins Skriloff
 * @version 03-02-2023
 *
 */
class ProductTest {

    private Product product;

    /**
     * setep the product.
     */
    @BeforeEach
    void setUp() {
        product = new Product();
    }

    /**
     * Tests my defualt Constuctor.
     */

    @Test
    void testDefaultConstructor() {
        Product product = new Product();
        assertEquals("Generic", product.getName());
        assertNotEquals("Product", product.getName());
        assertEquals(25, product.getCost());
        assertEquals(Product.ROUND_PRICE, product.getCost());
        assertNotEquals(24, product.getCost());
        assertEquals(50, product.getPrice());
        assertEquals(2 * Product.ROUND_PRICE, product.getPrice());
        assertNotEquals(45, product.getPrice());

    }

    /**
     * Tests constuctor with vaild input.
     */

    @Test
    void testConstructorWithVaildInput() {
        Product product = new Product("TestProduct", 30, 60);
        assertEquals("TestProduct", product.getName());
        assertNotEquals("Product", product.getName());
        assertEquals(30, product.getCost());
        assertNotEquals(45, product.getCost());
        assertEquals(75, product.getPrice());
        assertNotEquals(60, product.getPrice());

    }

    /**
     * Gets name.
     */

    @Test
    void testGetName() {
        Product product = new Product("TestProduct", 30, 60);
        assertEquals("TestProduct", product.getName());
    }

    /**
     * Gets the cost.
     */

    @Test
    void testGetCost() {
        Product product = new Product("TestProduct", 30, 60);
        assertEquals(30, product.getCost());
    }

    /**
     * Gets the price.
     */

    @Test
    void testGetPrice() {
        Product product = new Product("TestProduct", 30, 75);
        assertEquals(75, product.getPrice());
    }

    /**
     * Test my constructor with null name.
     */

    @Test
    void testConstructorWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product(null, 50, 100);
        });

    }

    /**
     * Test for invalid values.
     */

    @Test
    void testConstructorWithInvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> new Product(null, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Product("M&Ms", -1, 0));
        assertThrows(IllegalArgumentException.class, () -> new Product("M&Ms", 0, -1));
    }

    /**
     * Test the rounded price.
     */
    @Test
    void testConstructorWithRoundedPrice() {
        Product product = new Product("M&Ms", 102, 120);
        assertEquals(125, product.getPrice());
    }

    /**
     * Test my constructor with negative cost.
     */

    @Test
    void testConstructorWithNegativeCost() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product("TestProduct", -10, 50);
        });
    }

    /**
     * Check if price is greater than cost.
     */
    @Test
    void testConstructorPriceGreaterThanCost() {
        Product product = new Product("TestProduct", 10, 5);
        assertEquals(25, product.getPrice());
    }

    /**
     * Test the actul price.
     */

    @Test
    void testPriceRoundUp() {
        // Test that the price is rounded up to the nearest ROUND_PRICE when it is not a multiple of ROUND_PRICE
        Product product = new Product("TestProduct", 100, 153);
        assertEquals(175, product.getPrice());
    }

    /**
     * If price incerases.
     */

    @Test
    void testPriceIncrease() {
        // Test that the price is increased by ROUND_PRICE when it is less than or equal to the cost
        Product product = new Product("TestProduct", 100, 100);
        assertEquals(125, product.getPrice());
    }

    /**
     * tests my constructor with negative price.
     */
    @Test
    void testConstructorWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product("TestProduct", 30, -60);
        });

    }

    /**
     * Test my constrictor with Price less than cost.
     */

    @Test
    void testConstructorWithPriceLessThanCost() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product("TestProduct", 50, -20);
        });
    }

    /**
     * Test my toString method.
     */

    @Test
    void testToString() {
        Product product = new Product("M&Ms", 102, 125);
        assertEquals("Product: M&Ms Cost: 1.02 Price: 1.25.", product.toString());
    }

}
