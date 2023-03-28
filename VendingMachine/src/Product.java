/**
 * Is a product class for a vending machine.
 *
 * @author adin Skriloff
 * @version 03-02-2023
 *
 */
public class Product {
    public static final int ROUND_PRICE = 25;
    private String name;
    private int cost;
    private int price;

    /**
     * Empty constructor. that sets the private variables to vaules.
     */

    public Product() {
        this.name = "Generic";
        this.cost = ROUND_PRICE;
        this.price = 2 * ROUND_PRICE;

    }

    /**
     * Checks to see if name is null or cost and price are negative throw and IllegalArgumentException.
     *
     * @param name String
     * @param cost int
     * @param price int
     * @throws IllegalArgumentException cannot be null or negative
     */

    public Product(String name, int cost, int price) throws IllegalArgumentException {

        // check if name is null and cost and price are negative and throw a IlleagalArgumentException
        if (null == name || cost < 0 || price < 0) {
            throw new IllegalArgumentException();

            // Got help from Kyle To on this part.
        }
        int actullyPrice = price;
        if (actullyPrice % ROUND_PRICE != 0) {
            actullyPrice += (ROUND_PRICE - actullyPrice % ROUND_PRICE);
        }
        if (actullyPrice <= cost) {
            actullyPrice += ROUND_PRICE;
        }

        // Initializes the instance variables for the product
        this.name = name;
        this.cost = cost;
        this.price = actullyPrice;

    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        double cost = this.cost;
        double price = this.price;
        return String.format("Product: %s Cost: %.2f Price: %.2f.", this.name, cost / 100, price / 100);
    }
}
