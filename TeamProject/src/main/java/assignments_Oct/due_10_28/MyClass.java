package assignments_Oct.due_10_28;

import java.util.*;

public class MyClass {
	int x;
	int y;
	int z;
	
	public MyClass() {
		x = 1;
		y = 2;
		z = 3;
	};
	List<Integer> l1 = Arrays.asList(x,y,z);
	public void test() {
		try {
			System.out.println(l1.get(10));
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Something is wrong");
		}
	}
}
