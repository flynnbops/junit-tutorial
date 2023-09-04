package junit5tests;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestClass {

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
  @DisplayName("First test here")
  void firstMethod(){
    System.out.println("First test method");
  }

  @Test
  @DisplayName("UserStory 1234 - WIP - @someTag")
  void secondMethod(){
    System.out.println("Second test method");
  }
}
