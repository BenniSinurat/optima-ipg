package com.jpa.optima.ipg.helper;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;

import com.google.common.io.BaseEncoding;

public class Utils {
	private static Logger logger = Logger.getLogger(Utils.class);
	
	public static XMLGregorianCalendar stringToXMLGregorianCalendar(Date s)
			throws ParseException, DatatypeConfigurationException {
		XMLGregorianCalendar result = null;

		GregorianCalendar gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
		gregorianCalendar.setTime(s);
		result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		return result;
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
		Date date = new java.util.Date();
		SimpleDateFormat format = new SimpleDateFormat(form);
		return format.format(date);
	}
	
	public static String formatDate(Date date, String form) {
		return DateFormatUtils.format(date, form);
	}

	public static String GenerateTransactionNumber() {
		int randomNum = ThreadLocalRandom.current().nextInt(100000, 1000000);
		return String.valueOf(randomNum);
	}

	public static String GenerateRandomNumber(int charLength) {
		return String.valueOf(charLength < 1 ? 0
				: new Random().nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
						+ (int) Math.pow(10, charLength - 1));
	}

	public static String formatDate(XMLGregorianCalendar xml) throws DatatypeConfigurationException {
		return xml.toGregorianCalendar().getTime().toString();
	}

	public static long getTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		long tmp = timestamp.getTime();
		
		logger.info("Timestamp: " + tmp);
		return tmp;
	}
	
	public static String hmacSHA512Encrypt(String words, String key) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
		SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"),
				"HmacSHA512");

		Mac mac = Mac.getInstance("HmacSHA512");
		mac.init(keySpec);
		String sha512Hex = BaseEncoding.base16().lowerCase().encode(mac.doFinal(words.getBytes("UTF-8")));

		logger.info("[Request WORDS : " + words + " /Hashed WORDS : " + sha512Hex + "]");
		
		return sha512Hex;
	}
}