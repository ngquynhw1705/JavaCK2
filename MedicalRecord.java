package clinic.model;

public class MedicalRecord {
    private int recordId;
    private int patientId;
    private int doctorId;
    private int appointmentId;
    private String examinationDate;
    private String symptoms;
    private String diagnosis;
    private String treatmentMethod;
    private String prescription;
    private String note;

    public MedicalRecord() {}

    public MedicalRecord(int recordId, int patientId, int doctorId, int appointmentId, String examinationDate, String symptoms, String diagnosis, String treatmentMethod, String prescription, String note) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentId = appointmentId;
        this.examinationDate = examinationDate;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.treatmentMethod = treatmentMethod;
        this.prescription = prescription;
        this.note = note;
    }

    public int getRecordId() { return recordId; }
    public void setRecordId(int recordId) { this.recordId = recordId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public String getExaminationDate() { return examinationDate; }
    public void setExaminationDate(String examinationDate) { this.examinationDate = examinationDate; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getTreatmentMethod() { return treatmentMethod; }
    public void setTreatmentMethod(String treatmentMethod) { this.treatmentMethod = treatmentMethod; }

    public String getPrescription() { return prescription; }
    public void setPrescription(String prescription) { this.prescription = prescription; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

}
