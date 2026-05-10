package clinic.model;

public class Prescription {
    private int prescriptionId;
    private int recordId;
    private int patientId;
    private int doctorId;
    private String createdDate;
    private String status;

    public Prescription() {}

    public Prescription(int prescriptionId, int recordId, int patientId, int doctorId, String createdDate, String status) {
        this.prescriptionId = prescriptionId;
        this.recordId = recordId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.createdDate = createdDate;
        this.status = status;
    }

    public int getPrescriptionId() { return prescriptionId; }
    public void setPrescriptionId(int prescriptionId) { this.prescriptionId = prescriptionId; }

    public int getRecordId() { return recordId; }
    public void setRecordId(int recordId) { this.recordId = recordId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}
