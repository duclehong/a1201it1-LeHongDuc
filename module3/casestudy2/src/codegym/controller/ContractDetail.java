package codegym.controller;

public class ContractDetail {
    private int id;
    private int contractID;
    private int attachServiceID;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int id, int contractID, int attachServiceID, int quantity) {
        this.id = id;
        this.contractID = contractID;
        this.attachServiceID = attachServiceID;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getAttachServiceID() {
        return attachServiceID;
    }

    public void setAttachServiceID(int attachServiceID) {
        this.attachServiceID = attachServiceID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
