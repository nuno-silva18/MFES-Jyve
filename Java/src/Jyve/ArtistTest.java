package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ArtistTest extends TestSuiteJyve {
  private DateTime d1 = new DateTime(2017L, 12L, 1L, 23L, 30L);
  private DateTime d2 = new DateTime(2017L, 12L, 2L, 4L, 0L);
  private DateTime d3 = new DateTime(2017L, 12L, 1L, 23L, 45L);
  private DateTime d4 = new DateTime(2017L, 12L, 2L, 3L, 30L);
  private Location l1 = new Location("New York", "New York");
  private Location l2 = new Location("Illinois", "Chicago");
  private Artist a1 =
      new Artist(
          "Father John Misty",
          l1,
          "Too cool for descriptions.",
          SetUtil.set("Indie"),
          SetUtil.set("Piano"));
  private Artist a2 = new Artist("St. Vincent", l1, "Coolio", SetUtil.set(), SetUtil.set());
  private Venue v1 = new Venue("The Den", l1, "Cool place to chill.");
  private Show s1 = new Show(d1, d2, v1, "Concert up buds!");
  private Show s2 = new Show(d3, d4, v1, "Concert down buds!");

  private void testaddMusic() {

    a1.addMusic("I Love You, Honeybear");
    a2.addMusic("Pure Comedy");
  }

  private void testaddInstrument() {

    a1.addInstrument("Guitar");
    a2.addInstrument("Piano");
  }

  private void testaddGenre() {

    a1.addGenre("Pop");
    a2.addGenre("Indie");
  }

  private void testaddShow() {

    assertEqual(a1.addShow(s1), true);
    assertEqual(a1.addShow(s2), false);
    assertEqual(a2.addShow(s2), true);
  }

  private void testgetName() {

    assertEqual(a1.getName(), "Father John Misty");
    assertEqual(a2.getName(), "St. Vincent");
  }

  private void testgetLocation() {

    assertEqual(a1.getLocation(), l1);
    assertEqual(a2.getLocation(), l1);
  }

  private void testgetDescription() {

    assertEqual(a1.getDescription(), "Too cool for descriptions.");
    assertEqual(a2.getDescription(), "Coolio");
  }

  private void testgetGenres() {

    assertEqual(a1.getGenres(), SetUtil.set("Indie", "Pop"));
    assertEqual(a2.getGenres(), SetUtil.set("Indie"));
  }

  private void testgetInstruments() {

    assertEqual(a1.getInstruments(), SetUtil.set("Piano", "Guitar"));
    assertEqual(a2.getInstruments(), SetUtil.set("Piano"));
  }

  private void testgetMusics() {

    assertEqual(a1.getMusics(), SetUtil.set("I Love You, Honeybear"));
    assertEqual(a2.getMusics(), SetUtil.set("Pure Comedy"));
  }

  private void testgetShows() {

    assertEqual(a1.getShows(), SetUtil.set(s1));
    assertEqual(a2.getShows(), SetUtil.set(s2));
  }

  private void testgetShow() {

    assertEqual(a1.getShow("The Den", 2017L, 12L, 1L, 23L, 30L), s1);
    assertEqual(a2.getShow("The Den", 2017L, 12L, 1L, 23L, 45L), s2);
    assertEqual(a1.getShow("Dummy Venue", 2018L, 12L, 12L, 12L, 12L), null);
  }

  private void testsetName() {

    a1.setName("Nuno Silva");
    a2.setName("Mário Esteves");
  }

  private void testsetLocation() {

    a1.setLocation(l2);
    a2.setLocation(l2);
  }

  private void testsetDescription() {

    a1.setDescription("Best musician on Earth");
    a2.setDescription("Massive weeb");
  }

  private void testremoveMusic() {

    a1.removeMusic("I Love You, Honeybear");
    a2.removeMusic("Pure Comedy");
  }

  private void testremoveInstrument() {

    a1.removeInstrument("Guitar");
    a2.removeInstrument("Piano");
  }

  private void testremoveGenre() {

    a1.removeGenre("Pop");
    a2.removeGenre("Indie");
  }

  private void testremoveShow() {

    a1.removeShow(s1);
    a2.removeShow(s2);
  }

  public static void main() {

    ArtistTest test = new ArtistTest();
    test.testaddMusic();
    test.testaddInstrument();
    test.testaddGenre();
    test.testaddShow();
    test.testgetName();
    test.testgetLocation();
    test.testgetDescription();
    test.testgetGenres();
    test.testgetInstruments();
    test.testgetMusics();
    test.testgetShows();
    test.testgetShow();
    test.testsetName();
    test.testsetLocation();
    test.testsetDescription();
    test.testremoveMusic();
    test.testremoveInstrument();
    test.testremoveGenre();
    test.testremoveShow();
  }

  public ArtistTest() {}

  public String toString() {

    return "ArtistTest{"
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
        + ", v1 := "
        + Utils.toString(v1)
        + ", s1 := "
        + Utils.toString(s1)
        + ", s2 := "
        + Utils.toString(s2)
        + "}";
  }
}
