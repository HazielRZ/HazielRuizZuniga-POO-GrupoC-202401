import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class LibrarySystem {
    private Library library;

    public LibrarySystem() {
        this.library = new Library();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.println("Enter user name:");
                    String userName = scanner.nextLine();
                    library.registerUser(userName);
                    break;
                case 2:
                    System.out.println("Enter book title:");
                    String bookTitle = scanner.nextLine();
                    library.registerBook(bookTitle);
                    break;
                case 3:
                    System.out.println("Enter user name:");
                    String renterName = scanner.nextLine();
                    System.out.println("Enter book title:");
                    String bookToRent = scanner.nextLine();
                    User renter = library.findUser(renterName);
                    Book book = library.findBook(bookToRent);
                    if (renter != null && book != null) {
                        library.rentBook(renter, book);
                        System.out.println("Book rented successfully.");
                    } else {
                        System.out.println("User or book not found.");
                    }
                    break;
                case 4:
                    displayUsers(library.getAllUsers());
                    break;
                case 5:
                    displayBooks(library.getAllBooks());
                    break;
                case 6:
                    displayUsers(library.getUsersWithBooks());
                    break;
                case 7:
                    displayBooks(library.getAvailableBooks());
                    break;
                case 8:
                    displayBooks(library.getRentedBooks());
                    break;
                case 9:

                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 10);
    }

    private void displayMenu() {
        System.out.println("1. Register User");
        System.out.println("2. Register Book");
        System.out.println("3. Rent Book");
        System.out.println("4. List All Users");
        System.out.println("5. List All Books");
        System.out.println("6. List Users with Books");
        System.out.println("7. List Available Books");
        System.out.println("8. List Rented Books");
        System.out.println("9. Save Data");
        System.out.println("10. Exit");
        System.out.println("Enter your choice:");
    }

    private void displayUsers(List<User> users) {
        System.out.println("Registered Users:");
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

    private void displayBooks(List<Book> books) {
        System.out.println("Registered Books:");
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }


    }
