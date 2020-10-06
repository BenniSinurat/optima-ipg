package com.jpa.optima.ipg.helper;

import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeHelper {
	public static byte[] getQRCodeImage(String text, int width, int height) {
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			com.google.zxing.common.BitMatrix bitMatrix = qrCodeWriter.encode(text,
					com.google.zxing.BarcodeFormat.QR_CODE, width, height);
			java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
			com.google.zxing.client.j2se.MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
			return byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}
}