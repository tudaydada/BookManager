import java.util.Comparator;

public class SortNameCustomer implements Comparator<Customer>{

    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getTen().compareTo(o2.getTen()) < 0) {
            return -1;
        } else if (o1.getTen().compareTo(o2.getTen()) < 0) {
            return 1;
        }
        return 0;
    }


}

