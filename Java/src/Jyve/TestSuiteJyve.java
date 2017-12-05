package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestSuiteJyve {
  protected void assertTrue(final Boolean arg) {

    return;
  }

  protected void assertEqual(final Object expected, final Object actual) {

    if (!(Utils.equals(expected, actual))) {
      IO.print("Actual value (");
      IO.print(((Object) actual));
      IO.print(") different from:\n");
      IO.print("expected (");
      IO.print(((Object) expected));
      IO.println(")\n");
    }
  }

  public TestSuiteJyve() {}

  public String toString() {

    return "TestSuiteJyve{}";
  }
}
