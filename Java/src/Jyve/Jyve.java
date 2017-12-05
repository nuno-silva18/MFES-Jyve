package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Jyve {
  private VDMSet artists = SetUtil.set();
  private VDMSet bands = SetUtil.set();
  private VDMSet venues = SetUtil.set();

  public VDMSet getArtists() {

    return Utils.copy(artists);
  }

  public VDMSet getBands() {

    return Utils.copy(bands);
  }

  public VDMSet getVenues() {

    return Utils.copy(venues);
  }

  public Artist getArtistbyName(final String an) {

    for (Iterator iterator_5 = artists.iterator(); iterator_5.hasNext(); ) {
      Artist a = (Artist) iterator_5.next();
      if (Utils.equals(an, a.getName())) {
        return a;
      }
    }
    return null;
  }

  public Band getBandbyName(final String bn) {

    for (Iterator iterator_6 = bands.iterator(); iterator_6.hasNext(); ) {
      Band b = (Band) iterator_6.next();
      if (Utils.equals(bn, b.getName())) {
        return b;
      }
    }
    return null;
  }

  public Venue getVenuebyName(final String vn) {

    for (Iterator iterator_7 = venues.iterator(); iterator_7.hasNext(); ) {
      Venue v = (Venue) iterator_7.next();
      if (Utils.equals(vn, v.getName())) {
        return v;
      }
    }
    return null;
  }

  public String getArtBandbyShow(final Show ss) {

    for (Iterator iterator_8 = artists.iterator(); iterator_8.hasNext(); ) {
      Artist a = (Artist) iterator_8.next();
      for (Iterator iterator_9 = a.getShows().iterator(); iterator_9.hasNext(); ) {
        Show as = (Show) iterator_9.next();
        if (Utils.equals(as, ss)) {
          return a.getName();
        }
      }
    }
    for (Iterator iterator_10 = bands.iterator(); iterator_10.hasNext(); ) {
      Band b = (Band) iterator_10.next();
      for (Iterator iterator_11 = b.getShows().iterator(); iterator_11.hasNext(); ) {
        Show bs = (Show) iterator_11.next();
        if (Utils.equals(bs, ss)) {
          return b.getName();
        }
      }
    }
    return SeqUtil.toStr(SeqUtil.seq());
  }

  public void addArtist(final Artist a) {

    artists = SetUtil.union(SetUtil.set(a), Utils.copy(artists));
  }

  public void addBand(final Band b) {

    bands = SetUtil.union(SetUtil.set(b), Utils.copy(bands));
  }

  public void addVenue(final Venue v) {

    venues = SetUtil.union(SetUtil.set(v), Utils.copy(venues));
  }

  public VDMSet searchArtist(final String sa) {

    VDMSet res = SetUtil.set();
    for (Iterator iterator_12 = artists.iterator(); iterator_12.hasNext(); ) {
      Artist a = (Artist) iterator_12.next();
      Boolean orResult_1 = false;

      if (Utils.equals(a.getName(), sa)) {
        orResult_1 = true;
      } else {
        orResult_1 = Utils.equals(a.getDescription(), sa);
      }

      if (orResult_1) {
        res = SetUtil.union(SetUtil.set(a), Utils.copy(res));
      }
    }
    return Utils.copy(res);
  }

  public VDMSet searchBand(final String sb) {

    VDMSet res = SetUtil.set();
    for (Iterator iterator_13 = bands.iterator(); iterator_13.hasNext(); ) {
      Band b = (Band) iterator_13.next();
      Boolean orResult_2 = false;

      if (Utils.equals(b.getName(), sb)) {
        orResult_2 = true;
      } else {
        orResult_2 = Utils.equals(b.getDescription(), sb);
      }

      if (orResult_2) {
        res = SetUtil.union(SetUtil.set(b), Utils.copy(res));
      }
    }
    return Utils.copy(res);
  }

  public VDMSet searchVenue(final String sv) {

    VDMSet res = SetUtil.set();
    for (Iterator iterator_14 = venues.iterator(); iterator_14.hasNext(); ) {
      Venue v = (Venue) iterator_14.next();
      Boolean orResult_3 = false;

      if (Utils.equals(v.getName(), sv)) {
        orResult_3 = true;
      } else {
        orResult_3 = Utils.equals(v.getDescription(), sv);
      }

      if (orResult_3) {
        res = SetUtil.union(SetUtil.set(v), Utils.copy(res));
      }
    }
    return Utils.copy(res);
  }

  public VDMSet searchShow(final String ss) {

    VDMSet res = SetUtil.set();
    for (Iterator iterator_15 = venues.iterator(); iterator_15.hasNext(); ) {
      Venue v = (Venue) iterator_15.next();
      for (Iterator iterator_16 = v.getShows().iterator(); iterator_16.hasNext(); ) {
        Show s = (Show) iterator_16.next();
        if (Utils.equals(s.getDescription(), ss)) {
          res = SetUtil.union(SetUtil.set(s), Utils.copy(res));
        }
      }
    }
    return Utils.copy(res);
  }

  public Number avgShowPerArtistBand() {

    Number nshows = 0L;
    Boolean b = false;
    Number tartb = 0L;
    for (Iterator iterator_17 = artists.iterator(); iterator_17.hasNext(); ) {
      Artist a = (Artist) iterator_17.next();
      b = true;
      nshows = nshows.longValue() + a.getShows().size();
      tartb = tartb.longValue() + 1L;
    }
    for (Iterator iterator_18 = bands.iterator(); iterator_18.hasNext(); ) {
      Band band = (Band) iterator_18.next();
      b = true;
      nshows = nshows.longValue() + band.getShows().size();
      tartb = tartb.longValue() + 1L;
    }
    if (!(b)) {
      return -1L;

    } else {
      return Utils.divide((1.0 * nshows.longValue()), tartb.longValue());
    }
  }

  public Jyve() {}

  public String toString() {

    return "Jyve{"
        + "artists := "
        + Utils.toString(artists)
        + ", bands := "
        + Utils.toString(bands)
        + ", venues := "
        + Utils.toString(venues)
        + "}";
  }
}
