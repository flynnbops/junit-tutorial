package junit5tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterisedTests {

  @DisplayName("Can use ValueSource Parameterized tests on Int values")
  @ParameterizedTest(name = "Run: {index} - value: {arguments}")
  @ValueSource(ints = {1,5,6})
  void intValues(int theParam){
    System.out.println("theParam = " + theParam);
  }

  @DisplayName("Can use ValueSource Parameterized tests on Strings")
  @ParameterizedTest(name = "Run: {index} - value: {arguments}")
  @NullAndEmptySource
  @ValueSource(strings = {"first", "second"})
  void StringValues(String params){
    System.out.println("params = " + params);
  }
}
