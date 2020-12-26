import java.util.Comparator;

public class SortNameBook implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		if(o1.getTen().compareTo(o2.getTen())>0) return -1;
		else if(o1.getTen().compareTo(o2.getTen())<0) return 1;
		return 0;
	}


}
