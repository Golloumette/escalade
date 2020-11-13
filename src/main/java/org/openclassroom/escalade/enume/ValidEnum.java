package org.openclassroom.escalade.enume;

public enum ValidEnum {
	Waiting(0, "waiting"),
    Validate(1, "validate"),
    Archive(2, "archive");
	
	
	private byte num;
	private String str;
	
	
	 ValidEnum(int i, String str) {
		this.num = (byte) i;
		this.str = str;
	}
	public byte getNum() {
		return num;
	}
	public void setNum(byte num) {
		this.num = num;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
