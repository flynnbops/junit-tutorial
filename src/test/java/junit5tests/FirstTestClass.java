package junit5tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTestClass {

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
