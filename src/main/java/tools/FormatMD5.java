package tools;

import java.security.MessageDigest;

public class FormatMD5 {

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * MD5 加密
     * 
     */
    public static String MD5(String origin) {
        String resultString = MD5Encode(origin, "UTF-8");
        if (!FormatEmpty.isEmpty(resultString)) {
            return resultString.toUpperCase();
        }
        return resultString;
    }

    /**
     * MD5 比较 匹配origin 加密后是否等于md5
     * 
     * @param origin
     *            密码�? 未加�?
     * @param md5
     *            已加密字符串
     * @return
     */
    public static boolean ecompareMD5(String origin, String md5) {
        String result = MD5(origin);
        return md5.equals(result);
    }

    /*
     * MD5 加密
     */
    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
        } catch (Exception exception) {

        }
        return resultString;
    }

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f" };

    /**
     * 将byte数组转换为表�?16进制值的字符串， 如：byte[]{8,18}转换为：0813�? 和public static byte[]
     * hexStr2ByteArr(String strIn) 互为可�?�的转换过程
     * 
     * @param arrB
     *            �?要转换的byte数组
     * @return 转换后的字符�?
     * @throws Exception
     *             本方法不处理任何异常，所有异常全部抛�?
     */
    public static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，�?以字符串的长度是数组长度的两�?
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数�?要在前面�?0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * 将表�?16进制值的字符串转换为byte数组�? 和public static String byteArr2HexStr(byte[] arrB)
     * 互为可�?�的转换过程
     * 
     * @param strIn
     *            �?要转换的字符�?
     * @return 转换后的byte数组
     * @throws Exception
     *             本方法不处理任何异常，所有异常全部抛�?
     * @author <a href="mailto:leo841001@163.com">LiGuoQing</a >
     */
    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        // 两个字符表示�?个字节，�?以字节数组长度是字符串长度除�?2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

}