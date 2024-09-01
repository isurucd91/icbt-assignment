package model;

public class Customer extends User {
	private int mID;
	private String mContactDetails;
	
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public String getmContactDetails() {
		return mContactDetails;
	}
	public void setmContactDetails(String mContactDetails) {
		this.mContactDetails = mContactDetails;
	}
}
