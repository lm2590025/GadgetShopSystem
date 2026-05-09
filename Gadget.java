/**
 * Gadget.java
 * Base class for all gadgets in the GadgetShop system.
 * Student: Md Mirazul Islam Rahat
 * Student ID: 221LM2590025
 */

public class Gadget {
    private String model;
    private double price;
    private int weight;
    private String size;

    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getSize() {
        return size;
    }

    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + " grams");
        System.out.println("Size: " + size);
    }

    public String toString() {
        return "Model: " + model +
               "\nPrice: £" + price +
               "\nWeight: " + weight + " grams" +
               "\nSize: " + size;
    }
}
