package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BandTest extends TestSuiteJyve {
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
  private Show s1 = new Show(d1, d2, v1, "Concert up buds!");
  private Show s2 = new Show(d3, d4, v1, "Concert down buds!");

  private void testaddMusic() {

    b1.addMusic("I Love You, Honeybear");
    b2.addMusic("Pure Comedy");
  }

  private void testaddGenre() {

    b1.addGenre("Pop");
    b2.addGenre("Indie");
  }

  private void testaddMember() {

    b1.addMember(a2);
    b2.addMember(a1);
  }

  private void testaddShow() {

    assertEqual(b1.addShow(s1), true);
    assertEqual(b1.addShow(s2), false);
    assertEqual(b2.addShow(s2), true);
  }

  private void testgetName() {

    assertEqual(b1.getName(), "Father John Misty's Band");
    assertEqual(b2.getName(), "Superband");
  }

  private void testgetLocation() {

    assertEqual(b1.getLocation(), l1);
    assertEqual(b2.getLocation(), l1);
  }

  private void testgetDescription() {

    assertEqual(b1.getDescription(), "Cool band.");
    assertEqual(b2.getDescription(), "Super band with two awesome people!");
  }

  private void testgetGenres() {

    assertEqual(b1.getGenres(), SetUtil.set("Indie", "Pop"));
    assertEqual(b2.getGenres(), SetUtil.set("Indie"));
  }

  private void testgetMembers() {

    assertEqual(b1.getMembers(), SetUtil.set(a1, a2));
    assertEqual(b2.getMembers(), SetUtil.set(a1, a2));
  }

  private void testgetMusics() {

    assertEqual(b1.getMusics(), SetUtil.set("I Love You, Honeybear"));
    assertEqual(b2.getMusics(), SetUtil.set("Pure Comedy"));
  }

  private void testgetShows() {

    assertEqual(b1.getShows(), SetUtil.set(s1));
    assertEqual(b2.getShows(), SetUtil.set(s2));
  }

  private void testgetShow() {

    assertEqual(b1.getShow("The Den", 2017L, 12L, 1L, 23L, 30L), s1);
    assertEqual(b2.getShow("The Den", 2017L, 12L, 1L, 23L, 45L), s2);
    assertEqual(b1.getShow("Dummy Venue", 2018L, 12L, 12L, 12L, 12L), null);
  }

  private void testsetName() {

    b1.setName("Nuno Silva and the MFES band");
    b2.setName("Mário Esteves and the weebs band");
  }

  private void testsetLocation() {

    b1.setLocation(l2);
    b2.setLocation(l2);
  }

  private void testsetDescription() {

    b1.setDescription("Best band on Earth");
    b2.setDescription("Massive weeb band");
  }

  private void testremoveMusic() {

    b1.removeMusic("I Love You, Honeybear");
    b2.removeMusic("Pure Comedy");
  }

  private void testremoveMember() {

    b1.removeMember(a2);
    b2.removeMember(a1);
  }

  private void testremoveGenre() {

    b1.removeGenre("Pop");
    b2.removeGenre("Indie");
  }

  private void testremoveShow() {

    b1.removeShow(s1);
    b2.removeShow(s2);
  }

  public static void main() {

    BandTest test = new BandTest();
    test.testaddMusic();
    test.testaddMember();
    test.testaddGenre();
    test.testaddShow();
    test.testgetName();
    test.testgetLocation();
    test.testgetDescription();
    test.testgetGenres();
    test.testgetMembers();
    test.testgetMusics();
    test.testgetShows();
    test.testgetShow();
    test.testsetName();
    test.testsetLocation();
    test.testsetDescription();
    test.testremoveMusic();
    test.testremoveMember();
    test.testremoveGenre();
    test.testremoveShow();
  }

  public BandTest() {}

  public String toString() {

    return "BandTest{"
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
        + ", s1 := "
        + Utils.toString(s1)
        + ", s2 := "
        + Utils.toString(s2)
        + "}";
  }
}
