package wbs.generics;

import java.util.ArrayList;
import java.util.List;

public class ListUtilDemo {

	public static void main(String[] args) {
		
		List<Number> nList = new ArrayList<>();
		List<Integer> iList = new ArrayList<>();
		
		@SuppressWarnings("unused")
		List<String> sList = new ArrayList<>();
		
		iList.add(1);
		iList.add(2);
		iList.add(3);
		
		ListUtil.copy(iList, nList);
		// ListUtil.copy(iList, sList);  compilerfehler

	}

}
