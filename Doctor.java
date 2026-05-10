package clinic.model;

public class Doctor {
    private int doctorId;
    private String fullName;
    private String phone;
    private String email;
    private String specialty;
    private String workSchedule;
    private int patientCount;
    private int accountId;

    public Doctor() {}

    public Doctor(int doctorId, String fullName, String phone, String email, String specialty, String workSchedule, int patientCount, int accountId) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.specialty = specialty;
        this.workSchedule = workSchedule;
        this.patientCount = patientCount;
        this.accountId = accountId;
    }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public String getWorkSchedule() { return workSchedule; }
    public void setWorkSchedule(String workSchedule) { this.workSchedule = workSchedule; }

    public int getPatientCount() { return patientCount; }
    public void setPatientCount(int patientCount) { this.patientCount = patientCount; }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

}
