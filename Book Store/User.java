import java.util.*;

public class User {
    String username;
    List<Book> purchasedBooks;

    public User(String username) {
        this.username = username;
        this.purchasedBooks = new ArrayList<>();
    }

    public void addPurchase(Book book) {
        purchasedBooks.add(book);
    }

    public void viewPurchases() {
        if (purchasedBooks.isEmpty()) {
            System.out.println("No purchases yet.");
            return;
        }
        System.out.println("--- Your Purchased Books ---");
        for (Book b : purchasedBooks) {
            System.out.println(b);
        }
    }
}
