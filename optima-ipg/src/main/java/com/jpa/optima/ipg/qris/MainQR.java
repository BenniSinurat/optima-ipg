package com.jpa.optima.ipg.qris;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class MainQR {
	public static String qrisCompose(String merchantID, String merchantName, String merchantCity, String postalCode,
			String msisdn, String amount, String fee, String invoiceID, Integer terminalID, String nnsID,
			String merchantCategory, String nmid, String merchantCriteria, String terminal)
			throws InvalidTagException, UnsupportedEncodingException {
		QRComposer bc = new QRComposer();
		bc.setCrc(new DefaultCrcCalculator());

		bc.set("00", "01");
		bc.set("01", "12"); // 11 = QR Static, 12 = QR Dynamic

		bc.set("26", "00", "ID.FELLO.WWW");
		bc.set("26", "01", nnsID); // merchant PAN
		bc.set("26", "02", merchantID); // MID
		bc.set("26", "03", merchantCriteria);

		bc.set("51", "00", "ID.CO.QRIS.WWW");
		bc.set("51", "02", nmid); // MID
		bc.set("51", "03", merchantCriteria); // Merchant Criteria

		bc.set("52", merchantCategory); // MCC (Merchant Category Code)
		bc.set("53", "360"); // Transaction currency

		bc.set("54", amount); // amount
		// bc.set("55", "01"); // fee type -> 01 = Manual input, 02 = fixed value fee,
		// 03 = percentage
		// bc.set("56", fee); // fee amount

		bc.set("58", "ID"); // Country code
		bc.set("59", merchantName); // merchant name
		bc.set("60", merchantCity); // merchant city
		bc.set("61", postalCode); // Postal code

		bc.set("62", "01", invoiceID); // InvoiceID
		bc.set("62", "02", msisdn); // user msisdn
		bc.set("62", "03", terminalID.toString()); // terminal ID
		bc.set("62", "07", terminal); // TID

		String qrdata = bc.doCompose();
		System.out.println("[Composed : " + qrdata + "]");

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