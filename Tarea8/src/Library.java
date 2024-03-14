import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<User> users;
    private List<Book> books;

    public Library() {
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    public void registerUser(String name) {
        users.add(new User(name));
    }

    public void registerBook(String title) {
        books.add(new Book(title));
    }

    public void rentBook(User user, Book book) {
        book.setRented(true);
        user.rentBook(book);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<User> getUsersWithBooks() {
        List<User> usersWithBooks = new ArrayList<>();
        for (User user : users) {
            if (!user.getRentedBooks().isEmpty()) {
                usersWithBooks.add(user);
            }
        }
        return usersWithBooks;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isRented()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public List<Book> getRentedBooks() {
        List<Book> rentedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isRented()) {
                rentedBooks.add(book);
            }
        }
        return rentedBooks;
    }

    public User findUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null; // User not found
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null; // Book not found
    }
}