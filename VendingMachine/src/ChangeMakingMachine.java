/**
 * The changemakingmachine class that extends the vendingmachine class.
 *
 * @author adins
 * @version 03-24-2023
 */
public class ChangeMakingMachine extends VendingMachine {
    /**
     * Calls the parent class.
     */

    public ChangeMakingMachine() {
        super();
    }

    /**
     * Performs the same action for the ChangeMakingMachine as VendingMachine(int size).
     *
     * @param size int
     */

    public ChangeMakingMachine(int size) {
        super(size);
    }

    /**
     * Performs the same action for the ChangeMakingMachine as VendingMachine(int size, Product product).
     *
     * @param size int
     * @param product product
     */

    public ChangeMakingMachine(int size, Product product) {
        super(size, product);
    }

    /**
     * Models buying one item from the slot number indicated. Throws an IllegalArgumentException if the slotNum is out
     * of bounds or if quarters or dollars are negative.
     *
     * @param slotNum int
     * @param quarters int
     * @param dollars int
     * @return -1
     * @throws IllegalArgumentException checks the params.
     */

    public int buy(int slotNum, int quarters, int dollars) throws IllegalArgumentException {
        if (quarters < 0 || dollars < 0) {
            throw new IllegalArgumentException();

        }
        // calculate the total amount paid by the user in cents
        int amountPaid = (quarters * 25) + (dollars * 100);
        // get the next product in the specified slot
        Product nextProduct = nextProduct(slotNum);
        // check if the amount paid is right to buy the next product
        if (amountPaid >= nextProduct.getPrice()) {
            // if the amount paid is right, buy the product in the right slot
            super.buy(slotNum);
            // calculate and return the change if any
            return amountPaid - nextProduct.getPrice();
        }
        // if the amount paid was not right return -1 to show it was incorrect
        return -1;

    }
}
