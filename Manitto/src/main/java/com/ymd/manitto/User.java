package com.ymd.manitto;

public class User {
	private String KAKAOCODE;
	private String NAME;
	private String COLOR;
	private String FOOD;
	private String SINGER;
	private String MOVIEGENRE;
	private String INSTAGRAM;
	private String EMAIL;
	private int STATUS;
	private String PROFILEIMG;
	public String getKAKAOCODE() {
		return KAKAOCODE;
	}
	public void setKAKAOCODE(String kAKAOCODE) {
		KAKAOCODE = kAKAOCODE;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getCOLOR() {
		return COLOR;
	}
	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}
	public String getFOOD() {
		return FOOD;
	}
	public void setFOOD(String fOOD) {
		FOOD = fOOD;
	}
	public String getSINGER() {
		return SINGER;
	}
	public void setSINGER(String sINGER) {
		SINGER = sINGER;
	}
	public String getMOVIEGENRE() {
		return MOVIEGENRE;
	}
	public void setMOVIEGENRE(String mOVIEGENRE) {
		MOVIEGENRE = mOVIEGENRE;
	}
	public String getINSTAGRAM() {
		return INSTAGRAM;
	}
	public void setINSTAGRAM(String iNSTAGRAM) {
		INSTAGRAM = iNSTAGRAM;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	public String getPROFILEIMG() {
		return PROFILEIMG;
	}
	public void setPROFILEIMG(String pROFILEIMG) {
		PROFILEIMG = pROFILEIMG;
	}
	@Override
	public String toString() {
		return "User [KAKAOCODE=" + KAKAOCODE + ", NAME=" + NAME + ", COLOR=" + COLOR + ", FOOD=" + FOOD + ", SINGER="
				+ SINGER + ", MOVIEGENRE=" + MOVIEGENRE + ", INSTAGRAM=" + INSTAGRAM + ", EMAIL=" + EMAIL + ", STATUS="
				+ STATUS + ", PROFILEIMG=" + PROFILEIMG + "]";
	}
	
	
}
