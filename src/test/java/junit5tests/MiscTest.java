package junit5tests;

import org.junit.jupiter.api.*;

public class MiscTest {

  @Test
  @Timeout(5)
  void timeout() throws InterruptedException{
    System.out.println("This test is annotated with 5 second timeout");
    Thread.sleep(6000);
  }


  @Test
  @Timeout(90)
  @DisplayName("This is a long one")
  @Tag("my-tag")
  void annotatedMethod(){
    System.out.println("The annotated method");
  }

  @MyAnnotation
  void annotatedMethod2() throws InterruptedException{
    System.out.println("The method using custom 'myAnnotation'");
    Thread.sleep(3000);
  }

  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  @Nested
  class NestedTest{
    @BeforeAll
    void BeforeAll(){
      System.out.println("Before all in the nested test");
    }

    @Test
    void nestedTestMethod(){
      System.out.println("Nested Test Method");
    }
  }
}
