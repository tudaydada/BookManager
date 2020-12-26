public class Book {
	private String ten, ID, tacGia, theLoai, NXB;
	private int giaTien, soLuong, daBan;
	
	public Book() {
		
	}
	
	public Book(String ten, String iD, String tacGia, String theLoai, String nXB, int giaTien, int soLuong, int daBan) {
		super();
		this.ten = ten;
		this.ID = iD;
		this.tacGia = tacGia;
		this.theLoai = theLoai;
		this.NXB = nXB;
		this.giaTien = giaTien;
		this.soLuong = soLuong;
		this.daBan = daBan;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getDaBan() {
		return daBan;
	}

	public void setDaBan(int daBan) {
		this.daBan = daBan;
	}
	
	public void display() {
		System.out.println("ID : " + ID);
		System.out.println("Ten sach : " + ten);
		System.out.println("Tac gia : " + tacGia);
		System.out.println("The Loai : " + theLoai);
		System.out.println("Nha Xuat Ban : " + NXB);
		System.out.println("Gia tien : " + giaTien);
		System.out.println("So luong nhap ve : " + soLuong);
		System.out.println("So luong da ban : " + daBan);
		System.out.println("So luong con lai : " + (int)(soLuong - daBan));
	}
}

