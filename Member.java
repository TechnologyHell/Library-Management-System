public class Member {
    private String memberId;
    private String name;
    private Book borrowedBook;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void borrowBook(Book book) {
        this.borrowedBook = book;
    }

    public void returnBook(Book book) {
        if (this.borrowedBook != null && this.borrowedBook.equals(book)) {
            this.borrowedBook = null;
        }
    }

    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        if (borrowedBook != null) {
            System.out.println("Borrowed Book: " + borrowedBook.getTitle());
        } else {
            System.out.println("No books borrowed.");
        }
    }
}
