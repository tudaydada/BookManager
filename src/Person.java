public class Person {
	private String ten, diaChi;
	private int tuoi;
	
	public Person() {
		
	}
	
	public Person(String ten, String diaChi, int tuoi) {
		this.ten = ten;
		this.diaChi = diaChi;
		this.tuoi = tuoi;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}	
}

