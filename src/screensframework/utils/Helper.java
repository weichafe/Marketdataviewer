package screensframework.utils;

import java.text.DecimalFormat;
import java.util.UUID;

public class Helper {

    public static final String XSGO = "XSGO";
    public static DecimalFormat formatNumber = new DecimalFormat( "#,###,###,##0");
    public static DecimalFormat formatNumber2 = new DecimalFormat( "#,###,###,##0.00");
    public static DecimalFormat formatNumber3 = new DecimalFormat( "#,###,###,##0.000");

    public synchronized static String getID() {
        return Long.toString(UUID.randomUUID().getMostSignificantBits(), 16);
    }
}
