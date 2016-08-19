package wbs.nested_classes;

import java.util.ArrayList;
import java.util.List;

public abstract class MyListDemo {

	/*
	 * wir bestücken eine list mit den zahlen von 1 bis 4
	 * und geben dann alle teillisten dieser list aus
	 */
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		MyList<Integer> mylist = new MyList<>(list);
		
		for(int i = 1;i <= 4;i++) {
			list.add(i);
		}
		
		for(List<Integer> subList : mylist) {
			System.out.println(subList);
		}
	}
}
