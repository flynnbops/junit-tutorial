package junit5tests;

import listeners.Listener;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(Listener.class)
public class AssertionsTest {

  @Test
  @Tag("junit5-assertion")
  void assertEqualsTest(){
    assertEquals("House", "House", "House not found");
  }

  @Test
  @Tag("junit5-assertion")
  void assertEqualsListTest(){
    List<String> expectedValues = Arrays.asList("First", "Second", "Third");
    List<String> actualValues = Arrays.asList("First", "Second", "Third");

    assertEquals(expectedValues, actualValues, "The lists do not match");
  }

  @Test
  @Tag("junit5-assertion")
  void assertEqualsArraysTest(){
    int[] expectedValues = {1, 2, 3};
    int[] actualValues = {1, 2, 3};

    assertArrayEquals(expectedValues, actualValues, "The arrays do not match");
  }

  @Test
  @Tag("junit5-assertion")
  void assertTrueTest(){
    assertFalse(false, "Condition is not false");
    assertTrue(true, "Condition is not true");
  }

  @Test
  @Tag("junit5-assertion")
   void assertThrowsTest(){
    assertThrows(NullPointerException.class, null);
  }

  @Test
  @Tag("junit5-assertion")
  void AssertAllTest(){
    assertAll(
            () -> assertEquals("House", "House", "House not found"),
            () -> assertEquals("House", "Mouse", "House not found"),
            () -> assertThrows(NullPointerException.class, null),
            () -> assertFalse(true, "Condition is not false")
    );
  }

  @Test
  @Tag("hamcrest-assertion")
  void assertForMapTest(){
    Map<String, Integer> ourMap = new HashMap<>();
    ourMap.put("first", 1);
    ourMap.put("second", 12);
    ourMap.put("third", 23);

    assertThat(ourMap, hasKey("second"));
    assertThat(ourMap, hasValue(1));
  }

  @Test
  @Tag("hamcrest-assertion")
  void assertForListTest(){
    List <String> ourList = Arrays.asList("First", "Second");
    assertThat(ourList, hasItem("First"));
  }

  @Test
  @Tag("hamcrest-assertion")
  void assertForAnyOfTest(){
    List <String> ourList = Arrays.asList("First", "Second", "Third");
    assertThat(ourList, Matchers.anyOf(
            hasItem("Second"),
            hasItem("First")

    ));
  }

  @Test
  @Tag("hamcrest-assertion")
  void assertForAllOfTest(){
    List <String> ourList = Arrays.asList("First", "Second", "Third");
    assertThat(ourList, Matchers.allOf(
            hasItem("Second"),
            hasItem("Forth")
    ));
  }

  @Test
  @Tag("hamcrest-assertion")
  void assertForContainsInAnyOrderTest(){
    List <String> ourList = Arrays.asList("First", "Second", "Third");
    assertThat(ourList, containsInAnyOrder("Third", "First", "Second"));
  }
}
