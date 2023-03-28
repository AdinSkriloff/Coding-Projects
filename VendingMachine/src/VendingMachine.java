/**
 * This is the vendingmachine class.
 *
 * @author adins
 * @version 03-24-2023
 */
public class VendingMachine {
    public static final int DEFAULT_SIZE = 15;
    protected static int totalProfit;
    protected int machineProfit;
    private Slot[] slots;

    /**
     * Creates a VendingMachine instance with 15 slots.
     */
    public VendingMachine() {
        this(DEFAULT_SIZE);

    }

    /**
     * 1 arg Constructor.
     *
     * @param size int
     */

    public VendingMachine(int size) {
        // create an array of slots with the given size.
        slots = new Slot[size];
        // loop through the array and initialize each slot with a new Slot.
        for (int i = 0; i < size; i++) {
            slots[i] = new Slot();
        }

    }

    /**
     * 2 arg constructor.
     *
     * @param size int
     * @param product Product
     */

    public VendingMachine(int size, Product product) {
        slots = new Slot[size];
        // Loop through the array adn initialize each slot with a new Slot
        for (int i = 0; i < size; i++) {
            slots[i] = new Slot(product);
            // reduce the machines and total profit by the cost of the product.
            machineProfit -= product.getCost() * Slot.SLOT_SIZE;
            totalProfit -= product.getCost() * Slot.SLOT_SIZE;

        }

    }

    /**
     * The load method.
     */

    public void load() {
        // create a new instance of generic product
        Product genericProduct = new Product();
        // loop through each slot in the machine and load it with generic prodcut
        for (Slot slot : slots) {
            // call the load method on the current slot to load with genricproduct
            int count = slot.load(genericProduct);
            // camculate the cose of the loaded products by * the count by cost
            int cost = genericProduct.getCost() * count;
            // update the machine and total profut by substracting the cost of the loaded products.
            machineProfit -= cost;
            totalProfit -= cost;
        }

    }

    /**
     * 3 arg constructor.
     *
     * @param slotNum int
     * @param count int
     * @param product Product
     * @throws IllegalArgumentException if the params are vaild
     */

    public void load(int slotNum, int count, Product product) throws IllegalArgumentException {
        // check the parameters are vaild and make sure not out of bounds and that count cant be negative.
        if (slotNum < 0 || slotNum >= slots.length || count < 0 || product == null) {
            throw new IllegalArgumentException();
        }
        // get the slot object for the given slot number
        Slot slot = slots[slotNum];
        // call the load method on the Slot object to load it with the given product and count
        int actualCount = slot.load(product, count);
        // calculate the cost of the loaded products by * the actual count by the cost of the product
        int cost = product.getCost() * actualCount;

        // update the machine and total profut by substracting the cost of the loaded products.
        machineProfit -= cost;
        totalProfit -= cost;

    }

    /**
     * 1 arg constructor.
     *
     * @param slotNum int
     * @return the nextProduct
     * @throws IllegalArgumentException if the params are not vaild.
     */

    public Product nextProduct(int slotNum) throws IllegalArgumentException {
        // check parameters are valid
        if (slotNum < 0 || slotNum >= slots.length) {
            throw new IllegalArgumentException();
        }
        // get the Slot object for the given slot number
        Slot slot = slots[slotNum];
        // call the nextProduct method on the Slot object to get the next product in the slot
        return slot.nextProduct();
    }

    /**
     * 1 arg constructor.
     *
     * @param slotNum int
     * @return a boolean
     * @throws IllegalArgumentException if the params are not vaild
     */

    public boolean buy(int slotNum) throws IllegalArgumentException {
        // check the parameters are vaild
        if (slotNum < 0 || slotNum >= slots.length) {
            throw new IllegalArgumentException();
        }
        // Get the Slot object for the given slot number
        Slot slot = slots[slotNum];
        // check if there is a product available to buy in the specified slot
        if (this.nextProduct(slotNum) != null) {
            // if there is a product available then but one from the slot
            Product product = slot.buyOne();
            // get the price of the bought product
            int price = product.getPrice();
            // update the machine and total profit by adding the price of the bought product
            machineProfit += price;
            totalProfit += price;
            return true;
        }

        return false;
    }

    public int getSlotCount() {
        return slots.length;
    }

    public int getMachineProfit() {
        return machineProfit;
    }

    public static int getTotalProfit() {
        return totalProfit;
    }

    /**
     * Statice method.
     */

    public static void resetTotalProfit() {
        totalProfit = 0;
    }

    @Override
    public String toString() {
        double tlProfit = totalProfit;
        double mProfit = machineProfit;
        String result = "Vending Machine\n";
        for (Slot slot : slots) {
            result += slot.toString();
        }

        result += String.format("Total Profit: %.2f Machine Profit: %.2f.", tlProfit / 100, mProfit / 100);
        return result;
    }
}