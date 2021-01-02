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

    public void subBook(String nameSubBook) {
        System.out.println("So luong sach da ban: ");
        int soLuong = scan.nextInt();
        for (int i = 0; i < quanLiSach.size(); i++) {
            if (quanLiSach.get(i).getTen().equals(nameSubBook)) {
                int tam = quanLiSach.get(i).getSoLuong();
                quanLiSach.get(i).setSoLuong(tam + soLuong);
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
            if (quanLiSach.get(i).getID().equals(ID)) {
                quanLiSach.get(i).setSoLuong(soLuong);
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

    public void BuyBook() {

        Scanner sc = new Scanner(System.in);
        var isContinueBuyBook = true;
        if (quanLiSach.size() < 1) {
            System.out.println("\t [kho sách đang rỗng ] \n vui lòng quay lại sau!");
            System.out.print("Co muon tiep tuc? 0/1 : ");
            int stop = Integer.valueOf(sc.nextInt());
            if (stop == 0) {
                System.out.println("tam biet !");
                return;
            }
        } else {
            while (isContinueBuyBook){
                System.out.println(quanLiSach);
                System.out.print("nhap ID:");
                String ID = String.valueOf(sc.nextLine());
                boolean check = false;
                int index;
                for (int i = 0; i < quanLiSach.size(); i++) {
                    if (quanLiSach.get(i).getID().equals(ID)) check = true;
                }
                if (check) {
                    var currentBook = findBookByID(ID);
                    var currentNumber = currentBook.getSoLuong();
                    if (currentNumber < 1) {
                        System.out.println("rất tiếc sách bạn đã hết , \n bạn thử chọn quyển sách khách xem sao !");
                        isContinueBuyBook=false;
                        check=false;
                    }else {
                        var invalidNumberInput = true;
                        while (invalidNumberInput){

                            System.out.println("bạn muốn mua số lượng là bao nhiêu ? (0-" + findBookByID(ID).getSoLuong() + ")");
                            System.out.print("vui lòng nhập: ");
                            int soluong = Integer.valueOf(sc.nextLine());
                            if (soluong <= 0 || soluong > currentNumber) {
                                System.out.println("số lượng sách không hợp lệ , vui lòng nhập lại !");
                                invalidNumberInput = true;
                            } else {
                                currentBook.setSoLuong( -soluong);
                                currentBook.setDaBan(soluong);
                                //thêm vào danh sách mua
                                var newCustomer =  addCustomer();
                                var sachDaMua = currentBook;
                                findCustomerByID(newCustomer.getID()).muaSach(sachDaMua, currentBook.getSoLuong());
                                invalidNumberInput = false;
                                isContinueBuyBook = false;
                            }
                        }
                    }
                } else {
                    System.out.println("ID bạn chọn không hợp lệ , vui lòng chọn lại ");
                    isContinueBuyBook = true;
                }
            }
        }
    }

    public Book findBookByID(String bookId) {
        for (int i = 0; i< quanLiSach.size(); i++ ){
            if(bookId.equals(quanLiSach.get(i).getID())){
                return  quanLiSach.get(i);
            }
        }
        return null;
    }
    public Customer findCustomerByID(String customerId) {
        for (int i = 0; i< quanLiKhach.size(); i++ ){
            if(customerId.equals(quanLiKhach.get(i).getID())){
                return  quanLiKhach.get(i);
            }
        }
        return null;
    }

    public void quanlisach() {
        Scanner sc = new Scanner(System.in);
        int stop = 0;
        int stop1, stop2;
        int choose;
        System.out.println("\n\t\t === Quan li sach ===");
        do {
            System.out.print("\t 0. Tro lai");
            System.out.print("\t 1. Them sach");
            System.out.print("\t 2. Tim sach");
            System.out.println("\t 3. Sap xep");

            System.out.print("Moi lua chon: ");
            choose = Integer.valueOf(sc.nextLine());
            switch (choose) {
                case 1:
                    do {
                        addBook();
                        System.out.println("Tiep? 0/1 ");
                        stop2 = Integer.valueOf(sc.nextLine());
                    }
                    while (stop2 == 1);
                    stop = 1;
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
                            findNameBook(bookName);
                            break;
                        case 2:
                            System.out.print("Nhap tac gia can tim: ");
                            String bookAuthor = sc.nextLine();
                            findAuthor(bookAuthor);
                            break;
                        case 3:
                            System.out.print("Nhap sach the loai can tim: ");
                            String bookKind = sc.nextLine();
                            findKindBook(bookKind);
                            break;
                        case 4:
                            System.out.print("Nhap Nha xuat ban can tim: ");
                            String bookNXB = sc.nextLine();
                            findNXB(bookNXB);
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
                            sortNameBook();
                            break;
                        case 2:
                            sortPopular();
                            break;
                        case 3:
                            sortPrice();
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Tiep? 0/1 ");
                    break;
            }
            break;
        } while (stop == 1);
    }

    public void quanlikhachhang() {
        Scanner sc = new Scanner(System.in);
        int stop = 0;
        int stop1;
        System.out.println("\n\t\t === Quan li khach hang ===");

        int choose;
        do {


            System.out.print("1. Them khach hang");
            System.out.print("\t 2. Tim khach hang");
            System.out.println("\t 3. danh sach khach hang");
            System.out.print("Moi lua chon: ");
            choose = Integer.valueOf(sc.nextLine());
            switch (choose) {
                case 1:
                    addCustomer();
                    if(addCustomer()!=null)
                        addCustomer().setVisitNumber();
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
                            findNameCustomer(customerName);
                            break;
                        case 2:
                            System.out.print("Nhap tac gia can tim: ");
                            String bookAuthor = sc.nextLine();
                            findIdCustomer(bookAuthor);
                            break;
                        case 3:
                            System.out.print("Nhap so dien thoai can tim: ");
                            String bookKind = sc.nextLine();
                            findNumberPhoneCustomer(bookKind);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("\t danh sach khach hang");
                    sortNameCustomer();
                    break;
            }
            System.out.println("Tiep? 0/1 ");
            stop1 = Integer.valueOf(sc.nextLine());
        } while (stop1 == 1);
    }

    public void Store() {
        Scanner sc = new Scanner(System.in);

        Manager manager = new Manager("Thu", "Viet Nam", 16);

        System.out.println("\t===Welcom to my tiem sach!===");

        int stop = 0;
        do {
            System.out.print(" 0. mua sach");
            System.out.print("\t 1. Quan li sach");
            System.out.println("\t 2. Quan li khach hang");

            System.out.print("Moi lua chon: ");
            int choose = Integer.valueOf(sc.nextLine());

            int stop1;
            if (choose == 1) {
                manager.quanlisach();
            } else if (choose == 2) {
                manager.quanlikhachhang();
            } else if (choose == 0) {
                System.out.println("\t chọn sách bạn muốn mua theo ID tương ứng của sách đó ");
                manager.BuyBook();
            } else {
                System.out.print("Co muon tiep tuc? 0/1 : ");
                stop = Integer.valueOf(sc.nextInt());
                if (stop == 0) {
                    System.out.println("tam biet !");
                    return;
                } else
                    Store();
            }
        } while (true);
    }

    public Customer addCustomer() {
        Customer customerAdd;
        String ten, diachi, ID, soDT;
        int tuoi;
        boolean check = true;
        boolean isContinue = true;
        while (isContinue){
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
//                quanLiKhach.get(i).setAmount(quanLiKhach.get(i).getAmount() + 1);
                    check = false; break;
                }
            }
            //kiem tra neu check la dung thi se them moi sach
            if (check) {
                customerAdd = new Customer(ID, ten, tuoi, soDT, diachi);
                quanLiKhach.add(customerAdd);
                return  customerAdd;
            }else {
                System.out.println("Khach hang da ton tai");
                customerAdd = new Customer(ID, ten, tuoi, soDT, diachi);
                return  customerAdd;
            }
        }
        return  null;
    }

    public void findNameCustomer(String name) {
        for (int i = 0; i < quanLiKhach.size(); i++) {
            if (quanLiKhach.get(i).getTen().equals(name)) {
                System.out.println("=");
                quanLiKhach.get(i).displayHistoryBuy();
            }
        }
    }

    public void findIdCustomer(String id) {
        for (int i = 0; i < quanLiKhach.size(); i++) {
            if (quanLiKhach.get(i).getID().equals(id)) {
                System.out.println("=");
                quanLiKhach.get(i).displayHistoryBuy();
            }
        }
    }

    public void findNumberPhoneCustomer(String numberPhone) {
        for (int i = 0; i < quanLiKhach.size(); i++) {
            if (quanLiKhach.get(i).getSoDT().equals(numberPhone)) {
                System.out.println("=");
                quanLiKhach.get(i).displayHistoryBuy();
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
        for (int i = 0; i < quanLiSach.size(); i++) {
            quanLiSach.get(i).display();
        }
    }

    public void sortNameCustomer() {
        Collections.sort(quanLiKhach, new SortNameCustomer());
        for (int i = 0; i < quanLiKhach.size(); i++) {
            quanLiKhach.get(i).displayHistoryBuy();
        }
    }

    public void sortPopular() {
        Collections.sort(quanLiSach, new SortTrendingBook());
        for (int i = 0; i < 5; i++) {
            quanLiSach.get(i).display();
        }
    }

    public void sortPrice() {
        Collections.sort(quanLiSach, new SortPriceBook());
        for (int i = 0; i < quanLiSach.size(); i++) {
            quanLiSach.get(i).display();
        }
    }
}
