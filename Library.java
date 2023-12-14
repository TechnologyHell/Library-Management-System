import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();

        // Adding some predefined books
        books.add(new Book("Java Programming", "John Doe", "123456789"));
        books.add(new Book("Data Structures", "Jane Smith", "987654321"));

        // Adding some predefined members
        members.add(new Member("M001", "Alice"));
        members.add(new Member("M002", "Bob"));
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    public void displayMembers() {
        for (Member member : members) {
            System.out.println(member.getName() + " (ID: " + member.getMemberId() + ")");
        }
    }

    public Book searchBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void deleteBook(Book book) {
        books.remove(book);
        System.out.println("Book deleted successfully.");
    }

    public void updateBook(Book oldBook, Book newBook) {
        int index = books.indexOf(oldBook);
        if (index != -1) {
            books.set(index, newBook);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void borrowBook(Member member, Book book) {
        if (book.isAvailable()) {
            member.borrowBook(book);
            book.setAvailable(false);
            System.out.println(member.getName() + " has successfully borrowed " + book.getTitle());
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }

    public void returnBook(Member member, Book book) {
        member.returnBook(book);
        book.setAvailable(true);
        System.out.println(member.getName() + " has successfully returned " + book.getTitle());
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
}
