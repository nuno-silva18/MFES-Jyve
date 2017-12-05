package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Artist {
  private String name;
  private Location location;
  private String description;
  private VDMSet genres;
  private VDMSet instruments;
  private VDMSet musics = SetUtil.set();
  private VDMSet shows = SetUtil.set();

  public void cg_init_Artist_1(
      final String n, final Location l, final String d, final VDMSet setg, final VDMSet seti) {

    name = n;
    location = l;
    description = d;
    genres = Utils.copy(setg);
    instruments = Utils.copy(seti);
  }

  public Artist(
      final String n, final Location l, final String d, final VDMSet setg, final VDMSet seti) {

    cg_init_Artist_1(n, l, d, Utils.copy(setg), Utils.copy(seti));
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

  public VDMSet getGenres() {

    return Utils.copy(genres);
  }

  public VDMSet getInstruments() {

    return Utils.copy(instruments);
  }

  public VDMSet getMusics() {

    return Utils.copy(musics);
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

    for (Iterator iterator_1 = shows.iterator(); iterator_1.hasNext(); ) {
      Show s = (Show) iterator_1.next();
      Boolean andResult_1 = false;

      if (Utils.equals(s.getVenue().getName(), vn)) {
        Boolean andResult_2 = false;

        if (Utils.equals(s.getStartDate().getYear(), sy)) {
          Boolean andResult_3 = false;

          if (Utils.equals(s.getStartDate().getMonth(), sm)) {
            Boolean andResult_4 = false;

            if (Utils.equals(s.getStartDate().getDay(), sd)) {
              Boolean andResult_5 = false;

              if (Utils.equals(s.getStartDate().getHour(), stime)) {
                if (Utils.equals(s.getStartDate().getMinutes(), sminutes)) {
                  andResult_5 = true;
                }
              }

              if (andResult_5) {
                andResult_4 = true;
              }
            }

            if (andResult_4) {
              andResult_3 = true;
            }
          }

          if (andResult_3) {
            andResult_2 = true;
          }
        }

        if (andResult_2) {
          andResult_1 = true;
        }
      }

      if (andResult_1) {
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

  public void addMusic(final String m) {

    musics = SetUtil.union(SetUtil.set(m), Utils.copy(musics));
  }

  public void addInstrument(final String i) {

    instruments = SetUtil.union(SetUtil.set(i), Utils.copy(instruments));
  }

  public void addGenre(final String g) {

    genres = SetUtil.union(SetUtil.set(g), Utils.copy(genres));
  }

  public Boolean addShow(final Show nshow) {

    for (Iterator iterator_2 = shows.iterator(); iterator_2.hasNext(); ) {
      Show s = (Show) iterator_2.next();
      Boolean andResult_8 = false;

      if (nshow.getEndDate().laterTime(s.getStartDate())) {
        if (s.getEndDate().laterTime(nshow.getStartDate())) {
          andResult_8 = true;
        }
      }

      if (andResult_8) {
        return false;
      }
    }
    shows = SetUtil.union(SetUtil.set(nshow), Utils.copy(shows));
    nshow.getVenue().addShow(nshow);
    return true;
  }

  public void removeMusic(final String m) {

    musics = SetUtil.diff(Utils.copy(musics), SetUtil.set(m));
    return;
  }

  public void removeInstrument(final String i) {

    instruments = SetUtil.diff(Utils.copy(instruments), SetUtil.set(i));
    return;
  }

  public void removeGenre(final String g) {

    genres = SetUtil.diff(Utils.copy(genres), SetUtil.set(g));
    return;
  }

  public void removeShow(final Show s) {

    shows = SetUtil.diff(Utils.copy(shows), SetUtil.set(s));
    s.getVenue().removeShow(s);
    return;
  }

  public Artist() {}

  public String toString() {

    return "Artist{"
        + "name := "
        + Utils.toString(name)
        + ", location := "
        + Utils.toString(location)
        + ", description := "
        + Utils.toString(description)
        + ", genres := "
        + Utils.toString(genres)
        + ", instruments := "
        + Utils.toString(instruments)
        + ", musics := "
        + Utils.toString(musics)
        + ", shows := "
        + Utils.toString(shows)
        + "}";
  }
}
