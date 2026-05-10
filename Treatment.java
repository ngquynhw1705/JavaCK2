package clinic.model;

public class Treatment {
    private int treatmentId;
    private int patientId;
    private int doctorId;
    private String treatmentName;
    private String startDate;
    private String endDate;
    private String initialCondition;
    private String result;
    private String evaluation;
    private String beforeImage;
    private String afterImage;

    public Treatment() {}

    public Treatment(int treatmentId, int patientId, int doctorId, String treatmentName, String startDate, String endDate, String initialCondition, String result, String evaluation, String beforeImage, String afterImage) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.treatmentName = treatmentName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.initialCondition = initialCondition;
        this.result = result;
        this.evaluation = evaluation;
        this.beforeImage = beforeImage;
        this.afterImage = afterImage;
    }

    public int getTreatmentId() { return treatmentId; }
    public void setTreatmentId(int treatmentId) { this.treatmentId = treatmentId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public String getTreatmentName() { return treatmentName; }
    public void setTreatmentName(String treatmentName) { this.treatmentName = treatmentName; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getInitialCondition() { return initialCondition; }
    public void setInitialCondition(String initialCondition) { this.initialCondition = initialCondition; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public String getEvaluation() { return evaluation; }
    public void setEvaluation(String evaluation) { this.evaluation = evaluation; }

    public String getBeforeImage() { return beforeImage; }
    public void setBeforeImage(String beforeImage) { this.beforeImage = beforeImage; }

    public String getAfterImage() { return afterImage; }
    public void setAfterImage(String afterImage) { this.afterImage = afterImage; }

}
