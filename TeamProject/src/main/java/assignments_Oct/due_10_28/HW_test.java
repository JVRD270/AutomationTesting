package assignments_Oct.due_10_28;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class HW_test {
  @Test
  public void f() {
	  System.out.println("Hello World");
	  MyClass testClass = new MyClass();
	  testClass.test();
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
