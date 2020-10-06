package com.jpa.optima.ipg.helper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
	public Utils() {
	}

	public static String formatAmount(java.math.BigDecimal amount, String grouping, String decimal, String format,
			String prefix, String trailer) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(java.util.Locale.getDefault());
		symbols.setGroupingSeparator(grouping.charAt(0));
		symbols.setDecimalSeparator(decimal.charAt(0));
		DecimalFormat df = new DecimalFormat(format, symbols);
		if (prefix == null) {
			prefix = "";
		}
		if (trailer == null) {
			trailer = "";
		}
		return prefix + df.format(amount) + " " + trailer;
	}

	public static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	public static String GetDate(String form) {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat format = new SimpleDateFormat(form);
		return format.format(date);
	}

	public static String GenerateTransactionNumber() {
		int randomNum = ThreadLocalRandom.current().nextInt(100000, 1000000);
		return String.valueOf(randomNum);
	}
}