import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testCalculateSubtotal() {
        Order order = new Order(false);
        order.addFlavor(new Flavor("Mint Chocolate Chip", 2.80));
        order.addTopping(new Topping("Sprinkles", 0.30));

        assertEquals(3.10, order.calculateSubtotal(), 0.01);
    }

    @Test
    public void testCalculateTotalWithTax() {
        Order order = new Order(true);
        order.addFlavor(new Flavor("Chocolate Fudge", 3.00));
        order.addTopping(new Topping("Chocolate Chips", 0.50));

        assertEquals(9.18, order.calculateTotal(), 0.01); // Subtotal (8.50) + Tax (0.68)
    }

    @Test
    public void testInvoiceGeneration() {
        Order order = new Order(false);
        order.addFlavor(new Flavor("Strawberry Swirl", 2.75));
        order.addTopping(new Topping("Marshmallow", 0.70));

        String invoice = order.generateInvoice();
        assertTrue(invoice.contains("Strawberry Swirl - 1 scoop: $2.75"));
        assertTrue(invoice.contains("Subtotal: $3.45"));
    }
}

