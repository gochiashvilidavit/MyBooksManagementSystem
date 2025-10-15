import java.io.*;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
    }

    // Task 6
    public static void serializeBook(Book book, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(book);
            System.out.println("Serialized book data to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 7
    public static Book deserializeBook(String filePath) {
        Book book = null;
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            book = (Book) in.readObject();
            System.out.println("Deserialized book data from " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return book;
    }
}
