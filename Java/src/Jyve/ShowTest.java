package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ShowTest extends TestSuiteJyve {
  private DateTime d1 = new DateTime(2017L, 12L, 1L, 23L, 30L);
  private DateTime d2 = new DateTime(2017L, 12L, 2L, 4L, 0L);
  private DateTime d3 = new DateTime(2017L, 12L, 1L, 23L, 45L);
  private DateTime d4 = new DateTime(2017L, 12L, 2L, 3L, 30L);
  private Location l1 = new Location("New Jersey", "New York");
  private Location l2 = new Location("Los Angeles", "California");
  private Venue v1 = new Venue("New Jersey's Cool Bar", l1, "New Jersey's best bar!");
  private Venue v2 = new Venue("LA's Laking Bar", l2, "Come see our lack of lakes!");
  private Show s1 = new Show(d1, d2, v1, "Concert up buds!");
  private Show s2 = new Show(d3, d4, v2, "Concert up in another club!");

  private void testgetStartDate() {

    assertEqual(s1.getStartDate(), d1);
    assertEqual(s2.getStartDate(), d3);
  }

  private void testgetEndDate() {

    assertEqual(s1.getEndDate(), d2);
    assertEqual(s2.getEndDate(), d4);
  }

  private void testgetVenue() {

    assertEqual(s1.getVenue(), v1);
    assertEqual(s2.getVenue(), v2);
  }

  private void testgetDescription() {

    assertEqual(s1.getDescription(), "Concert up buds!");
    assertEqual(s2.getDescription(), "Concert up in another club!");
  }

  private void testsetDescription() {

    s1.setDescription("Why is the other show copying our description...");
    s2.setDescription("Because we can!");
  }

  public static void main() {

    ShowTest test = new ShowTest();
    test.testgetStartDate();
    test.testgetEndDate();
    test.testgetVenue();
    test.testgetDescription();
    test.testsetDescription();
  }

  public ShowTest() {}

  public String toString() {

    return "ShowTest{"
        + "d1 := "
        + Utils.toString(d1)
        + ", d2 := "
        + Utils.toString(d2)
        + ", d3 := "
        + Utils.toString(d3)
        + ", d4 := "
        + Utils.toString(d4)
        + ", l1 := "
        + Utils.toString(l1)
        + ", l2 := "
        + Utils.toString(l2)
        + ", v1 := "
        + Utils.toString(v1)
        + ", v2 := "
        + Utils.toString(v2)
        + ", s1 := "
        + Utils.toString(s1)
        + ", s2 := "
        + Utils.toString(s2)
        + "}";
  }
}
