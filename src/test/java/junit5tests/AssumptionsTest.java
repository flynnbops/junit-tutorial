package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionsTest {

  @DisplayName("Use 'assumeTrue' assumption to skip tests that meet the condition")
  @ParameterizedTest(name = "Run: {index} - value: {arguments}")
  @ValueSource(ints = {1,5,6})
  void intValues(int theParam){
    assumeTrue( theParam > 4);
    System.out.println("theParam = " + theParam);
  }

  @DisplayName("Use 'assumeFalse' assumption to skip tests that do not meet the condition")
  @ParameterizedTest
  @CsvSource(value = {"steve,rodgers", "comma,separated", "jane,doe"})
  void csvSourceStringWithComma(String param1, String param2){
    assumeFalse(param1.equals("steve"), "The assumption failed for the " +
            "following param2: " + param2);
    System.out.println("param1 = " + param1 + ", param2 = " + param2);
  }

  @DisplayName("Using 'assumingThat' will not skip tests that do not meet the condition, but useful for skipping parts.")
  @ParameterizedTest
  @CsvSource(value = {"steve,32,true", "roger,12,false", "tom,1,true"})
  void csvSourceMixedParameterTypes(String param1, int param2, boolean param3){
    assumingThat(param2 > 20, () -> System.out.println("This assumption evaluated to True"));
    System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
  }
}
