package model;

import java.util.Comparator;

public class ByDateComparator implements Comparator<Game> {

	@Override
	public int compare(Game o1, Game o2) {
		// TODO Auto-generated method stub
		return o1.getDate().compareTo(o2.getDate());
	}

}
