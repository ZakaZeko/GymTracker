package one.thing.well.gymtimekeeper.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String DATE_FORMAT_STRING = "dd/MM/yy HH:mm";

    public static final String MONTH_ONLY_STRING = "MMM";

    public static final String DAY_ONLY_STRING = "dd";

    public static final String DISPLAY_DATE_FORMAT_STRING = "dd/MM";

    public static final String TIME_FORMAT_STRING = "HH:mm";

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat(DateUtils.DATE_FORMAT_STRING);

    private static final DateFormat TIME_FORMAT = new SimpleDateFormat(DateUtils.TIME_FORMAT_STRING);

    private static final DateFormat DISPLAY_DATE_FORMAT = new SimpleDateFormat(DateUtils.DISPLAY_DATE_FORMAT_STRING);

    private static final DateFormat MONTH_ONLY_FORMAT = new SimpleDateFormat(DateUtils.MONTH_ONLY_STRING);

    private static final DateFormat DAY_ONLY_FORMAT = new SimpleDateFormat(DateUtils.DAY_ONLY_STRING);

    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }

    public static String formatTime(Date date) {
        return TIME_FORMAT.format(date);
    }

    public static String formatDisplayDate(Date date){
        return  DISPLAY_DATE_FORMAT.format(date);
    }

    public static String getMonth(Date date) {
        return MONTH_ONLY_FORMAT.format(date);
    }

    public static String formatDay(Date date) {
        return DAY_ONLY_FORMAT.format(date);
    }

    public static Date parseDateString(String dateString) throws ParseException {
        return DATE_FORMAT.parse(dateString);
    }

    public static Date addMinutesToDate(Date date, int minutes) {
        long dateInMillis = date.getTime();
        long milliseconds = dateInMillis + (minutes * 60 * 1000);
        Date dateWithAddedMinutes = new Date(milliseconds);
        return dateWithAddedMinutes;
    }

    public static String calculateDuration(Date start, Date end) {
        long durationInMillis = end.getTime() - start.getTime();
        long days = durationInMillis / (60 * 60 * 1000 * 24);
        long hours = durationInMillis / (60 * 60 * 1000) % 24;
        long minutes = durationInMillis / (60 * 1000) % 60;
        if (days > 0) return days + "d " + hours + "h " + minutes + "m";
        return hours + "h " + minutes + "m";
    }

    public static Date getWeekStart() {
        DateTime monday = LocalDate.now().withDayOfWeek(DateTimeConstants.MONDAY).toDateTimeAtStartOfDay();
        return monday.toDate();
    }

    public static String convertToDuration(long durationThisWeek) {
        return calculateDuration(new Date(0), new Date(durationThisWeek));
    }

    public static Date getDayStart() {
        DateTime startOfDay = LocalDate.now().toDateTimeAtStartOfDay();
        return startOfDay.toDate();
    }
}
