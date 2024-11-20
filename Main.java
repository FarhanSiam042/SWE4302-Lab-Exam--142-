//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Flavor mintChocolateChip = new Flavor("Mint Chocolate Chip", 2.80);
        Flavor chocolateFudge = new Flavor("Chocolate Fudge", 3.00);
        Flavor strawberrySwirl = new Flavor("Strawberry Swirl", 2.75);
        Flavor PistachioDelight = new Flavor("Pistachio Delight", 3.25);

        Topping sprinkles = new Topping("Sprinkles", 0.30);
        Topping chocolateChips = new Topping("Chocolate Chips", 0.50);
        Topping marshmallow = new Topping("Marshmallow", 0.70);
        Topping crushedOreo = new Topping("Crushed Oreo", 0.85);
        Topping freshStarwberries = new Topping("Fresh Strawberries", 1.00);


        Order order = new Order(true);
        order.addFlavor(mintChocolateChip);
        order.addFlavor(chocolateFudge);
        order.addTopping(sprinkles);
        order.addTopping(chocolateChips);
        order.addTopping(freshStarwberries);


        String invoice = order.generateInvoice();
        System.out.println(invoice);


        try (FileWriter writer = new FileWriter("Invoice.txt")) {
            writer.write(invoice);
        } catch (IOException e) {
            System.out.println("Error saving invoice: " + e.getMessage());
        }
    }
}
