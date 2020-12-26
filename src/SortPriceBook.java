import java.util.Comparator;

public class SortPriceBook implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		if(o1.getGiaTien()>o2.getGiaTien()) return -1;
		else if(o1.getGiaTien()<o2.getGiaTien()) return 1;
		return 0;
	}
	
}