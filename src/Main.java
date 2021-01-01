import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{

        Manager manager = new Manager("Thu", "Viet Nam", 16);

        manager.Store(manager);
    }
}

