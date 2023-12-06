package TeamProject;

import java.util.HashMap;
import java.util.Map;

class VendingMachineException extends Exception {
    VendingMachineException() {}
    VendingMachineException(String s) {super(s);}
}

public class VendingMachine {
    
    private HashMap<Product, Integer> selection = new HashMap<Product, Integer>();
    private double money;

    public VendingMachine() {};

    public void deposit(double amount) {
        this.money += amount;
    }

    public void addItem(Product item) {
        selection.put(item, selection.getOrDefault(item, 0)+1);
    }
    
    public void addItem(Product item, int quantity) {
        if(quantity <= 0) return;
        selection.put(item, selection.getOrDefault(item, 0)+quantity);
    }

    public void removeItem(Product item) {
        selection.remove(item);
    }

    public void removeItem(Product item, int quantity) {
        if(quantity <= 0) return;
        int have = selection.getOrDefault(item, 0);
        if(have <= quantity) {
            removeItem(item);
        } else {
            selection.put(item, have - quantity);
        }
    }

    public void removeAll() {
        selection.clear();
    }

    public double getTotalCost() {
        double total=0;
        for(Map.Entry<Product, Integer> item : selection.entrySet()) {
            total += item.getKey().getPrice() * item.getValue();
        }
        return total;
    }

    public double purchase() throws VendingMachineException {
        double cost = getTotalCost();
        if(cost > money) {
            throw new VendingMachineException(String.format(
                    "Not enough money!\n"+
                    "The total of %.2f and only %.2f deposited.\n", 
                    getTotalCost(), money
                    ));
        } else {
            money -= cost;
        }

        return money;
    }

    public String getReceipt() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-35s%s  %s\n\n", "Product", "Amount", "Total"));
        for(Map.Entry<Product, Integer> item : selection.entrySet()) {
            sb.append(String.format("%-35s| %d     $%.2f\n", 
                    item.getKey(), 
                    item.getValue(),
                    item.getKey().getPrice() * item.getValue()
            ));
        }
        for(int i=0; i<50; i++)
            sb.append('=');
        return sb.toString();
    }

    public double getRemaining() {
        return this.money;
    }

    public void reset() {
        this.money = 0;
        removeAll();
    }

    public double exit() {
        return this.money;
    }

}
