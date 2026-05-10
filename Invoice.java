package clinic.model;

public class Invoice {
    private int invoiceId;
    private int patientId;
    private String invoiceDate;
    private double examinationFee;
    private double medicineFee;
    private double serviceFee;
    private double discount;
    private double totalAmount;
    private String paymentMethod;

    public Invoice() {}

    public Invoice(int invoiceId, int patientId, String invoiceDate, double examinationFee, double medicineFee, double serviceFee, double discount, double totalAmount, String paymentMethod) {
        this.invoiceId = invoiceId;
        this.patientId = patientId;
        this.invoiceDate = invoiceDate;
        this.examinationFee = examinationFee;
        this.medicineFee = medicineFee;
        this.serviceFee = serviceFee;
        this.discount = discount;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }

    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(String invoiceDate) { this.invoiceDate = invoiceDate; }

    public double getExaminationFee() { return examinationFee; }
    public void setExaminationFee(double examinationFee) { this.examinationFee = examinationFee; }

    public double getMedicineFee() { return medicineFee; }
    public void setMedicineFee(double medicineFee) { this.medicineFee = medicineFee; }

    public double getServiceFee() { return serviceFee; }
    public void setServiceFee(double serviceFee) { this.serviceFee = serviceFee; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

}
