package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Band {
  private String name;
  private Location location;
  private String description;
  private VDMSet genres;
  private VDMSet members;
  private VDMSet musics = SetUtil.set();
  private VDMSet shows = SetUtil.set();

  public void cg_init_Band_1(
      final String n, final Location l, final String d, final VDMSet setg, final VDMSet seta) {

    name = n;
    location = l;
    description = d;
    genres = Utils.copy(setg);
    members = Utils.copy(seta);
  }

  public Band(
      final String n, final Location l, final String d, final VDMSet setg, final VDMSet seta) {

    cg_init_Band_1(n, l, d, Utils.copy(setg), Utils.copy(seta));
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

  public VDMSet getMembers() {

    return Utils.copy(members);
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

    for (Iterator iterator_3 = shows.iterator(); iterator_3.hasNext(); ) {
      Show s = (Show) iterator_3.next();
      Boolean andResult_12 = false;

      if (Utils.equals(s.getVenue().getName(), vn)) {
        Boolean andResult_13 = false;

        if (Utils.equals(s.getStartDate().getYear(), sy)) {
          Boolean andResult_14 = false;

          if (Utils.equals(s.getStartDate().getMonth(), sm)) {
            Boolean andResult_15 = false;

            if (Utils.equals(s.getStartDate().getDay(), sd)) {
              Boolean andResult_16 = false;

              if (Utils.equals(s.getStartDate().getHour(), stime)) {
                if (Utils.equals(s.getStartDate().getMinutes(), sminutes)) {
                  andResult_16 = true;
                }
              }

              if (andResult_16) {
                andResult_15 = true;
              }
            }

            if (andResult_15) {
              andResult_14 = true;
            }
          }

          if (andResult_14) {
            andResult_13 = true;
          }
        }

        if (andResult_13) {
          andResult_12 = true;
        }
      }

      if (andResult_12) {
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

  public void addMember(final Artist a) {

    members = SetUtil.union(SetUtil.set(a), Utils.copy(members));
  }

  public void addGenre(final String g) {

    genres = SetUtil.union(SetUtil.set(g), Utils.copy(genres));
  }

  public Boolean addShow(final Show nshow) {

    for (Iterator iterator_4 = shows.iterator(); iterator_4.hasNext(); ) {
      Show s = (Show) iterator_4.next();
      Boolean andResult_18 = false;

      if (nshow.getEndDate().laterTime(s.getStartDate())) {
        if (s.getEndDate().laterTime(nshow.getStartDate())) {
          andResult_18 = true;
        }
      }

      if (andResult_18) {
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

  public void removeMember(final Artist a) {

    members = SetUtil.diff(Utils.copy(members), SetUtil.set(a));
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

  public Band() {}

  public String toString() {

    return "Band{"
        + "name := "
        + Utils.toString(name)
        + ", location := "
        + Utils.toString(location)
        + ", description := "
        + Utils.toString(description)
        + ", genres := "
        + Utils.toString(genres)
        + ", members := "
        + Utils.toString(members)
        + ", musics := "
        + Utils.toString(musics)
        + ", shows := "
        + Utils.toString(shows)
        + "}";
  }
}
