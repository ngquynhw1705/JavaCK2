package clinic.model;

public class InvoiceDetail {
    private int detailId;
    private int invoiceId;
    private String itemType;
    private String itemName;
    private int quantity;
    private double price;
    private double total;

    public InvoiceDetail() {}

    public InvoiceDetail(int detailId, int invoiceId, String itemType, String itemName, int quantity, double price, double total) {
        this.detailId = detailId;
        this.invoiceId = invoiceId;
        this.itemType = itemType;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public int getDetailId() { return detailId; }
    public void setDetailId(int detailId) { this.detailId = detailId; }

    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }

    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

}
