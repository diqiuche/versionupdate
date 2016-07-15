package net.tfedu.core.utils.datatype;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date Utility Class used to convert Strings to Dates and Timestamps
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by
 *         <a href="mailto:dan@getrolling.com">Dan Kibler </a> to correct time
 *         pattern. Minutes should be mm not MM (MM is month).
 */
public final class DateUtil {
    private static Logger log = LoggerFactory.getLogger(DateUtil.class);
    private static final String TIME_PATTERN = "HH:mm:ss";

    /**
     * Checkstyle rule: utility classes should not have public constructor
     */
    private DateUtil() {
    }

    /**
     * Return default datePattern (MM/dd/yyyy)
     *
     * @return a string representing the date pattern on the UI
     */
    public static String getDatePattern() {
        return "yyyy-MM-dd";
    }

    public static String getDateTimePattern() {
        return DateUtil.getDatePattern() + " HH:mm:ss";
    }

    /**
     * This method attempts to convert an Oracle-formatted date in the form
     * dd-MMM-yyyy to mm/dd/yyyy.
     *
     * @param aDate
     *            date from database as a string
     * @return formatted string for the ui
     */
    public static String getDate(Date aDate) {
        SimpleDateFormat df;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date/time in the
     * format you specify on input
     *
     * @param aMask
     *            the date pattern the string is in
     * @param strDate
     *            a string representation of a date
     * @return a converted Date object
     * @throws ParseException
     *             when String doesn't match the expected format
     * @see java.text.SimpleDateFormat
     */
    public static Date stringToDate(String aMask, String strDate) throws ParseException {
        SimpleDateFormat df;
        Date date;
        df = new SimpleDateFormat(aMask);

        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            // log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    /**
     * This method returns the current date time in the format: MM/dd/yyyy HH:MM
     * a
     *
     * @param theTime
     *            the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(TIME_PATTERN, theTime);
    }

    /**
     * This method returns the current date in the format: MM/dd/yyyy
     *
     * @return the current date
     * @throws ParseException
     *             when String doesn't match the expected format
     */
    public static Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(stringToDate(todayAsString));

        return cal;
    }

    /**
     * This method generates a string representation of a date's date/time in
     * the format you specify on input
     *
     * @param aMask
     *            the date pattern the string is in
     * @param aDate
     *            a date object
     * @return a formatted string representation of the date
     * @see java.text.SimpleDateFormat
     */
    public static String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            log.warn("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date based on the
     * System Property 'dateFormat' in the format you specify on input
     *
     * @param aDate
     *            A date to convert
     * @return a string representation of the date
     */
    public static String dateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }

    /**
     * This method converts a String to a date using the datePattern
     *
     * @param strDate
     *            the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * @throws ParseException
     *             when String doesn't match the expected format
     */
    public static Date stringToDate(final String strDate) throws ParseException {
        return stringToDate(getDatePattern(), strDate);
    }

    /**
     * 日期转字符串 yyyy-MM-dd HH:mm:ss 格式
     * 
     * @param date
     * @return
     */
    public static String timeToString(final Date date) {
        return getDateTime(getDateTimePattern(), date);
    }

    /**
     * 字符串转时间戳
     * 
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Timestamp stringToTime(final String strDate) throws ParseException {
        Date date = stringToDate(getDateTimePattern(), strDate);
        Timestamp ts = new Timestamp(date.getTime());
        return ts;
    }
}
