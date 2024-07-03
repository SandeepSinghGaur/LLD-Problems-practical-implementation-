package LibraryManagementSystem;

import java.util.Date;
import java.util.UUID;

public class Reservation {
    private String reservationId;
    private Book book;
    private Member member;
    private Date reservationDate;
    private boolean notificationSent;

    public Reservation(Book book, Member member) {
        this.reservationId = UUID.randomUUID().toString();
        this.book = book;
        this.member = member;
        this.reservationDate = new Date();
        this.notificationSent = false;
    }

    // Getters and setters

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
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

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public boolean isNotificationSent() {
        return notificationSent;
    }

    public void setNotificationSent(boolean notificationSent) {
        this.notificationSent = notificationSent;
    }
}

