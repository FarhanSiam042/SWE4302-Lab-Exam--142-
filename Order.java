import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Flavor> flavors = new ArrayList<>();
    private List<Topping> toppings = new ArrayList<>();
    private boolean isWaffleCone;

    public Order(boolean isWaffleCone) {
        this.isWaffleCone = isWaffleCone;
    }


    public void addFlavor(Flavor flavor) {
        flavors.add(flavor);
    }


    public void addTopping(Topping topping) {
        toppings.add(topping);
    }


    public double calculateSubtotal() {
        double subtotal = 0.0;


        for (Flavor flavor : flavors) {
            subtotal += flavor.getPricePerScoop();
        }


        for (Topping topping : toppings) {
            subtotal += topping.getPrice();
        }


        if (isWaffleCone) {
            subtotal += 5.0;
        }

        return subtotal;
    }


    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        return subtotal + (subtotal * 0.08);
    }


    public String generateInvoice() {
        StringBuilder invoice = new StringBuilder("Ice Cream Shop Invoice\n");


        for (Flavor flavor : flavors) {
            invoice.append(flavor.getName()).append(" - 1 scoop: $")
                    .append(String.format("%.2f", flavor.getPricePerScoop())).append("\n");
        }


        for (Topping topping : toppings) {
            invoice.append(topping.getName()).append(" - 1 time: $")
                    .append(String.format("%.2f", topping.getPrice())).append("\n");
        }


        double subtotal = calculateSubtotal();
        double tax = subtotal * 0.08;
        double total = calculateTotal();

        invoice.append("Subtotal: $").append(String.format("%.2f", subtotal)).append("\n");
        invoice.append("Tax: $").append(String.format("%.2f", tax)).append("\n");
        invoice.append("Total Amount Due: $").append(String.format("%.2f", total)).append("\n");

        return invoice.toString();
    }
}

