package com.biblioteca.atenea.model.base;

import java.time.LocalDate;

public class LoanModel {
    private String userId;
    private String bookId;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public LoanModel() {
    }

    public LoanModel(String userId, String bookId, LocalDate loanDate, LocalDate returnDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
