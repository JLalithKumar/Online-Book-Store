import java.util.*;

public class BookStore {
    private List<Book> books = new ArrayList<>();
    private int bookId = 1;

    public void addBook(String title, String author, double price, int stock) {
        books.add(new Book(bookId++, title, author, price, stock));
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("--- Available Books ---");
        for (Book b : books) System.out.println(b);
    }

    public Book searchBookById(int id) {
        for (Book b : books) {
            if (b.id == id) return b;
        }
        return null;
    }

    public void searchBook(String keyword) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase()) ||
                b.author.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No matching books found.");
    }

    public boolean buyBook(int id) {
        Book book = searchBookById(id);
        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }
        if (book.stock <= 0) {
            System.out.println("Out of stock!");
            return false;
        }
        book.stock--;
        System.out.println("Purchased: " + book.title);
        return true;
    }

    public void removeBook(int id) {
        books.removeIf(b -> b.id == id);
        System.out.println("Book removed (if it existed).");
    }
}
