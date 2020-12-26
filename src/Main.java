import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
			Manager manager = new Manager("Thu", "Viet Nam", 16);
			
			System.out.println("\t===Welcom to my tiem sach!===");
			
			int stop;
		do {
			System.out.print(" 1. Quan li sach");
			System.out.println("\t 2. Quan li khach hang");
			System.out.print("Moi lua chon: ");
			int choose = Integer.valueOf(sc.nextLine());
			int stop1;
			if (choose == 1) {
				do {
					System.out.print("\t 1. Them sach");
					System.out.print("\t 2. Tim sach");
					System.out.println("\t 3. Sap xep");
					System.out.print("Moi lua chon: ");
					choose = Integer.valueOf(sc.nextLine());
					switch (choose) {
						case 1:
							manager.addBook();
							break;
						case 2:
							System.out.print("1. Tim theo ten");
							System.out.print("\t 2. Tim theo tac gia");
							System.out.print("\t 3. Tim theo the loai");
							System.out.println("\t 4. Tim theo Nha xuat ban");
							System.out.print("Moi lua chon: ");
							choose = Integer.valueOf(sc.nextLine());
							switch (choose) {
								case 1:
									System.out.print("Nhap sach can tim: ");
									String bookName = sc.nextLine();
									manager.findNameBook(bookName);
									break;
								case 2:
									System.out.print("Nhap tac gia can tim: ");
									String bookAuthor = sc.nextLine();
									manager.findAuthor(bookAuthor);
									break;
								case 3:
									System.out.print("Nhap sach the loai can tim: ");
									String bookKind = sc.nextLine();
									manager.findKindBook(bookKind);
									break;
								case 4:
									System.out.print("Nhap Nha xuat ban can tim: ");
									String bookNXB = sc.nextLine();
									manager.findNXB(bookNXB);
									break;
							}
							break;
						case 3:
							System.out.print("1. Sap xep theo ten");
							System.out.print("\t 2. Sap xep theo sach pho bien");
							System.out.println("\t 3. Sap xep theo gia tien");
							System.out.print("Moi lua chon: ");
							choose = Integer.valueOf(sc.nextLine());
							switch (choose) {
								case 1:
									manager.sortNameBook();
									break;
								case 2:
									manager.sortPopular();
									break;
								case 3:
									manager.sortPrice();
									break;
							}
							break;
					}
					System.out.println("Tiep? 0/1 ");
					stop1 = Integer.valueOf(sc.nextLine());
				} while (stop1 == 1);
			}
				else if (choose == 2) {
					do {
						System.out.print("1. Them khach hang");
						System.out.print("\t 2. Tim khach hang");
						System.out.println("\t 3. danh sach khach hang");
						System.out.print("Moi lua chon: ");
						choose = Integer.valueOf(sc.nextLine());
						switch (choose) {
							case 1:
								manager.addCustomer();
								break;
							case 2:
								System.out.print("1. Tim theo ten");
								System.out.print("\t 2.Tim theo ID");
								System.out.println("\t 3.Tim theo so dien thoai");
								System.out.print("Moi lua chon: ");
								choose = Integer.valueOf(sc.nextLine());
								switch (choose) {
									case 1:
										System.out.print("Nhap ten can tim: ");
										String customerName = sc.nextLine();
										manager.findNameCustomer(customerName);
										break;
									case 2:
										System.out.print("Nhap tac gia can tim: ");
										String bookAuthor = sc.nextLine();
										manager.findIdCustomer(bookAuthor);
										break;
									case 3:
										System.out.print("Nhap so dien thoai can tim: ");
										String bookKind = sc.nextLine();
										manager.findNumberPhoneCustomer(bookKind);
										break;
								}
								break;
							case 3:
								System.out.println("\t danh sach khach hang");
								manager.sortNameCustomer();
								break;
						}
						System.out.println("Tiep? 0/1 ");
						stop1 = Integer.valueOf(sc.nextLine());
					} while (stop1 == 1);
				}
				System.out.print("Co muon tiep tuc? 0/1 ");
				stop = Integer.valueOf(sc.nextInt());
			} while (stop == 1);
		}

}
