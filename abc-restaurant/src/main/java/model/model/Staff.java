package model;

public class Staff extends User {
	private int mID;
	private String mPosition;
	
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public String getmPosition() {
		return mPosition;
	}
	public void setmPosition(String mPosition) {
		this.mPosition = mPosition;
	}
}
