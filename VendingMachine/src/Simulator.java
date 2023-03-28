import java.util.ArrayList;

/**
 * Simulator class.
 *
 * Simulates a small business of vending machines by keeping track of a list of VendingMachine objects and providing a
 * method for buying products from every slot of every machine.
 *
 * @author adins
 * @version 03-24-2023
 */

public class Simulator {
    private ArrayList<VendingMachine> vmList;

    /**
     * Creates a new instance of the Simulator class with an empty list of vending machines.
     *
     * @param vmList ArrayList
     */

    public Simulator(ArrayList<VendingMachine> vmList) {
        this.vmList = new ArrayList<VendingMachine>();
        for (VendingMachine vm : vmList) {
            addVM(vm);
        }
    }

    /**
     * Adds a VendingMachine to the list of machines owned by the company.
     *
     * @param vm vendingmachine
     */

    public void addVM(VendingMachine vm) {
        this.vmList.add(vm);
    }

    /**
     * Simulates buying a specific number of products from every slot of every VendingMachine owned by the company.
     *
     * @param pCount int
     * @return totalProfit
     *
     * Kyle To also gave me some direction on this as well.
     */

    public int simulate(int pCount) {

        for (VendingMachine vm : vmList) {
            for (int i = 0; i < vm.getSlotCount(); i++) {
                if (vm.nextProduct(i) != null) {
                    for (int j = 0; j < pCount; j++) {
                        vm.buy(i);
                    }
                }
            }

        }
        return VendingMachine.totalProfit;
    }

}
