package net.tfedu.core.utils.datatype;

public class StringUtils {

    /**
     * 判断是否为空
     * 
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0 || str.trim().equals("") || str.trim().equals("null");
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
