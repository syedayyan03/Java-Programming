import java.util.*;

public class FoodWendingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menu items with prices
        String[] items = {"Dal Fry", "Paneer Butter Masala", "Chicken Curry", "Fish Fry", "Tomato Curry"};
        int[] prices = {40, 100, 120, 100, 30};

        System.out.print("Hi, Please enter your name: ");
        String name = sc.nextLine();
        System.out.printf("Hey %s, Welcome to our Restaurant!\n\n", name);

        int totalBill = 0;
        boolean ordering = true;

        while (ordering) {
            // Display menu
            System.out.println("========= MENU =========");
            for (int i = 0; i < items.length; i++) {
                System.out.printf("%d. %s - Rs.%d\n", (i + 1), items[i], prices[i]);
            }
            System.out.println("0. Exit & Pay Bill");
            System.out.println("========================");

            // Get choice
            System.out.print("Select from the menu: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                ordering = false; // Exit loop
                continue;
            }

            if (choice < 1 || choice > items.length) {
                System.out.println("Invalid choice! Please try again.\n");
                continue;
            }

            // Get quantity
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            int itemPrice = prices[choice - 1] * qty;
            System.out.printf("You selected %s x %d = Rs.%d\n", items[choice - 1], qty, itemPrice);

            // Payment
            System.out.print("Enter amount paid: ");
            int paid = sc.nextInt();

            if (paid == itemPrice) {
                System.out.println("Exact amount received. Order placed successfully!\n");
                totalBill += itemPrice;
            } else if (paid > itemPrice) {
                int change = paid - itemPrice;
                System.out.printf("Payment received. Please take your change Rs.%d\n", change);
                totalBill += itemPrice;
            } else {
                int due = itemPrice - paid;
                System.out.printf("You still need to pay Rs.%d more!\n\n", due);
                continue; // don’t add to total if not fully paid
            }
        }

        // Final bill
        System.out.println("\n========= BILL =========");
        System.out.printf("Customer: %s\n", name);
        System.out.printf("Total Amount: Rs.%d\n", totalBill);
        System.out.println("Thanks for ordering with us! Visit again.");
        System.out.println("========================");

        sc.close();
    }
}
