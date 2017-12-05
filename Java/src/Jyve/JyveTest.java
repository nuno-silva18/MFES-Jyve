package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class JyveTest extends TestSuiteJyve {
  private Jyve j = new Jyve();
  private DateTime d1 = new DateTime(2017L, 12L, 1L, 23L, 30L);
  private DateTime d2 = new DateTime(2017L, 12L, 2L, 4L, 0L);
  private DateTime d3 = new DateTime(2017L, 12L, 1L, 23L, 45L);
  private DateTime d4 = new DateTime(2017L, 12L, 2L, 3L, 30L);
  private Location l1 = new Location("New York", "New York");
  private Location l2 = new Location("Illinois", "Chicago");
  private Artist a1 =
      new Artist(
          "Father John Misty", l1, "Too cool for descriptions.", SetUtil.set(), SetUtil.set());
  private Artist a2 = new Artist("St. Vincent", l1, "Coolio", SetUtil.set(), SetUtil.set());
  private Band b1 =
      new Band("Father John Misty's Band", l1, "Cool band.", SetUtil.set("Indie"), SetUtil.set(a1));
  private Band b2 =
      new Band(
          "Superband", l1, "Super band with two awesome people!", SetUtil.set(), SetUtil.set(a2));
  private Venue v1 = new Venue("The Den", l1, "Cool place to chill.");
  private Venue v2 = new Venue("The Dank", l1, "Dank place to chill.");
  private Show s1 = new Show(d1, d2, v1, "Concert up buds!");
  private Show s2 = new Show(d3, d4, v1, "Concert down buds!");

  private void testaddArtist() {

    j.addArtist(a1);
    j.addArtist(a2);
  }

  private void testaddBand() {

    j.addBand(b1);
    j.addBand(b2);
  }

  private void testaddVenue() {

    j.addVenue(v1);
    j.addVenue(v2);
  }

  private void testgetArtists() {

    assertEqual(j.getArtists(), SetUtil.set(a1, a2));
  }

  private void testgetBands() {

    assertEqual(j.getBands(), SetUtil.set(b1, b2));
  }

  private void testgetVenues() {

    assertEqual(j.getVenues(), SetUtil.set(v1, v2));
  }

  private void testgetArtistbyName() {

    assertEqual(j.getArtistbyName("Father John Misty"), a1);
    assertEqual(j.getArtistbyName("St. Vincent"), a2);
    assertEqual(j.getArtistbyName("Me"), null);
  }

  private void testgetBandbyName() {

    assertEqual(j.getBandbyName("Father John Misty's Band"), b1);
    assertEqual(j.getBandbyName("Superband"), b2);
    assertEqual(j.getBandbyName("You"), null);
  }

  private void testgetVenuebyName() {

    assertEqual(j.getVenuebyName("The Den"), v1);
    assertEqual(j.getVenuebyName("The Dank"), v2);
    assertEqual(j.getVenuebyName("What"), null);
  }

  private void testgetArtBandbyShow() {

    if (a1.addShow(s1)) {
      assertEqual(j.getArtBandbyShow(s1), "Father John Misty");
    }

    if (b1.addShow(s2)) {
      assertEqual(j.getArtBandbyShow(s2), "Father John Misty's Band");
    }
  }

  private void testsearchArtist() {

    assertEqual(j.searchArtist("Father John Misty"), SetUtil.set(a1));
    assertEqual(j.searchArtist("Coolio"), SetUtil.set(a2));
  }

  private void testsearchBand() {

    assertEqual(j.searchBand("Cool band."), SetUtil.set(b1));
    assertEqual(j.searchBand("Superband"), SetUtil.set(b2));
  }

  private void testsearchVenue() {

    assertEqual(j.searchVenue("Cool place to chill."), SetUtil.set(v1));
    assertEqual(j.searchVenue("The Dank"), SetUtil.set(v2));
  }

  private void testsearchShow() {

    assertEqual(j.searchShow("Concert up buds!"), SetUtil.set(s1));
    assertEqual(j.searchShow("Concert down buds!"), SetUtil.set(s2));
  }

  public static void main() {

    JyveTest test = new JyveTest();
    test.testaddArtist();
    test.testaddBand();
    test.testaddVenue();
    test.testgetArtists();
    test.testgetBands();
    test.testgetVenues();
    test.testgetArtistbyName();
    test.testgetBandbyName();
    test.testgetVenuebyName();
    test.testgetArtBandbyShow();
    test.testsearchArtist();
    test.testsearchBand();
    test.testsearchVenue();
    test.testsearchShow();
  }

  public JyveTest() {}

  public String toString() {

    return "JyveTest{"
        + "j := "
        + Utils.toString(j)
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
        + ", a1 := "
        + Utils.toString(a1)
        + ", a2 := "
        + Utils.toString(a2)
        + ", b1 := "
        + Utils.toString(b1)
        + ", b2 := "
        + Utils.toString(b2)
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
