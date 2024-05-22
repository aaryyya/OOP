import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;
 class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", isbn='" + isbn + '\'' +
               ", isAvailable=" + isAvailable +
               '}';
    }
}

 class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    // Borrow a book from the library
    public void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book borrowed: " + book);
                    return;
                } else {
                    System.out.println("Book is currently not available.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    // Return a book to the library
    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned: " + book);
                    return;
                } else {
                    System.out.println("Book was not borrowed.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    // Search for books by title
    public List<Book> searchByTitle(String title) {
        return books.stream()
                    .filter(book -> book.getTitle().equalsIgnoreCase(title))
                    .collect(Collectors.toList());
    }

    // Search for books by author
    public List<Book> searchByAuthor(String author) {
        return books.stream()
                    .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                    .collect(Collectors.toList());
    }

    // Display all available books
    public void displayAvailableBooks() {
        books.stream()
             .filter(Book::isAvailable)
             .forEach(System.out::println);
    }
}


public class _21_LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add new book");
            System.out.println("2. Borrow book");
            System.out.println("3. Return book");
            System.out.println("4. Search book by title");
            System.out.println("5. Search book by author");
            System.out.println("6. Display available books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to borrow: ");
                    String borrowIsbn = scanner.nextLine();
                    library.borrowBook(borrowIsbn);
                    break;
                case 3:
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnIsbn);
                    break;
                case 4:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle).forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor).forEach(System.out::println);
                    break;
                case 6:
                    library.displayAvailableBooks();
                    break;
                case 7:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
