package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Show {
  private DateTime startdate;
  private DateTime enddate;
  private Venue venue;
  private String description;

  public void cg_init_Show_1(
      final DateTime dts, final DateTime dte, final Venue v, final String desc) {

    startdate = dts;
    enddate = dte;
    venue = v;
    description = desc;
    return;
  }

  public Show(final DateTime dts, final DateTime dte, final Venue v, final String desc) {

    cg_init_Show_1(dts, dte, v, desc);
  }

  public DateTime getStartDate() {

    return startdate;
  }

  public DateTime getEndDate() {

    return enddate;
  }

  public Venue getVenue() {

    return venue;
  }

  public String getDescription() {

    return description;
  }

  public void setDescription(final String d) {

    description = d;
    return;
  }

  public Show() {}

  public String toString() {

    return "Show{"
        + "startdate := "
        + Utils.toString(startdate)
        + ", enddate := "
        + Utils.toString(enddate)
        + ", venue := "
        + Utils.toString(venue)
        + ", description := "
        + Utils.toString(description)
        + "}";
  }
}
