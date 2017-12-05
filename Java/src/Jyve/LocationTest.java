package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class LocationTest extends TestSuiteJyve {
  private Location l1 = new Location("New Jersey", "New York");
  private Location l2 = new Location("Los Angeles", "California");

  private void testgetCity() {

    assertEqual(l1.getCity(), "New Jersey");
    assertEqual(l2.getCity(), "Los Angeles");
  }

  private void testgetState() {

    assertEqual(l1.getState(), "New York");
    assertEqual(l2.getState(), "California");
  }

  private void testsetCity() {

    l1.setCity("Miami");
    l2.setCity("Oklahoma City");
  }

  private void testsetState() {

    l1.setState("Florida");
    l2.setState("Oklahoma");
  }

  public static void main() {

    LocationTest test = new LocationTest();
    test.testgetCity();
    test.testgetState();
    test.testsetCity();
    test.testsetState();
  }

  public LocationTest() {}

  public String toString() {

    return "LocationTest{" + "l1 := " + Utils.toString(l1) + ", l2 := " + Utils.toString(l2) + "}";
  }
}
