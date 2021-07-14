package models;

public abstract class Product {
    private String id;
    private String productCode;
    private String name;
    private double costs;
    private int amount;
    private String producer;

    public Product() {
    }

    public Product(String id, String product_code, String name, double costs, int amount, String producer) {
        this.id = id;
        this.productCode = product_code;
        this.name = name;
        this.costs = costs;
        this.amount = amount;
        this.producer = producer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCosts() {
        return costs;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", product_code='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", costs=" + costs +
                ", amount=" + amount +
                ", producer='" + producer + '\'' +
                '}';
    }
    public abstract void showInfor();
}
