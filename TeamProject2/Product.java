package TeamProject2;

public enum Product {
    COCO_COLA("Coco Cola", 1.65),
    MM_ORANGE_JUICE("Minute Maid Orange Juice", 3.50),
    EVIAN_WATER("Evian Mineral Water", 2.80),
    MM_CHOCOLATE("M&M's Chocolate", 1.5),
    HERSHEY_CHOCOLATE("Hershey's Chocolate Bar", 1.85),
    OREO_COOKIES("Oreo Cookies", 1.0),
    DT_CHIPS("Doritos Tortilla Chips", 3.25),
    PRINGLES_CHIPS("Pringles Potato Chips", 3.40)
    ;
    private final String name;
    private final double price;
    
    private Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
