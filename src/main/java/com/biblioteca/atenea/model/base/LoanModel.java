package com.biblioteca.atenea.model.base;

import java.time.LocalDate;

public class LoanModel {
    private String nationalId;
    private String serialId;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public LoanModel() {
    }

    public LoanModel(String nationalId, String serialId, LocalDate loanDate, LocalDate returnDate) {
        this.nationalId = nationalId;
        this.serialId = serialId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getSerialId() {
        return serialId;
    }

    public void getSerialId(String serialId) {
        this.serialId = serialId;
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
