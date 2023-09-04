package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatingTests {

  @RepeatedTest(5)
  @DisplayName("Repeating tests")
  void firstRepeatedMethod(){
    System.out.println("Repeating this test");
  }

  @RepeatedTest(value = 3, name = "Running repeat: {currentRepetition}," +
  " Total: {totalRepetitions}")
  @DisplayName("This is a repeated test method")
  void secondRepeatedMethod(){
    System.out.println("Repeating a different test");
  }

  @RepeatedTest(3)
  void thirdRepeatedMethod(RepetitionInfo info){
    System.out.println("This code will run each iteration");
    Assumptions.assumingThat(info.getCurrentRepetition() == 3,
            () -> System.out.println("Runs in repetition 3"));
  }
}
