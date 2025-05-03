package com.biblioteca.atenea.models.base;

import java.time.LocalDate;

public class PenaltyModel {
    private double penaltyAmount;
    private boolean isPaid;
    private LocalDate startPenalty;
    private LocalDate endPenalty;
    private String reason;
    private String additional_note;

    public PenaltyModel(LocalDate startPenalty, LocalDate endPenalty, String reason, String additional_note) {
        this.startPenalty = startPenalty;
        this.endPenalty = endPenalty;
        this.reason = reason;
        this.additional_note = additional_note;
    }

    public double getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(double penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public LocalDate getStartPenalty() {
        return startPenalty;
    }

    public void setStartPenalty(LocalDate startPenalty) {
        this.startPenalty = startPenalty;
    }

    public LocalDate getEndPenalty() {
        return endPenalty;
    }

    public void setEndPenalty(LocalDate endPenalty) {
        this.endPenalty = endPenalty;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAdditional_note() {
        return additional_note;
    }

    public void setAdditional_note(String additional_note) {
        this.additional_note = additional_note;
    }
}
