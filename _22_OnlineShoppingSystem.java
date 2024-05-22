import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 interface Purchasable {
    void addItem();
    void removeItem();
    double calculateTotalPrice();
}
 abstract class Item implements Purchasable {
    protected String name;
    protected double price;
    protected int quantity;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void addItem() {
        quantity++;
    }

    @Override
    public void removeItem() {
        if (quantity > 0) {
            quantity--;
        }
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
               "name='" + name + '\'' +
               ", price=" + price +
               ", quantity=" + quantity +
               '}';
    }
}

 class Electronics extends Item {
    public Electronics(String name, double price) {
        super(name, price);
    }
}
 class Clothing extends Item {
    public Clothing(String name, double price) {
        super(name, price);
    }
}
 class Books extends Item {
    public Books(String name, double price) {
        super(name, price);
    }
}


 class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        item.addItem();
        if (!items.contains(item)) {
            items.add(item);
        }
        System.out.println(item.getName() + " added to the cart.");
    }

    public void removeItem(Item item) {
        item.removeItem();
        if (item.getQuantity() == 0) {
            items.remove(item);
        }
        System.out.println(item.getName() + " removed from the cart.");
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.calculateTotalPrice();
        }
        return totalPrice;
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Items in the cart:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public void checkout() {
        double totalPrice = calculateTotalPrice();
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Thank you for your purchase!");
        items.clear();
    }
}


public class _22_OnlineShoppingSystem {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOnline Shopping System:");
            System.out.println("1. Add Electronics");
            System.out.println("2. Add Clothing");
            System.out.println("3. Add Book");
            System.out.println("4. Remove Electronics");
            System.out.println("5. Remove Clothing");
            System.out.println("6. Remove Book");
            System.out.println("7. Display Cart");
            System.out.println("8. Checkout");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Electronics name: ");
                    String eName = scanner.nextLine();
                    System.out.print("Enter Electronics price: ");
                    double ePrice = Double.parseDouble(scanner.nextLine());
                    cart.addItem(new Electronics(eName, ePrice));
                    break;
                case 2:
                    System.out.print("Enter Clothing name: ");
                    String cName = scanner.nextLine();
                    System.out.print("Enter Clothing price: ");
                    double cPrice = Double.parseDouble(scanner.nextLine());
                    cart.addItem(new Clothing(cName, cPrice));
                    break;
                case 3:
                    System.out.print("Enter Book name: ");
                    String bName = scanner.nextLine();
                    System.out.print("Enter Book price: ");
                    double bPrice = Double.parseDouble(scanner.nextLine());
                    cart.addItem(new Books(bName, bPrice));
                    break;
                case 4:
                    System.out.print("Enter Electronics name to remove: ");
                    String reName = scanner.nextLine();
                    cart.removeItem(new Electronics(reName, 0));
                    break;
                case 5:
                    System.out.print("Enter Clothing name to remove: ");
                    String rcName = scanner.nextLine();
                    cart.removeItem(new Clothing(rcName, 0));
                    break;
                case 6:
                    System.out.print("Enter Book name to remove: ");
                    String rbName = scanner.nextLine();
                    cart.removeItem(new Books(rbName, 0));
                    break;
                case 7:
                    cart.displayCart();
                    break;
                case 8:
                    cart.checkout();
                    break;
                case 9:
                    System.out.println("Exiting Online Shopping System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
