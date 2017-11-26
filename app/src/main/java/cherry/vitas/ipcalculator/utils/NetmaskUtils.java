package cherry.vitas.ipcalculator.utils;

import static cherry.vitas.ipcalculator.model.NumericConstants.NETMASK_MAXIMUM;

public class NetmaskUtils {

    /**
     * Checks if string contains number
     * @param s string to check
     * @return true, if it contains a number, else - false
     */
    public static boolean isNumber(String s) { return s.length() <= 2; }

    /**
     * Checks if netmask value is maximum
     * @return true, if netmask value is max, else - false
     */
    public static boolean isNetmaskMaximum(int netmaskValue) { return netmaskValue == NETMASK_MAXIMUM; }
}
