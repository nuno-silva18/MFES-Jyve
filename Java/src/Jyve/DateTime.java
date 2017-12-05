package Jyve;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DateTime {
  private Number year;
  private Number month;
  private Number day;
  private Number hour;
  private Number minutes;

  public void cg_init_DateTime_1(
      final Number y, final Number m, final Number d, final Number h, final Number min) {

    year = y;
    month = m;
    day = d;
    hour = h;
    minutes = min;
    return;
  }

  public DateTime(
      final Number y, final Number m, final Number d, final Number h, final Number min) {

    cg_init_DateTime_1(y, m, d, h, min);
  }

  public Number getYear() {

    return year;
  }

  public Number getMonth() {

    return month;
  }

  public Number getDay() {

    return day;
  }

  public Number getHour() {

    return hour;
  }

  public Number getMinutes() {

    return minutes;
  }

  public Boolean laterDate(final DateTime d) {

    return year.longValue() * 525948L + month.longValue() * 43829L + day.longValue() * 1440L
        > d.getYear().longValue() * 525948L
            + d.getMonth().longValue() * 43829L
            + d.getDay().longValue() * 1440L;
  }

  public Boolean sameDate(final DateTime d) {

    return Utils.equals(
        year.longValue() * 525948L + month.longValue() * 43829L + day.longValue() * 1440L,
        d.getYear().longValue() * 525948L
            + d.getMonth().longValue() * 43829L
            + d.getDay().longValue() * 1440L);
  }

  public Boolean laterHour(final DateTime dth) {

    return hour.longValue() * 60L + minutes.longValue()
        > dth.getHour().longValue() * 60L + dth.getMinutes().longValue();
  }

  public Boolean sameHour(final DateTime dth) {

    return Utils.equals(
        hour.longValue() * 60L + minutes.longValue(),
        dth.getHour().longValue() * 60L + dth.getMinutes().longValue());
  }

  public Boolean laterTime(final DateTime dt) {

    return year.longValue() * 525948L
            + month.longValue() * 43829L
            + day.longValue() * 1440L
            + hour.longValue() * 60L
            + minutes.longValue()
        > dt.getYear().longValue() * 525948L
            + dt.getMonth().longValue() * 43829L
            + dt.getDay().longValue() * 1440L
            + dt.getHour().longValue() * 60L
            + dt.getMinutes().longValue();
  }

  public DateTime() {}

  public String toString() {

    return "DateTime{"
        + "year := "
        + Utils.toString(year)
        + ", month := "
        + Utils.toString(month)
        + ", day := "
        + Utils.toString(day)
        + ", hour := "
        + Utils.toString(hour)
        + ", minutes := "
        + Utils.toString(minutes)
        + "}";
  }
}
