package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;
    private List<Reservation> reservations;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        transactions = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    // Book Management
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Optional<Book> findBookByISBN(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
    }

    public List<Book> searchBooksByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    // Member Management
    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public Optional<Member> findMemberById(String memberId) {
        return members.stream().filter(member -> member.getMemberId().equals(memberId)).findFirst();
    }

    // Borrow and Return Books
    public void issueBook(String isbn, String memberId) {
        Optional<Book> bookOpt = findBookByISBN(isbn);
        Optional<Member> memberOpt = findMemberById(memberId);

        if (bookOpt.isPresent() && memberOpt.isPresent()) {
            Book book = bookOpt.get();
            Member member = memberOpt.get();
            Transaction transaction = new Transaction(book, member);
            transactions.add(transaction);
            book.setCopies(book.getCopies() - 1);
            System.out.println("Book issued to member.");
        } else {
            System.out.println("Book or member not found.");
        }
    }

    public void returnBook(String isbn, String memberId) {
        Optional<Book> bookOpt = findBookByISBN(isbn);
        Optional<Member> memberOpt = findMemberById(memberId);

        if (bookOpt.isPresent() && memberOpt.isPresent()) {
            Book book = bookOpt.get();
            Member member = memberOpt.get();

            Optional<Transaction> transactionOpt = transactions.stream()
                    .filter(trans -> trans.getBook().equals(book) && trans.getMember().equals(member))
                    .findFirst();

            if (transactionOpt.isPresent()) {
                transactions.remove(transactionOpt.get());
                book.setCopies(book.getCopies() + 1);
                System.out.println("Book returned by member.");
            } else {
                System.out.println("Transaction not found.");
            }
        } else {
            System.out.println("Book or member not found.");
        }
    }

    // Reservation Management
    public void reserveBook(String isbn, String memberId) {
        Optional<Book> bookOpt = findBookByISBN(isbn);
        Optional<Member> memberOpt = findMemberById(memberId);

        if (bookOpt.isPresent() && memberOpt.isPresent()) {
            Book book = bookOpt.get();
            Member member = memberOpt.get();
            Reservation reservation = new Reservation(book, member);
            reservations.add(reservation);
            System.out.println("Book reserved.");
        } else {
            System.out.println("Book or member not found.");
        }
    }
}

