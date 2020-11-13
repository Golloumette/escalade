package org.openclassroom.escalade.enume;

public enum DispoEnum {
	Disponible(0, "disponible"),
    Waiting(1, "waiting"),
    Indisponible(2, "indisponible");
	
	
	
	private byte num;
	private String dispo;
	
DispoEnum(int i, String string) {
	this.num= (byte) i;
	this.dispo = string;
}

public byte getNum() {
	return num;
}

public void setNum(byte num) {
	this.num = num;
}

public String getDispo() {
	return dispo;
}

public void setDispo(String dispo) {
	this.dispo = dispo;
}
}