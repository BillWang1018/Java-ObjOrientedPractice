package HW231012;
import java.util.Scanner;
import java.util.stream.Stream;

import HW231012.WishTea.IcelvlE;
import HW231012.WishTea.ProductE;
import HW231012.WishTea.SizeE;
import HW231012.WishTea.ToppingE;

import java.util.ArrayList;
import java.util.Arrays;

public class WishTea_main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<WishTea> orders = new ArrayList<>();
        String s = new String();
        int[] count = {1, 0, 0};

        while(true) {
            orders.add(readOrder());
            System.out.printf("Continue adding? [Y/N]\n");
            s = sc.nextLine().toUpperCase().trim();
            if(s.charAt(0) == 'N')
                break;
        }

        // Print order
        System.out.printf("""
        Order Description
        =======================================================================
        """);

        orders.forEach((o) -> {
            System.out.printf("%d. %s\n", count[0]++, o.getDescription());
            count[1] += o.getCount();
            count[2] += o.calcCost();
        });

        System.out.printf("-----------------------------------------------------------------------\n");
        System.out.printf("Total Cost\t\t\t\t\t\t%d\t$%d\n", count[1], count[2]);
        System.out.printf("=======================================================================\n");
        
        sc.close();
    }

    static WishTea readOrder() {
        Scanner sc = new Scanner(System.in);
        WishTea order = new WishTea();

        System.out.printf("Please input your order: [Name] [Size] [Iced] [Amount] (Toppings)[Y/N]\n");
        String str = new String();

        str = sc.next().toUpperCase();

        if (str.charAt(0) == 'S') {
            order.setProduct(ProductE.SIGNATURED_FRUIT_TEA);
        } else
        if (str.charAt(0) == 'B') {
            order.setProduct(ProductE.BUBBLE_MILK_TEA);
        } 
        else {
            order.setProduct(ProductE.UNKNOWN);
        }

        str = sc.next().toUpperCase();

        if (str.charAt(0) == 'S') {
            order.setSize(SizeE.SMALL);
        } else
        if (str.charAt(0) == 'M') {
            order.setSize(SizeE.MEDIUM);
        } else
        if (str.charAt(0) == 'L') {
            order.setSize(SizeE.LARGE);
        }

        str = sc.next().toUpperCase();

        if (str.charAt(0) == 'N') {
            order.setIcelvl(IcelvlE.NO);
        } else
        if (str.charAt(0) == 'L' || str.charAt(0) == 'S') {
            order.setIcelvl(IcelvlE.LITTLE);
        } else 
        if (str.charAt(0) == 'R') {
            order.setIcelvl(IcelvlE.REGULAR);
        }

        order.setCount(sc.nextInt());

        str = sc.next().toUpperCase();

        if (str.charAt(0) == 'Y') {
            System.out.printf("Please input your desired toppings (split using ','):\n");
            sc.nextLine();
            str = sc.nextLine().toUpperCase();
            Stream<String> stream = Arrays.stream(str.split(","));

            ArrayList<ToppingE> toppings = new ArrayList<ToppingE>();
            stream.forEach((s) -> {
                s = s.trim();
                if (s.charAt(0) == 'B') {
                    toppings.add(ToppingE.BUBBLE);
                } else
                if (s.charAt(0) == 'P') {
                    toppings.add(ToppingE.PUDDING);
                }
            });
            order.setToppings(toppings);
            System.out.printf("Added %d topping(s).\n", toppings.size());
        }
        System.out.printf("Added %d drink(s).\n", order.getCount());
        sc.close();
        return order;
    }
}
