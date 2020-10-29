package assignments_Oct.due_10_29;

import java.util.*;

public class HW_10_29 {
	ArrayList<Integer> myList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	
	public void returnIterationsForLoop() {
		for(int i=0;i<myList.size();i++) {
			System.out.println(myList.get(i));
		}
	}
	
	public void returnIterationsForEachLoop() {
		for (int num: myList) {
			System.out.println(num);
		}
	}
	
	
}
