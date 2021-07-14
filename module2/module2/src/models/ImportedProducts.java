package models;

public class ImportedProducts extends Product {
    private double importPrices;
    private String nameProvince;
    private double tax;

    public ImportedProducts() {
    }

    public ImportedProducts(double importPrices, String nameProvince, double tax) {
        this.importPrices = importPrices;
        this.nameProvince = nameProvince;
        this.tax = tax;
    }

    public ImportedProducts(String id, String product_code, String name, double costs, int amount, String producer, double importPrices, String nameProvince, double tax) {
        super(id, product_code, name, costs, amount, producer);
        this.importPrices = importPrices;
        this.nameProvince = nameProvince;
        this.tax = tax;
    }

    public double getImportPrices() {
        return importPrices;
    }

    public void setImportPrices(double importPrices) {
        this.importPrices = importPrices;
    }

    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public void showInfor() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + "ImportedProducts{" +
                "importPrices=" + importPrices +
                ", nameProvince='" + nameProvince + '\'' +
                ", tax=" + tax +
                '}';
    }
}
