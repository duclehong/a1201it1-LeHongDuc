package models;

public class ExportProducts extends Product{
    private double exportPrice;
    private String NameCountryOfProductEntry;

    public ExportProducts() {
    }

    public ExportProducts(double exportPrice, String nameCountryOfProductEntry) {
        this.exportPrice = exportPrice;
        NameCountryOfProductEntry = nameCountryOfProductEntry;
    }

    public ExportProducts(String id, String product_code, String name, double costs, int amount, String producer, double exportPrice, String nameCountryOfProductEntry) {
        super(id, product_code, name, costs, amount, producer);
        this.exportPrice = exportPrice;
        NameCountryOfProductEntry = nameCountryOfProductEntry;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getNameCountryOfProductEntry() {
        return NameCountryOfProductEntry;
    }

    public void setNameCountryOfProductEntry(String nameCountryOfProductEntry) {
        NameCountryOfProductEntry = nameCountryOfProductEntry;
    }

    @Override
    public void showInfor() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + "ExportProducts{" +
                "exportPrice=" + exportPrice +
                ", NameCountryOfProductEntry='" + NameCountryOfProductEntry + '\'' +
                '}' ;
    }
}
