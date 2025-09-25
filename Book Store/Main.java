import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookStore store = new BookStore();
        List<User> users = new ArrayList<>();

        // Sample books
        store.addBook("Java Basics", "James Gosling", 499.0, 5);
        store.addBook("Effective Java", "Joshua Bloch", 899.0, 3);

        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        User currentUser = new User(username);
        users.add(currentUser);

        while (true) {
            System.out.println("\n=== Online Book Store ===");
            System.out.println("1. View Books");
            System.out.println("2. Search Book");
            System.out.println("3. Buy Book");
            System.out.println("4. View My Purchases");
            System.out.println("5. Admin - Add Book");
            System.out.println("6. Admin - Remove Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> store.viewBooks();
                case 2 -> {
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();
                    store.searchBook(keyword);
                }
                case 3 -> {
                    System.out.print("Enter Book ID to buy: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (store.buyBook(id)) {
                        Book purchasedBook = store.searchBookById(id);
                        currentUser.addPurchase(purchasedBook);
                    }
                }
                case 4 -> currentUser.viewPurchases();
                case 5 -> {
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter stock: ");
                    int stock = sc.nextInt();
                    sc.nextLine();
                    store.addBook(title, author, price, stock);
                }
                case 6 -> {
                    System.out.print("Enter Book ID to remove: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    store.removeBook(id);
                }
                case 0 -> {
                    System.out.println("Goodbye, " + currentUser.username + "!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
