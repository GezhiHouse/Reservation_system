package org.lanqiao.Reservation_system.domain;

public class Food {

	private String F_PIC;
	private String F_KIND;
	private String F_SAL;
	private String F_NAME;
	private int F_ID;
	private String F_INTRO;
	public Food(String f_PIC, String f_KIND, String f_SAL, String f_NAME, int f_ID, String f_INTRO) {
		super();
		F_PIC = f_PIC;
		F_KIND = f_KIND;
		F_SAL = f_SAL;
		F_NAME = f_NAME;
		F_ID = f_ID;
		F_INTRO = f_INTRO;
	}
	public Food() {
		super();
	}
	public String getF_PIC() {
		return F_PIC;
	}
	public void setF_PIC(String f_PIC) {
		F_PIC = f_PIC;
	}
	public String getF_KIND() {
		return F_KIND;
	}
	public void setF_KIND(String f_KIND) {
		F_KIND = f_KIND;
	}
	public String getF_SAL() {
		return F_SAL;
	}
	public void setF_SAL(String f_SAL) {
		F_SAL = f_SAL;
	}
	public String getF_NAME() {
		return F_NAME;
	}
	public void setF_NAME(String f_NAME) {
		F_NAME = f_NAME;
	}
	public int getF_ID() {
		return F_ID;
	}
	public void setF_ID(int f_ID) {
		F_ID = f_ID;
	}
	public String getF_INTRO() {
		return F_INTRO;
	}
	public void setF_INTRO(String f_INTRO) {
		F_INTRO = f_INTRO;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + F_ID;
		result = prime * result + ((F_INTRO == null) ? 0 : F_INTRO.hashCode());
		result = prime * result + ((F_KIND == null) ? 0 : F_KIND.hashCode());
		result = prime * result + ((F_NAME == null) ? 0 : F_NAME.hashCode());
		result = prime * result + ((F_PIC == null) ? 0 : F_PIC.hashCode());
		result = prime * result + ((F_SAL == null) ? 0 : F_SAL.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (F_ID != other.F_ID)
			return false;
		if (F_INTRO == null) {
			if (other.F_INTRO != null)
				return false;
		} else if (!F_INTRO.equals(other.F_INTRO))
			return false;
		if (F_KIND == null) {
			if (other.F_KIND != null)
				return false;
		} else if (!F_KIND.equals(other.F_KIND))
			return false;
		if (F_NAME == null) {
			if (other.F_NAME != null)
				return false;
		} else if (!F_NAME.equals(other.F_NAME))
			return false;
		if (F_PIC == null) {
			if (other.F_PIC != null)
				return false;
		} else if (!F_PIC.equals(other.F_PIC))
			return false;
		if (F_SAL == null) {
			if (other.F_SAL != null)
				return false;
		} else if (!F_SAL.equals(other.F_SAL))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Food [F_PIC=" + F_PIC + ", F_KIND=" + F_KIND + ", F_SAL=" + F_SAL + ", F_NAME=" + F_NAME + ", F_ID="
				+ F_ID + ", F_INTRO=" + F_INTRO + "]";
	}

}
