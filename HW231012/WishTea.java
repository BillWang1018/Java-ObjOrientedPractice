package HW231012;
import java.util.ArrayList;
import java.util.stream.Collectors;

class WishTea {
    enum ProductE {
        SIGNATURED_FRUIT_TEA ("Signatured Fruit Tea", 5,60,80,90),
        BUBBLE_MILK_TEA      ("Bubble Milk Tea", 10,40,50,60),
        UNKNOWN              ("Unnamed", 0,0,0,0);
        
        private final String name;
        private final int toppingCost;
        private final int sSize;
        private final int mSize;
        private final int lSize;

        private ProductE(String name, int toppingCost, int sSize, int mSize, int lSize) {
            this.name = name;
            this.toppingCost = toppingCost;
            this.sSize = sSize;
            this.mSize = mSize;
            this.lSize = lSize;
        }

        public int getToppingCost() {
            return toppingCost;
        }
        public int getsSize() {
            return sSize;
        }
        public int getmSize() {
            return mSize;
        }
        public int getlSize() {
            return lSize;
        }
        public int getSizeCost(SizeE size) {
            switch(size) {
                case SMALL:
                    return sSize;
                case MEDIUM:
                    return mSize;
                case LARGE:
                    return lSize;
            }
            return 0;
        }

        @Override
        public String toString() {
            return name;
        }

    }


    enum SizeE {
        SMALL("Small"), MEDIUM("Medium"), LARGE("Large");

        private final String size;

        private SizeE(String size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return size;
        }
    }

    enum IcelvlE {
        NO("No Ice"), 
        LITTLE("Some Ice"), 
        REGULAR("Regular Ice");

        private final String icelvl;

        private IcelvlE(String icelvl) {
            this.icelvl = icelvl;
        }

        @Override
        public String toString() {
            return icelvl;
        }
    }
    enum ToppingE {
        BUBBLE("Bubble"), PUDDING("Pudding");

        private final String topping;

        private ToppingE(String topping) {
            this.topping = topping;
        }

        @Override
        public String toString() {
            return topping;
        }

    }


    private ProductE product;
    private SizeE size;
    private IcelvlE icelvl;
    private int count;
    private ArrayList<ToppingE> toppings = new ArrayList<ToppingE>();


    WishTea() {
        this.product = ProductE.UNKNOWN;
        this.size = SizeE.MEDIUM;
        this.icelvl = IcelvlE.LITTLE;
        this.count = 1;
    }

    WishTea(ProductE product, SizeE size, IcelvlE icelvlE, int count) {
        this.product = product;
        this.size = size;
        this.icelvl = icelvlE;
        this.count = count;
    }
    
    public ProductE getProduct() {
        return product;
    }

    public void setProduct(ProductE product) {
        this.product = product;
    }

    public SizeE getSize() {
        return size;
    }

    public void setSize(SizeE size) {
        this.size = size;
    }

    public IcelvlE getIcelvl() {
        return icelvl;
    }

    public void setIcelvl(IcelvlE icelvl) {
        this.icelvl = icelvl;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public ArrayList<ToppingE> getToppings() {
        return toppings;
    }

    public String getToppingsString() {
        String str;
        if (toppings.size() == 0) 
            return "\t";
        str = toppings.stream().map(ToppingE::toString).collect(Collectors.joining(" "));
        return str;
    }

    public void setToppings(ArrayList<ToppingE> toppings) {
        if(toppings.isEmpty()) {
            this.toppings.clear();
            return;
        }
        this.toppings = toppings;
    }

    //====================================================//

    public double calcCost() {
        double cost = product.getSizeCost(size);
        cost += product.getToppingCost() * toppings.size();
        cost *= count;

        return cost;
    }

    public String getDescription() {
        String description;
        description = String.format("%s\t\t%s\t%s\t%d\t$%.0f", product, size, getToppingsString(), count, calcCost());
        // System.out.printf("%s\t%s\t%d\t$%d", product, size, getToppingsString(), count, calcCost());

        return description;
    }


}