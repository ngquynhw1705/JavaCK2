package clinic.model;

public class Medicine {
    private int medicineId;
    private String name;
    private String type;
    private int quantity;
    private int minimumQuantity;
    private double price;
    private String expiryDate;
    private String description;

    public Medicine() {}

    public Medicine(int medicineId, String name, String type, int quantity, int minimumQuantity, double price, String expiryDate, String description) {
        this.medicineId = medicineId;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.minimumQuantity = minimumQuantity;
        this.price = price;
        this.expiryDate = expiryDate;
        this.description = description;
    }

    public int getMedicineId() { return medicineId; }
    public void setMedicineId(int medicineId) { this.medicineId = medicineId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getMinimumQuantity() { return minimumQuantity; }
    public void setMinimumQuantity(int minimumQuantity) { this.minimumQuantity = minimumQuantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}
