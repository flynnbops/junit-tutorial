package junit5tests;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

  @Test
  void assertEqualsTest(){
    assertEquals("House", "House", "House not found");
  }

  @Test
  void assertEqualsListTest(){
    List<String> expectedValues = Arrays.asList("First", "Second", "Third");
    List<String> actualValues = Arrays.asList("First", "Second", "Third");

    assertEquals(expectedValues, actualValues, "The lists do not match");
  }

  @Test
  void assertEqualsArraysTest(){
    int[] expectedValues = {1, 2, 3};
    int[] actualValues = {1, 2, 3};

    assertArrayEquals(expectedValues, actualValues, "The arrays do not match");
  }

  @Test
  void assertTrueTest(){
    assertFalse(false, "Condition is not false");
    assertTrue(true, "Condition is not true");
  }

  @Test
   void assertThrowsTest(){
    assertThrows(NullPointerException.class, null);
  }

  @Test
  void AssertAllTest(){
    assertAll(
            () -> assertEquals("House", "House", "House not found"),
            () -> assertEquals("House", "Mouse", "House not found"),
            () -> assertThrows(NullPointerException.class, null),
            () -> assertFalse(true, "Condition is not false")
    );
  }
}
