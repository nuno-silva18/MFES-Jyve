package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DateTimeTest extends TestSuiteJyve {
  private DateTime d1 = new DateTime(2017L, 12L, 30L, 20L, 30L);
  private DateTime d2 = new DateTime(2017L, 10L, 30L, 20L, 30L);
  private DateTime d3 = new DateTime(2017L, 12L, 30L, 21L, 30L);

  private void testlaterDate() {

    assertEqual(d1.laterDate(d2), true);
    assertEqual(d2.laterDate(d1), false);
  }

  private void testsameDate() {

    assertEqual(d1.sameDate(d3), true);
    assertEqual(d1.sameDate(d2), false);
  }

  private void testlaterHour() {

    assertEqual(d3.laterHour(d1), true);
    assertEqual(d1.laterHour(d3), false);
  }

  private void testsameHour() {

    assertEqual(d1.sameHour(d2), true);
    assertEqual(d2.sameHour(d3), false);
  }

  private void testlaterTime() {

    assertEqual(d3.laterTime(d1), true);
    assertEqual(d1.laterTime(d3), false);
  }

  private void testgetYear() {

    assertEqual(d1.getYear(), 2017L);
    assertEqual(d2.getYear(), 2017L);
  }

  private void testgetMonth() {

    assertEqual(d1.getMonth(), 12L);
    assertEqual(d2.getMonth(), 10L);
  }

  private void testgetDay() {

    assertEqual(d1.getDay(), 30L);
    assertEqual(d2.getDay(), 30L);
  }

  private void testgetHour() {

    assertEqual(d1.getHour(), 20L);
    assertEqual(d2.getHour(), 20L);
  }

  private void testgetMinutes() {

    assertEqual(d1.getMinutes(), 30L);
    assertEqual(d2.getMinutes(), 30L);
  }

  public static void main() {

    DateTimeTest test = new DateTimeTest();
    test.testlaterDate();
    test.testsameDate();
    test.testlaterHour();
    test.testsameHour();
    test.testlaterTime();
    test.testgetYear();
    test.testgetMonth();
    test.testgetDay();
    test.testgetHour();
    test.testgetMinutes();
  }

  public DateTimeTest() {}

  public String toString() {

    return "DateTimeTest{"
        + "d1 := "
        + Utils.toString(d1)
        + ", d2 := "
        + Utils.toString(d2)
        + ", d3 := "
        + Utils.toString(d3)
        + "}";
  }
}
