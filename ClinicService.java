package clinic.model;

public class ClinicService {
    private int serviceId;
    private String name;
    private double price;
    private String duration;
    private String description;

    public ClinicService() {}

    public ClinicService(int serviceId, String name, double price, String duration, String description) {
        this.serviceId = serviceId;
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.description = description;
    }

    public int getServiceId() { return serviceId; }
    public void setServiceId(int serviceId) { this.serviceId = serviceId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}
