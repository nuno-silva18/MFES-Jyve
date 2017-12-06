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

    for (Iterator iterator_19 = shows.iterator(); iterator_19.hasNext(); ) {
      Show s = (Show) iterator_19.next();
      Boolean andResult_31 = false;

      if (Utils.equals(s.getVenue().getName(), vn)) {
        Boolean andResult_32 = false;

        if (Utils.equals(s.getStartDate().getYear(), sy)) {
          Boolean andResult_33 = false;

          if (Utils.equals(s.getStartDate().getMonth(), sm)) {
            Boolean andResult_34 = false;

            if (Utils.equals(s.getStartDate().getDay(), sd)) {
              Boolean andResult_35 = false;

              if (Utils.equals(s.getStartDate().getHour(), stime)) {
                if (Utils.equals(s.getStartDate().getMinutes(), sminutes)) {
                  andResult_35 = true;
                }
              }

              if (andResult_35) {
                andResult_34 = true;
              }
            }

            if (andResult_34) {
              andResult_33 = true;
            }
          }

          if (andResult_33) {
            andResult_32 = true;
          }
        }

        if (andResult_32) {
          andResult_31 = true;
        }
      }

      if (andResult_31) {
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
    for (Iterator iterator_20 = j.getArtists().iterator(); iterator_20.hasNext(); ) {
      Artist a = (Artist) iterator_20.next();
      if (!(Utils.equals(j.getArtistbyName(artbandname), null))) {
        a.removeShow(s);
        return;

      } else {
        for (Iterator iterator_21 = j.getBands().iterator(); iterator_21.hasNext(); ) {
          Band b = (Band) iterator_21.next();
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
