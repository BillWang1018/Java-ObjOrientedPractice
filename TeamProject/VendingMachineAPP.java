package TeamProject;

import java.util.Scanner;

public class VendingMachineAPP {
    private static Scanner sc = new Scanner(System.in);
    private static VendingMachine vm = new VendingMachine();
    private static char cmd;
    private static int cent=0;
    private static Product selection;
    private static String printAfter;

    private static char nextChar() {
        String input = sc.nextLine().toUpperCase();
        if(input.length() == 0) return 0;
        return input.charAt(0);
    }

    private static void clearAndPrint(Messages depositInfo) {
        clearConsole();
        System.out.print(depositInfo.toString());
    }
    private static void clearAndPrint(String str) {
        clearConsole();
        System.out.print(str);
    }
    private static void clearConsole() {
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
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
        printAfter = "";
        clearAndPrint(Messages.DEPOSIT_INFO);
        cmd = nextChar();
        
        switch (cmd) {
            case 'B':
                while (true) {
                    clearAndPrint(printAfter + Messages.DEPOSIT_B_INFO);
                    try {
                        cent = Integer.parseInt(sc.nextLine());

                    } catch(Exception e) {
                        printAfter = ("ignored...\n");
                        continue;
                    }

                    if ( vm.avalibleBills.contains(cent) ) {
                        vm.deposit(cent*100); // change to cent
                        printAfter = String.format(
                                "Added %d, Total of %.2f\n", cent, vm.getRemainingDollar());
                    } else if (cent==0) {
                        printAfter = String.format("Deposit: $%.2f\n", vm.getRemainingDollar());
                        break; // break while
                    } else {
                        printAfter = ("ignored...\n");
                    }
                }
                break;

                case 'C':
                while (true) {
                    clearAndPrint(printAfter + Messages.DEPOSIT_C_INFO);
                    try {
                        cent = Integer.parseInt(sc.nextLine());

                    } catch(Exception e) {
                        printAfter = ("ignored...\n");
                        continue;
                    }
                    if ( vm.avalibleCoins.contains(cent) ) {
                        vm.deposit(cent);
                        printAfter = String.format(
                                "Added %.2f, Total of %.2f\n", cent/100.0, vm.getRemainingDollar());
                    } else if (cent==0) {
                        printAfter = String.format(
                                "Deposit: $%.2f\n", vm.getRemainingDollar());
                        break; // break while
                    } else {
                        printAfter = ("ignored...\n");
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
                        clearAndPrint(printAfter + Messages.ADDING_TITLE + Messages.PRODUCT_INFO.toString());
                        cmd = nextChar();
                        selection = charToProduct(cmd);
                        if(cmd == 'Q') break; // break while
                        else {
                            if(selection != null) {
                                vm.addItem(selection, 1);
                                printAfter = (
                                        "Added 1* " + selection + 
                                        ", now having " + vm.getAmount(selection) + "\n");
                            } else {
                                printAfter = ("ignored...\n");
                            }
                        }
                    }
                    break;

                case 'C': // Remove products
                    while (true) {
                        clearAndPrint(printAfter + Messages.REMOVING_TITLE + Messages.PRODUCT_INFO.toString());
                        cmd = nextChar();
                        selection = charToProduct(cmd);
                        if(cmd == 'Q') break; // break while
                        else {
                            if(selection != null && vm.getAmount(selection) > 0) {
                                vm.removeItem(selection, 1);
                                printAfter = (
                                        "Removed 1* " + selection + 
                                        ", now having " + vm.getAmount(selection)  + "\n");
                            } else {
                                printAfter = ("ignored...\n");
                            }
                        }
                    }
                    break;

                case 'D': // Check out
                    try {
                        clearAndPrint(vm.getReceipt());
                        System.out.printf("Deposit: %.2f\n", vm.getRemainingDollar());
                        
                        System.out.println("Proceed to purchase? (Y/N)");
                        switch (nextChar()) {
                            case 'Y':
                                vm.purchase();
                                System.out.println("Purchase complete!");
                                System.out.printf("Remaining: %.2f\n", vm.getRemainingDollar());
                                System.out.println("Enter to continue...");
                                vm.reset();
                                nextChar();
                                break;
                            default:
                                break;
                        }
                        
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
                    System.out.printf("Deposit: %.2f\n", vm.getRemainingDollar());
                    vm.printDeposit();
                    vm.reset();
                    return;
                default:
                    break;
            }
            clearAndPrint(printAfter);
            printAfter = "";
        }
    }

    public static void main(String[] args) {
        
        startMachine();

        sc.close();
    }
}
