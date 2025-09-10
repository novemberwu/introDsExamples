package unit1;

public class Product {
    private String name;
    private double price;
    private static int totalProductsCreated = 0; // Static data member

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        totalProductsCreated++; // Accessing and modifying static member in constructor (an instance method)
    }

    public void displayProductInfo() { // Instance method
        System.out.println("Product Name: " + this.name);
        System.out.println("Product Price: $" + this.price);
        System.out.println("Total Products Created: " + totalProductsCreated); // Accessing static member
    }

    public static int getTotalProductsCreated() { // Static method to access static member
        return totalProductsCreated;
    }

    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1200.00);
        product1.displayProductInfo();

        Product product2 = new Product("Mouse", 25.00);
        product2.displayProductInfo();

        System.out.println("Total products from static method: " + Product.getTotalProductsCreated());
    }
}
