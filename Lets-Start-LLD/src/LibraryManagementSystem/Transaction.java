package LibraryManagementSystem;

import java.util.Date;
import java.util.UUID;

public class Transaction {
    private String transactionId;
    private Book book;
    private Member member;
    private Date issueDate;
    private Date dueDate;
    private Date returnDate;
    private double fine;

    public Transaction(Book book, Member member) {
        this.transactionId = UUID.randomUUID().toString();
        this.book = book;
        this.member = member;
        this.issueDate = new Date();
        this.dueDate = new Date(issueDate.getTime() + (14 * 24 * 60 * 60 * 1000L)); // 14 days from issue date
        this.returnDate = null;
        this.fine = 0.0;
    }

    // Getters and setters

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
}
