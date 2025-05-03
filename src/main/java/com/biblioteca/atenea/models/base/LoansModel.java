package com.biblioteca.atenea.models.base;

import java.time.LocalDate;

public class LoansModel {
    private BookModel book;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public LoansModel() {
    }

    public LoansModel(LocalDate loanDate, LocalDate returnDate) {
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
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
