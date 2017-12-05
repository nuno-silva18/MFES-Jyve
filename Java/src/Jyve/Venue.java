package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Venue {
  private String name;
  private Location location;
  private String description;
  private VDMSet shows = SetUtil.set();

  public void cg_init_Venue_1(final String n, final Location l, final String d) {

    name = n;
    location = l;
    description = d;
    return;
  }

  public Venue(final String n, final Location l, final String d) {

    cg_init_Venue_1(n, l, d);
  }

  public String getName() {

    return name;
  }

  public Location getLocation() {

    return location;
  }

  public String getDescription() {

    return description;
  }

  public VDMSet getShows() {

    return Utils.copy(shows);
  }

  public Show getShow(
      final String vn,
      final Number sy,
      final Number sm,
      final Number sd,
      final Number stime,
      final Number sminutes) {

    for (Iterator iterator_17 = shows.iterator(); iterator_17.hasNext(); ) {
      Show s = (Show) iterator_17.next();
      Boolean andResult_25 = false;

      if (Utils.equals(s.getVenue().getName(), vn)) {
        Boolean andResult_26 = false;

        if (Utils.equals(s.getStartDate().getYear(), sy)) {
          Boolean andResult_27 = false;

          if (Utils.equals(s.getStartDate().getMonth(), sm)) {
            Boolean andResult_28 = false;

            if (Utils.equals(s.getStartDate().getDay(), sd)) {
              Boolean andResult_29 = false;

              if (Utils.equals(s.getStartDate().getHour(), stime)) {
                if (Utils.equals(s.getStartDate().getMinutes(), sminutes)) {
                  andResult_29 = true;
                }
              }

              if (andResult_29) {
                andResult_28 = true;
              }
            }

            if (andResult_28) {
              andResult_27 = true;
            }
          }

          if (andResult_27) {
            andResult_26 = true;
          }
        }

        if (andResult_26) {
          andResult_25 = true;
        }
      }

      if (andResult_25) {
        return s;
      }
    }
    return null;
  }

  public void setName(final String n) {

    name = n;
    return;
  }

  public void setLocation(final Location l) {

    location = l;
    return;
  }

  public void setDescription(final String d) {

    description = d;
    return;
  }

  public void addShow(final Show s) {

    shows = SetUtil.union(Utils.copy(shows), SetUtil.set(s));
    return;
  }

  public void removeShow(final Show s) {

    shows = SetUtil.diff(Utils.copy(shows), SetUtil.set(s));
    return;
  }

  public void cancelShow(final Show s, final Jyve j) {

    String artbandname = j.getArtBandbyShow(s);
    for (Iterator iterator_18 = j.getArtists().iterator(); iterator_18.hasNext(); ) {
      Artist a = (Artist) iterator_18.next();
      if (!(Utils.equals(j.getArtistbyName(artbandname), null))) {
        a.removeShow(s);
        return;

      } else {
        for (Iterator iterator_19 = j.getBands().iterator(); iterator_19.hasNext(); ) {
          Band b = (Band) iterator_19.next();
          if (!(Utils.equals(j.getBandbyName(artbandname), null))) {
            b.removeShow(s);
            return;
          }
        }
      }
    }
    return;
  }

  public Venue() {}

  public String toString() {

    return "Venue{"
        + "name := "
        + Utils.toString(name)
        + ", location := "
        + Utils.toString(location)
        + ", description := "
        + Utils.toString(description)
        + ", shows := "
        + Utils.toString(shows)
        + "}";
  }
}
