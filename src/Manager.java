import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Manager extends Person {
	Scanner scan = new Scanner(System.in);
	ArrayList<Book> quanLiSach = new ArrayList<>();
	ArrayList<Customer> quanLiKhach = new ArrayList<>();

	public Manager() {
		
	}
	
	public Manager(String ten, String diaChi, int tuoi) {
		super(ten,diaChi,tuoi);
	}
	
	public void subBook(String nameSubBook) {
		System.out.println("So luong sach da ban: ");
		int soLuong = scan.nextInt();
		for(int i=0;i<quanLiSach.size();i++) {
			if(quanLiSach.get(i).getTen().equals(nameSubBook)) {
				int tam = quanLiSach.get(i).getSoLuong();
				quanLiSach.get(i).setSoLuong(tam+soLuong);
			}
		}
	}
	
	public void addBook() {
		Book bookAdd = null;
		String ten, ID, tacGia, theLoai, NXB;
		int giaTien, soLuong, daBan;
		boolean check = true;
		
		System.out.print("Ten sach : ");
		ten = scan.nextLine();
		System.out.print("ID : ");
		ID = scan.nextLine();
		System.out.print("Tac gia : ");
		tacGia = scan.nextLine();
		System.out.print("The loai : ");
		theLoai = scan.nextLine();
		System.out.print("NXB : ");
		NXB = scan.nextLine();
		System.out.print("Gia tien : ");
		giaTien = Integer.valueOf(scan.nextLine());
		System.out.print("So luong : ");
		soLuong = Integer.valueOf(scan.nextLine());


		//check neu sach da co trong kho thi soluong=soluonghientai+soluongvuanhap
		for (int i = 0; i < quanLiSach.size(); i++) {
			if (quanLiSach.get(i).getTen().equals(ten)) {
				quanLiSach.get(i).setSoLuong(quanLiSach.get(i).getSoLuong() + soLuong);
				check = false;
				break;
			}
		}
		//kiem tra neu check la dung thi se them moi sach
		if (check) {
			bookAdd = new Book(ten, ID, tacGia, theLoai, NXB, giaTien, soLuong, 0);
			quanLiSach.add(bookAdd);
		}
	}
	
	public void findNameBook(String name) {
		for (int i = 0; i < quanLiSach.size(); i++) {
			if (quanLiSach.get(i).getTen().equals(name)) {
				System.out.println("=");
				quanLiSach.get(i).display();
			}
		}
	}

	public void addCustomer() {
		Customer customerAdd = null;
		String ten,diachi,ID, soDT;
		int tuoi;
		ArrayList<Book> sachDaMua;
		boolean check = true;

		System.out.print("Ten khach hang : ");
		ten = scan.nextLine();
		System.out.print("ID : ");
		ID = scan.nextLine();
		System.out.print("dia chi : ");
		diachi = scan.nextLine();
		System.out.print("so dien thoai : ");
		soDT = scan.nextLine();
		System.out.print("tuoi : ");
		tuoi = Integer.parseInt(scan.nextLine());




		//check neu sach da co trong kho thi soluong=soluonghientai+soluongvuanhap
		for (int i = 0; i < quanLiKhach.size(); i++) {
			if (quanLiKhach.get(i).getID().equals(ID)) {
				quanLiKhach.get(i).setAmount(quanLiKhach.get(i).getAmount() + 1);
				check = false;
				break;
			}
		}
		//kiem tra neu check la dung thi se them moi sach
		if (check) {
			customerAdd = new Customer(ID,ten,tuoi,soDT,diachi);
			quanLiKhach.add(customerAdd);
		}
	}

	public void findNameCustomer(String name) {
		for (int i = 0; i < quanLiKhach.size(); i++) {
			if (quanLiKhach.get(i).getTen().equals(name)) {
				System.out.println("=");
				quanLiKhach.get(i).display();
			}
		}
	}
	public void findIdCustomer(String id) {
		for (int i = 0; i < quanLiKhach.size(); i++) {
			if (quanLiKhach.get(i).getID().equals(id)) {
				System.out.println("=");
				quanLiKhach.get(i).display();
			}
		}
	}
	public void findNumberPhoneCustomer(String numberPhone) {
		for (int i = 0; i < quanLiKhach.size(); i++) {
			if (quanLiKhach.get(i).getSoDT().equals(numberPhone)) {
				System.out.println("=");
				quanLiKhach.get(i).display();
			}
		}
	}
	
	public void findAuthor(String author) {
		for (int i = 0; i < quanLiSach.size(); i++) {
			if (quanLiSach.get(i).getTacGia().equals(author)) {
				System.out.println("=");
				quanLiSach.get(i).display();
			}
		}
	}
	
	public void findKindBook(String kind) {
		for (int i = 0; i < quanLiSach.size(); i++) {
			if (quanLiSach.get(i).getTheLoai().equals(kind)) {
				System.out.println("=");
				quanLiSach.get(i).display();
			}
		}
	}
	
	public void findNXB(String NXB) {
		for (int i = 0; i < quanLiSach.size(); i++) {
			if (quanLiSach.get(i).getNXB().equals(NXB)) {
				System.out.println("=");
				quanLiSach.get(i).display();
			}
		}
	}
	
	public void sortNameBook() {
		Collections.sort(quanLiSach, new SortNameBook());
		for(int i=0;i<quanLiSach.size();i++) {
			quanLiSach.get(i).display();
		}
	}
	public void sortNameCustomer() {
		Collections.sort(quanLiKhach, new SortNameCustomer());
		for(int i=0;i<quanLiKhach.size();i++) {
			quanLiKhach.get(i).display();
		}
	}
	
	public void sortPopular() {
		Collections.sort(quanLiSach, new SortTrendingBook());
		for(int i=0;i<5;i++) {
			quanLiSach.get(i).display();
		}
	}
	
	public void sortPrice() {
		Collections.sort(quanLiSach, new SortPriceBook());
		for(int i=0;i<quanLiSach.size();i++) {
			quanLiSach.get(i).display();
		}
	}
}
