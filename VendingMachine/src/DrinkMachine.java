/**
 * The drinkmachine class that extends the vendingmachine class.
 *
 * @author adins
 * @version 03-24-2023
 */
public class DrinkMachine extends VendingMachine {
    public static final int COOLING_CHARGE = 10;

    /**
     * calls the parent class.
     *
     */

    public DrinkMachine() {
        super();
    }

    /**
     * 2 arg constructor.
     *
     * @param size int
     * @param product Product
     */

    public DrinkMachine(int size, Product product) {
        super(size, product);
    }

    // Kyle to helped me with this.
    @Override
    public boolean buy(int slotNum) throws IllegalArgumentException {
        // call the buy method of the superclass and store the resul.
        boolean buy = super.buy(slotNum);
        // deduct the cooling charge from the machine profit
        this.machineProfit -= COOLING_CHARGE;
        // deduct the cooling charge from the total profit
        totalProfit -= COOLING_CHARGE;
        // return the result of the buy method of the superclass
        return buy;
    }

}