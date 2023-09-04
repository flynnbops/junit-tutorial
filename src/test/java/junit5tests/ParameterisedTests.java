package junit5tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

  @DisplayName("Can use data from multiple CSV files.")
  @ParameterizedTest
  @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv", "src/test/resources/params/shoppinglist2.csv"},numLinesToSkip = 1)
  void csvFileSourceMultipleCSVFilesTest(String name, double price, int qty, String unitOfMeasure, String provider){
    System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", unit = " + unitOfMeasure + ", provider = " + provider);
  }

  @DisplayName("Can use different delimiters in CSV files.")
  @ParameterizedTest
  @CsvFileSource(files = "src/test/resources/params/shoppinglist3.csv", numLinesToSkip = 1, delimiterString = "]")
  void csvFileSourceDelimeterTest(String name, double price, int qty, String unitOfMeasure, String provider){
    System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", unit = " + unitOfMeasure + ", provider = " + provider);
  }

  List<String> sourceString() {
    return Arrays.asList("Tomato", "Carrot", "Parsley");
  }

  // If the methodSource method lives in a different class, it must be "static"
  @ParameterizedTest
  @MethodSource(value = "sourceString")
  void methodSource_String(String param1){
    System.out.println("param1 = " + param1);
  }

  Stream<String> sourceStringAsStream(){
    return Stream.of("beets", "beans", "turnips");
  }

  @DisplayName("Use String as Stream from method to provide data for a Test")
  @ParameterizedTest
  @MethodSource(value = "sourceStringAsStream")
  void methodSource_StringStream(String param1){
    System.out.println("param1 = " + param1);
  }

  List<Arguments> sourceStringDifferentTypes(){
    return Arrays.asList(arguments("tomato", 2.0),
            arguments("carrot", 1.99),
            arguments("turnip", 1.01));
  }

  @DisplayName("Use Arguments as List from method to provide different data types for a Test")
  @ParameterizedTest
  @MethodSource(value = "sourceStringDifferentTypes")
  void methodSource_StringListDifferentTypes(String param1, double param2){
    System.out.println("param1 = " + param1 + ", param2 = " + param2);
  }


  @DisplayName("Use Arguments as Stream from method to provide different data types for a Test")
  @ParameterizedTest
  @MethodSource(value = "junit5tests.ParamProvider#sourceStreamDifferentTypes")
  void methodSource_StringStreamDifferentTypes(String param1, double param2){
    System.out.println("param1 = " + param1 + ", param2 = " + param2);
  }

}
