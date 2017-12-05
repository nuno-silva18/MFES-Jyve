package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Location {
  private String city;
  private String state;

  public void cg_init_Location_1(final String c, final String s) {

    city = c;
    state = s;
    return;
  }

  public Location(final String c, final String s) {

    cg_init_Location_1(c, s);
  }

  public String getCity() {

    return city;
  }

  public String getState() {

    return state;
  }

  public void setCity(final String c) {

    city = c;
    return;
  }

  public void setState(final String s) {

    state = s;
    return;
  }

  public Location() {}

  public String toString() {

    return "Location{"
        + "city := "
        + Utils.toString(city)
        + ", state := "
        + Utils.toString(state)
        + "}";
  }
}
