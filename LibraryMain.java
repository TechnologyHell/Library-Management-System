import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Show list of books");
            System.out.println("2. Show list of users");
            System.out.println("3. Search for a book");
            System.out.println("4. Add a book");
            System.out.println("5. Delete a book");
            System.out.println("6. Update a book");
            System.out.println("7. Borrow a book");
            System.out.println("8. Return a book");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    library.displayMembers();
                    break;
                case 3:
                    System.out.print("Enter ISBN to search for a book: ");
                    String searchISBN = scanner.nextLine();
                    Book foundBook = library.searchBook(searchISBN);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook.getTitle() + " by " + foundBook.getAuthor());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter book title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String newISBN = scanner.nextLine();
                    Book newBook = new Book(newTitle, newAuthor, newISBN);
                    library.addBook(newBook);
                    break;
                case 5:
                    System.out.print("Enter ISBN to delete a book: ");
                    String deleteISBN = scanner.nextLine();
                    Book bookToDelete = library.searchBook(deleteISBN);
                    if (bookToDelete != null) {
                        library.deleteBook(bookToDelete);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter ISBN to update a book: ");
                    String updateISBN = scanner.nextLine();
                    Book oldBook = library.searchBook(updateISBN);
                    if (oldBook != null) {
                        System.out.print("Enter new title: ");
                        String updatedTitle = scanner.nextLine();
                        System.out.print("Enter new author: ");
                        String updatedAuthor = scanner.nextLine();
                        Book updatedBook = new Book(updatedTitle, updatedAuthor, updateISBN);
                        library.updateBook(oldBook, updatedBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter member ID: ");
                    String memberId = scanner.nextLine();
                    Member borrower = library.findMemberById(memberId);
                    if (borrower != null) {
                        System.out.print("Enter ISBN of the book to borrow: ");
                        String borrowISBN = scanner.nextLine();
                        Book borrowBook = library.searchBook(borrowISBN);
                        if (borrowBook != null && borrowBook.isAvailable()) {
                            library.borrowBook(borrower, borrowBook);
                        } else {
                            System.out.println("Book not available for borrowing.");
                        }
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter member ID: ");
                    String returnMemberId = scanner.nextLine();
                    Member returnMember = library.findMemberById(returnMemberId);
                    if (returnMember != null && returnMember.getBorrowedBook() != null) {
                        library.returnBook(returnMember, returnMember.getBorrowedBook());
                    } else {
                        System.out.println("Member not found or no book borrowed.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
