package format;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FormatNumber {
	public static String formataBigDecimal(BigDecimal value) {
		DecimalFormatSymbols sysbols = new DecimalFormatSymbols();
		sysbols.setDecimalSeparator(',');
		sysbols.setGroupingSeparator('.');
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", sysbols);
		return decimalFormat.format(value);
	}
}
