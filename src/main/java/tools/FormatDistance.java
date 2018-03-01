package tools;

public class FormatDistance {

    /**
     * 经纬度分隔符
     */
    private static final String SPLIT = "-";

    /**
     * 赤道半径
     */
    private static final double R = 6378137;

    /**
     * @param lon1
     *            经度1
     * @param lat1
     *            纬度1
     * @param lon2
     *            经度2
     * @param lat2
     *            维度2
     * @return
     */
    public static Double getDistance(String lon1, String lat1, String lon2, String lat2) {
        Double x1 = getPoint(lon1);
        Double y1 = getPoint(lat1);
        Double x2 = getPoint(lon2);
        Double y2 = getPoint(lat2);
        Double y11 = changeToRad(y1);
        Double y22 = changeToRad(y2);
        return 2 * R * Math.asin(Math.sqrt(Math.pow(Math.sin((y11 - y22) / 2), 2)
                + Math.cos(y11) * Math.cos(y22) * Math.pow(Math.sin((changeToRad(x1) - changeToRad(x2)) / 2), 2)));
    }

    private static Double getPoint(String s) {
        if (FormatEmpty.isEmpty(s)) {
            return null;
        }
        int len = s.length();
        Double d;
        s = s.substring(0, len - 2);
        if (s.indexOf(SPLIT) > 0) {
            String[] arr = s.split(SPLIT);
            d = Double.parseDouble(arr[0]) + Double.parseDouble(arr[1]) / 60;
        } else {
            d = Double.parseDouble(s);
        }
        // char last = s.charAt(len - 1);
        // if (last == 'S' || last == 'W') {
        // d *= -1;
        // }
        return d;
    }

    /**
     * 将角度转化为弧度--（弧度）＝弧�?/半径
     * 
     * @param angle
     *            角度
     * @return 弧度
     */
    private static Double changeToRad(Double angle) {
        return angle / 180 * Math.PI;
    }

    public static void main(String[] args) {
        System.out.println(getDistance("122-08.441E", "30-09.994N", "122-08.444E", "30-09.989N"));
    }

}
