package model;

import java.util.Comparator;

public class ByHour implements Comparator<Game> {

	@Override
	public int compare(Game o1, Game o2) {
		// TODO Auto-generated method stub
		return o1.getHour().compareTo(o2.getHour());
	}
}
