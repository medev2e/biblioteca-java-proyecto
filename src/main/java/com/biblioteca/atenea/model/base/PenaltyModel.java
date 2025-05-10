package com.biblioteca.atenea.model.base;

import java.time.LocalDate;

public class PenaltyModel {
    private String nationalId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private String additionalNotes;
    private double penaltyAmount;
    private boolean isPaid;

    public PenaltyModel() {
    }

    public PenaltyModel(String nationalId, LocalDate startDate, LocalDate endDate, String reason,
            String additionalNotes,
            double penaltyAmount, boolean isPaid) {
        this.nationalId = nationalId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.additionalNotes = additionalNotes;
        this.penaltyAmount = penaltyAmount;
        this.isPaid = isPaid;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public double getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(double penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean paid) {
        isPaid = paid;
    }
}
