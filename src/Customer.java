import java.util.ArrayList;
import java.util.Arrays;

public class Customer extends Person {
	private String ID, soDT;
	private  int visitNumber = 0;
	private  ArrayList<BuyBookRecord> buyBookRecord;

	private class BuyBookRecord {
		int amount;
		Book sachDaMua;
		public BuyBookRecord( Book sachDaMua,int amount) {
			this.amount = amount;
			this.sachDaMua = sachDaMua;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public Book getSachDaMua() {
			return sachDaMua;
		}

		public void setSachDaMua(Book sachDaMua) {
			this.sachDaMua = sachDaMua;
		}
	}

	public Customer() {
	}
	public  BuyBookRecord getBuyBookRecord(String BookId){
		for (int i = 0 ; i< buyBookRecord.size();i++){
			if(buyBookRecord.get(i).sachDaMua.getID() == BookId){
				return buyBookRecord.get(i);
			}
		}
		return null;
	}

	public Customer(String iD, String ten, int tuoi, String soDT, String diaChi) {
		super(ten, diaChi, tuoi);
		ID = iD;
		this.soDT = soDT;
		this.buyBookRecord = new ArrayList<BuyBookRecord>();
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

	public void muaSach(Book sachMua, int amout) {
		boolean isExistInHistory = false;
		for(int i=0; i< buyBookRecord.size();i++){
			if(sachMua.getID() == buyBookRecord.get(i).sachDaMua.getID()){
				isExistInHistory = true;
				break;
			}
		}
		if(isExistInHistory){
			var currentBookHistory = getBuyBookRecord(sachMua.getID());
			currentBookHistory.setAmount(currentBookHistory.getAmount() + amout);
		} else {
			var newBookHistory = new BuyBookRecord(sachMua,amout);
			buyBookRecord.add(newBookHistory);
		}
		visitNumber++;
	}

	public int getVisitNumber() {
		return visitNumber;
	}

	public void setVisitNumber(int visitNumber) {
		this.visitNumber += visitNumber;
	}

	public void displayHistoryBuy() {
		System.out.println("--------------------------------------------");
		System.out.println("ID				 : " + ID);
		System.out.println("Ten khach hang	 : " + this.getTen());
		System.out.println("dia chi 		 : "+ this.getDiaChi());
		System.out.println("so dien thoai	 : " + soDT);
		System.out.println("so lan mua 		 : " + visitNumber);
		ArrayList<String> bookBought = new ArrayList<String>();
		for ( int i = 0;i<buyBookRecord.size();i++){
			bookBought.add(buyBookRecord.get(i).sachDaMua.getTen());
		}
		System.out.println("sach da mua  	 : " + String.join(", ",bookBought));
		System.out.println("--------------------------------------------");
		/*ArrayList<String> bookBought = new ArrayList<String>();
		for ( int i = 0;i<buyBookRecord.size();i++){
			bookBought.add(buyBookRecord.get(i).sachDaMua.getTen());
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("   "+ID+"    / "+this.getTen()+"  / "+this.getDiaChi()+"   / "+soDT+"       /  "+visitNumber+"      /   "+String.join(",",bookBought)   );
*/
	}
}
