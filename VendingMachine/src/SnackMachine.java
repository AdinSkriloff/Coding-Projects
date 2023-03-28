import java.util.ArrayList;

/**
 * Snackmahcine extends the changemakingmachine.
 *
 * @author adins
 * @version 03-24-2023
 */

public class SnackMachine extends ChangeMakingMachine {

    private ArrayList<Product> productList;

    /**
     * 1 arg constructor.
     *
     * @param pList Arraylist
     */

    public SnackMachine(ArrayList<Product> pList) {
        // call the constructor of the parent vendingmachine class with size of product list
        super(pList.size());
        // create a new arraylist to store products
        productList = new ArrayList<Product>();
        // add each product in the plist parameter to the prodcutlist
        for (Product product : pList) {
            productList.add(product);
        }
        // Load the products into the vending machine slots
        load();
    }

    @Override
    public void load() {
        // iterate over the productlist and load each product into the right slot
        for (int i = 0; i < productList.size(); i++) {
            load(i, Slot.SLOT_SIZE, productList.get(i));
        }
    }

}
