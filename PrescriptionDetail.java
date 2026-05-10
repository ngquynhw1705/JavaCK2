package clinic.model;

public class PrescriptionDetail {
    private int detailId;
    private int prescriptionId;
    private int medicineId;
    private int quantity;
    private String dosage;

    public PrescriptionDetail() {}

    public PrescriptionDetail(int detailId, int prescriptionId, int medicineId, int quantity, String dosage) {
        this.detailId = detailId;
        this.prescriptionId = prescriptionId;
        this.medicineId = medicineId;
        this.quantity = quantity;
        this.dosage = dosage;
    }

    public int getDetailId() { return detailId; }
    public void setDetailId(int detailId) { this.detailId = detailId; }

    public int getPrescriptionId() { return prescriptionId; }
    public void setPrescriptionId(int prescriptionId) { this.prescriptionId = prescriptionId; }

    public int getMedicineId() { return medicineId; }
    public void setMedicineId(int medicineId) { this.medicineId = medicineId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }

}
