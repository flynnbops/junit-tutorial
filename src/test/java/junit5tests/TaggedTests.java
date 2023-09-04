package junit5tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaggedTests {

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
  @Tag("WIP")
  @Tag("review-NEEDED")
  @DisplayName("First test here")
  void firstMethod(){
    System.out.println("First test method");
  }

  @Test
  @DisplayName("UserStory 1234 - WIP - @someTag")
  void secondMethod(){
    System.out.println("Second test method");
  }

  @Test
  @Tag("acceptance")
  @DisplayName("UserStory 1234 - WIP - @someTag")
  void thirdMethod(){
    System.out.println("Third test method");
  }

  @DisplayName("Parameterised test")
  @Tag("acceptance")
  @ParameterizedTest(name = "Run: {index} - value: {arguments}")
  @ValueSource(ints = {1,5,6})
  void intValues(int theParam){
    System.out.println("theParam = " + theParam);
  }


}
