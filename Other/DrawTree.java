package Other;
import java.util.Scanner;

public class DrawTree {
    public static void main(String args[]) {
        // declair vars
        int tier, topSide, growth, twidth, theight;

        // input handling
        Scanner sc = new Scanner(System.in);
        System.out.print("How many tiers in the tree: ");
        tier = sc.nextInt();
        System.out.print("What's the side of the uppermost triangle: ");
        topSide = sc.nextInt();
        System.out.print("What's the growth of the lower tier compared to the upper tier: ");
        growth = sc.nextInt();
        while(true) {
            System.out.print("What's the width of the trunk (odd number): ");
            twidth = sc.nextInt();
            if(twidth%2 == 0) 
                System.err.print("The number should be a odd number, try again\n");
            else 
                break;
        }
        System.out.print("What's the height of the trunk: ");
        theight = sc.nextInt();

        // make tree

        // layers of currently printing triangle
        int layer = topSide;
        // tier of tree
        for(int t=0; t<tier; t++) {
            // triangle of each tier
            if(t == 0) {// apex
                for(int i=0; i<layer-1+growth*(tier-t-1); i++)
                    System.out.print(" ");
                System.out.print("#\n");
            }
            // middle layers
            for(int l=1; l<layer-1; l++) {
                for(int i=0; i<layer-l-1+growth*(tier-t-1); i++) 
                    System.out.print(" ");
                System.out.print("#");
                for(int i=0; i<2*l-1; i++)
                    System.out.print("@");
                System.out.print("#\n");
            }
            // bottom layer
            for(int i=0; i<growth*(tier-t-1); i++) 
                System.out.print(" ");
            for(int i=0; i<2*layer-1; i++)
                System.out.print("#");
            System.out.println();

            // append layers by growth
            layer += growth;
        }
        // trunk
        for(int h=0; h<theight; h++) {
            for(int i=0; i<layer-growth-1-(twidth/2); i++) 
                System.out.print(" ");
            for(int w=0; w<twidth; w++)
                System.out.print('|');
            System.out.println();
        }
    }
}
