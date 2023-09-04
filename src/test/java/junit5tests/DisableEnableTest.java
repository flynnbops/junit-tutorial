package junit5tests;

import listeners.Listener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@ExtendWith(Listener.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DisableEnableTest {

  @Test
  @Disabled("Disabled for demo purposes")
  @Order(1)
  void firstTest(){
    System.out.println("First test method");
  }

  @Test
  @Order(2)
  @DisabledOnOs(value = OS.MAC, disabledReason = "DEMO")
  void secondTest(){
    System.out.println("Second test method");
  }

  @Test
  @Order(3)
  @DisabledIfSystemProperty(named = "ENV", matches = "staging", disabledReason = "Demo")
  void thirdTest(){
    System.out.println("Third test method");
  }


  boolean provider(){
    return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.MONDAY);
  }

  @Test
  @Order(4)
  @DisabledIf(value = "provider", disabledReason = "Don\'t run on Monday")
  void forthTest(){
    System.out.println("Forth test method");
  }

  @Test
  @Order(5)
  @EnabledOnOs(OS.MAC)
  void fifthTest(){
    System.out.println("Fifth test method");
  }
}
