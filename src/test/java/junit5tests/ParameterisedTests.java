package junit5tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

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

  @DisplayName("Can use CSVSource Parameterized tests")
  @ParameterizedTest
  @CsvSource(value = {"john,doe", "ann,bowling", "jar,binks"})
  void csvSourceStringString(String param1, String param2){
    System.out.println("param1 = " + param1 + ", param2 = " + param2);
  }

  @DisplayName("Can use mixed types with CSVSource Parameterized tests")
  @ParameterizedTest
  @CsvSource(value = {"steve,32,true", "roger,12,false", "tom,1,true"})
  void csvSourceMixedParameterTypes(String param1, int param2, boolean param3){
    System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
  }

  @DisplayName("Can use comma separated string as a single parameter")
  @ParameterizedTest
  @CsvSource(value = {"steve rodgers, 'comma,separated'", "jane doe, 'some,thing'"})
  void csvSourceStringWithComma(String param1, String param2){
    System.out.println("param1 = " + param1 + ", param2 = " + param2);
  }

  @DisplayName("Can change the CSV delimiter")
  @ParameterizedTest
  @CsvSource(value = {"steve?rodgers","some?thing"}, delimiter = '?')
  void csvSourceChangeDelimiter(String param1, String param2){
    System.out.println("param1 = " + param1 + ", param2 = " + param2);
  }
}
