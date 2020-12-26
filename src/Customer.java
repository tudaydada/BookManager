import java.util.ArrayList;

public class Customer extends Person {
	private String ID, soDT;
	private int amount;
	ArrayList<Book> sachDaMua;
	
	public Customer() {
		
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public ArrayList<Book> getSachDaMua() {
		return sachDaMua;
	}

	public void setSachDaMua(ArrayList<Book> sachDaMua) {
		this.sachDaMua = sachDaMua;
	}
	public void display() {
		System.out.println("[ID: " + ID+"/"+"Ten khach hang : " + this.getTen()+"/"+"tuoi : " + this.getTuoi()+"/"+"dia chi : "
				+ this.getDiaChi()+"/"+"so dien thoai : " + soDT+"/"+"so lan mua : " + amount+"]");


	}
}
