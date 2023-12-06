package TeamProject;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class VendingMachineAPP {
    private static Scanner sc = new Scanner(System.in);
    private static VendingMachine vm = new VendingMachine();
    private static char cmd;
    private static int money=0;
    private static Product selection;

    private static char nextChar() {
        return sc.nextLine().toUpperCase().charAt(0);
    }

    private static void clearAndPrint(Messages depositInfo) {
        System.out.flush();
        System.out.print(depositInfo.toString());
    }
    private static void clearAndPrint(String str) {
        System.out.flush();
        System.out.print(str);
    }

    private static Product charToProduct(char c) {
        switch (c) {
            case 'A':
                return Product.COCO_COLA;
            case 'B':
                return Product.MM_ORANGE_JUICE;
            case 'C':
                return Product.EVIAN_WATER;
            case 'D':
                return Product.MM_CHOCOLATE;
            case 'E':
                return Product.HERSHEY_CHOCOLATE;
            case 'F':
                return Product.OREO_COOKIES;
            case 'G':
                return Product.DT_CHIPS;
            case 'H':
                return Product.PRINGLES_CHIPS;
        }
        return null;
    }

    private static void deposit() {
        clearAndPrint(Messages.DEPOSIT_INFO);
        cmd = nextChar();
        
        switch (cmd) {
            case 'B':
                while (true) {
                    clearAndPrint(Messages.DEPOSIT_B_INFO);
                    money = Integer.parseInt(sc.nextLine());
                    if ( Arrays.asList(1, 5, 10, 20).contains(money) ) {
                        vm.deposit(money);
                    } else if (money==0) {
                        break; // break while
                    } else {
                        System.out.println("ignored...");
                    }
                }
                break;

            case 'C':
                while (true) {
                    clearAndPrint(Messages.DEPOSIT_C_INFO);
                    money = Integer.parseInt(sc.nextLine());
                    if ( Arrays.asList(5, 10, 25).contains(money) ) {
                        vm.deposit(money/100.0);
                    } else if (money==0) {
                        break; // break while
                    } else {
                        System.out.println("ignored...");
                    }
                    
                }

            default:
                break;
        }
    }

    private static void startMachine() {
        while(true) {
            clearAndPrint(Messages.FUNCTION_INFO);
            cmd = nextChar();
            switch (cmd) {
                case 'A': // Deposit
                    deposit();
                    break;

                case 'B': // Select products
                    while (true) {
                        clearAndPrint(Messages.ADDING_TITLE + Messages.PRODUCT_INFO.toString());
                        cmd = nextChar();
                        selection = charToProduct(cmd);
                        if(cmd == 'Q') break; // break while
                        else {
                            if(selection != null) {
                                vm.addItem(selection);
                            } else {
                                System.out.println("ignored...");
                            }
                        }
                    }
                    break;

                case 'C': // Remove products
                    while (true) {
                        clearAndPrint(Messages.REMOVING_TITLE + Messages.PRODUCT_INFO.toString());
                        cmd = nextChar();
                        selection = charToProduct(cmd);
                        if(cmd == 'Q') break; // break while
                        else {
                            if(selection != null) {
                                vm.removeItem(selection);
                            } else {
                                System.out.println("ignored...");
                            }
                        }
                    }
                    break;

                case 'D': // Check out
                    try {
                        vm.purchase();
                        clearAndPrint(vm.getReceipt());
                        System.out.printf("Remaining: %.2f\n", vm.getRemaining());
                        vm.reset();
                        
                    } catch (VendingMachineException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Enter deposit mode? (Y/N)");
                        switch (nextChar()) {
                            case 'Y':
                                deposit();
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                
                case 'E': // Exit
                    System.out.printf("Remaining: %.2f\n", vm.getRemaining());
                    vm.reset();
                    return;
                default:
                    break;
            }
            System.out.flush();
        }
    }

    public static void main(String[] args) {
        
        startMachine();

        // vm.deposit(100);
        // vm.addItem(Product.MM_CHOCOLATE);
        // vm.addItem(Product.COCO_COLA, 2);
        // System.out.println(vm.getReceipt());
        // try {
        //     vm.purchase();
        // } catch (Exception e) {
        //     System.err.println(e.getMessage());
        // }

        // double moneyLeft = vm.exit();
        // System.out.printf("Money left: $%.2f\n", moneyLeft);
        sc.close();
    }
}
