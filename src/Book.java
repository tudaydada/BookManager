public class Book {
	private String ten, ID, tacGia, theLoai, NXB;
	private int giaTien, soLuong, daBan;
	// hello world;
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
		System.out.println("\n ID : " + ID);
		System.out.print("/Ten sach : " + ten);
		System.out.print("/Tac gia : " + tacGia);
		System.out.print("/The Loai : " + theLoai);
		System.out.print("/Nha Xuat Ban : " + NXB);
		System.out.print("/Gia tien : " + giaTien);
		System.out.print("/So luong nhap ve : " + soLuong);
		System.out.print("/So luong da ban : " + daBan);
		System.out.print("/So luong con lai : " + (int)(soLuong - daBan));
	}

	@Override
	public String toString(){
		return "Book{" +
				"ten='" + ten + '\'' +
				", ID='" + ID + '\'' +
				", tacGia='" + tacGia + '\'' +
				", theLoai='" + theLoai + '\'' +
				", NXB='" + NXB + '\'' +
				", giaTien=" + giaTien +
				", soLuong=" + soLuong +
				", daBan=" + daBan +
				'}';
	}
}

