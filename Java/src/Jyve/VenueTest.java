package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class VenueTest extends TestSuiteJyve {
  private Jyve j1 = new Jyve();
  private DateTime d1 = new DateTime(2017L, 12L, 1L, 23L, 30L);
  private DateTime d2 = new DateTime(2017L, 12L, 2L, 4L, 0L);
  private DateTime d3 = new DateTime(2017L, 12L, 3L, 23L, 30L);
  private DateTime d4 = new DateTime(2017L, 12L, 4L, 4L, 0L);
  private Location l1 = new Location("New Jersey", "New York");
  private Location l2 = new Location("Los Angeles", "California");
  private Venue v1 = new Venue("New Jersey's Cool Bar", l1, "New Jersey's best bar!");
  private Venue v2 = new Venue("LA's Laking Bar", l2, "Come see our lack of lakes!");
  private Show s1 = new Show(d1, d2, v1, "Concert up buds!");
  private Show s2 = new Show(d3, d4, v2, "Concert up in another club!");
  private Artist a1 =
      new Artist(
          "Father John Misty",
          l1,
          "Too cool for descriptions.",
          SetUtil.set("Indie"),
          SetUtil.set("Piano"));
  private Artist a2 = new Artist("St. Vincent", l1, "Coolio", SetUtil.set(), SetUtil.set());
  private Band b1 =
      new Band("Father John Misty's Band", l1, "Cool band.", SetUtil.set("Indie"), SetUtil.set(a1));

  private void testaddShow() {

    v1.addShow(s1);
    v2.addShow(s2);
  }

  private void testgetName() {

    assertEqual(v1.getName(), "New Jersey's Cool Bar");
    assertEqual(v2.getName(), "LA's Laking Bar");
  }

  private void testgetLocation() {

    assertEqual(v1.getLocation(), l1);
    assertEqual(v2.getLocation(), l2);
  }

  private void testgetDescription() {

    assertEqual(v1.getDescription(), "New Jersey's best bar!");
    assertEqual(v2.getDescription(), "Come see our lack of lakes!");
  }

  private void testgetShows() {

    assertEqual(v1.getShows(), SetUtil.set(s1));
    assertEqual(v2.getShows(), SetUtil.set(s2));
  }

  private void testgetShow() {

    assertEqual(v1.getShow("New Jersey's Cool Bar", 2017L, 12L, 1L, 23L, 30L), s1);
    assertEqual(v2.getShow("LA's Laking Bar", 2017L, 12L, 3L, 23L, 30L), s2);
    assertEqual(v1.getShow("Dummy Venue", 2018L, 12L, 12L, 12L, 12L), null);
  }

  private void testsetName() {

    v1.setName("LA's Worst Bar");
    v2.setName("New Jersey's Non-Laking Bar");
  }

  private void testsetLocation() {

    v1.setLocation(l2);
    v2.setLocation(l1);
  }

  private void testsetDescription() {

    v1.setDescription("We shouldn't have moved...");
    v2.setDescription("At least our description makes sense!");
  }

  private void testremoveShow() {

    v1.removeShow(s1);
    v2.removeShow(s2);
  }

  private void testcancelShow() {

    j1.addArtist(a1);
    j1.addBand(b1);
    j1.addVenue(v1);
    j1.addVenue(v2);
    if (a1.addShow(s1)) {
      v1.cancelShow(s1, j1);
    }

    if (b1.addShow(s2)) {
      v2.cancelShow(s2, j1);
    }
  }

  public static void main() {

    VenueTest test = new VenueTest();
    test.testaddShow();
    test.testgetName();
    test.testgetLocation();
    test.testgetDescription();
    test.testgetShows();
    test.testgetShow();
    test.testsetName();
    test.testsetLocation();
    test.testsetDescription();
    test.testremoveShow();
    test.testcancelShow();
  }

  public VenueTest() {}

  public String toString() {

    return "VenueTest{"
        + "j1 := "
        + Utils.toString(j1)
        + ", d1 := "
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
        + ", a1 := "
        + Utils.toString(a1)
        + ", a2 := "
        + Utils.toString(a2)
        + ", b1 := "
        + Utils.toString(b1)
        + "}";
  }
}
