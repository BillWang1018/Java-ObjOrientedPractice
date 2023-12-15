package TeamProject2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class VendingMachineException extends Exception {
    VendingMachineException() {}
    VendingMachineException(String s) {super(s);}
}

public class VendingMachine {
    
    final List<Integer> avalibleBills = Arrays.asList(1, 5, 10, 20);
    final List<Integer> avalibleCoins = Arrays.asList(5, 10, 25);
    private HashMap<Product, Integer> selection = new HashMap<Product, Integer>();
    private List<Integer> depositRecord = new ArrayList<Integer>();
    private int cent;

    public VendingMachine() {};

    public void deposit(int amount) {
        this.cent += amount;
        depositRecord.add(amount);
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

    public void purchase() throws VendingMachineException {
        int cost = (int)(getTotalCost()*100);

        if(cost == 0) {
            throw new VendingMachineException("Nothing selected!");
        }

        if(cost > cent) {
            throw new VendingMachineException(String.format(
                    "Not enough money!\n"+
                    "The total of %.2f and only %.2f deposited.\n", 
                    getTotalCost(), cent/100.0
                    ));
        } 

        cent -= cost;

        printDepositExchanged();
    }

    public String getReceipt() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<50; i++) sb.append('=');
        sb.append('\n');
        sb.append(String.format("%-35s%s  %s\n\n", "Product", "Amount", "Price"));
        for(Map.Entry<Product, Integer> item : selection.entrySet()) {
            sb.append(String.format("%-35s| %2d    $%.2f\n", 
                    item.getKey(), 
                    item.getValue(),
                    item.getKey().getPrice() * item.getValue()
            ));
        }
        for(int i=0; i<50; i++) sb.append('*');
        sb.append('\n');
        sb.append(String.format("%-43s$%.2f\n", "Total:", getTotalCost()));
        for(int i=0; i<50; i++) sb.append('=');
        sb.append('\n');
        return sb.toString();
    }

    public double getRemainingDollar() {
        return this.cent/100.0;
    }

    public int getAmount(Product p) {
        if(!selection.containsKey(p)) return 0;
        return selection.get(p);
    }

    public void reset() {
        this.cent = 0;
        this.depositRecord.clear();
        removeAll();
    }

    public void printDepositExchanged() {
        int target = cent;
        List<Integer> avalCent = new ArrayList<Integer>(avalibleBills);
        avalCent.replaceAll(i -> i*100);
        avalCent = Stream.concat(avalibleCoins.stream(), avalCent.stream()).toList();
        int dp[] = new int[target+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=target; i++) {
            for(int c : avalCent) {
                if(i-c < 0) continue;
                if(dp[i-c] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[i-c]+1);
            }
        }

        List<Integer> record = new ArrayList<Integer>();
        int prev, next;
        prev = next = target;
        while(next >= 0) {
            if(dp[next] < dp[prev]) {
                record.add(prev-next);
                prev = next;
            } else {
                next--;
            }
        }
        
        record.sort(Comparator.reverseOrder());
        System.out.println(getMoneyString(record));

    }

    public void printDeposit() {
        System.out.println(getMoneyString(depositRecord));
    }

    private String getMoneyString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        list.sort(Comparator.reverseOrder());
        for(int m : list) {
            if(m >= 100) {
                sb.append(String.format("[%d] ", m/100));
            } else {
                sb.append(String.format("(.%02d) ", m));
            }
        }
        return sb.toString();
    }

}
