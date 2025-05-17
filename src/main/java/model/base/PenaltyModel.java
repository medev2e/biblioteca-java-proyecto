package model.base;

public class PenaltyModel {
    private String nationalId;
    private String reason;
    private String additionalNotes;
    private double penaltyAmount;
    private boolean isPaid;

    public PenaltyModel() {
    }

    public PenaltyModel(String nationalId, String reason, String additionalNotes, double penaltyAmount,
            boolean isPaid) {
        this.nationalId = nationalId;
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
