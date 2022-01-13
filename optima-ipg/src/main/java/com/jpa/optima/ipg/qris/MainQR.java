package com.jpa.optima.ipg.qris;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Map;

public class MainQR {
	public static String qrisCompose(String merchantID, String merchantName, String merchantCity, String postalCode,
			String msisdn, BigDecimal amount, BigDecimal fee, String invoiceID)
			throws InvalidTagException, UnsupportedEncodingException {
		QRComposer bc = new QRComposer();
		bc.setCrc(new DefaultCrcCalculator());

		bc.set("00", "01");
		bc.set("01", "12"); // 11 = QR Static, 12 = QR Dynamic
		// bc.set("02", "1234567890123456"); //ditetapkan untuk visa
		// bc.set("03", "1234567890123456"); //ditetapkan untuk visa

		bc.set("26", "00", "ID.CO.KOPI.WWW");
		bc.set("26", "01", "936009260000000001"); // merchant PAN
		bc.set("26", "02", "1112007"); // MID
		bc.set("26", "03", "UMI");

		bc.set("51", "00", "ID.CO.OPTIMA-S");
		bc.set("51", "02", merchantID); // MID
		bc.set("51", "03", "UMI");

		bc.set("52", "1110"); // MCC (Merchant Category Code)
		bc.set("53", "360"); // Transaction currency

		bc.set("54", amount.toPlainString()); // amount
		bc.set("55", "02"); // fee type -> 01 = Manual input, 02 = fixed value fee, 03 = percentage
		bc.set("56", fee.toPlainString()); // fee amount

		bc.set("58", "ID"); // Country code
		bc.set("59", merchantName); // merchant name
		bc.set("60", merchantCity); // merchant city
		bc.set("61", postalCode); // Postal code

		bc.set("62", "01", invoiceID); // InvoiceID
		bc.set("62", "02", msisdn); // user msisdn
		bc.set("62", "07", "0716947387261892"); // TID

		String qrdata = bc.doCompose();
		System.out.println("[Composed : " + qrdata + "]");

		// bc.set("85", "CPV01");
		//bc.set("61", "4F", "A0000000555555");
		//bc.set("61", "57", "1234567890123458D191220112345F");

		// String qrdata = bc.doCompose();
		// byte[] qrdata = "8505CPV01".getBytes();

		// String encoded = Base64.getEncoder().encodeToString(qrdata);
		// System.out.println("[Composed : " + encoded);
		return qrdata;
	}

	public static void qrisDecompose(String qrdata) throws InvalidTagException {
		QRDecomposer dc = new QRDecomposer(qrdata);
		dc.setCrc(new DefaultCrcCalculator());

		Map<String, String> map = dc.doDecompose();
		System.out.println("[Decomposed : " + map + "]");
		System.out.println("[Valid CRC : " + dc.isValidCRC(map.get("63")) + "]");
		System.out.println("MID : " + dc.getTagValue(map.get("62"), "07"));

		// return map;
	}
}