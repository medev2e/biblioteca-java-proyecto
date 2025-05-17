package model.base;

import java.time.LocalDate;

public class LoanModel {
    private String nationalId;
    private String isbnNumber;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public LoanModel() {
    }

    public LoanModel(String nationalId, String isbnNumber, LocalDate loanDate, LocalDate returnDate) {
        this.nationalId = nationalId;
        this.isbnNumber = isbnNumber;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void getIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
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
