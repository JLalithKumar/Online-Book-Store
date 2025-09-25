public class Book {
    int id;
    String title;
    String author;
    double price;
    int stock;

    public Book(int id, String title, String author, double price, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public String toString() {
        return id + " | " + title + " by " + author + " | ₹" + price + " | Stock: " + stock;
    }
}
