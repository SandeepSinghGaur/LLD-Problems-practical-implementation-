package LibraryManagementSystem;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        library.addBook(new Book("12345", "Book1", "Author1", "Genre1", "2021-01-01", 5, "Shelf1"));
        library.addBook(new Book("67890", "Book2", "Author2", "Genre2", "2021-01-02", 3, "Shelf2"));

        // Add members
        library.addMember(new Member("M001", "Member1", "Address1", "1234567890", "member1@example.com", "2021-01-01"));
        library.addMember(new Member("M002", "Member2", "Address2", "0987654321", "member2@example.com", "2021-01-02"));

        // Issue book
        library.issueBook("12345", "M001");


        // Return book
        library.returnBook("12345", "M001");

        // Reserve book
        library.reserveBook("67890", "M002");
        Book book = new Book();
        book.getAuthor();
    }
}
