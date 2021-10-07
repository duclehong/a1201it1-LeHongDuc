package codegym.phanso;

public class PhanSo {
    private int tu_so;
    private int mau_so;

    public PhanSo() {
    }
    public PhanSo(int tu_so, int mau_so) {
        this.tu_so = tu_so;
        this.mau_so = mau_so;
    }
    public int getTu_so() {
        return tu_so;
    }

    public void setTu_so(int tu_so) {
        this.tu_so = tu_so;
    }

    public int getMau_so() {
        return mau_so;
    }

    public void setMau_so(int mau_so) {
        this.mau_so = mau_so;
    }

    public PhanSo toiGian(){
        System.out.println("tu so la:" + this.getTu_so() + " mau so la" + this.getMau_so());
        return new PhanSo();
    }

    public static PhanSo tichHaiPhanSo(PhanSo ps1, PhanSo ps2){
        int tuSo = ps1.getTu_so()*ps2.getTu_so();
        int mauSo = ps1.getMau_so()*ps2.getMau_so();
        return new PhanSo(tuSo,mauSo);
    }
}
