package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestJyve {
  public static void main() {

    new BandTest().main();
    new ArtistTest().main();
    new DateTimeTest().main();
    new LocationTest().main();
    new VenueTest().main();
    new ShowTest().main();
    new JyveTest().main();
  }

  public TestJyve() {}

  public String toString() {

    return "TestJyve{}";
  }
}
