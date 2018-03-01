package tools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatCalendar {

    public static final String F_YMD    = "yyyy-MM-dd";
    public static final String F_YMDH   = "yyyy-MM-dd HH";
    public static final String F_YMDHMS = "yyyy-MM-dd HH:mm:ss";
    
    
    /**
     * @param format  参数
     * @return
     * 生成当前时间  
     * 生成该这个地方的快捷键将鼠标放在public前面 然后Ctrl+shift+j
     */
    public static String getCurrentTime(String format) {
    	Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
    }
    
    public static Calendar toCalender(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static Calendar now() {
        return toCalender(new Date());
    }

    public static Calendar format(String date) {
        return format(date, F_YMDHMS);
    }

    public static Calendar format(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return toCalender(d);
    }

    public static String format(Calendar cal) {
        return format(cal, F_YMDHMS);
    }

    public static String format(Calendar cal, String format) {
        return new SimpleDateFormat(format).format(cal.getTime());
    }

    // public static Integer compare(Calendar c1, Calendar c2, int type) {
    // if (c1 == null || c2 == null) {
    // return null;
    // }
    // long l1 = c1.getTimeInMillis();
    // long l2 = c2.getTimeInMillis();
    // long dif = 1000;
    // switch (type) {
    // case 1:
    // dif = 365 * 24 * 3600 * 1000;
    // break;
    // case 2:
    // dif = 365 * 24 * 3600 * 1000;
    // break;
    // case 3:
    // dif = 365 * 24 * 3600 * 1000;
    // break;
    // case 4:
    // dif = 365 * 24 * 3600 * 1000;
    // break;
    // case 5:
    // dif = 365 * 24 * 3600 * 1000;
    // break;
    // case 6:
    // dif = 365 * 24 * 3600 * 1000;
    // break;
    // case 7:
    // dif = 365 * 24 * 3600 * 1000;
    // break;
    // default:
    // break;
    // }
    // }

    /**
     * 时间偏移方法
     * 
     * @param cal
     *            �??要偏移的原时�??
     * @param offset
     *            偏移�??-正数=�??未来便宜，负数：�??过去偏移
     * @param type
     *            偏移类型-1=�??-2=�??-3=�??-4=�??-5=�??-6=�??
     * @return
     */
    public static Calendar offset(Calendar cal, int offset, int type) {
        if (cal == null) {
            return null;
        }
        int field = 0;
        switch (type) {
            case 1:
                field = Calendar.YEAR;
                break;
            case 2:
                field = Calendar.MONTH;
                break;
            case 3:
                field = Calendar.DAY_OF_MONTH;
                break;
            case 4:
                field = Calendar.HOUR_OF_DAY;
                break;
            case 5:
                field = Calendar.MINUTE;
                break;
            case 6:
                field = Calendar.SECOND;
                break;
            default:
                break;
        }
        cal.add(field, offset);
        return cal;
    }

    public static Timestamp getNow() {
        return new Timestamp(System.currentTimeMillis());
    }

    // private static Integer getY(String date) {
    // if (FormatEmpty.isEmpty(date) || date.length() < 4) {
    // return null;
    // }
    // String y = date.substring(0, 4);
    // return Integer.valueOf(y);
    // }

    // private static Integer getM(String date) {
    // if (FormatEmpty.isEmpty(date) || date.length() < 4) {
    // return null;
    // }
    // String y = date.substring(0, 4);
    // return Integer.valueOf(y);
    // }
    //
    // private static Integer getY(String date) {
    // if (FormatEmpty.isEmpty(date) || date.length() < 4) {
    // return null;
    // }
    // String y = date.substring(0, 4);
    // return Integer.valueOf(y);
    // }

    public static void main(String[] args) {
        String t1 = "2016-11-12 00";
        String t2 = "2016-11-12 00:00:01";
        // String t3 = "2016-11-12 10:00:01";
        // Calendar cal = format(t3);
        // offset(cal, 5, 6);
        // System.out.println(cal.getTime().toLocaleString());
        System.out.println(t1.compareTo(t2));
    }

}
