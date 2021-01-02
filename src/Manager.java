import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
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
        super(ten, diaChi, tuoi);
    }

    // ============================================================================

    // nếu khách hàng mua sách thì gọi phương thức này để giảm số lượng sách
    public boolean subBook(String IDSubBook, int soLuong) {
        boolean ok = false;
        for (int i = 0; i < quanLiSach.size(); i++) {
            if (quanLiSach.get(i).getID().equals(IDSubBook)) {
                int tam = quanLiSach.get(i).getSoLuong() - quanLiSach.get(i).getDaBan() - soLuong; // kiểm tra sách hiện có có đủ số lượng không
                if (tam >= 0) {
                    quanLiSach.get(i).setDaBan(soLuong + quanLiSach.get(i).getDaBan());
                    ok = true;
                }
            }
        }
        return ok;
    }

    // nếu nhập thêm sách về thì gọi phương thức này để thêm vào kho sách
    public void addBook() {
        Book bookAdd = null;
        String ten, ID, tacGia, theLoai, NXB;
        int giaTien, soLuong;
        boolean check = true;

        System.out.print("ID : ");			ID = scan.nextLine();
        System.out.print("Ten sach : ");	ten = scan.nextLine();
        System.out.print("Tac gia : ");		tacGia = scan.nextLine();
        System.out.print("The loai : ");	theLoai = scan.nextLine();
        System.out.print("NXB : ");			NXB = scan.nextLine();
        System.out.print("Gia tien : ");	giaTien = Integer.valueOf(scan.nextLine());
        System.out.print("So luong : ");	soLuong = Integer.valueOf(scan.nextLine());

        // check = true nếu sách chưa có trong kho, ngược lại sách đã có, cập nhật lại số lượng sách
        for (int i = 0; i < quanLiSach.size(); i++) {
            if (quanLiSach.get(i).getID().equals(ID)) {
                quanLiSach.get(i).setSoLuong(quanLiSach.get(i).getSoLuong() + soLuong);
                check = false;
                break;
            }
        }

        // nếu check = true nên tiến hành cập nhật sách mới vào kho
        if (check) {
            bookAdd = new Book(ten, ID, tacGia, theLoai, NXB, giaTien, soLuong, 0);
            quanLiSach.add(bookAdd);
        }
    }

    // tìm sách theo tên sách
    public void findNameBook(String name) {
        int dem = 0;	// đếm số lượng sách tìm thấy, xong đánh thứ tự mỗi lần in cho rõ ràng
        for (int i = 0; i < quanLiSach.size(); i++) {
            // tìm chuỗi con không kể hoa thường
            if (quanLiSach.get(i).getTen().toLowerCase().contains(name.toLowerCase())) {
                dem++;
                System.out.print(dem + ". ");
                quanLiSach.get(i).display();
            }
        }
        if (dem == 0) {
            System.out.println("Khong tim thay!");
        }
    }

    // tìm sách theo thể loại
    public void findKindBook(String kind) {
        int dem = 0;
        for (int i = 0; i < quanLiSach.size(); i++) {
            if (quanLiSach.get(i).getTheLoai().toLowerCase().contains(kind.toLowerCase())) {
                dem++;
                System.out.print(dem + ". ");
                quanLiSach.get(i).display();
            }
        }
        if (dem == 0) {
            System.out.println("Khong tim thay!");
        }
    }

    // tìm sách theo nhà xuất bản
    public void findNXB(String NXB) {
        int dem = 0;
        for (int i = 0; i < quanLiSach.size(); i++) {
            if (quanLiSach.get(i).getNXB().toLowerCase().contains(NXB.toLowerCase())) {
                dem++;
                System.out.print(dem + ". ");
                quanLiSach.get(i).display();
            }
        }
        if (dem == 0) {
            System.out.println("Khong tim thay!");
        }
    }

    // tìm sách theo tác giả
    public void findAuthor(String author) {
        int dem = 0;
        for (int i = 0; i < quanLiSach.size(); i++) {
            if (quanLiSach.get(i).getTacGia().toLowerCase().contains(author.toLowerCase())) {
                dem++;
                System.out.print(dem + ". ");
                quanLiSach.get(i).display();
            }
        }
        if (dem == 0) {
            System.out.println("Khong tim thay!");
        }
    }

    // sắp xếp tên sách theo thứ tự từ điển
    public void sortNameBook() {
        Collections.sort(quanLiSach, new SortNameBook());
        for (int i = 0; i < quanLiSach.size(); i++) {
            quanLiSach.get(i).display();
        }
    }

    // sắp xếp sách tăng dần theo số lượng bán được
    public void sortPopular() {
        Collections.sort(quanLiSach, new SortTrendingBook());
        for (int i = 0; i < quanLiSach.size(); i++) {
            quanLiSach.get(i).display();
        }
    }

    // sắp xếp sách tăng dần theo giá tiền
    public void sortPrice() {
        Collections.sort(quanLiSach, new SortPriceBook());
        for (int i = 0; i < quanLiSach.size(); i++) {
            quanLiSach.get(i).display();
        }
    }

    // ==================================================================================

    // thêm khách hàng vào hệ thống
    public void addCustomer() {
        Customer customerAdd = null;
        String ten, diaChi, ID, soDT;
        int tuoi;
        boolean check = true;

        System.out.print("ID : ");				ID = scan.nextLine();
        System.out.print("Ten khach hang : ");	ten = scan.nextLine();
        System.out.print("Dia chi : ");			diaChi = scan.nextLine();
        System.out.print("So dien thoai : ");	soDT = scan.nextLine();
        System.out.print("Tuoi : ");			tuoi = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < quanLiKhach.size(); i++) {
            if (quanLiKhach.get(i).getID().equals(ID)) {
                check = false;
                break;
            }
        }
        if (check) {
            customerAdd = new Customer(ID, ten, tuoi, soDT, diaChi);
            quanLiKhach.add(customerAdd);
        }
    }
        //Tim theo ten khach hang
    public void findNameCustomer(String name) {
        int dem = 0;
        for (int i = 0; i < quanLiKhach.size(); i++) {
            if (quanLiKhach.get(i).getTen().toLowerCase().contains(name.toLowerCase())) {
                dem++;
                System.out.print(dem + ". ");
                quanLiKhach.get(i).display();
            }
        }
        if (dem == 0) {
            System.out.println("Khong tim thay!");
        }
    }
        //Tim theo ID
    public void findIdCustomer(String id) {
        int dem = 0;
        for (int i = 0; i < quanLiKhach.size(); i++) {
            // tìm theo id thì phải tìm chính xác
            if (quanLiKhach.get(i).getID().toLowerCase().equals(id.toLowerCase())) {
                dem++;
                quanLiKhach.get(i).display();
            }
        }
        if (dem == 0) {
            System.out.println("Khong tim thay!");
        }
    }
        //Tim theo SDT
    public void findNumberPhoneCustomer(String numberPhone) {
        int dem = 0;
        for (int i = 0; i < quanLiKhach.size(); i++) {
            // tìm số điện thoại cũng phải chính xác
            if (quanLiKhach.get(i).getSoDT().toLowerCase().equals(numberPhone.toLowerCase())) {
                dem++;
                quanLiKhach.get(i).display();
            }
        }
        if (dem == 0) {
            System.out.println("Khong tim thay!");
        }
    }

    // sắp xếp tên theo thứ tự từ điển
    public void sortNameCustomer() {
        Collections.sort(quanLiKhach, new SortNameCustomer());
        for (int i = 0; i < quanLiKhach.size(); i++) {
            quanLiKhach.get(i).display();
        }
    }

    // bán sách
    public void sellBook(){
        if (quanLiSach.size() < 1) {
            System.out.println("\tKho sách đang rỗng! Vui lòng quay lại sau!");
            return;
        }

        // đầu tiên nhập list sách bán
        ArrayList<Book> listSachBan = new ArrayList<Book>();
        System.out.println("=Nhap list sach ban=");
        do {
            int soLuongSach;
            String IDSach;

            System.out.print("Ma sach : ");
            IDSach = scan.nextLine();
            System.out.print("So luong : ");
            soLuongSach = Integer.valueOf(scan.nextLine());

            // kiểm tra xem có trừ số lượng sách xuống được không
            if (subBook(IDSach, soLuongSach)) {
                Book book = new Book(IDSach, soLuongSach);
                listSachBan.add(book);
            } else {
                System.out.println("So luong khong du hoac sach khong co trong kho!");
            }
            System.out.print("Tiep tuc? Yes/No ");
            String ans = scan.nextLine();
            if (ans.contains("No")) {
                break;
            }
        } while (true);

        // nhập sách rồi mới được nhập tiếp
        if (listSachBan.size() > 0) {
            // tiếp theo nhập ID khách hàng mua đống sách ở trên, được lấy từ danh sách khách hàng đã nhập
            do {
                System.out.print("Nhap ID khach hang mua sach: ");
                String IDKhach = scan.nextLine();
                boolean find = false;
                int viTriKhach = -1;

                for (int i = 0; i < quanLiKhach.size(); i++) {
                    if (quanLiKhach.get(i).getID().equals(IDKhach)) {
                        find = true;
                        viTriKhach = i;
                        break;
                    }
                }

                // nếu ID khách hàng hợp lệ thì xuất hoá đơn, ngược lại thông báo chọn lại
                if (find) {
                    int tien = 0, tongTien = 0;
                    System.out.println("==Hoa don== ");
                    System.out.println("Khach hang: " + quanLiKhach.get(viTriKhach).getTen());
                    for (int i = 0; i < listSachBan.size(); i++) {
                        for (int j = 0; j < quanLiSach.size(); j++) {
                            if (quanLiSach.get(j).getID().contains(listSachBan.get(i).getID())) {
                                tien = quanLiSach.get(j).getGiaTien()*listSachBan.get(i).getSoLuong();
                                System.out.println("\tSach: " + quanLiSach.get(j).getTen() +
                                        "- SL: " + listSachBan.get(i).getSoLuong() +
                                        "- Thanh tien: " + tien);
                                break;
                            }
                        }
                        tongTien += tien;
                    }
                    System.out.println("\nTong tien thanh toan = " + tongTien);
                    break;
                } else {
                    System.out.println("ID ban chon khong hop le, vui long chon lai!");
                }
            } while (true);
        }
    }

    public void quanLi_Sach() {
        int stop = 0;

        System.out.println("\n\t\t === Quan li sach ===");
        do {
            System.out.println("\t 0. Tro lai");
            System.out.println("\t 1. Them sach");
            System.out.println("\t 2. Tim sach");
            System.out.println("\t 3. Sap xep sach");
            System.out.println("\t 4. In kho sach");

            System.out.print("Moi lua chon: ");
            int choose = Integer.valueOf(scan.nextLine());

            String stop2;
            int choose2;

            switch (choose) {
                case 0:
                    stop = 1;
                    break;
                case 1:
                    do {
                        addBook();
                        System.out.print("Tiep tuc them sach? Yes/No ");
                        stop2 = scan.nextLine();
                    } while (! stop2.contains("No"));
                    break;
                case 2:
                    System.out.println("\t\t 1. Tim theo ten");
                    System.out.println("\t\t 2. Tim theo tac gia");
                    System.out.println("\t\t 3. Tim theo the loai");
                    System.out.println("\t\t 4. Tim theo Nha xuat ban");

                    System.out.print("Moi lua chon: ");
                    choose2 = Integer.valueOf(scan.nextLine());
                    switch (choose2) {
                        case 1:
                            System.out.print("Nhap sach can tim: ");
                            String bookName = scan.nextLine();
                            findNameBook(bookName);
                            break;
                        case 2:
                            System.out.print("Nhap tac gia can tim: ");
                            String bookAuthor = scan.nextLine();
                            findAuthor(bookAuthor);
                            break;
                        case 3:
                            System.out.print("Nhap sach the loai can tim: ");
                            String bookKind = scan.nextLine();
                            findKindBook(bookKind);
                            break;
                        case 4:
                            System.out.print("Nhap Nha xuat ban can tim: ");
                            String bookNXB = scan.nextLine();
                            findNXB(bookNXB);
                            break;
                        default:
                            System.out.println("Yeu cau khong hop le!");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("\t\t 1. Sap xep theo ten");
                    System.out.println("\t\t 2. Sap xep theo sach pho bien");
                    System.out.println("\t\t 3. Sap xep theo gia tien");

                    System.out.print("Moi lua chon: ");
                    choose2 = Integer.valueOf(scan.nextLine());
                    switch (choose2) {
                        case 1:
                            sortNameBook();
                            break;
                        case 2:
                            sortPopular();
                            break;
                        case 3:
                            sortPrice();
                            break;
                        default:
                            System.out.println("Yeu cau khong hop le!");
                            break;
                    }
                    break;
                case 4:
                    sortNameBook();
                    break;
                default:
                    System.out.println("Yeu cau khong hop le!");
                    break;
            }
        } while (stop == 0);
    }

    public void quanLi_KhachHang(){
        int stop = 0, choose;

        System.out.println("\n\t\t === Quan li khach hang ===");
        do {
            System.out.println("\t 0. Quay lai");
            System.out.println("\t 1. Them khach hang");
            System.out.println("\t 2. Tim khach hang");
            System.out.println("\t 3. Danh sach khach hang");

            System.out.print("Moi lua chon: ");
            choose = Integer.valueOf(scan.nextLine());

            int choose2;

            switch (choose) {
                case 0:
                    stop = 1;
                    break;
                case 1:
                    addCustomer();
                    break;
                case 2:
                    System.out.println("\t\t 1. Tim theo ten");
                    System.out.println("\t\t 2. Tim theo ID");
                    System.out.println("\t\t 3. Tim theo so dien thoai");

                    System.out.print("Moi lua chon: ");
                    choose2 = Integer.valueOf(scan.nextLine());
                    switch (choose2) {
                        case 1:
                            System.out.print("Nhap ten can tim: ");
                            String customerName = scan.nextLine();
                            findNameCustomer(customerName);
                            break;
                        case 2:
                            System.out.print("Nhap ID can tim: ");
                            String customerID = scan.nextLine();
                            findIdCustomer(customerID);
                            break;
                        case 3:
                            System.out.print("Nhap so dien thoai can tim: ");
                            String customerSDT = scan.nextLine();
                            findNumberPhoneCustomer(customerSDT);
                            break;
                        default:
                            System.out.println("Yeu cau khong hop le!");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("\t Danh sach khach hang : ");
                    sortNameCustomer();
                    break;
                default:
                    System.out.println("Yeu cau khong hop le!");
                    break;
            }
        } while (stop == 0);
    }

    public void Store(Manager manager) throws IOException {
        System.out.println("\t   ===Welcom to my Book Store!===");

        // đọc sách trong tệp ra cho vào kho sach
        InputStream in = new FileInputStream("Sach.txt");
        Reader reader = new InputStreamReader(in, "UTF-8");
        BufferedReader br = new BufferedReader(reader);

        String s = null;

        while ((s = br.readLine()) != null) {
            String[] arr = s.split(",");
            manager.quanLiSach.add(new Book(arr[0], arr[1], arr[2], arr[3], arr[4],
                    Integer.valueOf(arr[5]), Integer.valueOf(arr[6]), Integer.valueOf(arr[7])));
        }

        // đọc khách hàng trong tệp ra cho vào hệ thống
        in = new FileInputStream("Khach.txt");
        reader = new InputStreamReader(in, "UTF-8");
        br = new BufferedReader(reader);

        String st = null;

        while ((st = br.readLine()) != null) {
            String[] arr2 = st.split(",");
            manager.quanLiKhach.add(new Customer(arr2[0], arr2[1], Integer.parseInt(arr2[2]), arr2[3], arr2[4]));
        }

        int stop = 0, choose;

        do {
            System.out.println("0. Thoat he thong");
            System.out.println("1. Quan li sach");
            System.out.println("2. Quan li khach hang");
            System.out.println("3. Ban sach");

            System.out.print("Moi lua chon: ");
            choose = Integer.valueOf(scan.nextLine());
            if (choose == 0) {
                stop = 1;
                System.out.println("Tam biet!");
            } else if (choose == 1) {
                manager.quanLi_Sach();
            } else if (choose == 2) {
                manager.quanLi_KhachHang();
            } else if (choose == 3){
                manager.sellBook();
            }
        } while (stop == 0);
    }
}
