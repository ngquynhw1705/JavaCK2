package clinic.model;

public class Patient {
    private int patientId;
    private String fullName;
    private String birthDate;
    private String gender;
    private String phone;
    private String address;
    private String customerType;
    private int points;
    private int accountId;

    public Patient() {}

    public Patient(int patientId, String fullName, String birthDate, String gender, String phone, String address, String customerType, int points, int accountId) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.customerType = customerType;
        this.points = points;
        this.accountId = accountId;
    }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCustomerType() { return customerType; }
    public void setCustomerType(String customerType) { this.customerType = customerType; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

}
