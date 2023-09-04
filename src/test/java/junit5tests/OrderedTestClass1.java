package junit5tests;

import org.junit.jupiter.api.*;


// Can change what order tests run.
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass1 {

  @BeforeAll
  void beforeAll(){
    System.out.println("-- BeforeAll setup step");
  }

  @BeforeEach
  void beforeEach(){
    System.out.println("---- BeforeEach setup step");
  }

  @AfterAll
  static void afterAll(){
    System.out.println("-- AfterAll setup step");
  }

  @AfterEach
  void afterEach(){
    System.out.println("---- AfterEach setup step");
  }

  @Test
  @Order(2)
  void firstMethod(){
    System.out.println("First test method");
  }

  @Test
  @Order(1)
  @DisplayName("UserStory 1234 - WIP - @someTag")
  void secondMethod(){
    System.out.println("Second test method");
  }

  @Test
  @DisplayName("AAA")
  void thirdMethod(){
    System.out.println("Thirds test method");
  }
}
