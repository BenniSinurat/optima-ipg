package com.jpa.optima.ipg.model;

public class Currency {
	private String code;
	private String codeNumber;
	private boolean supported;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}

	public boolean isSupported() {
		return supported;
	}

	public void setSupported(boolean supported) {
		this.supported = supported;
	}

}
