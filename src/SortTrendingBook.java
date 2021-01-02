import java.util.Comparator;

public class SortTrendingBook implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        int tam1 = o1.getDaBan();
        int tam2 = o2.getDaBan();
        if (tam1 > tam2) {
            return -1;
        } else if (tam1 < tam2) {
            return 1;
        }
        return 0;
    }

}
