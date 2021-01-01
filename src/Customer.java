import java.util.ArrayList;

public class Customer extends Person {
    private String ID, soDT;

    public Customer() {

    }

    public Customer(String iD, String ten, int tuoi, String soDT, String diaChi) {
        super(ten, diaChi, tuoi);
        ID = iD;
        this.soDT = soDT;

    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public void display() {
        System.out.println("Custommer [ID : " + ID + "/ Ten khach hang : " + this.getTen() +
                "/ Tuoi : " + this.getTuoi() + "/ Dia chi : " + this.getDiaChi() +
                "/ So dien thoai : " + soDT + "]");
    }
}
