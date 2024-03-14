import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> rentedBooks;

    public User(String name) {
        this.name = name;
        this.rentedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void rentBook(Book book) {
        rentedBooks.add(book);
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }
}

